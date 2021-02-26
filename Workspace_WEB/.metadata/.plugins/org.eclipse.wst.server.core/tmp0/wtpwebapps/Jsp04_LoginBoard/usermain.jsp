<%response.setHeader("Cache-control", "no-store"); %>


<%@page import="com.login.dto.MyMemberDto"%>
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
	MyMemberDto dto =(MyMemberDto)session.getAttribute("dto"); //컨트롤러에서 dto 받아와서 형변환 
	if(dto==null){
		pageContext.forward("index.html");
	}
	
	

%>

	<div>
	<h1><%=dto.getMyid() %>님 환영합니다.</h1>
	<a href="logincontroller.jsp?command=logout">logout</a>
	
	</div>

		<div>
			<a href="logincontroller.jsp?command=updateuser&myno=<%=dto.getMyno()%>">내 정보 수정</a>
		</div>
		
		<div>
			<a href="logincontroller.jsp?command=deleteuser&myno=<%=dto.getMyno()%>">회원 탈퇴(enabled='n')</a>
		</div>


</body>
</html>