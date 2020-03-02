package com.heroking.o2o.dto;

/**
* @Author heroking
* @Date 2019年12月12日 下午9:30:53
* 类说明 
*/

import java.util.List;

import com.heroking.o2o.entity.ShopCategory;
import com.heroking.o2o.entity.WechatAuth;
import com.heroking.o2o.enums.WechatAuthStateEnum;

public class WechatAuthExecution {
	// 结果状态
	private int state;
	// 状态标识
	private String stateInfo;

	private int count;

	private WechatAuth wechatAuth;

	private List<WechatAuth> wechatAuthList;

	// 构造器
	public WechatAuthExecution() {

	}

	// 失败的时候使用的构造器
	public WechatAuthExecution(WechatAuthStateEnum stateEnum) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
	}

	// 操作成功的时候使用的构造器
	public WechatAuthExecution(WechatAuthStateEnum stateEnum, WechatAuth wechatAuth) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.wechatAuth = wechatAuth;
	}

	// 操作成功的时候使用的构造器
	public WechatAuthExecution(WechatAuthStateEnum stateEnum, List<WechatAuth> wechatAuthList) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.wechatAuthList = wechatAuthList;
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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public WechatAuth getWechatAuth() {
		return wechatAuth;
	}

	public void setWechatAuth(WechatAuth wechatAuth) {
		this.wechatAuth = wechatAuth;
	}

	public List<WechatAuth> getWechatAuthList() {
		return wechatAuthList;
	}

	public void setWechatAuthList(List<WechatAuth> wechatAuthList) {
		this.wechatAuthList = wechatAuthList;
	}
}
