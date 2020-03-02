package com.heroking.o2o.exceptions;
/**
* @Author heroking
* @Date 2019年11月16日 上午10:24:28
* 类说明 
*/
public class ProductOperationException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6525454077020955321L;

	public ProductOperationException(String msg) {
		super(msg);
	}
}
