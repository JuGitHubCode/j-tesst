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
	
	<div class='itemslist'>
		<c:forEach var='vo' items='${list}'>
			<form name="frm_item_list" id="frm_item_list" method="post">
					<div class='item' name='item'>
						<div class='item_img' name='item_img'>
							<img src='./images/test.jpg' class='img' name='img' onclick='javascript:document.frm_item_list.btn.onclick()'>
						</div>
						<div class='item_info' name='item_info'>
							<a href='#' onclick='javascript:document.frm_item_list.btn.onclick()' >책 제목</a><br>
							<label name='codeName' for='${vo.codeName }'></label><br>
							<label name='writer' value='${vo.writer }'></label> | <label name='company' value='${vo.company }'></label> | <label name='nal' value='${vo.nal }'></label><br>
							<label name='price' value='${vo.price }'></label>
							<label name='ea' value='${vo.ea }'></label>
						</div>
						
						<input type='text' value='${vo.code }' name='code'/>
						<input type='text' value='${vo.img }' size='30px' name='img'/>
						<button type='button' hidden='hidden' name='btn' onclick='userBook.details(this.form)'>hidden_페이지이동</button>
					</div>
			</form>
		</c:forEach>
		<input type='text' value='${page.findStr }' name='findStr'/>
		<input type='text' value='${page.findStr }' name='findStr'/>
	</div>
	
</body>
</html>