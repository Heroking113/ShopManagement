package com.heroking.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import com.heroking.o2o.BaseTest;
import com.heroking.o2o.entity.PersonInfo;
import com.heroking.o2o.entity.WechatAuth;

/**
* @Author heroking
* @Date 2019年12月12日 下午7:59:37
* 类说明 
*/

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WechatAuthDaoTest extends BaseTest{
	@Autowired
	private WechatAuthDao wechatAuthDao;
	
	@Test
	@Ignore
	public void testAInsertWechatAuth() throws Exception{
		//新增一条微信账号
		WechatAuth wechatAuth = new WechatAuth();
		PersonInfo personInfo = new PersonInfo();
		personInfo.setUserId(2L);
		//给微信账号绑定上用户信息
		wechatAuth.setPersonInfo(personInfo);
		//随意设置上openId;
		wechatAuth.setOpenId("dajkdlaj");
		wechatAuth.setCreateTime(new Date());
	
		int effectedNum = wechatAuthDao.insertWechatAuth(wechatAuth);
		assertEquals(1, effectedNum);
	}
	
	@Test
	public void testBQueryWechatAuthByOpenId() throws Exception{
		WechatAuth wechatAuth = wechatAuthDao.queryWechatInfoByOpenId("1");
		System.out.println("username:"+wechatAuth.getPersonInfo().getName());
	}
}
