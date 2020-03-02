package com.heroking.o2o.exceptions;

/**
 * @Author heroking
 * @Date 2019年12月13日 下午9:00:16 类说明
 */
public class LocalAuthOperationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2414199808013228596L;

	public LocalAuthOperationException(String msg) {
		super(msg);
	}
}
