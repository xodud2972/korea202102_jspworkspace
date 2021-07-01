package com.koreait.model2app.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 웹 클라이언트의 모든 ~~~ 요청을 받는 유일한 진입점 서블릿 ( 요청을 분석하여 어떤 하위컨트롤러가 
// 요청을 전담할지를 결정짓고, 해당 하위컨트롤러가 업무를 마친 후에는 결과를 다시 클라이언트에게 전달 즉 응답을 처리한다. )
// 1.요청을 받는다 2. 요청을 분석 5 단계 처리
public class DispatcherServlet extends HttpServlet{
	// 아래의 객체들은 적어도 분석하기 전에는 미리 메모리에 올라와 있어야 함 (생성자 또는 init을 통해 처리)
	Properties props; // java.uril 컬렉션 프레임웤 객체 중 Map의 자식
	FileReader reader; // 프로퍼티스 객체는 자체적으로 파일에 접근할 수 없기 때문에 파일스트림이 필요하다.
	
	public void init(ServletConfig config) throws ServletException {
		props = new Properties();
		try {
			// 파일의 경로는 개발자의 육안이 아니라 프로그래밍 적으로 얻어와야, 이 웹 어플리케이션을 윈도우가 아닌 다른
			// 플랫폼에서 실행할 때 문제가 되지 않는다.
			// jsp의 application 내장객체가 필요한 시점이다. 하지만, 현재 코드는 서블릿이므로, application 내장객체의
			// 자료형을 개발자가 알아야한다. ServletContext (서블릿의 맥락 == 현재서블릿이 실행되는 어플리케이션 ) 
			// 어플리케이션의 전역적 정보를 가진 객체이다.
			ServletContext context = config.getServletContext(); // application 내장객체의 원형
			
			// 유지보수성을 높이려면, 설정정보 등은 자바코드안에 두기보다는 외부 설정 파일에 둬서, 변경하기 쉽게
			// 처리하는 방식이 일반적이다. ( ex : JNDI가 대표적)
			String realPath = context.getRealPath(config.getInitParameter("contextConfigLocation"));
			
			reader = new FileReader(realPath);
			try {
				props.load(reader); // 프로퍼티스 객체가 스트림을 이용하는 시점 즉 파일을 검색하기 위한 준비 끝
			} catch (IOException e) {
				e.printStackTrace();
			} 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}
	protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 하위 컨트롤러에게 request, response 객체를 전달하기 전에 공통적인 기능이 있다면, 형님 컨트롤러에서 
		// 처리해줘야 코드 중복을 피할 수 있다 ( 안해도 되지만 코드가 속상하다. )
		request.setCharacterEncoding("utf-8");
		
		// 요청을 분석( uri 분석한다. )
		String uri = request.getRequestURI();
		System.out.println("요청받은 uri 는" + uri);
		
		//if문 대신, props 파일을 탐색하기
		String className = props.getProperty(uri);
		System.out.println("이 요청에 동작할 클래스 명은 "+className);
	}
	
	// 서블릿의 생명주기 메서드 중, 서블릿 소멸시 호출되는 destory() 재정의
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
