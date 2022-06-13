<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Book Search</title>
<script defer src='./js/user_book.js'></script>
</head>
<body>
	<h1>유저 상품 Search Page</h1>
	검색했을때 불러오는 Page
	세부 카테고리, 검색 list 등등...<br>
	<input type='text' name='findStr' value='${param.findStr}' size='10px'/>
	
	<div class='searchlist'>
		<form name="frm_item_list" id="frm_item_list" method="post">
				<div class='item' name='item'>
				
					<div class='item_img' name='item_img'>
						<img src='./images/test.jpg' class='img' name='img' onclick='javascript:document.frm_item_list.btn.onclick()'>
					</div>
					<div class='item_info' name='item_info'>
						<a href='#' onclick='javascript:document.frm_item_list.btn.onclick()' >책 제목</a><br>
						<label name='codeName'>책 설명</label><br>
						<label name='writer'>작가</label> | <label name='company'>출판사</label> | <label name='nal'>책 날짜</label><br>
						<label name='price'>책 가격</label>
						<label name='ea'>책 수량</label>
					</div>
					<input type='text' value='' name='code'/>
					<input type='text' value='${page.findStr }' name='code'/>
					<button type='button' hidden='hidden' name='btn' onclick='userBook.details(this.form)'>hidden_페이지이동</button>
				</div>
		</form>
	</div>
	
	
	
	
</body>
</html>