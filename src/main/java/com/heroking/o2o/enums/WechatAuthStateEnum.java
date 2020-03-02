package com.heroking.o2o.enums;
/**
* @Author heroking
* @Date 2019年12月12日 下午9:33:41
* 类说明 
*/
public enum WechatAuthStateEnum {
	LOGINFAIL(-1, "openId输入错误"),SUCCESS(1, "操作成功"), NULL_AUTH_INFO(-1002,"没有微信账号");
	
	private int state;
	private String stateInfo;
	
	private WechatAuthStateEnum(int state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
	}

	/**
	 * 依据传入的state返回相应的enum值
	 */
	public static WechatAuthStateEnum stateOf(int state) {
		for (WechatAuthStateEnum stateEnum : values()) {
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
