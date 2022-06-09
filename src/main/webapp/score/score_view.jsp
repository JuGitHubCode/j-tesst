<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"	 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>view</title>
<link rel="stylesheet" href="./css/score.css">
</head>
<body>
	<div id="score">
		<form name="frm_score" id="frm_score"  method="post">
			<span class="title">성적 상세 조회</span>
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
			<label>연락처</label>
			<input type="text"name="phone" value="${vo.phone }">
			<br>
			<label>이메일</label>
			<input type="text"name="email" value="${vo.email }">
			<br>
			<label>과목</label>
			<input type="text"name="subject" value="${vo.subject }">
			<br>
			<label>성적</label>
			<input type="text"name="score" value="${vo.score }">
			<br>
			<input type="button" name="btnModify" id="btnModify" value="수정">
			<input type="button" name="btnDelete" id="btnDelete" value="삭제">
			<input type="button" name="btnList" id="btnList" value="취소">
			
			
			<input type="text" name="findStr" value="${param.findStr }">
			<input type="text" name="nowPage" id="nowPage" value="${param.nowPage }">
			
			<input type="text"name="sno" id="sno" value="${vo.sno}">
		</form>
	</div>
	
<script src="js/score.js"></script>
</body>
</html>