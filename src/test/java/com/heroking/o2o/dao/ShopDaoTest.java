package com.heroking.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.heroking.o2o.entity.Area;
import com.heroking.o2o.entity.PersonInfo;
import com.heroking.o2o.entity.Shop;
import com.heroking.o2o.entity.ShopCategory;

/**
 * Description:
 * 
 * @author Heroking
 * @date 2019年10月29日
 */
public class ShopDaoTest extends com.heroking.o2o.BaseTest {
	@Autowired
	private ShopDao shopDao;
	
	@Test
	public void testQueryShopListAndCount() {
		Shop shopCondition = new Shop();
		ShopCategory childCategory = new ShopCategory();
		ShopCategory parentCategory = new ShopCategory();
		parentCategory.setShopCategoryId(1L);
		childCategory.setParent(parentCategory);
		shopCondition.setShopCategory(childCategory);
		List<Shop> shopList = shopDao.queryShopList(shopCondition, 0, 6);
		int count = shopDao.queryShopCount(shopCondition);
		System.out.println("店铺列表的大小："+shopList.size());
		System.out.println("店铺总数为："+count);
	}
	
	@Test
	@Ignore
	public void testQueryShopList() {
		Shop shopCondition = new Shop();
		PersonInfo owner = new PersonInfo();
		owner.setUserId(1L);
		shopCondition.setOwner(owner);
		System.out.println("执行到这里啦！");
		List<Shop> shopList = shopDao.queryShopList(shopCondition, 0, 3);
		int count = shopDao.queryShopCount(shopCondition);
		System.out.println("店铺列表的大小："+shopList.size());
		System.out.println("店铺总数："+count);
		ShopCategory sc = new ShopCategory();
		sc.setShopCategoryId(1L);
		shopCondition.setShopCategory(sc);
		shopList = shopDao.queryShopList(shopCondition, 0, 2);
		count = shopDao.queryShopCount(shopCondition);
		System.out.println("new店铺列表的大小："+shopList.size());
		System.out.println("new店铺总数："+count);
	}
	
	@Test
	@Ignore
	public void testQueryByShopId() {
		long shopId=1;
		Shop shop=shopDao.queryByShopId(shopId);
		System.out.println("areaId: "+shop.getArea().getAreaId());
		System.out.println("areaName: "+shop.getArea().getAreaName());
	}
	
	@Test
	@Ignore
	public void testInsertShop() {
		Shop shop = new Shop();
		PersonInfo owner = new PersonInfo();
		Area area = new Area();
		ShopCategory shopCategory = new ShopCategory();
		owner.setUserId(1L);
		area.setAreaId(2);
		shopCategory.setShopCategoryId(1L);
		shop.setOwner(owner);
		shop.setArea(area);
		shop.setShopCategory(shopCategory);
		shop.setShopName("店铺6");
		shop.setShopDesc("test");
		shop.setShopAddr("test");
		shop.setPhone("test");
		shop.setShopImg("test");
		shop.setCreateTime(new Date());
		shop.setEnableStatus(1);
		shop.setAdvice("审核中");
		int effectedNum = shopDao.insertShop(shop);
		assertEquals(1, effectedNum);
	}
	
	@Test
	@Ignore //相当于注释掉这个函数
	public void testUpdateShop() {
		Shop shop = new Shop();
		shop.setShopId(12L); //shopId是”long“型的，所以要加一个L
		shop.setShopDesc("测试描述");
		shop.setShopAddr("测试地址");
		shop.setLastEditTime(new Date());
		int effectedNum = shopDao.updateShop(shop);
		assertEquals(1, effectedNum);
	}
}
