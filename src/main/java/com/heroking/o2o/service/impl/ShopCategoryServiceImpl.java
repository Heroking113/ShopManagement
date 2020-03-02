package com.heroking.o2o.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.heroking.o2o.cache.JedisUtil;
import com.heroking.o2o.dao.ShopCategoryDao;
import com.heroking.o2o.dto.ImageHolder;
import com.heroking.o2o.dto.ShopCategoryExecution;
import com.heroking.o2o.entity.ShopCategory;
import com.heroking.o2o.enums.ShopCategoryStateEnum;
import com.heroking.o2o.exceptions.AreaOperationException;
import com.heroking.o2o.exceptions.ShopCategoryOperationException;
import com.heroking.o2o.service.ShopCategoryService;
import com.heroking.o2o.util.ImageUtil;
import com.heroking.o2o.util.PathUtil;

@Service
public class ShopCategoryServiceImpl implements ShopCategoryService {

	@Autowired
	private ShopCategoryDao shopCategoryDao;
	// 引入缓存和日志
	@Autowired
	private JedisUtil.Keys jedisKeys;
	@Autowired
	private JedisUtil.Strings jedisStrings;
	private static Logger logger = LoggerFactory.getLogger(ShopCategoryServiceImpl.class);

	@Override
	public List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition) {
		// 定义redis的key前缀
		String key = SCLISTKEY;
		// 定义接收对象
		List<ShopCategory> shopCategoryList = null;
		// 定义jackson数据转换操作类
		ObjectMapper mapper = new ObjectMapper();
		// 拼接出redis的key
		if (shopCategoryCondition == null) {
			// 若查询条件为空，则列出所有首页大类，即parentId为空的店铺类别
			key = key + "_allfirstlevel";
		} else if (shopCategoryCondition != null && shopCategoryCondition.getParent() != null
				&& shopCategoryCondition.getParent().getShopCategoryId() != null) {
			// 若parentId为非空，则列出该parentId下面的所有子类别
			key = key + "_parent" + shopCategoryCondition.getParent().getShopCategoryId();
		} else if (shopCategoryCondition != null) {
			// 列出所有子类别，不管其他属于哪个类，都列出来
			key = key + "_allsecondlevel";
		}
		// 判断key是否存在
		if (!jedisKeys.exists(key)) {
			// 若不存在，则从数据库里面取出相应数据
			shopCategoryList = shopCategoryDao.queryShopCategory(shopCategoryCondition);
			// 将相关的实体类集合转换成string，存入redis里面对应的key中
			String jsonString = null;
			try {
				jsonString = mapper.writeValueAsString(shopCategoryList);
			} catch (JsonParseException e) {
				e.printStackTrace();
				logger.error(e.getMessage());
				throw new AreaOperationException(e.getMessage());
			} catch (JsonMappingException e) {
				e.printStackTrace();
				logger.error(e.getMessage());
				throw new AreaOperationException(e.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
				logger.error(e.getMessage());
				throw new AreaOperationException(e.getMessage());
			}
		}

		return shopCategoryList;
	}

	@Override
	@Transactional
	public ShopCategoryExecution insertShopCategory(ShopCategory shopCategory, ImageHolder thumbnail)
			throws ShopCategoryOperationException {
		// 判断店铺类别是否为空
		if (shopCategory == null) {
			return new ShopCategoryExecution(ShopCategoryStateEnum.EMPTY_LIST);
		}
		try {
			// 初始化一些数据
			shopCategory.setCreateTime(new Date());
			shopCategory.setLastEditTime(new Date());
			int effectedNum = shopCategoryDao.insertShopCategory(shopCategory);
			if (effectedNum <= 0) {
				throw new ShopCategoryOperationException("创建店铺类别失败");
			} else {
				if (thumbnail.getImage() != null) {
					try {
						addShopCategoryImg(shopCategory, thumbnail);
					} catch (Exception e) {
						throw new ShopCategoryOperationException("add shopCategoryImg error:" + e.getMessage());
					}
					effectedNum = shopCategoryDao.updateShopCategory(shopCategory);
					if (effectedNum <= 0) {
						throw new ShopCategoryOperationException("给店铺类别添加图片失败");
					}
				}
			}
		} catch (Exception e) {
			throw new ShopCategoryOperationException("add shopCategory error:" + e.getMessage());
		}
		return new ShopCategoryExecution(ShopCategoryStateEnum.SUCCESS, shopCategory);
	}

	private void addShopCategoryImg(ShopCategory shopCategory, ImageHolder thumbnail) {
		String dest = PathUtil.getShopCategoryImgPath(shopCategory.getShopCategoryId());
		String shopCategoryImgAddr = ImageUtil.generateThumbnail(thumbnail, dest);
		shopCategory.setShopCategoryImg(shopCategoryImgAddr);

	}
}
