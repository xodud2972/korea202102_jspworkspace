package com.koreait.springmvc0707.controller.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.koreait.springmvc0707.model.board.service.BoardService;

import lombok.Setter;

// 게시판 목록 요청 처리하는 하위 컨트롤러
@Setter
public class ListController implements Controller{
	
	// 스프링으로부터 주입 받자 
	private BoardService boardService; // null
	
	// 3단계, 4단계
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 3단계 : 일시킨다.
		List boardList = boardService.selectAll();
		
		System.out.println("결과는 "+boardList);
		
		//4단계 : 결과저장
		request.setAttribute("boardList", boardList);
		
		ModelAndView mav = new ModelAndView(); // Model(보관할 데이터 넣을 수 있는 객체) + View(뷰이름을 갖는 객체)
		mav.addObject("boardList", boardList);
		mav.setViewName("board/list"); // 해석자가 이부분을 넘겨받아 실제 jsp 로 해석할 것이다.
		
		return mav;
	}
	
}
