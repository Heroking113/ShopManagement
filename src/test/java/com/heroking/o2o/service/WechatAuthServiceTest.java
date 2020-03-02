package com.heroking.o2o.service;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.heroking.o2o.BaseTest;
import com.heroking.o2o.dto.WechatAuthExecution;
import com.heroking.o2o.entity.PersonInfo;
import com.heroking.o2o.entity.WechatAuth;
import com.heroking.o2o.enums.WechatAuthStateEnum;

/**
 * @Author heroking
 * @Date 2019年12月12日 下午10:18:26 类说明
 */
public class WechatAuthServiceTest extends BaseTest {
	@Autowired
	private WechatAuthService wechatAuthService;

	@Test
	public void testRegister() {
		// 新增一条微信账号
		WechatAuth wechatAuth = new WechatAuth();
		PersonInfo personInfo = new PersonInfo();
		String openId = "fjdkjkldfj";
		// 给微信账号设置上用户信息，但不设置用户Id
		// 希望创建微信账号的时候，自动创建用户信息
		personInfo.setCreatetime(new Date());
		personInfo.setName("service层测试");
		personInfo.setUserType(1);
		wechatAuth.setPersonInfo(personInfo);
		wechatAuth.setOpenId(openId);
		wechatAuth.setCreateTime(new Date());
		WechatAuthExecution wae = wechatAuthService.register(wechatAuth);
		assertEquals(WechatAuthStateEnum.SUCCESS.getState(), wae.getState());

		// 通过openId找到新增的wechatAuth
		wechatAuth = wechatAuthService.getWechatAuthByOpenId(openId);
		// 打印用户名字看看 跟预期的是否相符
		System.out.println(wechatAuth.getPersonInfo().getName());
	}
}
