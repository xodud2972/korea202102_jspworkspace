package com.koreait.springmvc0707.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.koreait.springmvc0707.model.board.service.BoardService;
import com.koreait.springmvc0707.model.domain.Board;

import lombok.Setter;

//상세보기 요청을 처리하는 하위 컨트롤러
@Setter
public class DeatailController implements Controller{
	private BoardService boardService;
	
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 3단계 : 일시킨다.
		String board_id = request.getParameter("board_id"); // 파라미터 받기
		Board board = 	boardService.select(Integer.parseInt(board_id)); // 게시물 한건 반환
		
		// 4단계 : 결과 저장
		ModelAndView mav = new ModelAndView();
		mav.addObject("board",board);
		mav.setViewName("board/detail"); // 이 키워드를 완성 짓는 자는 ? ViewResolver가 해석함
		
		return mav;
	}

}
