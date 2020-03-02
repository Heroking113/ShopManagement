package com.heroking.o2o.enums;

/**
 * Description:
 * 
 * @author Heroking
 * @date 2019年11月15日
 */

//这个当时就直接复制了shopStateEnum的枚举
public enum ProductCategoryStateEnum {
	SUCCESS(1, "创建成功"), INNER_ERROR(-1001, "操作失败"),
	NULL_SHOPID(-1002, "添加数少于1"), EMPTY_LIST(0, "创建的列表为空");

	private int state;
	private String stateInfo;

	private ProductCategoryStateEnum(int state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
	}

	/**
	 * 依据传入的state返回相应的enum值
	 */
	public static ProductCategoryStateEnum stateOf(int index) {
		for (ProductCategoryStateEnum state : values()) {
			if (state.getState() == index) {
				return state;
			}
		}
		return null;
	}

	/**
	 * @return the state
	 */
	public int getState() {
		return state;
	}

	/**
	 * @return the stateInfo
	 */
	public String getStateInfo() {
		return stateInfo;
	}
}
