package site0617.gallery;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

//이미 jsp로도 업로드 처리가 가능하겠으나, 서블릿을 다시 한번 공부해보고자 이 클래스를 작성하는 것임!!
public class UploadServlet extends HttpServlet{
	ServletContext context;
	
	public void init(ServletConfig config) throws ServletException {
		context = config.getServletContext();
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8"); // jsp 의 어디 영역일까?
		// @page contentType="text/html;charset=utf-8"
		
		PrintWriter out = response.getWriter(); // jsp에서의 out내장객체의 print() 메서드 호출 
		out.print("제가 업로드 처리할께요<br>");  //<%="제가 업로드 처리할께요"%>  <%out.print("~~");%>
		
		request.setCharacterEncoding("utf-8"); //jsp의 request 객체의 setCharacterEncoding()과 동일
		
		//요청 파라미터 받기 (인코딩되어 전송되므로, 이를 해석(decode)할 컴포넌트가 사용되어야 한다
		//아래처럼 경로를 개발자가 직접 구할 경우, 시스템에 의존적이되므로, 이 웹어플리케이션을 다른 기반의 플랫폼에서 배포하여 실행할때
		//문제가 발생할 수있다
		//해결책? 프로그래밍적으로 경로를 동적으로 얻어와서 처리하면 됨..개발자가 하지말자!!
		//현재 어플리케이션에 대한 정보를 얻을 수 있는 javaEE의 객체를 이용해본다!!
		String path=context.getRealPath("/data");
		out.print(path);
		
		//String path="D:\\workspace\\korea202102_jspworkspace\\site0617\\src\\main\\webapp\\data";
		
		
		//첫번째 생성자는 파일명이 영문이 아닌 경우 깨진다..
		//MultipartRequest multi=new MultipartRequest(request, path); //생성자만으로도, 업로드가 완료됨!!
		
		//네번째 생성자는 업로드 용량을 제한 + 파일명의 인코딩처리 
		int maxSize = 2*1024*1024;
		try {
			//하기전
			MultipartRequest multi = new MultipartRequest(request, path, maxSize,"utf-8");
			out.print("업로드에 성공<br>");
			//이미 서버에 업로드된 파일의 이름을 바꾸자!!
			
		} catch (IOException e) {
			out.print("업로드에 실패하였습니다.용량을 확인해보세요<br>");
			e.printStackTrace(); //원인을 분석할 수 있도록 스택구조로 출력 (개발자를 위한 것)
		}
		
		out.print("업로드 완료<br>");
	}
	
}




