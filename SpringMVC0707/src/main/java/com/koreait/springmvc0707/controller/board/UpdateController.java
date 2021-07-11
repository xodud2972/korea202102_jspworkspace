package com.koreait.springmvc0707.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.koreait.springmvc0707.model.board.service.BoardService;

import lombok.Setter;

//수정 요청을 처리하는 하위 컨트롤러
@Setter
public class UpdateController implements Controller{
	private BoardService boardService;
	
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//3단계
		String board_id = request.getParameter("board_id");
		String title= request.getParameter("title");
		String writer= request.getParameter("writer");
		String content = request.getParameter("content");
		
		System.out.println("제목은 "+title);
		
		//boardService.update(null);
		
		//4단계 : 결과를 저장하지 않고, /board/detail?board_id=7 로 redirect하겠다. 즉 다시 접속을 유도할 것이다.
		
		return null;
	}

}
