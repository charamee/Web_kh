<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<%
	int seq = Integer.parseInt(request.getParameter("seq"));
	

%>

<jsp:useBean id="util" class="com.cal.common.Util"></jsp:useBean>


<h1>일정 수정</h1>
	<form action="cal.do" method="post">
	
	<input type="hidden" name="command" value="updateres">	
	<input type="hidden" name="seq" value="${dto.seq }">
		
		<table border="1">
			<tr>
				<th>ID</th>
				<td>${dto.id }</td>
			</tr>
			<tr>
				<th>일정</th>
				<td><jsp:setProperty property="todates" name="util" value="${dto.mdate }" />
                    <jsp:getProperty property="todates" name="util" /></td>	
			</tr>
			
			<tr>
				<th>제목</th>
				<td><input type="text" value="${dto.title }" name="title"></td>
			</tr>
			
			<tr>
				<th>내용</th>
				<td><textarea rows="10" cols="60" name="content">${dto.content }</textarea></td>
			</tr>
			
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="일정수정" >
					<input type="button" value="취소" onclick="location.href='cal.do?command=updateform&seq=${dto.seq }'">
				
				</td>
			</tr>
			
		</table>
		</form>

</body>
</html>