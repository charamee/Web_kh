<%@page import="java.util.ArrayList"%>
<%@page import="com.mvc.dto.MVCBoardDto"%>
<%@page import="java.util.List"%>
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
	String command = request.getParameter("command");

	MVCBoardBiz biz = new MVCBoardBizImpl(); 
	
	if(command.equals("list")){
		
		List<MVCBoardDto> list = biz.selectlist();
		//1. 가져올값 있으면 가져와 
		//2. 디비 연결해줘 
		//3. 
		request.setAttribute("list", list);
		
		
		//4. 
		pageContext.forward("mylist.jsp");
		
	}else if(command.equals("insertform")){
		
		
		
		response.sendRedirect("myinsert.jsp");
	}else if(command.equals("insertres")){
		
	}else if(command.equals("update")){
		
	}



%>

</body>
</html>