package com.heroking.o2o.util;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * @Author heroking
 * @Date 2019年12月1日 下午1:10:30 类说明
 */
public class EncryptPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
	// 需要加密的字段数组
	private String[] encryptPropNames = { "jdbc.master.username", "jdbc.master.password", "jdbc.slave.username", "jdbc.slave.password" };

	/**
	 *对关键字的属性进行加密
	 */
	@Override
	protected String convertProperty(String propertyName, String propertyValue) {
		if (isEncryptProp(propertyName)) {
			// 对已加密的字段进行解密工作
			String decryptValue = DESUtil.getDecryptString(propertyValue);
			return decryptValue;
		} else {
			return propertyValue;
		}
	}

	/**
	 * 判断该属性是否已加密
	 * @param propertyName
	 * @return
	 */
	private boolean isEncryptProp(String propertyName) {
		//若等于需要加密的field，则进行加密
		for(String encryptpropertyName:encryptPropNames) {
			if(encryptpropertyName.equals(propertyName)) {
				return true;
			}
		}
		return false;
	}
}
