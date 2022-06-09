<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>filter</title>
<script src="../lib/jquery-3.6.0.min.js"></script>
<script>
$(document).ready(function(){
	//짝수번째의 요소의 글자색을 파란
	$(".mnt:even").css("color","#00f");
	
	//홀수 색깔 레드
	$(".mnt:odd").css("color","#f00");
	
	//첫번째 요소 윗쪽 테두리 표시
	$(".mnt:first").css("border-top","2px solid #000");
	
	//마지막 요소 아래쪽 테두리 표시
	$(".mnt:last").css("border-bottom","3px solid #bbb");
	
	
	//모든 강이름 점을 제거 외각선 마진, 패딩 지정
	$("ul>li").css({
		"border":"2px outset #abc",
		"margin":"10px auto",
		"padding":"10px auto",
		"list-style":"none"
	});
	//강이름 중 첫번째 마지막 외각선 빨강
	$("li:first-child").css("border-radius","10px 10px 0 0")
	$("li:last-child").css("border-radius","0 0 10px 10px")
	//강이름들 중 홀수, 바탕색과 짝수번째 바탕색 다르게
	$("li:nth-child(2n)").css("background-color", "#aaa")
	$("li:nth-child(2n-1)").css("background-color", "#bbb")
})

</script>

</head>
<body>

<h1>
filter
</h1>

<div class="mnt">백두산</div>
<div class="mnt">설악산</div>
<div class="mnt">관악산</div>
<div class="mnt">금강산</div>
<div class="mnt">치악산</div>
<div class="mnt">내장산</div>
<div class="mnt">불암산</div>






<ul>
	<li>두만강</li>
	<li>낙동강</li>
	<li>한강</li>
	<li>소금강</li>
	<li>섬진강</li>
	<li>동강</li>
</ul>


</body>
</html>