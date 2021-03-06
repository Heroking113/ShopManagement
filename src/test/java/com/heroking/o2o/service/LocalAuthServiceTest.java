package com.heroking.o2o.service;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import com.heroking.o2o.BaseTest;
import com.heroking.o2o.dto.LocalAuthExecution;
import com.heroking.o2o.entity.LocalAuth;
import com.heroking.o2o.entity.PersonInfo;
import com.heroking.o2o.enums.WechatAuthStateEnum;

/**
 * @Author heroking
 * @Date 2019年12月14日 上午10:31:19 类说明
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LocalAuthServiceTest extends BaseTest {
	@Autowired
	private LocalAuthService localAuthService;

	@Test
	@Ignore
	public void testABindLocalAuth() {
		// 新增一条平台账号
		LocalAuth localAuth = new LocalAuth();
		PersonInfo personInfo = new PersonInfo();
		String username = "testusername";
		String password = "testpassword";
		// 给平台账号设置上用户信息
		// 给用户设置上用户Id，标明是某个用户创建的账号
		personInfo.setUserId(1L);
		// 给平台账号设置用信息，标明是与哪个用户绑定
		localAuth.setPersonInfo(personInfo);
		// 设置账号
		localAuth.setUsername(username);
		// 设置密码
		localAuth.setPassword(password);
		// 绑定账号
		LocalAuthExecution lae = localAuthService.bindLocalAuth(localAuth);
		assertEquals(WechatAuthStateEnum.SUCCESS.getState(), lae.getState());
		// 通过userId找到新增的localAuth
		localAuth = localAuthService.getLocalAuthByUserId(personInfo.getUserId());
		// 打印用户名字和账号密码看看是否符合预期
		System.out.println("用户昵称：" + localAuth.getPersonInfo().getName());
		System.out.println("平台账号密码：" + localAuth.getPassword());
	}

	@Test
	public void testBModifyLocalAuth() {
		// 设置账号信息
		long userId = 1;
		String username = "testusername";
		String password = "testpassword";
		String newPassword = "testnewpassword";
		// 修改该账号对应的密码
		LocalAuthExecution lae = localAuthService.modifyLocalAuth(userId, username, password, newPassword, new Date());
		assertEquals(WechatAuthStateEnum.SUCCESS.getState(), lae.getState());
		// 通过账号密码找到修改后的localAuth
		LocalAuth localAuth = localAuthService.getLocalAuthByUsernameAndPwd(username, newPassword);
		//打印一下用户名字和预期是否相符
		System.out.println(localAuth.getPersonInfo().getName());
	}
}
