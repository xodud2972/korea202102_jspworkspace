package site0616.test;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//���� Ŭ������ �׳� Ŭ�����̹Ƿ�, �������̳ʿ��� �ؼ� �� ����Ǳ� ���ؼ��� �������� �����ؾ� �Ѵ�
public class MyServlet extends HttpServlet{
	//�Ʒ��� �޼���� ������ �ν��Ͻ��� �������� ����, �������̳��� ���Ͽ� ���� �ʱ�ȭ �Ǳ� ���� �뵵�� ���ȴ� 
	//�׸��� init�޼����� �Ű������� ���޵Ǵ� ServletConfig ��ü��, �� �״�� ������ ȯ�������� ����ִ� ��ü�̴�!
	//�׸��� �� ServletConfig ��ü��, ���Ͽ� ���� �����Ǿ� �������� ���޵Ǿ� ���� 
	public void init(ServletConfig config) throws ServletException {
		String msg=config.getInitParameter("msg");
		System.out.println(msg);
	}
	
	//��û�� ó���ϴ� �޼��� 
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	//Ŭ���̾�Ʈ�� ��û�� Get����� ��� �����ϴ� �޼���, �� �޼���� service �޼��忡 ���� ȣ��ȴ�!
	//�̶�, ���ǵ� ��û, ���� �Ű������� service �޼����� ���� ���޹ް� �ȴ�. �� ���������� ������ ó���ϴ� �޼���� 
	//�ٷ� doXXX�̴� 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() �޼��忡�� ��û�� ó���մϴ�");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost() �޼��忡�� ��û�� ó���մϴ�");
	}
	
	@Override
	public void destroy() {
		System.out.println("�� �׾��..");
	}
}





