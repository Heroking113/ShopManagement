package com.heroking.o2o.service;
/**
* @Author heroking
* @Date 2019年11月23日 下午8:25:58
* 类说明 
*/


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.heroking.o2o.BaseTest;
import com.heroking.o2o.dto.ImageHolder;
import com.heroking.o2o.dto.ShopCategoryExecution;
import com.heroking.o2o.entity.ShopCategory;

public class ShopCategoryServiceTest extends BaseTest {
	@Autowired
	private ShopCategoryService shopCategoryService;
	
	@Test
	public void testInsertShopCategory() {
		ShopCategory parentShopCategory = new ShopCategory();
		parentShopCategory.setShopCategoryId(1L);
		
		ShopCategory shopCategory = new ShopCategory();
		shopCategory.setShopCategoryName("红豆奶茶");
		shopCategory.setShopCategoryDesc("红豆奶茶真好喝");
		shopCategory.setPriority(6);
		shopCategory.setCreateTime(new Date());
		shopCategory.setLastEditTime(new Date());
		shopCategory.setParent(parentShopCategory);
		
		
		File shopCategoryImg = new File("G:\\eclipse-workspace\\test_pictures\\naicha.jpg");
		InputStream is=null;
		try {
			is=new FileInputStream(shopCategoryImg);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		ImageHolder imageHolder = new ImageHolder(shopCategoryImg.getName(), is);
		
		ShopCategoryExecution se = shopCategoryService.insertShopCategory(shopCategory, imageHolder);
		System.out.println("se.getstate:"+se.getState());
		/* assertEquals(ShopCategoryStateEnum.SUCCESS.getState(), se.getState()); */		
	}
}
