package com.heroking.o2o.dao;

import java.util.List;

import com.heroking.o2o.entity.ProductImg;

public interface ProductImgDao {
	
	/**
	 * 批量添加商品详情图片
	 * @param productImgList
	 * @return
	 */
	int batchInsertProductImg(List<ProductImg> productImgList);
	
	
	/**
	 * 获取指定商品id的商品图片列表
	 * @param productId
	 * @return
	 */
	List<ProductImg> queryProductImgList(long productId);
	
	/**
	 * 删除指定商品下的所有详情图
	 * 
	 * @param productId
	 * @return
	 */
	int deleteProductImgByProductId(long productId);
}
