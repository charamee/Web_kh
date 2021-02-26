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

	<h1>useBean 을 통한 객체 생성!!</h1>
	
	<!-- session scope에서 sc가 있다면 호출해주고 없다면 객체를 만들어준다.  -->
	<!-- Score sc = new Score();과 같은것이다. scope : 저장될 범위 지정해줄수있다. -->
	<jsp:useBean id="sc" class="com.el.dto.Score" scope="session"></jsp:useBean>
	<!-- 위에서 만든 객체의 setter == sc.setName(); -->
	<jsp:setProperty property="name" name="sc" value="홍길동"/> 
	<!-- sc.getName(); -->
	<jsp:getProperty property="name" name="sc"/>
	
	<button onclick="location.href='result.jsp'">result</button>

</body>
</html>