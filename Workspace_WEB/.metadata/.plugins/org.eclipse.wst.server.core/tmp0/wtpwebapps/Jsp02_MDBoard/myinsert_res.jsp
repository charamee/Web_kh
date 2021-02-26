<%@page import="com.mdboard.dto.MDBoardDto"%>
<%@page import="com.mdboard.biz.MDBoardBizImpl"%>
<%@page import="com.mdboard.biz.MDBoardBiz"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%request.setCharacterEncoding("UTF-8"); %>
<%response.setContentType("text/html; charset=UTF-8");%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	String writer = request.getParameter("writer");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	
	MDBoardBiz biz = new MDBoardBizImpl(); 
	MDBoardDto dto = new MDBoardDto();
	dto.setWriter(writer);
	dto.setTitle(title);
	dto.setContent(content);
	
	int res = biz.insert(dto);
	
	if(res>0){
%>

<script type="text/javascript">
alert("글쓰기 성공!")
location.href="boardlist.jsp"

</script>

<%
	}else{
%>

<script type="text/javascript">
alert("글쓰기 실패.......")
location.href="boardlist.jsp"
</script>

<%
	}
%>
</body>
</html>