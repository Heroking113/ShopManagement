package com.heroking.o2o.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.heroking.o2o.cache.JedisUtil;
import com.heroking.o2o.dao.HeadLineDao;
import com.heroking.o2o.dto.HeadLineExecution;
import com.heroking.o2o.dto.ImageHolder;
import com.heroking.o2o.entity.HeadLine;
import com.heroking.o2o.enums.HeadLineStateEnum;
import com.heroking.o2o.exceptions.AreaOperationException;
import com.heroking.o2o.exceptions.HeadLineOperationException;
import com.heroking.o2o.service.HeadLineService;
import com.heroking.o2o.util.ImageUtil;
import com.heroking.o2o.util.PathUtil;

/**
 * @Author heroking
 * @Date 2019年11月22日 下午4:56:03 类说明
 */
//表示这个是service层的接口
@Service
public class HeadLineServiceImpl implements HeadLineService {
	@Autowired
	private HeadLineDao headLineDao;
	// 引入缓存和日志
	@Autowired
	private JedisUtil.Keys jedisKeys;
	@Autowired
	private JedisUtil.Strings jedisStrings;
	private static Logger logger = LoggerFactory.getLogger(HeadLineServiceImpl.class);

	@Override
	@Transactional
	public List<HeadLine> getHeadLineList(HeadLine headLineCondition) throws IOException {
		// 定义redis的key前缀
		String key = HLLISTKEY;
		// 定义接收对象
		List<HeadLine> headlinelist = null;
		// 定义jackson数据转换操作类
		ObjectMapper mapper = new ObjectMapper();
		// 拼接出redis的key
		if (headLineCondition != null && headLineCondition.getEnableStatus() != null) {
			key = key + "_" + headLineCondition.getEnableStatus();
		}
		// 判断key是否存在
		if (!jedisKeys.exists(key)) {
			// 若不存在，则从数据库里面取出相应数据
			headlinelist = headLineDao.queryHeadLine(headLineCondition);
			// 将相关的实体类集合转换成string，存入redis里面对应的key中
			String jsonString;
			try {
				jsonString = mapper.writeValueAsString(headlinelist);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
				logger.error(e.getMessage());
				throw new HeadLineOperationException(e.getMessage());
			}
			jedisStrings.set(key, jsonString);
		} else {
			// 若存在，则直接从redis里面取出相应数据
			String jsonString = jedisStrings.get(key);
			// 指定要将string转换成的集合类型
			JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class, HeadLine.class);
			try {
				// 将相关的key对应的value里面的string转换成对象的实体类集合
				headlinelist = mapper.readValue(jsonString, javaType);
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
		return headlinelist;
	}

	@Override
	public HeadLineExecution insertHeadLine(HeadLine headLine, ImageHolder thumbnail)
			throws HeadLineOperationException {
		// 判断头条信息是否为空
		if (headLine == null) {
			return new HeadLineExecution(HeadLineStateEnum.NULL_HEADLINE);
		}
		try {
			// 初始化一些数据
			headLine.setCreateTime(new Date());
			headLine.setLastEditTime(new Date());
			// 插入头条信息（不带图片的）
			System.out.println("111");
			int effectedNum = headLineDao.insertHeadLine(headLine);
			System.out.println("222");
			if (effectedNum <= 0) {
				throw new HeadLineOperationException("添加头条信息失败！");
			} else {
				// 插入头条图片
				if (thumbnail.getImage() != null) {
					try {
						addHeadLineImg(headLine, thumbnail);
					} catch (Exception e) {
						throw new HeadLineOperationException("add HeadLineImg error: " + e.getMessage());
					}
					effectedNum = headLineDao.updateHeadLine(headLine);
					if (effectedNum <= 0) {
						throw new HeadLineOperationException("添加头条图片失败！");
					}
				}
			}
		} catch (Exception e) {
			throw new HeadLineOperationException("添加头条信息失败！");
		}

		return new HeadLineExecution(HeadLineStateEnum.SUCCESS, headLine);
	}

	private void addHeadLineImg(HeadLine headLine, ImageHolder thumbnail) {
		String dest = PathUtil.getHeadLineImgPath(headLine.getLineId());
		String headLineImgAddr = ImageUtil.generateNormalImg(thumbnail, dest);
		headLine.setLineImg(headLineImgAddr);

	}
}
