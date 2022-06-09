<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>modify</title>
<link rel="stylesheet" href="./css/score.css">
</head>
<body>
	<div id="score">
		<form name="frm_score" id="frm_score" method="post">
			<span class="title">성적 수정</span>
			<br>
			<label>날짜</label>
			<input type="date"name="nal" value="${vo.nal }">
			<br>
			<label>아이디</label>
			<input type="text"name="id" value="${vo.id }">
			<input type="button" name="btnFindName" id="btnFindName" value="검색">
			<br>
			<label>성명</label>
			<input type="text"name="mName" value="${vo.mName }">
			<br>
			<label>과목</label>
			<input type="text"name="subject" value="${vo.subject }">
			<br>
			<label>성적</label>
			<input type="text"name="score" value="${vo.score }">
			<br>
			<input type="button" name="btnModifyR" id="btnModifyR" value="수정">
			<input type="button" name="btnList" id="btnList" value="취소">	
			
			<input type="text" name="findStr" value="${param.findStr }">
			<input type="text" name="nowPage" id="nowPage" value="${param.nowPage }">
			
			<input type="text"name="sno" id="sno" value="${vo.sno}">
		
		</form>
	</div>

<script src="js/score.js"></script>
</body>
</html>