<%@page import="com.mvc.dto.MVCBoardDto"%>
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
	function deleteProc(seq){
		if(confirm(seq+"번 글을 삭제하시겠습니가?")){
			location.href="mycontroller.jsp?command=delete&seq="+seq;
		}
	}


</script>
</head>
<body>

<%

	MVCBoardDto dto = (MVCBoardDto)request.getAttribute("select");
	

%>


<h1>select</h1>
<table border="1">
	<tr>
	<th>작성자</th>
	<td><%=dto.getWriter() %></td>
	</tr>
	
	<tr>
	<th>제목</th>
	<td><%=dto.getTitle() %></td>
	</tr>
	
	
	<tr>
	<th>내용</th>
	<td><textarea rows="10" cols="50" readonly="readonly"><%=dto.getContent() %></textarea></td>
	</tr>
	

	<tr>
	
		<td colspan="2" align="right">
		<input type="button" value="수정" onclick="location.href='mycontroller.jsp?command=updateform&seq=<%=dto.getSeq()%>'">
		<input type="button" value="목록">
		<input type="button" value="삭제" onclick="deleteProc(<%=dto.getSeq()%>);">
													
		</td>
	
	</tr>









</table>

</body>
</html>