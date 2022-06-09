<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>noti_main</title>
<link rel="stylesheet" href="./css/noti.css">
<script defer>
	//로그인 아이디를 세션아이디에 저장(향후 로그인 여부에따라 공지사항 컨텐츠 노출 결정에 사용)
	let sessionID="${sessionScope.mId}";
	console.log("sessionID :", sessionID)
</script>
</head>
<body>
	<div id="noti_main">
			<form name="frm_find" id="frm_find" class="frm_find" method="post">
				<button type="button" onclick="noti.ShowInputForm()">입력</button>
				<input type="text" id="findStr">
				<button type="button" id="btnFind" class="btnFind" onclick="noti.find(this.form)">검색</button>
			</form>
			
			<form name="frm_input" id="frm_input" class="frm_input" method="post">
				<label>작성일</label>
				<input type="date" id="nal" name="nal">
				<br>
				<label>작성자</label>
				<input type="text" id="id" name="id" value="${sessionScope.mId}" readonly>
				<br>
				<label>제목</label>
				<input type="text" id="subject" name="subject">
				<br>
				<textarea rows="" cols="" id="doc"  name="doc"></textarea>
				<button  type="button" id="btnSave" class="btnSave" onclick="noti.sendinsert(this.form)">저장</button>
			</form>
			
			
			

		<div id="msg" class="msg">message</div>

		<div id="btns" class="btns">
			<button type="button" class="btnPrev" onclick="noti.movePage(-1)">&lt</button>
			<button type="button" class="btnNext" onclick="noti.movePage(+1)">&gt</button>
		</div>
		
		
		<div id="items"></div>
		
		<div id="btns" class="btns">
			<button type="button" class="btnPrev" onclick="noti.movePage(-1)">&lt</button>
			<button type="button" class="btnNext" onclick="noti.movePage(+1)">&gt</button>
		</div>
		
	</div>
	<template class="temp" id="temp" name="temp">
		<form name="frm_list" id="frm_list" class="frm_list" method="post">
			<label>작성일</label>
			<input type="date" id="nal" name="nal">
			<br>
			<label>작성자</label>
			<input type="text" id="id" name="id">
			<br>
			<label>제목</label>
			<input type="text" id="subject" name="subject">
			<br>
			<textarea rows="" cols="" id="doc" name="doc"></textarea>
			<div class="btnUpDel">
			<button type="button" id="btnUpdate" class="btnUpdate" onclick="noti.sendUpdate(this.form)">수정</button>
			<button type="button"  id="btnDelete" class="btnDelete" onclick="noti.sendDelete(this.form)">삭제</button>
			</div>
			<input type="text" name="sno">
		</form>
	</template>


<script src="./lib/jquery-3.6.0.min.js"></script>
<script defer src="./js/noti.js"></script>



</body>
</html>