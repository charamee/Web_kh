<%@page import="com.mvc.biz.MVCBoardBizImpl"%>
<%@page import="com.mvc.biz.MVCBoardBiz"%>
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
<%
int seq = Integer.parseInt(request.getParameter("seq"));

MVCBoardBiz biz = new MVCBoardBizImpl();

int res = biz.delete(seq);
if(res>0){

%>

	<script type="text/javascript">
	
	alert("삭제 성공")
	
	location.href="Myservlet.do?command=list"
	</script>
	
	<%
		}else{
	%>
<script type="text/javascript">
alert("삭제 실패 ㅠ")
location.href="Myservlet.do?command=select&seq=<%=seq%>"
</script>
<%
		}
%>

</body>
</html>