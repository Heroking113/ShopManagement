package com.heroking.o2o.exceptions;

/**
 * @Author heroking
 * @Date 2019年12月12日 下午9:42:06 类说明
 */
public class WechatAuthOperationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6943736265848491572L;

	public WechatAuthOperationException(String msg) {
		super(msg);
	}

}
