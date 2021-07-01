package com.koreait.model2app.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//웹클라이언트의 모든~~~요청을 받는 유일한 진입점 서블릿( 요청을 분석하여 어떤 하위컨트롤러가 요청을 전담할
//를 결정짓고, 해당 하위컨트롤러가 업무를 마친후엔, 결과를 다시 클라이언트에게 전달 즉 응답을 처리한다) 
//1.요청을 받는다 ,2.요청을 분석, 5단계 처리 
public class DispatcherServlet extends HttpServlet{
	//아래의 객체들은 적어도 분석하기 전에는 미리 메모리에 올라와 있어야 함 (생성자 또는 init을 통해 처리)
	Properties props; //java.util 컬렉션 프레임웍 객체 중 Map의 자식
	FileReader reader; //프로퍼티스 객체는 자체적으로 파일을 접근할 수 없기 때문에 파일스트림이 필요함
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		props = new Properties();
		try {
			//파일의 경로는 개발자의 육안이 아닌 프로그래밍적으로 얻어와야, 이 웹어플리케이션을 윈도우 아닌
			//다른 플랫폼에서 실행할때 문제가 되지 않음
			//jsp의 application내장객체가 필요한 시점임..하지만 현재 코드는 서블릿이므로, application내장객체
			//의 자료형을 개발자가 알아야 한다... ServletContext !!(어플리케이션의 전역적 정보를 가진 객체)
			ServletContext context = config.getServletContext(); //application 내장객체의 원형
			
			//유지보수성을 높이려면, 설정정보 등은 자바코드안에 두기보다는 외부 설정파일에 두어서 , 변경하기 쉽게
			//처리하는 방식이 일반적이다.. (ex: JNDI가 대표적) 
			String realPath = context.getRealPath(config.getInitParameter("contextConfigLocation"));
			
			reader = new FileReader(realPath);
			props.load(reader); //프로퍼티스 객체가 스트림을 이용하는 시점!!!즉 파일을 검색하기 위한 준비끝
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
 			e.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}
	protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//하위컨트롤러에게  request, response 객체를 전달하기 전에 공통적인 기능이 있다면, 형님 컨트롤러에서
		//처리해줘야 코드 중복을 피할 수 있다!! ( 안해도 되지만 코드가 속상함..) 
		request.setCharacterEncoding("utf-8");
		
		
		//2단계: 요청을 분석(uri분석한다) , 더이상 if문은 사용하지 않는다!! (Map으로 대체됨)
		String uri = request.getRequestURI();

		//if문 대신, props파일을 탐색하기!!
		//이렇게 매 요청마다 처리할 로직을 전담 객체를 1:1 부여하는 방식을 가리켜 command pattern이라 한다(by GOF) 
		String className = props.getProperty(uri);
		System.out.println(uri+" 요청에 동작할 클래스명은"+className);
		
		//클래스이름을 이용하여, 클래스 Load하기 !!
		Controller controller=null;
		try {
			Class controllerClass = Class.forName(className);
			
			//파일에 명시된 클래스명을 이용하여, 동적으로 인스턴스를 생성하는 방법 == 팩토리패턴(Factory pattern)이라 한다
			controller=(Controller)controllerClass.newInstance(); //인스턴스 생성 ( 하위컨트롤 생성)
			controller.execute(request, response);//하위 컨트롤러 동작!!
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		//5단계: 응답정보를 이용한, 응답처리(즉 결과보여주기) 
		//결과는 MVC 중 view담당하므로, 현재 파일과는 다른 jsp에서 처리
		//주의) 응답을 하면 네트워크 끊기도 요청프로세스가 종료되므로, 응답을 하지않고 원하는 jsp 자원에 포워딩
		String viewName=controller.getViewName(); //  /blood/result
		//넘겨받은 viewName을 이용하여 다시 mapping파일 검색한다!!
		String viewPage=props.getProperty(viewName); //   /blood/result key 값에 대응되는 값인 /blood/result.jsp 반환
		
		//포워딩일 경우
		if(controller.isForward()) {
			RequestDispatcher dis=request.getRequestDispatcher(viewPage);
			dis.forward(request, response);//포워딩 시작
		}else {
			//다시 재접속을 명령하는 경우 redirect ==  location.href
			response.sendRedirect(viewPage); //지정한 url로 다시 재접속할것을 클라이언트에게 명령
		}		
	}
	
	//서블릿의 생명주기 메서드 중, 서블릿 소멸시 호출되는 destory() 재정의 
	@Override
	public void destroy() {
		if(reader!=null) {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}





















