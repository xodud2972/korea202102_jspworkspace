<%@page import="com.koreait.site0622.model.domain.News"%>
<%@page import="java.util.List"%>
<%@page import="com.koreait.site0622.model.news.dao.NewsDAO"%>
<%@page import="com.koreait.site0622.model.news.dao.MybatisNewsDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%!	NewsDAO newsDAO=new MybatisNewsDAO(); %>
<%
	List<News> newsList = newsDAO.selectAll();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width="100%" border="1px">
		<tr>
			<th>No</th>
			<th>제목</th>
			<th>작성자</th>
			<th>등록일</th>
			<th>조회수</th>
		</tr>
		<%for(News news : newsList){ %>
		<tr>
			<td><%=0%></td>
			<td><%=news.getTitle()%></td>
			<td><%=news.getContent()%></td>
			<td><%=news.getRegdate()%></td>
			<td><%=news.getHit()%></td>
		</tr>
		<%} %>
		<tr>
			<td colspan="5">
				<button onclick="location.href='/news/regist.jsp';">글등록</button>
			</td>
		</tr>
	</table>
</body>
</html>







