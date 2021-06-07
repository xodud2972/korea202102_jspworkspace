<%@ page contentType = "text/html; charset=utf-8"%>
<%
/* jsp 란 ?
	- Java Server Page : 자바기술로 오직 서버에서만 실행되는 파일
	결론 : 우리가 알고 있는 javaSE에 사용했던 문법이 그래도 사용될 수 있다.

	- jsp 파일의 작성 영역 ( 총 4가지 영역을 갖는다 )
	(1) 지시영역 (필수) -  현재 페이지에 대한 정보 및 설정, 응답시 head 정보를 구성한다.
	(2) 선언부 (선택) 
	(3) 스크립틀릿 (필수) [% 영역%]
							-	 로직을 작성하는 영역, 즉 클래스의 인스턴스 메서드 영역임
	(4) 표현식 (선택) 
*/
	// response.writeHead(200, {"Content-type":"text.html;charset=utf-8"});
	// node.js 에서의 response.end() 응답정보 전송
	out.print("나의 my jsp"); 

	// 구구단 출력해보기
	for(int i=1;i<=9;i++){
		out.print(3+"*"+i+"="+(3*i)+" <br>");
	}

	
%>