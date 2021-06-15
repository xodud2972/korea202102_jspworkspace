//목록 요청을 처리하는 서블릿
package servlet.board;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ListServlet extends HttpServlet{
	
	//요청처리 메서드
	public void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		response.setContentType("text/html;utf-8");



//		response.setCharacterEncoding("utf-8");

		PrintWriter out = response.getWriter();
		

		Connection con =null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;

		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");// 드라이버 로드
		//접속
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","webmaster","1234");
		

		if(con!=null){
			out.print("connection ok <br>");
			// select문 실행
			String sql="select * from board order by board_id desc";
			pstmt=con.prepareStatement(sql); //쿼리객체준비
			rs=pstmt.executeQuery(); // 쿼리 실행 및 레코드 반환
			//rs를 html 표table로 출력
			out.print("<table width='100%' border='1px'>");
			
			out.print("<tr>");
			out.print("<th>No</th>");
			out.print("<th>title</th>");
			out.print("<th>wrtier</th>");
			out.print("<th>regdate</th>");
			out.print("<th>hit</th>");
			out.print("</tr>");

			//반목문으로 tr처리
			while(rs.next()){
				out.print("<tr>");
				out.print("<th>No</th>");
				out.print("<th>"+rs.getString("title")+"</th>");
				out.print("<th>"+rs.getString("writer")+"</th>");
				out.print("<th>"+rs.getString("regdate")+"</th>");
				out.print("<th>"+rs.getInt("hit")+"</th>");
				out.print("</tr>");
			}

			out.print("</table>");

			// 접속해제
		}else{
			out.print("connection fail <br>");
		}
	}catch(ClassNotFoundException e){ // java.lang에 있기 때문에 import할 필요 없다.
		e.printStackTrace(); // 스택에러가 출력되는 곳은? 서버의 콘솔창 또는 log파일
	}catch(SQLException e){ // java.lang에 있기 때문에 import할 필요 없다.
		e.printStackTrace(); 
	}finally{
		if(rs!=null){
			try{rs.close();}catch(SQLException e){}
			}
		if(pstmt!=null){
			try{pstmt.close();}catch(SQLException e){}
			}
		if(con!=null){
			try{con.close();}catch(SQLException e){}
			}
		}
	}

}
