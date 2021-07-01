package com.koreait.model2app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 모든 하위 컨트롤러가 반드시 구현해야 할 메서드 정의
public interface Controller {
	// 형님으로 부터 받은 요청 정보를 이용하여 실제 요청을 처리하는 메서드
	public void  execute(HttpServletRequest request, HttpServletResponse response);
	public String getViewName(); // 응답시 보여질 결과 페이지
}
