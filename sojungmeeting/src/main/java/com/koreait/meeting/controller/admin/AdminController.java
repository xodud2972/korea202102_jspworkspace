package com.koreait.meeting.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koreait.meeting.domain.Admin;
import com.koreait.meeting.exception.MemberExistException;
import com.koreait.meeting.model.service.admin.AdminService;



/**
 * Handles requests for the application home page.
 */
@Controller
public class AdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private AdminService adminService;
	
	
	//로그인 폼 요청 처리 
	@RequestMapping(value="/loginform", method=RequestMethod.GET)
	public String loginForm(HttpServletRequest request) {
		return "admin/login/loginform";
	}
	
	//로그인 요청 처리 
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(Admin admin, HttpServletRequest request) {
		logger.info("아이디 {} ", admin.getEmail());
		
		//3단계: 일 시키기 
		Admin obj=adminService.login(admin);
		
		//4단계: 저장 
		HttpSession session=request.getSession();
		session.setAttribute("admin", obj);// request가 아닌 세션에 저장함 
		return "redirect:/admin/main"; //어드민 메인페이지 명
	}
	
	//관리자 메인 페이지 요청 
	@GetMapping("/main")
	public String getMain(HttpServletRequest request) {
		return "admin/main/index";
	}
	
	
	
	//위의 요청을 처리하는 메서드 중에서 , 어느것 하나라도 예외가 발생하면 아래의 메서드가 동작하게 됨
	@ExceptionHandler(MemberExistException.class)
	public String handleException(MemberExistException e, Model model) {
		model.addAttribute("e", e); //에러객체 저장
		
		return "error/result";
	}
	
	
}