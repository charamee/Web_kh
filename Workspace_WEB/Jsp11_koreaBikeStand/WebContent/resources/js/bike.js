
$(function(){
	getJsonData();
	//window.onload와 같다 
});

function getJsonData(){
	$.getJSON("resources/json/bike.json",function(mydata){
		//json으로 응답되는애 다 받아온다 
		$.ajax({
			url: "bike.do",
			method: "post",
			data: {"command":"getdata","mydata":JSON.stringify(mydata)}, 
			//JSON.stringify() 메서드는 JavaScript 값이나 객체를 JSON 문자열로 변환합니다k
			dataType:"json",
			success : function(msg){
				var $tbody = $("tbody");
				
				var list = msg.result; 
				for(var i=0;i<list.length;i++){
					var $tr = $("<tr>");
					
					$tr.append($("<td>").append(list[i].name));
					$tr.append($("<td>").append(list[i].addr));
					$tr.append($("<td>").append(list[i].latitude));
					$tr.append($("<td>").append(list[i].longitude));
					$tr.append($("<td>").append(list[i].bike_count));
					 
					$tbody.append($tr);
				}
			},
			error :function(){
				alert("통신 실패");
			}
			
		})
		
		
		
	})
}