<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/product.css">
</head>
<body>
<div id="product_input">
	<form name="frm_product_input" id="frm_product_input" method="post">
		<div>
		<label>순번</label>
		<input type="text" name="sno" value="${vo.sno }" readonly>
		</div>
		
		<div>
		<label>제품코드</label>
		<input type="text" class="code" name="code" size="20" value="${vo.code }">
		<button type="button" class="btnInsert" onclick="product.findCode()">검색</button>
		</div>
		
		
		<div>
		<label>제품명</label>
		<input type="text" name="codeName" size="30" value="${vo.codeName }">
		</div>
		
		<div>
		<label>생산일자</label>
		<input type="date" name="nal" value="${vo.nal }">
		</div>
		
		
		<div>
		<label>수량</label>
		<input type="text" name="ea" value="${vo.ea }" onkeyup="product.compute(this.form)">
		</div>
		
		
		<div>
		<label>단가</label>
		<input type="text" name="price" value="${vo.price }" onkeyup="product.compute(this.form)">
		</div>
		
		
		<hr>
		
		<div>
		<label>금액</label>
		<input type="text" name="amt" value="${vo.amt }" readonly>
		</div>
		
	</form>
	
		<div class="btn">
			<button type="button" class="btnInsert" onclick="product.insert()" >저장</button>
			<button type="button" class="btnUpdate" onclick="product.update()" disabled>수정</button>
			<button type="button" class="btnDelete" onclick="product.delete()" disabled>삭제</button>
			<button type="button" class="btnCancel" onclick="product.cancle()">취소</button>
		</div>
</div>
<c:if test="${not empty msg }"><!-- msg가 비어있지 않으면  -->
	<script>
		alert("${msg}");
	</script>
</c:if>
</body>
</html>