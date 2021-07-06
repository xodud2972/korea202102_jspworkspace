package com.koreait.springmvctest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.koreait.springmvctest.model.board.dao.BoardDAO;

public class ListController implements Controller {
	// 3단계 , 4단계
	private BoardDAO boardDAO;
	
	//setter 주입을 위해
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List boardList = boardDAO.selectAll(); // 3단계
		ModelAndView mav = new ModelAndView(); //4단계
		mav.addObject("boardList", boardList); // request 에 setAttribute() 한것 과 같다.
		mav.setViewName("board/list"); // 뷰이름 반환(접두어, 접미어 뺴고)
		return mav;
	}

}
