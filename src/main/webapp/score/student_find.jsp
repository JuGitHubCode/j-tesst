<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>find</title>
<link rel="stylesheet" href="../css/score.css">
</head>
<body>
<%
	int[] sno={1,2,3,4,5,6,7,8,10,11,12,13,14,15};
	request.setAttribute("sno", sno);
%>
	<div id="score_find">
		<form name="frm_score" id="frm_socre">
			<label>학번</label>
			<input type="text" name="sno" id="sno">
			
			<br>
			<label>이름</label>
			<input type="text" name="mName">
			<br>
			<label>ID</label>
			<input type="text" name="id">
			<br>
			<input type="button" name="btnFind" id="btnFind" value="검색">
			<input type="text" name="cName" id="cName" >
		</form>
		<div id="list">
			<div class="title">
				<span class="sno">sno</span>
				<span class="id">아이디</span>
				<span class="mName" >${mName}</span>
			</div>
			<div class="items">
			<c:forEach var="sno" items="${sno }">
				<div class="title" onclick="findName('주승환')">
					<span class="sno">${sno }</span>
					<span class="id">아이디</span>
					<span class="mName" >성명</span>
				</div>
			</c:forEach>
			</div>
		</div>
	</div>
	
	<script>
	function findName(mName){
		console.log("Test");
		let frm=document.frm_score;
		frm.cName.value=mName;
		frm.sno.value=mName;
		opener.document.getElementById("mName").value = document.getElementById("cName").value;
		
	}
	</script>
</body>
</html>