package com.koreait.springmvc0714.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.koreait.springmvc0714.exception.DMLException;
import com.koreait.springmvc0714.model.board.service.BoardService;
import com.koreait.springmvc0714.model.domain.Board;

import lombok.Setter;

@Setter
public class UpdateController implements Controller{
	private BoardService boardService;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 3단계 : 일시키기
		Board board = new Board();
		board.setBoard_id(Integer.parseInt(request.getParameter("board_id")));
		board.setTitle(request.getParameter("title"));
		board.setWriter(request.getParameter("writer"));
		board.setContent(request.getParameter("contetn"));
		
		ModelAndView mav = new ModelAndView();
		try {
			boardService.update(board);
			//성공의 경우 상세보기 재접속 유도
			mav.setViewName("redirect:/board/detail?board_id="+board.getBoard_id());
		} catch (DMLException e) {
			e.printStackTrace();
			// 에러의 경우 에러페이지로 이동
			
		}
		// 4단계 : 재접속을 유도시 저장할 것이 없음, 포워딩할 경우는 저장
		
		
		return mav;
	}

}
