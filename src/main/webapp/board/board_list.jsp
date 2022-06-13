<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board_list</title>
<link rel="stylesheet" href="./css/board.css">
<script src="./lib/jquery-3.6.0.min.js"></script>

</head>
<body>

	<div id="board_list">
		<form name="frm_board_list" class="frm_board_list" method="post">
			<button type="button" onclick="board.input(this.form)">입력</button>
			<input type="search" name="findStr" value="${param.findStr }">
			<button type="button" onclick="board.find(this.form)">조회</button>
			<input type="text" name="nowPage" value="${param.nowPage }">
			<input type="text" name="sno" value="test!!!!">
		</form> 
		<div class="title">
			<span class="sno">sno</span>
			<span class="subject">subject</span>
			<span class="nal">작성일</span>
			<span class="id">작성자</span>
			<span class="hit">조회수</span>
		</div>
		<div class="items">
			<c:forEach var="vo" begin="0" end="15">
				<div class="item" onclick="board.view(${vo})">
					<span class="sno">sno</span>
					<span class="subject">subject</span>
					<span class="nal">작성일</span>
					<span class="id">작성자</span>
					<span class="hit">조회수</span>
				</div>
			</c:forEach>
		</div>
		<div class="btns">
			<button type="button" onclick="board.movePage(1)">맨처음</button>
			<button type="button" onclick="board.movePage(1)">이전</button>
			
			<c:forEach var="i" begin="1" end="4">
				<button type="button" onclick="board.movePage(${i })">${i }</button>
			</c:forEach>
			
			<button type="button" onclick="board.movePage(${i })">>다음</button>
			<button type="button" onclick="board.movePage(${i })">>맨끝</button>
		</div>
	
	</div>
<script src="./js/board.js"></script>
</body>
</html>