package com.heroking.o2o.service;
/**
* @Author heroking
* @Date 2019年12月12日 下午9:28:32
* 类说明 
*/

import com.heroking.o2o.dto.WechatAuthExecution;
import com.heroking.o2o.entity.WechatAuth;
import com.heroking.o2o.exceptions.WechatAuthOperationException;

public interface WechatAuthService {
	/**
	 * 通过openId查找平台对应的微信账号 
	 * @param openId
	 * @return
	 */
	WechatAuth getWechatAuthByOpenId(String openId);
	
	/**
	 * 注册本平台的微信账号
	 * 
	 * @param wechatAuth
	 * @return
	 * @throws WechatAuthException
	 */
	WechatAuthExecution register(WechatAuth wechatAuth) throws WechatAuthOperationException;
}
