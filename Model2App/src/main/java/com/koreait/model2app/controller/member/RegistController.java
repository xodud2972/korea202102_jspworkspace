package com.koreait.model2app.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.model2app.controller.Controller;
import com.koreait.model2app.exception.LicenseRegistException;
import com.koreait.model2app.model.domain.Member;
import com.koreait.model2app.model.member.service.MemberService;
import com.koreait.model2app.model.member.service.MemberServiceImpl;
import com.koreait.model2app.util.FileManager;

//회원의 등록 요청을 처리하는 하위 컨트롤러
public class RegistController implements Controller{
	//3단계: 알맞는 로직객체에 일 시킨다 , 4단계: 결과가 있을때는 저장 (X)
	MemberService memberService;
	FileManager fileManager;
	String viewName;//성공 or 에러 페이지값을 담을 변수
	boolean forward;//포워딩 여부를 결정짓는 변수
	
	public RegistController() {
		memberService = new MemberServiceImpl();
	}
	
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		Member member=fileManager.saveFile(request);//파일 업로드 
		
		try {
			memberService.regist(member, request);
			viewName="/result/member/regist";
			//리스트로 재접속하게 해야 함
			forward=false;
		}catch(LicenseRegistException e) {
			viewName="/result/error";
			//에러페이지로 결과 메시지를 가져가야 함
			forward=true;
			request.setAttribute("obj", e);//결과 저장
		}
	}
	
	public String getViewName() {
		return viewName;
	}
	public boolean isForward() {
		return forward;//재접속을 시킬것임!!
	}	
}
