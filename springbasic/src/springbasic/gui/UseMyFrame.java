package springbasic.gui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UseMyFrame {
	
	public static void main(String[] args) {
		//MyFrame 클래스에 주입할 객체를 명시한 xml을 읽어들이고 실행하여 MyFrame을 동작시킨다.
		ApplicationContext context; //xml에 명시한 객체 즉 Bean들을 관리해주는 컨테이너
		
		context = new ClassPathXmlApplicationContext("spring/config/gui.xml"); //컨테이너 생성(XML로드완료)
		
		Object obj = context.getBean("myFrame");
		MyFrame myFrame = (MyFrame)obj; // 알맞는 자료형으로 형 변환
		myFrame.init();
	}
}
