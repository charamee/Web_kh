package com.cal.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cal.common.Util;
import com.cal.dao.CalDao;
import com.cal.dto.CalDto;

/**
 * Servlet implementation class CalController
 */
@WebServlet("/cal.do")
public class CalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		System.out.printf("<%s\n>",command);
		
		CalDao dao = new CalDao();
		
		
		try {
			if(command.equals("calendar")) {
				response.sendRedirect("calendar.jsp");
			}else if(command.equals("insert")) {
				String year=request.getParameter("year");
				String month=request.getParameter("month");
				String date=request.getParameter("date");
				String hour=request.getParameter("hour");
				String min=request.getParameter("min");
				String mdate = year+Util.isTwo(month)+Util.isTwo(date)+Util.isTwo(hour)+Util.isTwo(min);
				
				String id=request.getParameter("id");
				String title=request.getParameter("title");
				String content=request.getParameter("content");
				
				CalDto dto = new CalDto(0,id,title,content,mdate,null);
				
				int res = dao.insertCalBoard(dto);
				if(res>0) {
					response.sendRedirect("calendar.jsp");
				
				}else {
					request.setAttribute("msg", "일정 추가 실패 ㅠㅠ ");
					dispatch("error.jsp", request, response);
				}
				
			}else if(command.equals("list")) {
				
				String year = request.getParameter("year");
				String month =request.getParameter("month"); 
				String date = request.getParameter("date");
				
				String yyyyMMdd = year +Util.isTwo(month)+Util.isTwo(date);
				
				List<CalDto> list = dao.getCalList("kh",yyyyMMdd);
					request.setAttribute("list", list);
					dispatch("list.jsp", request, response);
				
			
			}else if(command.equals("select")) {
				
				int seq = Integer.parseInt(request.getParameter("seq"));
				String year = request.getParameter("year");
				String month =request.getParameter("month"); 
				String date = request.getParameter("date");
				
				CalDto dto = dao.selectCal(seq);
				request.setAttribute("dto", dto);
				dispatch("selectCal.jsp", request, response);
				
			}else if(command.equals("updateform")) {
				
				int seq = Integer.parseInt(request.getParameter("seq"));
			
				
				CalDto dto = dao.selectCal(seq);
				request.setAttribute("dto", dto);
				
				dispatch("update.jsp", request, response);
			
			
			}else if(command.equals("updateres")) {
				int seq = Integer.parseInt(request.getParameter("seq"));
				String title = request.getParameter("title");
				String content = request.getParameter("content");
				
				CalDto dto = new CalDto(); 
				dto.setSeq(seq);
				dto.setTitle(title);
				dto.setContent(content);
				
				int res = dao.update(dto);
				if(res>0) {
					dispatch("cal.do?command=select&seq="+seq, request, response);
				}else {
					request.setAttribute("msg", "수정 실패 ㅠㅠ ");
					dispatch("error.jsp", request, response);
				
				}
				
				
				
			}else if(command.equals("delete")) {
				int seq = Integer.parseInt(request.getParameter("seq"));
				
				
				int res = dao.delete(seq);
				
				if(res>0) {
					dispatch("cal.do?command=calendar", request, response);
					
				}else {
					request.setAttribute("msg", "일정 삭제 실패 ㅠㅠ ");
					dispatch("error.jsp", request, response);
				
				}
				
			}
			
			
			
		}catch(Exception e) {
			request.setAttribute("msg", "command 오류");
			dispatch("error.jsp", request, response);
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void dispatch(String path,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(path);
		dispatch.forward(request,response);
	}

}
