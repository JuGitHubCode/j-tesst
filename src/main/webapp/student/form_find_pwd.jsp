<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>form_find_pwd</title>
<link rel="stylesheet" href="../css/student.css">

</head>
<body>
	<form name="find_pwd" id="find_pwd" method="post">
		<h1>암호 찾기</h1>
		<label>아이디</label>
		<input type="text" name="mId"><br>
		<label>이메일</label>
		<input type="text" name="Email">
		<div id="button_section">
			<input type="button" id="btnFindPwd" value="암호 찾기">
		</div>
	</form>
<script src="./js/student.js"></script>
</body>
</html>