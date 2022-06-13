<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Book Category</title>
<link rel = 'stylesheet' type = 'text/css' href = './css/user_book_category.css'>
<script src='./lib/jquery-3.6.0.min.js'></script>
<script src='./js/user_book.js'></script>
</head>
<body>
	<h1>유저 상품 Category Page</h1>
	카테고리 Page
	해당 카테고리 list 등등...
	<%
		int item_count = 0;
	%>
	<div class='itemslist'>
		<form name="frm_item_list" id="frm_item_list" method="post">
			<c:forEach var='vo' items='${list}'>
				<div class='item' name='item' onclick='userBook.details("frm_item_list",${vo.code})'>
					<div class='item_img' name='item_img'>
						<img src='./images/test.jpg' width='250px' height='300px' class='img' name='img' onclick='javascript:document.frm_item_list.btn.onclick()'>
					</div>
					<div class='item_info' name='item_info'>
						<a href='#' onclick='javascript:document.frm_item_list.btn.onclick()' >${vo.codeName}</a><br>
						<label name='writer'>${vo.writer}</label> | <label name='company'>${vo.company}</label> | <label name='nal' >${vo.nal}</label><br>
						<label name='price' >${vo.price} 원</label><br>
						<label name='ea' >남은 수량 : ${vo.ea} 권</label>
					</div>
					
					<input type='text' value='${vo.code}' name='code'/>
					<input type='text' value='${vo.img }' size='30px' name='img'/>
					
				</div>
			</c:forEach>
			<!-- <button type='button' hidden='hidden' name='btn' onclick='userBook.details(this.form)'>hidden_페이지이동</button> -->
		</form>
		<input type='text' value='${page.findStr }' name='findStr'/>
		<input type='text' value='${page.nowPage }' name='nowPage'/>
	</div>
	
</body>
</html>