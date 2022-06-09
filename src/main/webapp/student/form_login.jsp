<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>form_login</title>
<link rel="stylesheet" type="text/css" href="./css/student.css">

</head>
<body>
	<form name="frm_login">
		<span id="login">로그인</span>
		<div class="main_login">
			<div class="info">
				<label>아이디</label>
				<input type="text" value="" name="mId" id="mId" onkeypress="foucs()"><br>
				<label>비밀번호</label>
				<input type="text" value=""name="mPwd" id="mPwd" onkeypress="press()">
			</div>
			<div class="button">
				<input type="button" value="로그인" id="btn_login2">
			</div>
		</div>
		<!-- <label id="find_id_info">아이디</label> -->
		<a href="index.jsp?inc=./student/form_find_id.jsp"id="find_id_info" >아이디</a>
		<span>/</span>
		<!-- <label id="find_pwd_info">비밀번호 찾기</label> -->
		<a href="index.jsp?inc=./student/form_find_pwd.jsp"id="find_id_info">비밀번호 찾기</a>
	
	
	
	
	</form>
	<script src="./js/student.js"></script>
</body>
</html>