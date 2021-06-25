package com.koreait.site0625.controller.reboard;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.site0625.model.domain.ReBoard;
import com.koreait.site0625.model.reboard.dao.MybatisReBoardDAO;
import com.koreait.site0625.model.reboard.dao.ReBoardDAO;
import com.koreait.site0625.util.message.MessageObject;

public class RegistServlet extends HttpServlet{
	ReBoardDAO reboardDAO;
	MessageObject obj;
	
	public void init() throws ServletException {
		//reboardDAO = new JdbcReBoardDAO();
		reboardDAO = new MybatisReBoardDAO();
		obj=new MessageObject();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터 받기
		request.setCharacterEncoding("utf-8");
		String title=request.getParameter("title");
		String writer=request.getParameter("writer");
		String content=request.getParameter("content");
		
		//VO에 담기 
		ReBoard reboard = new ReBoard();
		reboard.setTitle(title);
		reboard.setWriter(writer);
		reboard.setContent(content);
		
		//쿼리실행 
		int result=reboardDAO.insert(reboard);
		
		//쿼리수행 후 vo에는 최근에 증가된 pk가 들어있을것이다!!
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//out.print("글등록 후 반환된 pk는 "+reboard.getReboard_id());
		if(result==0) {
			out.print(obj.getMsgBack("등록실패"));
		}else {
			out.print(obj.getMsgURL("등록성공","/reboard/list.jsp"));
		}
	}
}








