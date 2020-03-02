package com.heroking.o2o.entity;
/**
 * Description:
 * @author Heroking
 * @date 2019年10月23日
 */

import java.util.Date;

public class WechatAuth {
	//主键Id
	private Long wechatAuthId;
	//微信获取用户信息的凭证，对于某个公众号具有唯一性
	private String openId;
	//创建时间
	private Date createTime;
	//用户信息
	private PersonInfo personInfo;
	
	/**
	 * @return the wechatAuthId
	 */
	public Long getWechatAuthId() {
		return wechatAuthId;
	}
	/**
	 * @param wechatAuthId the wechatAuthId to set
	 */
	public void setWechatAuthId(Long wechatAuthId) {
		this.wechatAuthId = wechatAuthId;
	}
	/**
	 * @return the openId
	 */
	public String getOpenId() {
		return openId;
	}
	/**
	 * @param openId the openId to set
	 */
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * @return the personInfo
	 */
	public PersonInfo getPersonInfo() {
		return personInfo;
	}
	/**
	 * @param personInfo the personInfo to set
	 */
	public void setPersonInfo(PersonInfo personInfo) {
		this.personInfo = personInfo;
	}
}
