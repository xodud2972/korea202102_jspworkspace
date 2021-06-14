package test;
//import javax.swing.JButton; // rt.jar jdk ��ġ �� �� �̹� jar�� ����
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter; // java se
import java.io.IOException;

// jsp ���̵�, �� �������� ����� ������ �� �ְ�, �Ʒ��� ���� �ؼ� �� ����Ǵ� Ŭ������ ������
// ����(Servlet)�̶� �ϸ�
// javaEE -- java ee for kit

// ���� Ŭ������ ���������� ����Ǹ�, Ŭ���̾�Ʈ�� �� ��û�� �ް�, ������ ó���ϴ�
// ���� Ŭ�����̴�. ���� jsp ��� ���������ε� �������� �����ϴ�.

// ������ �����ֱ� �޼ҵ�� �Ҹ��� �ֿ� �޼��尡 �����ϸ�, �� �����ֱ� �޼ҵ��
// �ϳ��� ���� ��ü�� �¾�� ���ϸ�, �Ҹ��ϴ� ������ ������ �ֿ� �޼����̴�.
// ���� Ŭ������ ��ġ�� WEB-INF/classes �̹Ƿ�, 
public class MyServlet extends HttpServlet{

	// ���� �ν��Ͻ��� �¾ ��, ������ �ʱ�ȭ �۾��� ȣ��Ǵ� �޼ҵ�
	public void init(){
		System.out.println("�� �¾��, �ʱ�ȭ �Ϸ�Ǿ��");
	}

	//�ʱ�ȭ�� �Ϸ��� ������, ��Ŭ���̾�Ʈ�� ��û�� ó���� �� �����ϴ� �޼���
	public void service(HttpServletRequest request, HttpServletResponse response){
		System.out.println("Ŭ���̾�Ʈ�� ��û�� ó���մϴ�");
		// ���������� ���� ������ �����Ͽ� �����ϱ�
		try{
			response.setCharacterEncoding("utf-8"); // ���������� ��� ���ڵ��� utf-8��
			PrintWriter out = response.getWriter(); // Ŭ���̾�Ʈ�� ����� ��� ��Ʈ��
			out.print("my servlet Test");
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	//������ �Ҹ��� �� ȣ��Ǵ� �޼���
	public void destroy(){
		System.out.println("�� ���� ���ϴ�..");
	}

	
}	

