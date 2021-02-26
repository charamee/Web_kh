<%@page import="com.board.dto.BoardDto"%>
<%@page import="com.board.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	int seq = Integer.parseInt(request.getParameter("seq"));

	BoardDao dao = new BoardDao();
	BoardDto dto = new BoardDto();
	dto.setSeq(seq);
	
	int res = dao.mydelete(dto);
	if(res>0){

%>
	<script type="text/javascript">
	confirm("삭제하시겠습니까?");
	alert("삭제 성공")
	location.href="mylist.jsp";
	</script>

<%
	}else{
%>

<script type="text/javascript">
	alert("삭제실패")
	location.href="mylist.jsp";

</script>

<%
	}
%>
</body>
</html>