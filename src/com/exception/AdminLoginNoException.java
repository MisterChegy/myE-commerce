package com.exception;
/**
 * 处理管理员未登录异常
 * @author Administrator
 *
 */
public class AdminLoginNoException extends Exception{
	private static final long serialVersionUID = 1L;
	public AdminLoginNoException(String message){
		super(message);
	}
}
