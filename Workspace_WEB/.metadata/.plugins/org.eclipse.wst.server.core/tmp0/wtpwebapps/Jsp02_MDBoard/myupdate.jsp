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
	int seq = Integer.parseInt(request.getParameter("seq"));

	MDBoardBiz biz = new MDBoardBizImpl();
	MDBoardDto dto = biz.selectOne(seq);



%>


<h1>수정</h1>

<form action="myupdate_res.jsp" method="post">
	<input type="hidden" name="seq" value="<%=dto.getSeq()%>">
		<table border="1">
			<tr>
				<th>작성자</th>
				<td><%=dto.getWriter() %></td>

			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" value="<%=dto.getTitle()%>"></td>

			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="10" cols="50" name="content"><%=dto.getContent() %></textarea></td>
			</tr>
			
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="확인" >
					<input type="button" value="취소" onclick="location.href='boardlist.jsp'">
				</td>
			</tr>




		</table>



	</form>


</body>
</html>