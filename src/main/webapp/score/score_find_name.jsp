<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="score_find">
		<form name="frm_find_name" id="frm_find_name" method="post" action="./score.do?job=findName">
			<label>아이디</label>
			<input type="text" name="id" id="id" value="${param.id}">
			<br>
			<button>검색</button>
			<button onclick="move(this.innerHTML)">${mName}</button>
		</form>	
	</div>
	
	<script>
	function move(mName){
		console.log("Test222");
		let frm=opener.document.frm_score;
		let localFrm=document.frm_find_name;
		frm.mName.value=mName;
		console.log(mName);
		frm.id.value=localFrm.id.value;
		console.log(localFrm.id.value);
		self.close();
	}
	</script>
</body>
</html>