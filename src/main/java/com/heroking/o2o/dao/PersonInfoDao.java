package com.heroking.o2o.dao;

import com.heroking.o2o.entity.PersonInfo;

/**
* @Author heroking
* @Date 2019年12月12日 下午6:48:56
* 类说明 
*/
public interface PersonInfoDao {
	/**
	 * 通过用户id查询用户
	 * @param userId
	 * @return
	 */
	PersonInfo queryPersonInfoById(long userId);
	
	/**
	 * 添加用户信息
	 * @param personInfo
	 * @return
	 */
	int insertPersonInfo(PersonInfo personInfo);
}
