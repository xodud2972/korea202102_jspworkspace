package com.koreait.springmvctest.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.koreait.springmvctest.model.board.dao.BoardDAO;
import com.koreait.springmvctest.model.board.dao.MybatisBoardDAO;

// 게시판과 관련된 요청을 처리하는 하위 컨트롤러
@Controller
public class BoardController {
	private BoardDAO boardDAO;
	
	public BoardController() {
		boardDAO = new MybatisBoardDAO(); // 결합도가 너무 강하다 따라서 약화시키려면 DI로 MybatisBoardDAO 주입 !
	}
	
	// 게시판 목록 요청
	@RequestMapping("/board/list")
	public String selectAll(Model model) {
		List list = boardDAO.selectAll();
		model.addAttribute("boardList", list);  //4단계 : 결과저장
		return "board/list";
	}
	
	// 게시글 등록 요청
	
	
	// 상세보기 요청
	
	
	// 수정하기 요청
	
	
	// 삭제하기 요청
	
}
