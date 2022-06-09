<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>input</title>
<link rel="stylesheet" href="./css/purchase.css">
</head>
<body>
<div id="purchase_input">
	<form name="frm_purchase_input" id="frm_purchase_input" method="post">
		<div>
		<label>순번</label>
		<input type="text" name="sno" value="${vo.sno }">
		</div>
		
		<div>
		<label>제품코드</label>
		<input type="text" class="code" name="code" size="20" value="${vo.code }">
		<button type="button" class="btnInsert" onclick="purchase.findCode()">검색</button>
		</div>
		
		
		<div>
		<label>제품명</label>
		<input type="text" name="codeName" class="codeName"  size="30" value="${vo.codeName }">
		</div>
		
		<div>
		<label>생산일자</label>
		<input type="date" name="nal" value="${vo.nal }">
		</div>
		
		
		<div>
		<label>수량</label>
		<input type="text" name="ea" value="${vo.ea }" onkeyup="purchase.compute(this.form)">
		</div>
		
		
		<div>
		<label>단가</label>
		<input type="text" name="price" value="${vo.price }" onkeyup="purchase.compute(this.form)">
		</div>
		
		
		<hr>
		
		<div>
		<label>금액</label>
		<input type="text" name="amt" value="${vo.amt }" readonly>
		</div>
		
	</form>
	
		<div class="btn">
			<button type="button" class="btnInsert" onclick="parts.insert()" >저장</button>
			<button type="button" class="btnUpdate" onclick="parts.update()" disabled>수정</button>
			<button type="button" class="btnDelete" onclick="parts.delete()" disabled>삭제</button>
			<button type="button" class="btnCancel" onclick="parts.cancel()">취소</button>
		</div>
</div>
<c:if test="${not empty msg }"><!-- msg가 비어있지 않으면  -->
	<script>
		alert("${msg}");
	</script>
</c:if>
</body>
</html>