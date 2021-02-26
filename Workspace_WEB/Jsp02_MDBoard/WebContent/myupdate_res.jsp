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
	int seq =Integer.parseInt(request.getParameter("seq"));
	String title = request.getParameter("title");
	String content = request.getParameter("content");

	MDBoardBiz biz = new MDBoardBizImpl();
	MDBoardDto dto = new MDBoardDto();
	dto.setSeq(seq);
	dto.setTitle(title);
	dto.setContent(content);
	
	
	int res = biz.update(dto);
	
	if(res>0){

%>
<script type="text/javascript">
alert("수정 성공")
location.href="boardlist.jsp"
</script>

<%
	}else{
%>
<script type="text/javascript">
alert("수정 실패! ")
location.href="boardlist.jsp"
</script>
<%
	}
%>

</body>
</html>