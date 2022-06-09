<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
 *{
 	box-sizing:border-box;
 	padding:0px;
 	margin:0px;
 }
 
#load{
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}

div{
	display: inline-block;
	width:300px;
	height: 200px;
	border: 2px solid #aaa;
	padding:20px;
}
</style>
</head>
<body>

<div id="a">
<h3>로그인 처리 완료</h3>
	<ul>
		<li>${param.id}</li>
		<li>${param.pwd}</li>
	</ul>
</div>
<div id="b">
	<h3>아이디 찾기</h3>
	<ul>
		<li>당신의 아이디는 ${param.id}</li>
	</ul>
</div>


<div id="c">
	<h3>아이디 찾기</h3>
	<ul>
		<li>${param.id}님의 암호는"1111"입니다.</li>
	</ul>
</div>


</body>
</html>