<%@page import="java.util.List"%>
<%@page import="com.mdboard.dto.MDBoardDto"%>
<%@page import="com.mdboard.biz.MDBoardBizImpl"%>
<%@page import="com.mdboard.biz.MDBoardBiz"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">





$(function() {
	$("#muldelform").submit(function(){
		if($("#muldelform input:checked").length == 0){
			alert("하나 이상 체크하세요!!");
			return false;
		}
	})
	
	
	
	$("input[name=chk]").click(function() {
		if($("input[name=chk]").length == $("input[name=chk]:checked").length){
			$("input[name=all]").prop("checked",true);
		}else{
			$("input[name=all]").prop("checked",false);
		}
				
		
	})
	
});

function allchk(bool) {
	$("input[name=chk]").each(function() {
		$(this).prop("checked",bool);
		
	})
}


</script>



</head>
<body>

	<%
		MDBoardBiz biz = new MDBoardBizImpl();
	List<MDBoardDto> list = biz.list();
	%>

	<h1>list</h1>

	<form action="./muldel.jsp" method="post" id="muldelform">
		<table border="1">
			<col width="30">
			<col width="50">
			<col width="200">
			<col width="300">
			<col width="100">

			<tr>
				<th><input type="checkbox" name="all"
					onclick="allchk(this.checked);"></th>
				<th>번호</th>
				<th>작성자</th>
				<th>제목</th>
				<th>날짜</th>
			</tr>
			<%
				if (list.size() == 0) {
			%>
			<tr>
				<td>----------작성된 글이 없습니다-----------</td>
			</tr>
			<%
				} else {
			for (MDBoardDto dto : list) {
			%>

			<tr>
				<td><input type="checkbox" name="chk" value=<%=dto.getSeq()%>>
				</td>
				<td><%=dto.getSeq()%></td>
				<td><%=dto.getWriter()%></td>
				<td><a href="myselect.jsp?seq=<%=dto.getSeq()%>"><%=dto.getTitle()%></a></td>
				<td><%=dto.getRegdate()%></td>
			</tr>

			<%
				}
			}
			%>

			<tr>
				<td colspan="5" align="right">
					<input type="submit" value="선택삭제">
					<input type="button" onclick="location.href='myinsert.jsp'"
					value="글쓰기"></td>
			</tr>

		</table>




	</form>

</body>
</html>