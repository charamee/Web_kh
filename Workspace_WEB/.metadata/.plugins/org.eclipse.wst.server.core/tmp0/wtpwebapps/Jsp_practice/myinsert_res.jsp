<%@page import="com.board.dto.BoardDto"%>
<%@page import="com.board.dao.BoardDao"%>
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

<%
	String writer= request.getParameter("writer");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	
	BoardDao dao = new BoardDao();
	BoardDto dto = new BoardDto();
	dto.setWriter(writer);
	dto.setTitle(title);
	dto.setContent(content);
	
	
	int res = dao.insert(dto);
	
	if(res>0){


%>
	<script type="text/javascript">
		 confirm("등록 하시겠습니까?");
		 alert("등록 성공!");
		 location.href="mylist.jsp";
	
	</script>

<%
	}else{
		
	
%>


	<script type="text/javascript">
	
		alert("등록 실패ㅠㅠ");
		location.href="myinsert.jsp";
		
	
	</script>
	
<%
	}
%>


</body>
</html>