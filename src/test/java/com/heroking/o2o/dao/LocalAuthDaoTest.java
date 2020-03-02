package com.heroking.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import com.heroking.o2o.BaseTest;
import com.heroking.o2o.entity.LocalAuth;
import com.heroking.o2o.entity.PersonInfo;

/**
 * @Author heroking
 * @Date 2019年12月13日 下午8:24:26 类说明
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LocalAuthDaoTest extends BaseTest {
	@Autowired
	private LocalAuthDao localAuthDao;
	private static final String username = "testusername";
	private static final String password = "testpassword";

	@Test
	@Ignore
	public void testAInsertLocalAuth() throws Exception {
		// 新增一条平台账号
		LocalAuth localAuth = new LocalAuth();
		PersonInfo personInfo = new PersonInfo();
		personInfo.setUserId(1L);
		// 给平台账号绑定上用户信息
		localAuth.setPersonInfo(personInfo);
		// 设置上用户名和密码
		localAuth.setUsername(username);
		localAuth.setPassword(password);
		localAuth.setCreateTime(new Date());
		int effectedNum = localAuthDao.insertLocalAuth(localAuth);
		assertEquals(1, effectedNum);
	}

	@Test
	public void testBqueryLocalByUserNameAndPwd() throws Exception {
		// 按照账号和密码去查询用户信息
		LocalAuth localAuth = localAuthDao.queryLocalByNameAndPwd(username, password);
		System.out.println("name1: " + localAuth.getPersonInfo().getName());
	}

	@Test
	public void testCQueryLocalByUserId() throws Exception {
		// 按照用户Id去查询平台账号，进而获取用户信息
		LocalAuth localAuth = localAuthDao.queryLocalByUserId(1L);
		System.out.println("name2: " + localAuth.getPersonInfo().getName());
	}

	@Test
	public void testDUpdateLocalAuth() throws Exception {
		// 依据用户Id，平台账号，以及旧密码去修改平台 账号密码
		Date now = new Date();
		int effectedNum = localAuthDao.updateLocalAuth(1L, username, password, password + "new", now);
		// 查询该平台账号的最新信息
		LocalAuth localAuth = localAuthDao.queryLocalByUserId(1L);
		// 输出新密码
		System.out.println("new password: " + localAuth.getPassword());
	}
}
