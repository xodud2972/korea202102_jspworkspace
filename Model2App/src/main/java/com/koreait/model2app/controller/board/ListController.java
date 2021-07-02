package com.koreait.model2app.controller.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.model2app.controller.Controller;
import com.koreait.model2app.model.board.dao.BoardDAO;
import com.koreait.model2app.model.board.dao.JdbcBoardDAO;
import com.koreait.model2app.model.board.dao.MybatisBoardDAO;

//Board의 요청 중 목록 요청을 처리하는 하위 컨트롤러 
//3단계: 알맞는 객체에 일시킨다,  4단계: 결과가 있다면 결과저장(형님 컨트롤러가 사용할 수 있는 접근장소) 
public class ListController implements Controller{
	BoardDAO boardDAO;
	public ListController() {
		//boardDAO = new MybatisBoardDAO();
		boardDAO = new JdbcBoardDAO();
	}
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		List list=boardDAO.selectAll();
		request.setAttribute("boardList", list);//4단계: 결과 저장
	}

	public String getViewName() {
		return "/result/board/list";
	}
	@Override
	public boolean isForward() { //형님 컨트롤러와 공유할 데이터 있슴
		return true;
	}
}
