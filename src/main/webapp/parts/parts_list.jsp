<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>parts list</title>
<link rel="stylesheet" href="./css/parts.css">
</head>
<body>
	
	<div id="parts_list">
		<form name=frm_parts_list id="frm_parts_list" class="frm_parts_list" method="post">
			<input type="text" name="findStr" value="${param.findStr }" onkeypress="press()">
			<input type="button" name="btnFind" id="btnFind" value="검색" onclick="parts.select()"><!--js의 이미디에이트에서 생성된 parts라는 오브젝트 사용-->
			<input type="text" name="nowPage" id="nowPage" value="${param.nowPage }">
			<input type="text" name="code">
		</form>
		
		<div id="list">
			<div class="title">
				<span class="no">.No</span>
				<span class="code">제품코드</span>
				<span class="codeName">제품명</span>
				<span class="spec">사양</span>
				<span class="price">단가 </span>
			</div>
			<div class="items">
				<c:set var="i" value="${page.startNo+1}"/>
				<c:set var="pos" value="0"/>
				<c:forEach var="vo" items="${list }">
					<div class="item"  onclick="parts.view(${pos},'${vo.code }')">
						<span class="no" name="no">${i }</span>
						<span class="code">${vo.code }</span>
						<span class="codeName">${vo.codeName }</span>
						<span class="spec">${vo.spec }</span>
						<span class="price">${vo.price } </span>
					</div>
					<c:set var="i" value="${i=i+1 }"/>
					<c:set var="pos" value="${pos=pos+1 }"/>
				</c:forEach>
			</div>
			
		</div>
		<div class="paging">
				<c:if test="${page.startPage>1}">
				<button type="button" class="btnFirst" onclick="parts.movePage(1)">맨처음</button>
				<button type="button" class="btnPrev" onclick="parts.movePage(${page.startPage-1})">이전</button>
				</c:if>
				
				<c:forEach var="i" begin="${page.startPage }" end="${page.endPage }">
				<button type="button" class="first" onclick='parts.movePage(${i})'>${i }</button>
				</c:forEach>
				
				<c:if test="${page.totPage>page.endPage}">
				<button type="button" class="btnNext"onclick="parts.movePage(${page.endPage+1})">다음</button>
				<button type="button" class="btnLast"onclick="parts.movePage(${page.totPage})">맨끝</button>
				</c:if>
		</div>
	</div>
		
<c:if test="${not empty msg }"><!-- msg가 비어있지 않으면  -->
	<script>
		alert("${msg}");
	</script>
</c:if>		
		
</div>
</body>
</html>