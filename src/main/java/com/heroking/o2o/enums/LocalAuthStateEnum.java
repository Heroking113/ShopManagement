package com.heroking.o2o.enums;

/**
 * @Author heroking
 * @Date 2019年12月13日 下午8:54:26 类说明
 */
public enum LocalAuthStateEnum {
	SUCCESS(1, "操作成功"), FAIL(-1001, "操作失败"), NULL_AUTH_INFO(-1002, "用户信息为空"), ONLY_ONE_ACCOUNT(-1003, "只能绑定一个账户");

	private int state;
	private String stateInfo;

	private LocalAuthStateEnum(int state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
	}

	/**
	 * 依据传入的state返回相应的enum值
	 */
	public static LocalAuthStateEnum stateOf(int index) {
		for (LocalAuthStateEnum state : values()) {
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
