package com.heroking.o2o.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heroking.o2o.cache.JedisUtil;
import com.heroking.o2o.service.CacheService;

/**
 * @Author heroking
 * @Date 2019年12月3日 上午9:37:40 类说明
 */
@Service
public class CacheServiceImpl implements CacheService {
	@Autowired
	private JedisUtil.Keys jedisKeys;

	@Override
	public void removeFromCache(String keyPrefix) {
		Set<String> keySet = jedisKeys.keys(keyPrefix + "*");
		for (String key : keySet) {
			jedisKeys.del(key);
		}
	}
}
