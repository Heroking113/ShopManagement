package com.heroking.o2o.dao;
/**
* @Author heroking
* @Date 2019年12月12日 下午7:59:24
* 类说明 
*/

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;
import com.heroking.o2o.BaseTest;
import com.heroking.o2o.entity.PersonInfo;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PersonInfoDaoTest extends BaseTest {
	@Autowired
	private PersonInfoDao personInfoDao;
	
	@Test
	public void testAInsertPersonInfo() throws Exception{
		//设置新的用户信息
		PersonInfo personInfo = new PersonInfo();
		personInfo.setName("Alice");
		personInfo.setGender("女");
		personInfo.setUserType(1);
		personInfo.setCreatetime(new Date());
		personInfo.setLastEditTime(new Date());
		personInfo.setEnableStatus(1);
		int effectedNum = personInfoDao.insertPersonInfo(personInfo);
		assertEquals(1, effectedNum);
	}
	
	@Test
	public void testBQueryPersonInfoById() {
		long userId = 1;
		//查询Id为1的用户信息
		PersonInfo person = personInfoDao.queryPersonInfoById(userId);
		System.out.println("the name of this person is:"+person.getName());
		
	}
}
