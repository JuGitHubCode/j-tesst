<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>student_input_form</title>
<link rel="stylesheet" href="./css/student.css">
</head>
<body>

	<div id="student">
		<form name="frm_student" id="frm_student" method="post">
			<h1>학생정보 입력</h1>
			<label>아이디</label>
			<input type ="text" name="id" size="15"><br>
			
			<label>성명</label>
			<input type ="text" name="mName" size="15"><br>
			
			<label>성별</label>
			<label><input type ="radio" name="gender" value="m">남자</label>
			<label><input type ="radio" name="gender" value="f">여자</label>
			<br>
				
			<label>암호</label>
			<input type ="password" name="pwd"size="15" maxlength="10" autocomplete="none"><br>
			
			<label>연락처</label>
			<input type ="text" name="phone"size="15"><br>
			
			<label>우편번호</label>
			<input type ="text" name="zipcode"size="7" >
			<button type="button" id="btnZipFind">검색</button>
			<br>
			
			<label>주소</label>
			<input type ="text" name="address"size="45"><br>
			
			<label>이메일</label>
			<input type ="text" name="email"size="15" autocomplete="none"><br>
			
			<label></label>
			<button type="button" id="btnSave">저장</button>
			<button type="button" id="btnlist">취소</button>
			<input type="text" name="findStr" value="${param.findStr}">
			<input type="text" name="nowPage" value='${param.nowPage}'/>
			
		</form>	
	</div>
	<script src="./js/student.js"></script>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</body>
</html>