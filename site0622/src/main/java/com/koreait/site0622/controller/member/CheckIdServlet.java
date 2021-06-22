package com.koreait.site0622.controller.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.site0622.model.domain.Member;
import com.koreait.site0622.model.member.dao.MemberDAO;
import com.koreait.site0622.model.member.dao.MybatisMemberDAO;
import com.koreait.site0622.util.message.MessageObject;

// 아이디 중복 체크 여부 확인 서블릿 
public class CheckIdServlet extends HttpServlet{
	MemberDAO memberDAO;
	MessageObject messageobject;
	
	public void init() throws ServletException {
		memberDAO = new MybatisMemberDAO();
		messageobject = new MessageObject();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터 넘겨받아, member 테이블에 이미 존재하는지 여부를 체크해보자.
		String user_id = request.getParameter("user_id");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print("넘겨받은 아이디" + user_id + "<br>");
		Member member = memberDAO.getMemberById(user_id); //다형성
		if(member==null) {
			//회원가입 진행해도 된다.
			out.print(messageobject.getMsgURL("사용 가능한 아이디 입니다.", "/member/signup.jsp"));
		}else {
			//회원가입 진행을 거절한다.
			out.print(messageobject.getmsgBack("이미 사용 중인 아이디 입니다."));
		}
		
	}
}
