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
	pageContext.setAttribute("pageId", "my pageContext value"); 
	request.setAttribute("requestId","my request value");
	session.setAttribute("sessionId", "my session value");
	application.setAttribute("applicationId", "my application value");

%>
	<h1>INDEX</h1>
	
	pageId : <%=pageContext.getAttribute("pageId") %><br>
	requestId : <%=request.getAttribute("requestId") %><br>
	sessionId : <%=session.getAttribute("sessionId") %><br>
	applicationId : <%=application.getAttribute("applicationId") %> <br>
	
	<a href="result.jsp">result</a>
	
	<a href="scope.do?mytest=1">test</a>
	
	<form action="scope.do" method="post">
		<input type="hidden" name="myRequest" value="my request value 2 ">
		<input type="submit" value="controller">
		<!-- 여기서 get 방식으로 form 을 통해 값을 전달해주고있기때문에 (파라미터를 같이 전달하자) result에서 getParam 했을때 값을 호출할 수 있다.  -->
	</form>
	
	<% //pageContext.forward("scope.do"); %> 
	<!--index 페이지 자체를 포워드해서 scope.do로 보낸다 -->

	
</body>
</html>