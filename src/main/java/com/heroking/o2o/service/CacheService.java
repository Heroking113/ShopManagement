package com.heroking.o2o.service;
/**
* @Author heroking
* @Date 2019年12月3日 上午9:35:04
* 类说明 
*/
public interface CacheService {

	/**
	 * 依据key前缀删除匹配该模式下的所有key-value，如传入：shopcategory，则shopcategory_allfirstlevel等
	 * 以“shopcategory打头的key-value都会被清空”
	 * @param keyPrefix
	 */
	void removeFromCache(String keyPrefix);
}
