package com.koreait.site0622.controller.news;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.site0622.model.domain.News;
import com.koreait.site0622.model.news.dao.MybatisNewsDAO;
import com.koreait.site0622.model.news.dao.NewsDAO;
import com.koreait.site0622.util.message.MessageObject;

// 뉴스 기사 등록 요청 처리 서블릿
public class RegistServlet extends HttpServlet{
	NewsDAO newsDAO;
	MessageObject messageObject;
	
	public void init() throws ServletException {
		newsDAO = new MybatisNewsDAO();
		messageObject = new MessageObject();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // 파라미터 인코딩
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		//VO 담기
		News news = new News();
		news.setTitle(title);
		news.setWriter(writer);
		news.setContent(content);
		
		//DAO에게 일치시키기
		int result = newsDAO.insert(news); 
		
		response.setCharacterEncoding("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if(result ==0) {
			out.print(messageObject.getMsgBack("등록실패"));
		}else {
			out.print(messageObject.getMsgURL("등록성공","/news/list.jsp"));
			
		}
		
		
	}
}
