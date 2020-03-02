package com.heroking.o2o.dto;

import java.util.List;

import com.heroking.o2o.entity.LocalAuth;
import com.heroking.o2o.enums.LocalAuthStateEnum;

/**
 * @Author heroking
 * @Date 2019年12月13日 下午8:50:24 类说明
 */
public class LocalAuthExecution {
	// 结果状态
	private int state;

	// 状态标识
	private String stateInfo;

	// 操作的LocalAuth
	private LocalAuth localAuth;

	private List<LocalAuth> localAuthList;

	// 构造器1
	public LocalAuthExecution() {

	}

	// 店铺操作失败的时候使用的构造器
	public LocalAuthExecution(LocalAuthStateEnum stateEnum) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
	}

	// 店铺操作成功的时候使用的构造器
	public LocalAuthExecution(LocalAuthStateEnum stateEnum, LocalAuth localAuth) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.localAuth = localAuth;
	}

	// 店铺操作成功的时候使用的构造器
	public LocalAuthExecution(LocalAuthStateEnum stateEnum, List<LocalAuth> localAuthList) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.localAuthList = localAuthList;
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

	public LocalAuth getLocalAuth() {
		return localAuth;
	}

	public void setLocalAuth(LocalAuth localAuth) {
		this.localAuth = localAuth;
	}
}
