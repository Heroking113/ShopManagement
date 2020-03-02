package com.heroking.o2o.entity;
/**
 * Description:
 * @author Heroking
 * @date 2019年10月23日
 */

import java.util.Date;

public class PersonInfo {
	private Long userId;
	private String name;
	private String profileImg;
	private String email;
	private String gender;
	private Integer enableStatus;
	//标识: 1.顾客 2.店家 3.超级管理员
	private Integer userType;
	private  Date createTime;
	private Date lastEditTime;
	
	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the profileImg
	 */
	public String getProfileImg() {
		return profileImg;
	}
	/**
	 * @param profileImg the profileImg to set
	 */
	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the enableStatus
	 */
	public Integer getEnableStatus() {
		return enableStatus;
	}
	/**
	 * @param enableStatus the enableStatus to set
	 */
	public void setEnableStatus(Integer enableStatus) {
		this.enableStatus = enableStatus;
	}
	/**
	 * @return the userType
	 */
	public Integer getUserType() {
		return userType;
	}
	/**
	 * @param userType the userType to set
	 */
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	/**
	 * @return the createtime
	 */
	public Date getCreatetime() {
		return createTime;
	}
	/**
	 * @param createtime the createtime to set
	 */
	public void setCreatetime(Date createtime) {
		this.createTime = createtime;
	}
	/**
	 * @return the lastEditTime
	 */
	public Date getLastEditTime() {
		return lastEditTime;
	}
	/**
	 * @param lastEditTime the lastEditTime to set
	 */
	public void setLastEditTime(Date lastEditTime) {
		this.lastEditTime = lastEditTime;
	}
	
	
}
