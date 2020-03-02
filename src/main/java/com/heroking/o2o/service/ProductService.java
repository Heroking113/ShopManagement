package com.heroking.o2o.service;

import java.util.List;

import com.heroking.o2o.dto.ImageHolder;
import com.heroking.o2o.dto.ProductExecution;
import com.heroking.o2o.entity.Product;
import com.heroking.o2o.exceptions.ProductOperationException;

/**
 * @Author heroking
 */
public interface ProductService {

	/**
	 * 查询商品列表并分页，可输入的条件有：商品名（模糊 ），商品状态，店铺Id，商品类别
	 * 
	 * @param productCondition
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	ProductExecution getProductList(Product productCondition, int pageIndex, int pageSize);

	/**
	 * 添加商品
	 * 
	 * @param product
	 * @param thumbnail
	 * @param productImgs
	 * @return
	 * @throws ProductOperationException
	 */
	ProductExecution addProduct(Product product, ImageHolder thumbnail, List<ImageHolder> productImgList)
			throws ProductOperationException;

	/**
	 * 根据商品Id获取相应的商品信息
	 * 
	 * @param productId
	 * @return
	 */
	Product getProductById(long productId);

	/**
	 * 修改商品信息
	 * 
	 * @param product
	 * @param thumbnail
	 * @param productImgList
	 * @return
	 * @throws ProductOperationException
	 */
	ProductExecution modifyProduct(Product product, ImageHolder thumbnail, List<ImageHolder> productImgHolderList)
			throws ProductOperationException;
}
