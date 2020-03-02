package com.heroking.o2o.enums;
/**
* @Author heroking
* @Date 2019年11月16日 上午10:19:51
* 类说明 
*/
public enum ProductStateEnum {
	SUCCESS(1, "创建成功"), INNER_ERROR(-1001, "操作失败"),
	NULL_SHOPID(-1002, "添加数少于1"), EMPTY_LIST(0, "创建的列表为空");

	private int state;
	private String stateInfo;

	private ProductStateEnum(int state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
	}

	/**
	 * 依据传入的state返回相应的enum值
	 */
	public static ProductStateEnum stateOf(int index) {
		for (ProductStateEnum state : values()) {
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
