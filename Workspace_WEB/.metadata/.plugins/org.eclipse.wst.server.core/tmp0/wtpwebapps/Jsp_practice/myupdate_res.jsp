<%@page import="com.board.dto.BoardDto"%>
<%@page import="com.board.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%request.setCharacterEncoding("UTF-8"); %>
<%response.setContentType("text/html ; charset=utf-8"); %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%

	int seq= Integer.parseInt(request.getParameter("seq"));
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	
	BoardDao dao = new BoardDao();
	BoardDto dto = new BoardDto();
	dto.setSeq(seq);
	dto.setTitle(title);
	dto.setContent(content);
	int res = dao.myupdate(dto);
	
	if(res>0){
	

%>

<script type="text/javascript">
confirm("수정하시겠습니까?");
alert("수정 성공!")
location.href="mylist.jsp";

</script>
<%
	}else{
%>

<script type="text/javascript">
alert("수정 실패")
location.href="mylist.jsp";

</script>

<%
	}
%>
</body>
</html>