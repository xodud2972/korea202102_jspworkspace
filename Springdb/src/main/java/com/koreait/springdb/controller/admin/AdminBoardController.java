package com.koreait.springdb.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminBoardController {
	
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public void main() {
		System.out.println("관리자 테스트");
	}
}
