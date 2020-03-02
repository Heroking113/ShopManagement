package com.heroking.o2o.cache;

import java.util.Set;

/**
* @Author heroking
* @Date 2019年12月1日 下午9:55:59
* 类说明 :这里老师没有讲为什么有keys和strings，网上有一个链接有讲：
* https://gitee.com/nmwork/RedisUtil#%E4%B8%80keys%E7%9B%B8%E5%85%B3%E5%91%BD%E4%BB%A4
*/

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisUtil {
	/**
	 * 操作key的方法
	 */
	public Keys KEYS;
	/**
	 * 对存储结构为String类型的操作
	 */
	public Strings STRINGS;
	/**
	 * Redis连接池对象
	 */
	private JedisPool jedisPool;

	/**
	 * 获取redis连接池
	 * 
	 * @return
	 */
	public JedisPool getJedisPool() {
		return jedisPool;
	}

	/**
	 * 设置redis连接池
	 * 
	 * @param jedisPool
	 */
	public void setJedisPool(JedisPoolWriper jedisPoolWriper) {
		this.jedisPool = jedisPoolWriper.getJedisPool();
	}

	/**
	 * 从jedis连接池中获取jedis对象
	 * 
	 * @return
	 */
	public Jedis getJedis() {
		return jedisPool.getResource();
	}

	public class Keys {
		Jedis jedis = getJedis();

		public boolean exists(String key) {
			return jedis.exists(key) ? true : false;
		}

		public Set<String> keys(String key) {
			return jedis.keys(key);
		}

		public Long del(String key) {
			return jedis.del(key);
		}
	}

	public class Strings {
		Jedis jedis = getJedis();

		public void set(String key, String value) {
			jedis.set(key, value);
		}

		public String get(String key) {
			return jedis.get(key);
		}
	}
}
