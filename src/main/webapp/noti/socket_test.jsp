<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>socket_test</title>
</head>
<body>

<div id="scket_test">
	<button type="button" onclick="connect()">연결</button>
	<button type="button" onclick="disconnect()">종료</button>
	
	<input type="text" name="msg" id="msg" size="50">
	<button type="button" onclick="send()">메세지</button>

</div>


<script>
	
	//http://localhost:5555/web_project2/index.jsp
	//http=>ws 로 바뀜/localho~~~project2까지는 동일/index.jsp=>test(<- TestWebSocket.java의 @ServerEndpoint("/test"))
	//ws://localhost:5555/web_project2/test
	
	//소켓에 사용되는 url
	var url="ws://192.168.0.26:5555/web_project2/test";
	//소켓 생성
	let socket;
	
	function connect(){
		console.log(url);
		socket = new WebSocket(url);
		
		socket.onopen=function(){
			 console.log("socket open");
		}
		
		//ws로부터 메시지가 전달되었을 때
		socket.onmessage=function(resp){
			console.log("receive data : ", resp.data);
		}
		socket.onclose=function(){}
	}
	
	function send(){
		let msg=document.getElementById("msg").value;
		let jsonObj={};
		jsonObj.msg=msg;
		jsonObj.command="select";
		jsonObj.nowPage=12;
		jsonObj.findStr="abc";
		
		console.log(jsonObj);
		
		//ws json을 바로 보내지않고 json string으로 변환하여 전송
		let jsonStr=JSON.stringify(jsonObj);
		console.log("jsonStr : ",jsonStr);
		
		//ws에게 값 전송
		socket.send(jsonStr);
	}
	
	
</script>
</body>
</html>