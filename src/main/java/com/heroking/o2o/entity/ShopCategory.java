package com.heroking.o2o.entity;
/**
 * Description:
 * @author Heroking
 * @date 2019年10月23日
 */

import java.util.Date;

public class ShopCategory {
	private Long shopCategoryId;
	private String shopCategoryName;
	private String shopCategoryDesc;
	private String shopCategoryImg;
	private Integer priority;
	private Date createTime;
	private Date lastEditTime;
	private ShopCategory parent;
	/**
	 * @return the shopCategoryId
	 */
	public Long getShopCategoryId() {
		return shopCategoryId;
	}
	/**
	 * @param shopCategoryId the shopCategoryId to set
	 */
	public void setShopCategoryId(Long shopCategoryId) {
		this.shopCategoryId = shopCategoryId;
	}
	/**
	 * @return the shopCategoryName
	 */
	public String getShopCategoryName() {
		return shopCategoryName;
	}
	/**
	 * @param shopCategoryName the shopCategoryName to set
	 */
	public void setShopCategoryName(String shopCategoryName) {
		this.shopCategoryName = shopCategoryName;
	}
	/**
	 * @return the shopCategoryDesc
	 */
	public String getShopCategoryDesc() {
		return shopCategoryDesc;
	}
	/**
	 * @param shopCategoryDesc the shopCategoryDesc to set
	 */
	public void setShopCategoryDesc(String shopCategoryDesc) {
		this.shopCategoryDesc = shopCategoryDesc;
	}
	/**
	 * @return the shopCategoryImg
	 */
	public String getShopCategoryImg() {
		return shopCategoryImg;
	}
	/**
	 * @param shopCategoryImg the shopCategoryImg to set
	 */
	public void setShopCategoryImg(String shopCategoryImg) {
		this.shopCategoryImg = shopCategoryImg;
	}
	/**
	 * @return the priority
	 */
	public Integer getPriority() {
		return priority;
	}
	/**
	 * @param priority the priority to set
	 */
	public void setPriority(Integer priority) {
		this.priority = priority;
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
	/**
	 * @return the parent
	 */
	public ShopCategory getParent() {
		return parent;
	}
	/**
	 * @param parent the parent to set
	 */
	public void setParent(ShopCategory parent) {
		this.parent = parent;
	}
	
}
