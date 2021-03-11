
function getParameterValues(){
	var name = "name=" + encodeURIComponent(document.getElementById("name").value);
	var kor = "kor="+document.getElementById("kor").value;
	var eng = "eng="+document.getElementById("eng").value;
	var math = "math="+document.getElementById("math").value;
	
	return "?" +name + "&"+kor+"&"+eng+"&"+math; 
	
	
}

function load(){
	var url = "score.do"+getParameterValues();
	
	httpRequest = new XMLHttpRequest();  		//server 와 통신하는 것을 도와주는 객체 XHR 로 부른다 
	httpRequest.onreadystatechange=callback; 	// readystate 가 변경(요청)할 때 마다 처리할 함수 callback : 요청하면 응답해준다 그래서 on readystatechange로 요청해서 응답해줌
	httpRequest.open("GET",url,true); 			//get방식과 post 방식이 있다, get + url 에 위의 qeury string , true:비동기/ false: 동기 
	httpRequest.send(); 						//get: send(); / post : send("data");
}

function callback(){
	alert("readystate: " +httpRequest.readyState);
	
	//통신이 완료 되었다면 = 4 
	if(httpRequest.readyState==4){
		alert("status : "+httpRequest.status);
		
		//통신이 성공했따면
		if(httpRequest.status == 200){
			
			
			//responseText : 요청 후 응답받은 문자열(응답값)
			var obj = JSON.parse(httpRequest.responseText);
			document.getElementById("result").innerHTML = decodeURIComponent(obj.name) +"의 총점 : " +obj.sum+"\n평균 : " +obj.avg;
			
		}else {
			alert("통신실패..")

		}
	}
	
}



/**


XMLHttpRequest : javascript object . http를 통한 데이터 송수신 지원 
<onreadystatechange> 
-readystate  요청해서 응답받는 일련의 과정 0부터 4까지 돌아간다 
	0:uninitialized - 실행 (load)되지 않음
	1: loading 로드중 
	2: loaded -로드 됨
	3: interactive -통신됨 
	4: complete - 통신 완료
	
	-status 
	200:성공 
	400 : bad request 
	401 : unauthorized
	403 : forbidden
	404 : not found
	500 : internal server error
	514 : 

encodeURIComponent :모든문자를 UTF-8로 인코딩해 (한글 깨지지 말라고) 
decodeURIcomponent :: 위에서 인코딩(UTF-8)했으니까 디코딩 다시 원래 글자로 
encodeURI : 주소줄에서 사용되는 특수문자는 제외하고 인코딩

JSON.parse : json 형태의 문자열을 json 객체로 변환 (string -> json object)
JSON.stringify : javascript 객체 (json 형태로 변환할 수 잇는)를 json 형태의 문자열로 변환 (object-> jason string)




 */