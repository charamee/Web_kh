<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.board.dto.BoardDto"%>
<%@page import="com.board.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html;charset=utf-8"); %>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

	a:link{
		text-decoration: none;
		color: black;
	}
	
	a:visited{
		text-decoration: none;
		color: black;
	}
	
	tr{
		text-align: center;
	}



</style>
</head>
<body>

<h1>글 전체보기</h1>

<table border="1">
	<col width="70">
	<col width="100">
	<col width="300">
	<col width="100">
	
	<tr>
		<th>글번호</th>
		<th>작성자</th>
		<th>제목</th>
		<th>날짜</th>
	</tr>
	
<%
	BoardDao dao = new BoardDao();
	BoardDto dto = new BoardDto();
	
	
	List<BoardDto> list = dao.mylist();
	
	
	for(int i=0;i<list.size();i++){

%>	
	
	<tr>	
		<td><%=list.get(i).getSeq()%></td>
		<td><%=list.get(i).getWriter() %></td>
		<td><a href="myselect.jsp?seq=<%=list.get(i).getSeq()%>"><%=list.get(i).getTitle() %></a></td>
		<td><%=list.get(i).getRegdate() %></td>
	</tr>
	
	
<%
	}
%>	
	
	<tr> 
		<td colspan="4" align="right">
			<input type="button" value="글쓰기" onclick="location.href='myinsert.jsp'">
		</td>
	
	</tr>





</table>

</body>
</html>