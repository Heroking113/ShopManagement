package com.heroking.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.heroking.o2o.BaseTest;
import com.heroking.o2o.entity.ShopCategory;

public class ShopCategoryDaoTest extends BaseTest {
	@Autowired
	private ShopCategoryDao shopCategoryDao;
	
	@Test
	@Ignore
	public void testQueryShopCategory() {
		List<ShopCategory> shopCategoryList = shopCategoryDao.queryShopCategory(null);
		System.out.println("shopCategoryList:"+shopCategoryList.size());
	}
	
	@Test
	@Ignore
	public void testInsertShopCategory() {
		ShopCategory parentShopCategory = new ShopCategory();
		parentShopCategory.setShopCategoryId(1L);
		
		ShopCategory shopCategory = new ShopCategory();
		shopCategory.setShopCategoryName("周边");
		shopCategory.setShopCategoryDesc("周边");
		shopCategory.setShopCategoryImg("test3");
		shopCategory.setPriority(5);
		shopCategory.setCreateTime(new Date());
		shopCategory.setLastEditTime(new Date());
		shopCategory.setParent(parentShopCategory);
		
		int effectedNum = shopCategoryDao.insertShopCategory(shopCategory);
		System.out.println("effectedNum:"+effectedNum);
		System.out.println(shopCategory.getParent());
	}
	
	@Test
	public void testUpdateShopCategory() {
		ShopCategory shopCategory = new ShopCategory();
		shopCategory.setShopCategoryId(1L);
		shopCategory.setShopCategoryDesc("奶茶好喝");
		int effectedNum = shopCategoryDao.updateShopCategory(shopCategory);
		assertEquals(1, effectedNum);
	}
}
