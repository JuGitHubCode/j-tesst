<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>score.do</title>
</head>
<body>
	<h1>score.do에 POST 타입으로 전달</h1>
	<form name='frm' method='post' action='../score.do'>
	<label>아이디</label>
	<input type="text" name="mId">
	<br>	
	<label>암호</label>
	<input type="text" name="mPwd">
	<br>
	<input type="submit" value="전송">
	</form>
</body>
</html>