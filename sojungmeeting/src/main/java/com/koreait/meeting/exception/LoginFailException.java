package com.koreait.meeting.exception;

//우리의 선택사항이기떄문에 runtimeException
public class LoginFailException extends RuntimeException{
	//생성자를 받기 떄문에
	
	public LoginFailException(String msg) {
		super(msg);
	}
	
	public LoginFailException(Throwable e) {
		super(e);
	}
	
	public LoginFailException(String msg, Throwable e) {
		super(msg, e);
	}
	
}