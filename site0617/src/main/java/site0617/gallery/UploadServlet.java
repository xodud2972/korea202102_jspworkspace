package site0617.gallery;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//�̹� jsp�ε� ���ε� ó���� �����ϰ�����, ������ �ٽ� �ѹ� �����غ����� �� Ŭ������ �ۼ��ϴ� ����!!
public class UploadServlet extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("���� ���ε� ó���Ҳ���");
		
		request.setCharacterEncoding("utf-8");
		
	}
	
}