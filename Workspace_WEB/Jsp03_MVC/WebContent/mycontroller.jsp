<%@page import="com.mvc.dto.MVCBoardDto"%>
<%@page import="java.util.List"%>
<%@page import="com.mvc.biz.MVCBoardBizImpl"%>
<%@page import="com.mvc.biz.MVCBoardBiz"%>
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
</head>
<body>

	<%
		// 컨트롤러의 역할 : 
	String command = request.getParameter("command");
	System.out.printf("[%s]\n", command);

	MVCBoardBiz biz = new MVCBoardBizImpl();
	//요청한 명령을 확인한다 
	if (command.equals("list")) {
		//1. 보내준 값이 있으면 받는다. 

		//2. db에 전달할 값이 있으면 전달하고, 
		// 없으면 없는대로 호출해서 리턴받는다. 

		List<MVCBoardDto> list = biz.selectlist();

		//3. 화면에 전달할 값이 있으면, request 객체에 담아준다. 
		request.setAttribute("list", list); // list를 "list"에 담는다 

		//4. 보낸다. 
		pageContext.forward("mylist.jsp"); // request에 뭔가 담으면 포워드해야하고 
		// 페이지를 위임 받는다 mylist로 가!  
		// 포워드 되는것은 주소창에서 확인이 안된다 
	} else if (command.equals("insertform")) {
		//1.
		//2.
		//3.
		//4.

		response.sendRedirect("myinsert.jsp"); // request에 뭐가 없다 ? 리다이렉트한다 
		/*
			pageContext.forward() : 페이지 위임(request,response  객체가 그대로 전달)
			response.sedRedirect() : 페이지 이동( 새로운 request, response 객체 )
		
		*/
	} else if (command.equals("insertres")) {
		//1.
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		//2.

		MVCBoardDto dto = new MVCBoardDto(0, writer, title, content, null);
		int res = biz.insert(dto);

		//3.
		//4.
		if (res > 0) {
	%>
	<script type="text/javascript">
 alert("글 작성 성공")
 location.href='mycontroller.jsp?command=list';
 
 </script>


	<%
		} else {
	%>
	<script type="text/javascript">
alert("글 작성 실패")
location.href="mycontroller.jsp?command=insertform";

</script>


	<%
		}
	} else if (command.equals("select")) {
	//1.
	int seq = Integer.parseInt(request.getParameter("seq"));

	//2.
	MVCBoardDto dto = biz.selectOne(seq);

	//3. 
	request.setAttribute("select", dto);

	//4. 
	pageContext.forward("myselect.jsp");

	} else if (command.equals("updateform")) {

	//1.	
	int seq = Integer.parseInt(request.getParameter("seq"));
	//3.
	request.setAttribute("seq", seq);

	//4.
	pageContext.forward("myupdate.jsp");

	} else if (command.equals("updateres")) {
	//1.
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	int seq = Integer.parseInt(request.getParameter("seq"));

	//2.
	MVCBoardDto dto = new MVCBoardDto();
	dto.setTitle(title);
	dto.setContent(content);
	dto.setSeq(seq);
	int res = biz.update(dto);

	if (res > 0) {
	%>
	<script type="text/javascript">
alert("수정 성공!")
location.href="mycontroller.jsp?command=select&seq=<%=dto.getSeq()%>"

</script>

	<%
		} else {
	%>

	<script type="text/javascript">
alert("수정실패")
location.href="mycontroller.jsp?command=updateform&seq=<%=dto.getSeq()%>"
	</script>

	<%
		}

	}else if(command.equals("delete")){
		
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		int res = biz.delete(seq);
		if(res>0){
			
	%>
	<script type="text/javascript">
	
	alert("삭제 성공")
	
	location.href="mycontroller.jsp?command=list"
	</script>
	
	<%
		}else{
	%>

<script type="text/javascript">
alert("삭제 실패 ㅠ")
location.href="mycontroller.jsp?command=select&seq=<%=seq%>"
</script>

<%
		}
	}else if(command.equals("muldel")){
		
		String [] seqs = request.getParameterValues("chk");
		
		//request.setAttribute("seqs", seqs);
		
		//pageContext.forward("mymuldel.jsp");
		int res = biz.muldelete(seqs);
		if(res>0){
			
	%>
	<script type="text/javascript">
	
	alert("삭제 성공")
	
	location.href="mycontroller.jsp?command=list"
	</script>
	
	<%
		}else{
	%>

<script type="text/javascript">
alert("삭제 실패 ㅠ")
location.href="mycontroller.jsp?command=list"
</script>

<%
		}
		
	}
%>
</body>
</html>