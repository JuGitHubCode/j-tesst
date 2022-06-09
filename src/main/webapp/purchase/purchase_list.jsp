<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list </title>
</head>
<body>
<div id="purchase_list">
		<form name="frm_purchase_list" class="frm_purchase_list" id="frm_purchase_list" method="post">
			<input type="text" id="findStr" name="findStr">
			<input type="button" id="btnFind" name="btnFind" value="검색" onclick="purchase.findSelect()">
			<input type="text" id="nowPage" name="nowPage">
			<input type="text" name="code">	
		</form>
		
		<div id="list">
			<div class="title">
				<span class="sno">.No</span>
				<span class="code">제품코드</span>
				<span class="codeName">제품명</span>
				<span class="nal">구매일자</span>
				<span class="price">단가</span>
				<span class="ea">수량</span>
				<span class="amt">금액</span>
			</div>
			<div class="items">
				<c:forEach var="tem" begin="0" end="20" varStatus="sts">
					<div class="item"  onclick="purchase.view(${sts.index })" >
						<span class="sno">${tem }</span>
						<span class="code">제품코드</span>
						<span class="codeName">제품명</span>
						<span class="nal">구매일자</span>
						<span class="price"><fmt:formatNumber>${vo }</fmt:formatNumber> </span>
						<span class="ea"><fmt:formatNumber>${vo }</fmt:formatNumber></span>
						<span class="amt"><fmt:formatNumber>${vo }</fmt:formatNumber></span>
						
					</div>
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
</body>
</html>