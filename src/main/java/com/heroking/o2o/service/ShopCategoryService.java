package com.heroking.o2o.service;

import java.util.List;

import com.heroking.o2o.dto.ImageHolder;
import com.heroking.o2o.dto.ShopCategoryExecution;
import com.heroking.o2o.entity.ShopCategory;
import com.heroking.o2o.exceptions.ShopCategoryOperationException;

public interface ShopCategoryService {
	public static final String SCLISTKEY = "shopcategorylist";	
	/**
	 * 根据查询条件获取shopCategory列表
	 * @param shopCategoryCondition
	 * @return
	 */
	List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition);
	
	/**
	 * 插入店铺类别
	 * @param shopCategory
	 * @param thumbnail
	 * @return
	 * @throws ShopCategoryOperationException
	 */
	ShopCategoryExecution insertShopCategory(ShopCategory shopCategory, ImageHolder thumbnail) throws ShopCategoryOperationException;
}
