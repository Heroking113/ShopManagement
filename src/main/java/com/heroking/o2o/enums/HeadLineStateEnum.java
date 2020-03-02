package com.heroking.o2o.enums;
/**
* @Author heroking
* @Date 2019年11月25日 上午9:44:32
* 类说明 
*/
public enum HeadLineStateEnum {
	SUCCESS(1, "操作成功"), INNER_ERROR(-1001, "内部系统错误"),
	NULL_HEADLINEID(-1002, "headLineId为空"), NULL_HEADLINE(-1003, "headLine信息为空");

	private int state;
	private String stateInfo;

	private HeadLineStateEnum(int state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
	}

	/**
	 * 依据传入的state返回相应的enum值
	 */
	public static HeadLineStateEnum stateOf(int state) {
		for (HeadLineStateEnum stateEnum : values()) {
			if (stateEnum.getState() == state) {
				return stateEnum;
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
