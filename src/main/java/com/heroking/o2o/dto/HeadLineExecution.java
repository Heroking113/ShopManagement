package com.heroking.o2o.dto;

import java.util.List;

import com.heroking.o2o.entity.HeadLine;
import com.heroking.o2o.entity.LocalAuth;
import com.heroking.o2o.enums.HeadLineStateEnum;
import com.heroking.o2o.enums.ShopStateEnum;

/**
 * @Author heroking
 * @Date 2019年11月25日 上午9:42:07 类说明
 */
public class HeadLineExecution {
	// 结果状态
	private int state;

	// 状态标识
	private String stateInfo;

	// 操作的Headline
	private HeadLine headLine;
	
	//操作的HeadLineList
	private List<HeadLine> headLineList;
	
	// 构造器1
	public HeadLineExecution() {

	}

	// 店铺操作失败的时候使用的构造器
	public HeadLineExecution(HeadLineStateEnum stateEnum) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
	}

	// 店铺操作成功的时候使用的构造器
	public HeadLineExecution(HeadLineStateEnum stateEnum, HeadLine headLine) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.headLine = headLine;
	}

	public HeadLineExecution(HeadLineStateEnum stateEnum, List<HeadLine> headLineList) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.headLineList = headLineList;
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

	public HeadLine getHeadLine() {
		return headLine;
	}

	public void setHeadLine(HeadLine headLine) {
		this.headLine = headLine;
	}

	public List<HeadLine> getHeadLineList() {
		return headLineList;
	}

	public void setHeadLineList(List<HeadLine> headLineList) {
		this.headLineList = headLineList;
	}

}
