package com.heroking.o2o.service;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.heroking.o2o.BaseTest;
import com.heroking.o2o.dto.ImageHolder;
import com.heroking.o2o.dto.ShopExecution;
import com.heroking.o2o.entity.Area; 
import com.heroking.o2o.entity.PersonInfo;
import com.heroking.o2o.entity.Shop;
import com.heroking.o2o.entity.ShopCategory;
import com.heroking.o2o.enums.ShopStateEnum;
import com.heroking.o2o.exceptions.ShopOperationException;
import com.heroking.o2o.service.ShopService;

/**
 * Description:
 * @author Heroking
 * @date 2019骞�10鏈�31鏃�
 */

public class ShopServiceTest extends BaseTest{
	@Autowired
	private ShopService shopService;
	
	@Test
	@Ignore
	public void testGetShopList() {
		Shop shopCondition = new Shop();
		ShopCategory sc = new ShopCategory();
		sc.setShopCategoryId(1L);
		shopCondition.setShopCategory(sc);
		ShopExecution se = shopService.getShopList(shopCondition, 2, 2);
		System.out.println("搴楅摵鍒楄〃鏁颁綅 锛�"+se.getShopList().size());
		System.out.println("搴楅摵鎬绘暟涓猴細"+se.getCount()); 
	}
	
	@Test
	@Ignore
	public void testModifyShop() throws ShopOperationException, FileNotFoundException{
		Shop shop=new Shop();
		shop.setShopId(1L);
		shop.setShopName("淇敼鍚庣殑搴楅摵鍚嶇О");
		File shopImg = new File("G:/eclipse-workspace/o2o/src/test/resources/ouwen.jpg");
		InputStream is = new FileInputStream(shopImg);
		ImageHolder imageHolder = new ImageHolder("ouwen.jpg", is);
		System.out.println("is: "+is);
		ShopExecution shopExecution=shopService.modifyShop(shop, imageHolder);
		System.out.println("鏂扮殑鍥剧墖鍦板潃涓猴細"+shopExecution.getShop().getShopImg());
	}
	
	@Test
	public void testAddShop() {
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
		shop.setShopName("娴嬭瘯鐨勫簵閾�4");
		shop.setShopDesc("test4");
		shop.setShopAddr("test4");
		shop.setPhone("test4");
		shop.setCreateTime(new Date());
		shop.setEnableStatus(ShopStateEnum.CHECK.getState());
		shop.setAdvice("瀹℃牳涓�");
		File shopImg = new File("G:/eclipse-workspace/o2o/src/test/resources/sea.jpg");
		InputStream is = null;
		try {
			is = new FileInputStream(shopImg);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImageHolder imageHolder = new ImageHolder(shopImg.getName(), is);
		ShopExecution se = shopService.addShop(shop, imageHolder);
		assertEquals(ShopStateEnum.CHECK.getState(), se.getState());
	}
}
