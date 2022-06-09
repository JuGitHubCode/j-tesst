<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>form_find_id</title>
<link rel="stylesheet" href="../css/student.css">
</head>
<body>
	<form name="find_id" id="find_id" method="post">
		<h1>아이디 찾기</h1>
		<label>연락처</label>
		<input type="text"name="Phone"><br>
		<label>이메일</label>
		<input type="text" name="Email">
		<div id="button_section">
			<input type="button" id="btnFindId" value="아이디 찾기">
		</div>
	</form>
<script src="./js/student.js"></script>
</body>
</html>