package com.score.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

/**
 * Servlet implementation class ScoreController
 */
@WebServlet("/score.do")
public class ScoreController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
	   String name = request.getParameter("name");
	   int kor = Integer.parseInt(request.getParameter("kor"));
	   int eng = Integer.parseInt(request.getParameter("eng"));
	   int math = Integer.parseInt(request.getParameter("math"));
		
	   int sum = kor+eng+math;
	   double avg = (double)sum/3;
	   
	   
	   //json-simple-1.1.1.jar
	   //json object  객체를 만들자 !!
	   JSONObject obj = new JSONObject();
	   obj.put("name", name);
	   obj.put("sum", sum);
	   obj.put("avg", String.format("%.2f", avg));
	   
	   //객체를 만들고 마지막 put 이 끝나면 {"name":name,"sum":sum,"avg":avg}
	   
	   System.out.println("server에서 보내는 데이터 :"+obj.toJSONString()); //toJSONString() : json 형식의 문자열로 만들자 
		
	   PrintWriter out = response.getWriter();
	   out.println(obj.toJSONString());
	   
		
		
	}
}
