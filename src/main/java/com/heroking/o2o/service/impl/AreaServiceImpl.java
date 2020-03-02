/**
 * Description:
 * @author Heroking
 * @date 2019年10月26日
 */
package com.heroking.o2o.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.heroking.o2o.cache.JedisUtil;
/**
 * Description:继承接口用“implement”关键字，继承类用“extends”关键字
 * @author Heroking
 * @date 2019年10月26日
 */
import com.heroking.o2o.dao.AreaDao;
import com.heroking.o2o.entity.Area;
import com.heroking.o2o.exceptions.AreaOperationException;
import com.heroking.o2o.service.AreaService;

//表示这个是service层的接口
@Service
public class AreaServiceImpl implements AreaService {
	// 告诉spring，我们需要用到某一个对象，请求spring注入进来
	@Autowired
	private AreaDao areaDao;
	
	// 引入缓存和日志
	@Autowired
	private JedisUtil.Keys jedisKeys;
	@Autowired
	private JedisUtil.Strings jedisStrings;
	private static Logger logger = LoggerFactory.getLogger(AreaServiceImpl.class);

	@Override
	@Transactional
	public List<Area> getAreaList() {
		String key = AREALISTKEY;
		List<Area> areaList = null;
		ObjectMapper mapper = new ObjectMapper();
		if (!jedisKeys.exists(key)) {
			areaList = areaDao.queryArea();
			String jsonString;
			try {
				jsonString = mapper.writeValueAsString(areaList);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
				logger.error(e.getMessage());
				throw new AreaOperationException(e.getMessage());
			}
			jedisStrings.set(key, jsonString);
		} else {
			String jsonString = jedisStrings.get(key);
			System.out.println("jsonString:"+jsonString);
			JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class, Area.class);
			try {
				areaList = mapper.readValue(jsonString, javaType);
			} catch (JsonParseException e) {
				e.printStackTrace();
				logger.error(e.getMessage());
				throw new AreaOperationException(e.getMessage());
			} catch (JsonMappingException e) {
				e.printStackTrace();
				logger.error(e.getMessage());
				throw new AreaOperationException(e.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
				logger.error(e.getMessage());
				throw new AreaOperationException(e.getMessage());
			}

		}
		return areaList;
	}
}
