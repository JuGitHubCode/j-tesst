<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>search</title>
<link rel="stylesheet" href="../css/product.css">
</head>
<body>

	<div id="search">
		<form name="frm_product_search" id="frm_product_search">
			<label>제품코드</label>
			<input type="text" id="code">
			
			<label>제품명</label>
			<input type="text" id="codeName">
			<input type="text" id="code_select">
			<button type="button">검색</button>
		</form>
		
		<div id="list">
			<div id=title>
				<span class="code">제품코드</span>
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
		
		<button type="button" onclick="test()">적용</button>
	</div>


<script src="../lib/jquery-3.6.0.min.js"></script>

<script>
select=function(sts){
	console.log(sts);
	let frm=$("#frm_product_search")[0];
	let array=$(".item").toArray();
	console.log(array);
	let code=$(array[sts]).find(".code_list").html();
	console.log(code);
	frm.code_select.value=code;
}
</script>
</body>
</html>