<%@page import="com.board.dto.BoardDto"%>
<%@page import="com.board.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	int seq= Integer.parseInt(request.getParameter("seq"));

	BoardDao dao = new BoardDao();
	BoardDto dto = dao.selectOne(seq);

%>

<h1>글 수정하기</h1>

<form action="myupdate_res.jsp" method="post">
	<input type="hidden" value="<%=dto.getSeq()%>" name="seq">

	<table border="1">
	

	
		<tr> 
			<th>작성자</th>
			<td> 
				<%=dto.getSeq() %>
			</td>
		</tr>
	
	
		<tr> 
			<th>제목</th>
			<td> 
				<input type="text" name="title" value="<%=dto.getTitle()%>">
			</td>
		</tr>
	
		<tr> 
			<th>내용</th>
			<td> 
				<textarea rows="10" cols="50" name="content"><%=dto.getContent() %></textarea>
			</td>
		</tr>
		
		<tr>
			<td colspan="2" align="right">
		 		<input type="submit" value="확인"> 
			</td>
		</tr>
	

	</table>



</form>

</body>
</html>