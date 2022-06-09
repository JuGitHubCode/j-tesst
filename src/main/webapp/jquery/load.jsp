<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>load</title>
<script src="../lib/jquery-3.6.0.min.js"></script>
<style>
 *{
 	box-sizing:border-box;
 	padding:0px;
 	margin:0px;
 }
 
#load{
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}

section>div{
	display: inline-block;
	width:300px;
	height: 200px;
	border: 2px solid #aaa;
	padding:20px;
}
</style>
<script>
	$(function(){
		$("#btnA").on("click",function(){
			let param=$("#frm_load").serialize();//p=v&p=v
			$("#a").load("load_sub.jsp #a",param)
		})
		
		$("#btnB").on("click",function(){
			let param=$("#frm_load").serialize();
			alert(param);
			$("#b").load("load_sub.jsp #b",param);
		})
		
		$("#btnC").on("click",function(){
			let param=$("#frm_load").serialize();
			$("#c").load("load_sub.jsp #c",param);
		})
		
	})


</script>


</head>
<body>
	<h1>load</h1>
	<div id="load">
		<form name="frm_load" id="frm_load" method="post">
			<label>아이디</label>
			<input type ="text" name="id"><br>
			<label>암호</label>
			<input type="text" name="pwd"><br>
			
			<button type="button" id="btnA">로그인</button>
			<button type="button" id="btnB">아이디 찾기</button>
			<button type="button" id="btnC">암호찾기</button>
				
		</form>
		
		<section>
			<div id="a"></div>
			<div id="b"></div>
			<div id="c"></div>
		
		
		
		</section>
	</div>
	
	
</body>
</html>