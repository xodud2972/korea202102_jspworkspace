package test;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

// 웹서버가 가동될 떄 를 감지하여, 원하는 메시지 심기
public class MyListener implements ServletContextListener{
	
	public void contextDestroyed(ServletContextEvent sce) {
		// 웹어플리케이션을 가동할 때 호출되는 메서드
		System.out.println("서버 가동하네요");
		ServletContext servletContext = sce.getServletContext();
		servletContext.setAttribute("obj","야호~~");
	}
	
	public void contextInitialized(ServletContextEvent sce) {
		// 웹어플리케이션을 중지할 때 호출되는 메서드
		System.out.println("서버 중지하네요");
	}

}
