package com.bike.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bike.dao.BikeDao;
import com.bike.dto.BikeDto;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@WebServlet("/BikeController")
public class BikeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public BikeController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		System.out.println("["+command+"]");
		
		if(command.equals("view")) {
			response.sendRedirect("view.html");
		
		}else if(command.equals("getdata")) {
			BikeDao dao = new BikeDao();
			
			if(dao.delete()){
				System.out.println("db 초기화 성공");
			}else {
				System.out.println("db초기화 실패");
			}
			String data = request.getParameter("mydata");
			//{["":""]} 형태로 들어가있다 
			
			JsonElement element = JsonParser.parseString(data);
			//JsonElement는 JsonObject, JsonPrimitive, JsonArray, JsonNull 
			//4가지의 부모 클래스로 추상클래스로 정의된다.
			//json parser: json string -> json object json 형태로 즉 k:v 형태의 값을 {} 로 감싼다 
			
			
			//data 에 어떤 타입이 들어가는지 모르기 때문에 전체를 포괄하는 element로 받아준다 
			JsonObject jsonData = element.getAsJsonObject();
			//jsonobject : key-value pair({"String" : JsonElemetn}형식)
			
			JsonElement records = jsonData.get("records");
			//bike.json 파일 열어보면 fields랑 records / records라는 key 값을주면 value값을 가져오는데 
			JsonArray recordsArray = records.getAsJsonArray(); //value값이 배열 형태이다.. 
			
			List<BikeDto> list = new ArrayList<BikeDto>();
			JsonArray resultArray = new JsonArray();
			
			/*
			 JsonElement tempElmenet = recordsArry.get(i); 
			 JsonObject tempObject = tempElement.getAsJsonObject();
			 JsonElemtn nameElemetn = tempObject.get("자전거대여소명");
			 String name = nameElement.getAsString(); 
			 
			 
			  
			 */
			  
			
			
			for(int i = 0 ; i<recordsArray.size();i++) {
				String name = recordsArray.get(i).getAsJsonObject().get("자전거대여소명").getAsString();
				String addr = null;
				if(recordsArray.get(i).getAsJsonObject().get("소재지도로명주소")!=null) {
					addr = recordsArray.get(i).getAsJsonObject().get("소재지도로명주소").getAsString();
				}else {
					addr = recordsArray.get(i).getAsJsonObject().get("소재지지번주소").getAsString();
					
				}
				
				double latitude = recordsArray.get(i).getAsJsonObject().get("위도").getAsDouble();
				double longitude = recordsArray.get(i).getAsJsonObject().get("경도").getAsDouble();
				
				int bike_count = recordsArray.get(i).getAsJsonObject().get("자전거보유대수").getAsInt();
			
				BikeDto dto = new BikeDto(name,addr,latitude,longitude,bike_count);
				//() 안에 있는 이름들이 K값 
				
				list.add(dto);
				
				Gson gson = new Gson(); 
				//자바 객체 -> json 형변환 , json 문자열 -> 자바객체 
				String jsonString = gson.toJson(dto);
				resultArray.add(JsonParser.parseString(jsonString));
				//json객체를 object >>  jsonString으로 형변환 
			
			
			
			}
			if(dao.insert(list)) {
				System.out.println("db저장 성공");
			}else {
				System.out.println("db 저장 실패");
			}
			
			JsonObject result = new JsonObject(); //제이슨 객체 만들어서 
			result.add("result", resultArray); // String 값을 result에 넣어줌 
			
			response.getWriter().append(result+""); //html 로 보냄 js 로 보낸다 
			
//			
//			encodeURIComponent :모든문자를 UTF-8로 인코딩해 (한글 깨지지 말라고) 
//			decodeURIcomponent :: 위에서 인코딩(UTF-8)했으니까 디코딩 다시 원래 글자로 
//			encodeURI : 주소줄에서 사용되는 특수문자는 제외하고 인코딩
//
//			JSON.parse : json  현태의 문자열을 json 객체로 변환 (string -> json object)
//			JSON.stringify : javascript 객체 (json 형태로 변환할 수 잇는)를 json 형태의 문자열로 변환 (object-> jason string)
//
//			
			
			
			
			
			
			
			
		}
		
	}

}
