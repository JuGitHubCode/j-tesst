<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>parts input</title>
<link rel="stylesheet" href="./css/parts.css">
</head>
<body>
<div id="view">
	<form name="frm_parts" id="frm_parts_input" method="post">
		<div>
		<label>코드</label>
		<input type="text" name="code" value="${vo.code }">
		</div>
		
		<div>
		<label>제품명</label>
		<input type="text" name="codeName" size="20" value="${vo.codeName }">
		</div>
		
		
		<div>
		<label>사양</label>
		<input type="text" name="spec" size="30" value="${vo.spec }">
		</div>
		
		<div>
		<label>단가</label>
		<input type="text" name="price" value="${vo.price }">
		</div>
		
	</form>
	
		<div class="btn">
			<button type="button" class="btnInsert" onclick="parts.insert()">저장</button>
			<button type="button" class="btnUpdate" disabled onclick="parts.update()">수정</button>
			<button type="button" class="btnDelete" disabled onclick="parts.delete()">삭제</button>
			<button type="button" class="btnCancel" onclick="parts.cancel()">취소</button>
		</div>

<c:if test="${not empty msg }"><!-- msg가 비어있지 않으면  -->
	<script>
		alert("${msg}");
	</script>
</c:if>
</div>
</body>
</html>