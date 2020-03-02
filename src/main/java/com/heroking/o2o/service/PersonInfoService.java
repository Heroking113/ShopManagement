package com.heroking.o2o.service;
/**
* @Author heroking
* @Date 2019年12月12日 下午11:10:42
* 类说明 
*/

import com.heroking.o2o.entity.PersonInfo;

public interface PersonInfoService {
	/**
	 * 根据用户Id获取personInfo信息
	 * @param userId
	 * @return
	 */
	PersonInfo getPersonInfoById(long userId);
}
