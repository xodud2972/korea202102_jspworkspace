package com.koreait.meeting.exception;

//우리의 선택사항이기떄문에 runtimeException
public class MemberExistException extends RuntimeException{
	//생성자를 받기 떄문에
	
	public MemberExistException(String msg) {
		super(msg);
	}
	
	public MemberExistException(Throwable e) {
		super(e);
	}
	
	public MemberExistException(String msg, Throwable e) {
		super(msg, e);
	}
	
}