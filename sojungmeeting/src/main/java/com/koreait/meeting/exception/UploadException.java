package com.koreait.meeting.exception;

//우리의 선택사항이기떄문에 runtimeException
public class UploadException extends RuntimeException{
	//생성자를 받기 떄문에
	
	public UploadException(String msg) {
		super(msg);
	}
	
	public UploadException(Throwable e) {
		super(e);
	}
	
	public UploadException(String msg, Throwable e) {
		super(msg, e);
	}
	
}