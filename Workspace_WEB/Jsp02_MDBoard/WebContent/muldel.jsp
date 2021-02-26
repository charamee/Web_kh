<%@page import="com.mdboard.biz.MDBoardBizImpl"%>
<%@page import="com.mdboard.biz.MDBoardBiz"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%request.setCharacterEncoding("UTF-8");%>
<%response.setContentType("text/html; charset=UTF-8");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	String [] seqs = request.getParameterValues("chk");
	
	if(seqs ==null || seqs.length==0){
		
	
%>
<script type="text/javascript">
	alert("삭제할 글을 선택해주세요!!")
	location.href="boardlist.jsp"

</script>

<%
	}else{
		
	MDBoardBiz biz = new MDBoardBizImpl();
	int res = biz.muldel(seqs);
	if(res>0){
%>

	<script type="text/javascript">
	alert("삭제 성공! ");
	location.href="boardlist.jsp"
	
	</script>
<%
	}else{
%>

<script type="text/javascript">
alert("선택한 글을 삭제하지 못했어요..왤까요?")
location.href="boardlist.jsp"

</script>

<%
		}

	}
%>
</body>
</html>