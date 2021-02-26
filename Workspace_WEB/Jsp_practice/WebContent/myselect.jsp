<%@page import="com.board.dao.BoardDao"%>
<%@page import="com.board.dto.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% request.setCharacterEncoding("UTF-8");%>
<%response.setContentType("text/html ; charset=UTF-8");%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>선택 글 보기</h1>

<table border="1">


<%
	int seq =Integer.parseInt(request.getParameter("seq"));

	BoardDao dao = new BoardDao();
	BoardDto dto = dao.selectOne(seq);


%>
	<tr>
	 <th>작성자</th>
	 <td><%=dto.getWriter() %></td>
	</tr>
	<tr>
	 <th>제목</th>
	 <td><%=dto.getTitle() %></td>
	</tr>
	
	<tr>
	 <th>내용</th>
	 <td>
	 	<textarea rows="10" cols="50" readonly="readonly"><%=dto.getContent() %></textarea>
	 </td>
	</tr>
	
	<tr>
		<td colspan="2" align="right">
			<input type="button" value="수정" onclick="location.href='myupdate.jsp?seq=<%=dto.getSeq()%>'">
			<input type="button" value="목록" onclick="location.href='mylist.jsp'">
			<input type="button" value="삭제" onclick="location.href='mydelete.jsp?seq=<%=dto.getSeq()%>'">
		</td>
	</tr>

</table>

</body>
</html>