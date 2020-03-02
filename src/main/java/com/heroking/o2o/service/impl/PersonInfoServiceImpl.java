package com.heroking.o2o.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heroking.o2o.dao.PersonInfoDao;
import com.heroking.o2o.entity.PersonInfo;
import com.heroking.o2o.service.PersonInfoService;

/**
 * @Author heroking
 * @Date 2019年12月12日 下午11:13:45 类说明
 */
@Service
public class PersonInfoServiceImpl implements PersonInfoService {
	@Autowired
	private PersonInfoDao personInfoDao;

	@Override
	public PersonInfo getPersonInfoById(long userId) {
		return personInfoDao.queryPersonInfoById(userId);
	}
}
