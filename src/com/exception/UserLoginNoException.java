package com.exception;

/**
 * 处理前台用户未登录异常
 * @author Administrator
 *
 */
public class UserLoginNoException extends Exception{
	private static final long serialVersionUID = 1L;
	public UserLoginNoException(String message){
		super(message);
	}
}
