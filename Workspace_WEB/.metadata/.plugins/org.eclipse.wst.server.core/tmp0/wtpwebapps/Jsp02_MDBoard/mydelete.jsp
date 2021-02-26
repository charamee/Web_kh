<%@page import="com.mdboard.dto.MDBoardDto"%>
<%@page import="com.mdboard.biz.MDBoardBizImpl"%>
<%@page import="com.mdboard.biz.MDBoardBiz"%>
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

	MDBoardBiz biz = new MDBoardBizImpl();
	MDBoardDto dto = new MDBoardDto();
	
	int res = biz.delete(seq);
	
	if(res>0){
	

%>

<script type="text/javascript">
alert("삭제 성공 !! ㅎㅎ");
location.href="boardlist.jsp";
</script>

<%
	}else{
%>

<script type="text/javascript">
alert("삭제 실패 ㅠㅠ");
location.href="boardlist.jsp";

</script>
<%
	}
%>
</body>
</html>