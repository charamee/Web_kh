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
<!-- score score = request.getParameter("score") 가 생략되어있음   -->

	<h1>EL</h1>
	
	<table border="1">
		<tr>
			<th colspan="2">${score.name }님의 점수표</th>
			<!-- Error conditions, like division by zero, are handled gracefully. 
			원래는 {aa.name}을 했을때 null값이기때문에 npe 가 떠야하는데 없는그대로 처리해줌.  -->
		</tr>
		
		<tr>
			<th>국어</th>
			<td>${score.kor }</td>
			<!-- 사실은 score가 가지고 있는 score.getKor()하고있는것임 -->
		</tr>
		<tr>
			<th>영어</th>
			<td>${score.eng }</td>
		</tr>
		<tr>
			<th>수학</th>
			<td>${score.math }</td>
		</tr>
		<tr>
			<th>총점</th>
			<td>${score.sum }</td>
		</tr>
		<tr>
			<th>평균</th>
			<td>${score.avg }</td>
		</tr>
		<tr>
			<th>등급</th>
			<td>${score.grade }</td>
		</tr>
	
	</table>

</body>
</html>