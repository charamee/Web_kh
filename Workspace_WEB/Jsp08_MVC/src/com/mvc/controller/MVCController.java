package com.mvc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.mvc.biz.MVCBoardBiz;
import com.mvc.biz.MVCBoardBizImpl;
import com.mvc.dto.MVCBoardDto;

/**
 * Servlet implementation class MVCControllerr
 */
@WebServlet("/MVCControllerr")
public class MVCController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MVCController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset=UTF-8");
	    
	    MVCBoardBiz biz = new MVCBoardBizImpl(); 
	    String command = request.getParameter("command");
	    System.out.println("["+command+"]");
	    
	    if(command.equals("list")) {
	    	//1.생략
	    	//2.
	    	List<MVCBoardDto> list = biz.selectlist();
	    	//3.
	    	request.setAttribute("list", list);
	    	//4.
	    	dispatch(request, response, "mvclist.jsp");
	    
	    }else if(command.equals("insertform")) {
	    	response.sendRedirect("myinsert.jsp");
	    	
	    }else if(command.equals("insertres")) {
	    	String writer = request.getParameter("writer");
	    	String title = request.getParameter("title");
	    	String content = request.getParameter("content");
	    	
	    	MVCBoardDto dto = new MVCBoardDto();
	    	dto.setWriter(writer);
	    	dto.setTitle(title);
	    	dto.setContent(content);
	    	
	    	int res = biz.insert(dto);
	    	if(res>0) {
	    		response.sendRedirect("controller.do?command=list");
	    	}else {
	    		response.sendRedirect("controller.do?command=insertform");
	    	}
	    	
	    	
	    	
	    }else if(command.equals("updateform")) {
	    	int seq = Integer.parseInt(request.getParameter("seq"));
	    	MVCBoardDto dto = biz.selectOne(seq);
	    	request.setAttribute("dto", dto);
	    	
	    	dispatch(request, response, "mvcupdate.jsp");
	    }else if(command.equals("updateres")) {
	    	int seq = Integer.parseInt(request.getParameter("seq"));
	    	String title = request.getParameter("title");
	    	String content = request.getParameter("content");
	    	
	    	MVCBoardDto dto = new MVCBoardDto(); 
	    	dto.setSeq(seq);;
	    	dto.setTitle(title);
	    	dto.setContent(content);
	    	int res = biz.update(dto);
	    	if(res>0) {
	    		//forward로 하면 request가 계속 연결되어 있어서 새로고침시 계속 값이 전달된다. 
	    		response.sendRedirect("controller.do?select&seq="+seq);
	    	}else {
	    		response.sendRedirect("controller.do?command=updateform.do&seq="+seq);
	    	}
	    }else if(command.equals("delete")) {
	    	int seq = Integer.parseInt(request.getParameter("seq"));
	    	int res = biz.delete(seq);
	    	
	    	if(res>0) {
	    		//forward로 하면 request가 계속 연결되어 있어서 새로고침시 계속 값이 전달된다. 
	    		response.sendRedirect("controller.do?commadn=list");
	    	}else {
	    		response.sendRedirect("controller.do?command=select&seq="+seq);
	    	}
	    }
	}

	
	public void dispatch(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(path);
		dispatch.forward(request, response);
	}	
}
