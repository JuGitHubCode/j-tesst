<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Book Details</title>
<link rel = 'stylesheet' type = 'text/css' href = './css/user_book_details.css'>
<script src='./lib/jquery-3.6.0.min.js'></script>
<script src='./js/user_book.js'></script>
</head>
<body>
	<h1>유저 상품 상세 Page</h1>
	상품 상세 Page
	상품 상세 정보....
	
	<div class='item'>
		<form name='frm_item_list' class='frm_item_list'>
			<div class='item_img'>
				<img src='./images/test.jpg' class='img'>
			</div>
			<div class='item_info'>
				<label>책 제목</label><br>
				<label>책 설명</label><br>
				<label>작가</label> | <label>출판사</label> | <label>책 날짜</label><br>
				<label>책 가격</label>
				<label>책 수량</label>				
			</div>
		</form>
	</div>
</body>
</html>