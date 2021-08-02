package com.koreait.meeting.exception;

//우리의 선택사항이기떄문에 runtimeException
public class FileHandleException extends RuntimeException{
	//생성자를 받기 떄문에
	
	public FileHandleException(String msg) {
		super(msg);
	}
	
	public FileHandleException(Throwable e) {
		super(e);
	}
	
	public FileHandleException(String msg, Throwable e) {
		super(msg, e);
	}
	
}