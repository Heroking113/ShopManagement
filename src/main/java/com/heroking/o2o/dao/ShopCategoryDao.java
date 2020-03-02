package com.heroking.o2o.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.heroking.o2o.entity.ShopCategory;

public interface ShopCategoryDao {
	/**
	 * 获取店铺类别列表
	 * @param ShopCategoryCondition
	 * @return
	 */
	List<ShopCategory> queryShopCategory(@Param("shopCategoryCondition")ShopCategory ShopCategoryCondition);
	
	/**
	 * 新增店铺类别：分为一级类别和二级类别（一级类别无parentId，二级类别有）
	 * @param shopCategory
	 * @return
	 */
	int insertShopCategory(ShopCategory shopCategory);
	
	/**
	 * 更新店铺类别信息
	 * @param shopCategory
	 * @return
	 */
	int updateShopCategory(ShopCategory shopCategory);
}	
