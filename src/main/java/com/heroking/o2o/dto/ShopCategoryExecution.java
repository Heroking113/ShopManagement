package com.heroking.o2o.dto;

import java.util.List;

import com.heroking.o2o.entity.ShopCategory;
import com.heroking.o2o.enums.ShopCategoryStateEnum;

/**
* @Author heroking
* @Date 2019年11月23日 下午6:41:39
* 类说明 
*/
public class ShopCategoryExecution {
	//结果状态
	private int state;
	
	//状态标识
	private String stateInfo;
	
	private ShopCategory shopCategory;
	
	private List<ShopCategory> shopCategoryList;
	
	public ShopCategoryExecution() {
		
	}
	
	//失败的时候使用的构造器
	public ShopCategoryExecution(ShopCategoryStateEnum stateEnum) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
	}
	
	//操作成功的时候使用的构造器
	public ShopCategoryExecution(ShopCategoryStateEnum stateEnum, ShopCategory shopCategory) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.shopCategory = shopCategory;
	}
	
	//操作成功的时候使用的构造器
	public ShopCategoryExecution(ShopCategoryStateEnum stateEnum, List<ShopCategory> shopCategoryList) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.shopCategoryList = shopCategoryList;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}

	public ShopCategory getShopCategory() {
		return shopCategory;
	}

	public void setShopCategory(ShopCategory shopCategory) {
		this.shopCategory = shopCategory;
	}

	public List<ShopCategory> getShopCategoryList() {
		return shopCategoryList;
	}

	public void setShopCategoryList(List<ShopCategory> shopCategoryList) {
		this.shopCategoryList = shopCategoryList;
	}
}
