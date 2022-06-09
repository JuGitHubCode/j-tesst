<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list</title>
<link rel="stylesheet" href="./css/score.css">
</head>
<body>
<%
	int[] sno={1,2,3,4,5,6,7,8,10,11,12,13,14,15};
	request.setAttribute("sno", sno);
%>

	<div id="score_list">
		<span class="title">성적정보 조회</span>
		<form name="frm_score" id="frm_score" method="post">
			<input type="button" name="btnCreate" id="btnCreate"value="생성">
			<input type="text" name="findStr" value="${param.findStr }">
			<input type="button" name="btnFind" id="btnFind" value="검색">
			<input type="text" name="nowPage" id="nowPage" value="${param.nowPage }">
			<input type="text" name="sno" id="sno" >
		</form>
		<div id="list">
			<div class="title">
				<span class="sno">sno</span>
				<span class="id">아이디</span>
				<span class="mName">성명</span>
				<span class="sub">과목 </span>
				<span class="score">성적</span>
				<span class="date">응시일</span>
			</div>
			<div class="items">
			<c:forEach var="vo" items="${list }">
				<div class="item" onclick="view(${vo.sno})" >
					<span class="sno" name="sno">${vo.sno}</span>
					<span class="id">${vo.id }</span>
					<span class="mName">${vo.mName }</span>
					<span class="sub">${vo.subject } </span>
					<span class="score">${vo.score }</span>
					<span class="date">${vo.nal}</span>
				</div>
			</c:forEach>
			</div>
		</div>
		<div class="paging">
				<c:if test="${page.startPage>1}">
				<button type="button" class="btnFirst" onclick="movePage(1)">맨처음</button>
				<button type="button" class="btnPrev" onclick="movePage(${page.startPage-1})">이전</button>
				</c:if>
				
				<c:forEach var="i" begin="${page.startPage }" end="${page.endPage }">
				<button type="button" class="first" onclick='movePage(${i})'>${i }</button>
				</c:forEach>
				
				<c:if test="${page.totPage>page.endPage}">
				<button type="button" class="btnNext"onclick="movePage(${page.endPage+1})">다음</button>
				<button type="button" class="btnLast"onclick="movePage(${page.totPage})">맨끝</button>
				</c:if>
		</div>
	</div>
	<script src="./js/score.js"></script>
</body>
</html>