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

	<h1>RESULT</h1>
	
	pageId : <%=pageContext.getAttribute("pageId") %><br> 
	<!-- 현재 페이지에서만 가능 : null -->
	requestId : <%=request.getAttribute("requestId") %> <br>
	<!-- request 받아서 다음페이지에서 가능 : 여기는 컨트롤러를 거쳐서 오기때문에 컨트롤러에서만 받을수이씀 -->
	sessionId : <%=application.getAttribute("applicationId") %> <br>
	applicationId : <%=application.getAttribute("applicationId") %> <br>
	myRequest : <%=request.getAttribute("myRequest") %> <br>

</body>
</html>