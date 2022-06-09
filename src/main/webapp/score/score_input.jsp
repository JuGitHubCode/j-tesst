<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>input</title>
</head>
<link rel="stylesheet" href="./css/score.css">
<body>
	<div id="score">
		<form name="frm_score" id="frm_score"  method="post">
			<span class="title">성적 입력</span>
			<br>
			<label>날짜</label>
			<input type="date"name="nal">
			<br>
			<label>아이디</label>
			<input type="text"name="id" id="id">
			<input type="button" name="btnFindName" id="btnFindName" value="검색">
			<br>
			<label>성명</label>
			<input type="text"name="mName" id="mName">
			<br>
			<label>과목</label>
			<input type="text"name="subject">
			<br>
			<label>성적</label>
			<input type="text"name="score">
			<br>
			<input type="button" name="btnInputR" id="btnInputR" value="저장">
			<input type="button" name="btnList" id="btnList" value="취소">
			
			
			<input type="text" name="findStr" value="${param.findStr }">
			<input type="text" name="nowPage" id="nowPage" value="${param.nowPage }">
			
		</form>
	</div>
	
	<script src="js/score.js"></script>
</body>
</html>