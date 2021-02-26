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

	<!-- session scope에서 sc가 있다면 호출해주고 없다면 객체를 만들어준다.  -->
  	<jsp:useBean id="sc" class="com.el.dto.Score" scope="session"></jsp:useBean>
  	
  	<h1><jsp:getProperty property="name" name="sc"/></h1> <!-- 객체만든 sc를 통해서 name을 호출 -->
  	<h1>${sc.name }</h1> <!-- 바로 sc.name 으로 바로바로 바로 호출  -->

</body>
</html>