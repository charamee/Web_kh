<%@page import="com.mvc.dao.MVCBoardDao"%>
<%@page import="com.mvc.biz.MVCBoardBizImpl"%>
<%@page import="com.mvc.biz.MVCBoardBiz"%>
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
</head>
<body>
<%
	int seq = Integer.parseInt(request.getParameter("seq"));

	MVCBoardBiz biz = new MVCBoardBizImpl();
	MVCBoardDto dto = biz.selectOne(seq);
	

%>

<h1>UPDATE</h1>

    <form action="Myservlet.do" method="post">
        <input type="hidden" name="command" value="updateres">
        <input type="hidden" name="seq" value="<%=dto.getSeq()%>">
        <table border="1">
            <tr>
                <th>작성자</th>
                <td><%=dto.getWriter() %>></td>
            </tr>
            <tr>
                <th>제목</th>
                <td><input type="text" name="title" value="<%=dto.getTitle()%>"></td>
            </tr>
            <tr>
                <th>내용</th>
                <td><textarea rows="10" cols="60" name="content"><%=dto.getContent() %></textarea></td>
            </tr>
            <tr>
                <td colspan="4" align="right">
                    <input type="submit" value="확인">
                    <input type="button" value="취소" onclick="location.href='Myservlet.do?command=select&seq=<%=dto.getSeq()%>'">
                </td>
            </tr>
        </table>
    </form>

</body>
</html>