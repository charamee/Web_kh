<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

	 onload=function(){
		 var myid = opener.document.getElementsByName("myid")[0].value;
		 document.getElementsByName("id")[0].value=myid;
		 
	 }
	 
	 function confirmId(bool){
		 if(bool == "true"){
			 opener.document.getElementsByName("myid")[0].title = "y";
			 opener.document.getElementsByName("mypw")[0].focus(); 
			 
		 }else{
			 opener.document.getElementsByName("myid")[0].focus();
		 }
		 
		 self.close();
	 }

</script>
</head>
<body>

<%
	String idnotused = request.getParameter("idnotused");

%>

	<table border="1">
		<tr>
			<td><input type="text" name="id" readonly="readonly"></td>
		</tr>
		<tr>
			<td><%=idnotused.equals("true")?"id생성 가능" : "id가 이미 존재합니다" %></td>
		</tr>
		<tr>
			<td>
				<input type="button" value="확인" onclick="confirmId('<%=idnotused%>');">
			</td>
		</tr>
	
	
	</table>

</body>
</html>