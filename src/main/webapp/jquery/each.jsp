<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>each</title>
<script src="../lib/jquery-3.6.0.min.js"></script>
<script>
$(function(){
	var bg=["#foo","#oof","#aaa","#abc","#cba"];
	$("div").each(function(index){
		$(this).css("background-color", bg[index])
	})
	
})
</script>
</head>
<body>

<h1>each</h1>

<div class="d">A</div>
<div class="d">B</div>
<div class="d">C</div>
<div class="d">D</div>
<div class="d">E</div>


</body>
</html>