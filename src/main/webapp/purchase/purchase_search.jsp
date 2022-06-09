<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>search</title>
<link rel="stylesheet" href="../css/purchase.css">
</head>
<body>

	<div id="search">
		<form name="frm_purchase_search" id="frm_purchase_search">
			<label>제품코드</label>
			<input type="text" id="code">
			
			<label>제품명</label>
			<input type="text" id="codeName">
			<input type="text" id="code_selected">
			<input type="text" id="codeName_selected">
			<button type="button">검색</button>
		</form>
		<div id="list">
			<div id=title>
				<span class="code_list">제품코드</span>
				<span class="codeName">제품명</span>
			</div>
			<div id="items" >
			<c:forEach var="i" begin="0" end="5" varStatus="sts">
				<div class="item" onclick="select(${sts.index})">
					<span class="code_list">${i }</span>
					<span class="codeName">제품명</span>
				</div>
			</c:forEach>
			</div>
		</div>
		
		<button type="button" onclick="submit()">적용</button>
	</div>


<script src="../lib/jquery-3.6.0.min.js"></script>

<script>
let openFrm=$("#frm_purchase_input",opener.document).value;
let localFrm=$("#frm_purchase_search")[0];
select=function(sts){
	console.log(sts);
	let array=$(".item").toArray();
	console.log(array);
	let code=$(array[sts]).find(".code_list").html();
	let codeName=$(array[sts]).find(".codeName").html();
	localFrm.code_selected.value=code;
	localFrm.codeName_selected.value=codeName;
}

submit=function(){
	console.log(localFrm.code_selected.value);
	console.log(localFrm.codeName_selected.value);
	$("#frm_purchase_input",opener.document).find(".code").val(localFrm.code_selected.value);
	$("#frm_purchase_input",opener.document).find(".codeName").val(localFrm.codeName_selected.value);
}

</script>
</body>
</html>