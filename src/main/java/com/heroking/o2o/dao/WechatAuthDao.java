package com.heroking.o2o.dao;
/**
* @Author heroking
* @Date 2019年12月12日 下午6:51:16
* 类说明 
*/

import com.heroking.o2o.entity.WechatAuth;

public interface WechatAuthDao {
	/**
	 * 通过openId查询对应本平台的微信账号
	 * @param openId
	 * @return
	 */
	WechatAuth queryWechatInfoByOpenId(String openId);
	
	/**
	 * 添加对应本平台的微信账号
	 * @param wechatAuth
	 * @return
	 */
	int insertWechatAuth(WechatAuth wechatAuth);
}
