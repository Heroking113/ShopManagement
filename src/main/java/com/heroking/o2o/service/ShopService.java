package com.heroking.o2o.service;


import com.heroking.o2o.dto.ImageHolder;
import com.heroking.o2o.dto.ShopExecution;
import com.heroking.o2o.entity.Shop;
import com.heroking.o2o.exceptions.ShopOperationException;

/**
 * Description:
 * @author Heroking
 */
public interface ShopService {
	/**
	 * @param shopCondition
	 * @param pageIndex
	 * @param pageSize
	 * @return 
	 * */
	public ShopExecution getShopList(Shop shopCondition, int pageIndex, int pageSize);
	
	/**
	 * 获取特定的店铺信息
	 * 
	 * @param shopId
	 * @return
	 * */
	Shop getByShopId(long shopId);
	
	/**
	 * 更新店铺信息
	 * 
	 * @param shop
	 * @param shopImgInputStream
	 * @param fileName
	 * @return
	 * @throws ShopOperationException
	 * */
	
	ShopExecution modifyShop(Shop shop, ImageHolder thumbnail) throws ShopOperationException;
	
	/**
	 * 添加店铺
	 * 
	 * @param shop
	 * @param shopImgInputStream
	 * @param fileName
	 * @return
	 * @throws ShopOperationException
	 * */
	
	ShopExecution addShop(Shop shop, ImageHolder thumbnail) throws ShopOperationException;
}
