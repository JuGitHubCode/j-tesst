<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>socket_test2</title>
</head>
<body>
<h1>socket test2</h1>

<form name="frm"> 
	<label>아이디</label>
	<input type="text" name="id" value="hong">
	</br>
	
	<label>성명</label>
	<input type="text" name="irum" value="홍길동씨">
	<br>
	
	<label>연락처</label>
	<input type="text" name="phone" value="010-1001-1001">
	
	<button type="button" onclick="connect()">연결</button>
	<button type="button" onclick="send(this.form)">보내기</button>
	<div>수신결과는 콘솔창에서 확인</div>
</form>


<script>
	let socket;
	var url="ws://192.168.0.26:5555/web_project2/test2";
	
	function connect(){
		console.log("connect");
		socket=new WebSocket(url)
		
		socket.onopen=function(){
			console.log("onopen");
		}
		socket.onclose=function(){};
		socket.onmessage=function(resp){
			let jsonStr=resp.data;
			let jsonObj=JSON.parse(jsonStr)
			console.log("------------------------------------");
			console.log("jsonObj : ",jsonObj);
			console.log("ID : ",jsonObj.id );
			console.log("irum : ", jsonObj.irum);
			console.log("phone : ", jsonObj.phone);
			console.log("------------------------------------");
		}
	}
	function send(frm){
		console.log("send");
		let jsonObj={};
		jsonObj.id=frm.id.value;
		jsonObj.irum=frm.irum.value;
		jsonObj.phone=frm.phone.value;
		
		
		let jsonStr=JSON.stringify(jsonObj);
		console.log("------------------------------------");
		console.log("jsonStr : ", jsonStr);
		console.log("------------------------------------");
		socket.send(jsonStr);
	}
</script>
</body>
</html>