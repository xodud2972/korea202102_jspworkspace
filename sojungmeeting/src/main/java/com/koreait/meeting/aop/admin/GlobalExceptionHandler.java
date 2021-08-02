package com.koreait.meeting.aop.admin;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.koreait.meeting.exception.LoginFailException;



//모든 컨트롤러마다 일일이 중복된 예외를 처리하지말고, 공통된 예외를 처리할때는 예외처리 전용 컨트롤러를 이용할수
//있다..
@ControllerAdvice
public class GlobalExceptionHandler {

	//로그인 실패 예외처리 
	@ExceptionHandler(LoginFailException.class)
	public String handle(LoginFailException e, Model model) {
		model.addAttribute("e", e);
		return "error/result";
	}
}