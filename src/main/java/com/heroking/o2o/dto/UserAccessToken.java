package com.heroking.o2o.dto;

/**
* @Author heroking
* @Date 2019年12月4日 上午10:01:17
* 类说明 
* 用户授权token
*/

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserAccessToken {
	// JsonProperty此注解用于属性上，作用是把该属性的名称"access_token"序列化为另外一个名称：access_token
	// 获取到的凭证
	@JsonProperty("access_token")
	private String accessToken;

	// 凭证有效时间:单位（秒）
	@JsonProperty("expires_in")
	private String expires_in;
	
	//表示更新令牌，用来获取下一次的访问令牌，这里没有太大用处
	@JsonProperty("refresh_token")
	private String refresh_token;
	
	//该用户在此公众号下面的身份标识，对于此微信号具有唯一性
	@JsonProperty("openid")
	private String openId;
	
	//表示权限范围，这里可以省略
	@JsonProperty("scope")
	private String scope;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String access_token) {
		this.accessToken = access_token;
	}

	public String getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(String expires_in) {
		this.expires_in = expires_in;
	}

	public String getRefresh_token() {
		return refresh_token;
	}

	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}
		
}
