package com.koreait.springmvc0714.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.koreait.springmvc0714.exception.DMLException;
import com.koreait.springmvc0714.model.board.service.BoardService;

public class DeleteController implements Controller{
	private BoardService boardService;
	
	
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 3단계 : 일시키기
		ModelAndView mav = new ModelAndView();
		try {
			boardService.delete(Integer.parseInt(request.getParameter("board_id")));
			mav.setViewName("redirect:/board/list");
		}catch(DMLException e) {
			e.printStackTrace();
			mav.addObject("e", e);
			mav.setViewName("error/result");
		}
		// 4단계 : 생략, 목록으로 재접속을 유도 (redirect)
		return mav;
	}

}
