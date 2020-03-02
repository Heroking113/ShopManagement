package com.heroking.o2o.enums;
/**
* @Author heroking
* @Date 2019年11月23日 下午6:42:37
* 类说明 
*/
public enum ShopCategoryStateEnum {
	SUCCESS(1, "创建成功"), INNER_ERROR(-1001, "操作失败"),
	NULL_SHOPCATEGORY(-1002, "添加数少于1"), EMPTY_LIST(0, "创建的列表为空");

	private int state;
	private String stateInfo;

	private ShopCategoryStateEnum(int state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
	}

	/**
	 * 依据传入的state返回相应的enum值
	 */
	public static ShopCategoryStateEnum stateOf(int index) {
		for (ShopCategoryStateEnum state : values()) {
			if (state.getState() == index) {
				return state;
			}
		}
		return null;
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
}
