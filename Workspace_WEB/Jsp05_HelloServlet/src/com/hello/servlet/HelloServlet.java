package com.hello.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */

//web.xml설정을 annotation으로 간략화한것 . 
@WebServlet("/controller.do")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String contextParam;
	private String initParam;

       
    public HelloServlet() {
    	System.out.println("servlet Constructor");
    }
    

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("servlet init");
		
		contextParam =config.getServletContext().getInitParameter("name");
		initParam = config.getInitParameter("sports");
		System.out.println("context-param :" + contextParam);
		System.out.println("init-param :" + initParam);
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		System.out.println("Get 방식으로 들어옴 ! 호출해서 응답해준다");
		
		//1
		String command = request.getParameter("command");
		System.out.println("command : " +command);
		
		
		//2.보내서 받을값 : 없음
		//3.
		//4. 
		PrintWriter out = response.getWriter();
		out.print("<h1 style='color : red'> Hello Servlet</h1>");
		out.print("<h2> 계층구조, lifecycle, url-mapping</h2>");
		out.print("<a href='home.html'>home...</a>");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		System.out.println("Post방식으로 들어옴 ! 호출해서 응답해준다");
		

		//1
		String command = request.getParameter("command");
		System.out.println("command : "+command);
		
		//2
		//3
		
		//4
		PrintWriter out = response.getWriter();
		
		out.println("<h1 style='color : blue'>Hello Servlet</h1>");
		out.println("<h2>init - service- doGet/doPost 0 destroy<h2>");
		out.println("a href='home.html'>home...</a>");
		
		
	}
	
	
	@Override
	public void destroy() {
		System.out.println("servlet destroy");
		
		
		
	}

}
