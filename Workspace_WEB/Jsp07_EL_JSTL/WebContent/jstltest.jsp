<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- corelibrary를 사용하고 있다.  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>JSTL : Jsp Standard Tag Library</h1>
	
	<table border="1">
	
		<tr>
			<th>이름</th>
			<th>국어</th>
			<th>영어</th>
			<th>수학</th>
			<th>총점</th>
			<th>평균</th>
			<th>등급</th>
			
		</tr>
		<!-- eq: == , ne : != , empty : null -->
		<c:forEach items = "${list }" var="score">
		<!-- items : 객체 var: 변수 -->
			<tr>
				<td>
					<c:if test="${score.name eq '이름10' }">
					 <c:out value="홍길동"></c:out>
					 <!-- print와 같은역할..? 여기서는밑에서 other에 20,30 이외에 누구지? 가 추가로 나온다 -->
					</c:if>
					
					<!-- when, otherwise를 감싸고있는 태그  -->
					<!-- eq : == -->
					<c:choose> 
						<c:when test="${score.name eq '이름20' }">
						
							<c:out value="${score.name }님!"></c:out>
						
						</c:when>
						<c:when test="${score.name eq '이름30' }">
							<c:out value="${score.name }"></c:out>
						</c:when>
						<c:otherwise>
							<c:out value="누구지???"></c:out>
						</c:otherwise>
					
					
					</c:choose>
				
				
				
				</td>
				<td>${score.kor }</td>
				<td>${score.eng }</td>
				<td>${score.math }</td>
				<td>${score.sum }</td>
				<td>${score.avg }</td>
				
				<td>
					<c:choose>
						<c:when test="${score.grade eq 'A' || score.grade eq 'B'}">
							<c:out value="PASS"></c:out>
						
						</c:when>
						<c:otherwise>
							<c:out value="FAIL"></c:out>
						</c:otherwise>
					
					</c:choose>
				</td>
			
			
			
			</tr>
		
		
			</c:forEach>
	
	
	
	
	</table>
	<table border="1">
	    <tr>
		 	<th>구구단</th>
		 	<th colspan="9">값</th>
		 </tr>
	
	<c:forEach var="i" begin="2" end="9" step="1">
		<tr><td>${i}단</td>
		
		<c:forEach var="j" begin="1" end ="9" step="1">
			
		<td>${i}*${j}=${i*j }</td>
		 
		 
		 
		</c:forEach>
		 </tr>
	</c:forEach>
	
	</table>
</body>
</html>