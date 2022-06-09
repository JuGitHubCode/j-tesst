<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>selector</title>
<script src="../lib/jquery-3.6.0.min.js"></script>
</head>
<body>
<h1>selector</h1>
<button type="button" onclick="funred()">red</button>
<button type="button" onclick="funblue()">blue</button>

<div id="first">first</div>
<div id="second">second</div>
<span name="h" a="a">k</span>
	<span name="l">l</span>
	<span name="p">p</span>
<div id="items">
	<span name="h" a="a">k</span>
	<span name="l">l</span>
	<span name="p">p</span>
</div>

<script>

	function funred(){
		$("h1").css("color","#f00");
	}
	
	function funblue(){
		$("h1").css("color","#00f");
	}
	
	
	$("#first").css({
		"padding" : "20px", "background-color":"#abc",
		"border" :"2px solid #fff",
		"color": "#fff",
		"margin" : "10px auto"
	})
	
	//items 안의 모든 span에 border padding 지정
	$("#items>span").css({
		"border": "2px solid #000",
		"padding" : "20px auto"
	})
	
	
	//items 안으 span 태그중 name 속성에 따른 h=red, l=blue, p=gray
	$("span[name=h]").css({
		"background-color":"red"
	})
	$("span[name=l]").css({
		"background-color":"blue"
	})
	$("span[name=p]").css({
		"background-color":"gray"
	})
	
	//태그 a속성의 a값이 있으면 글씨 bold
	
	$("[a=a]").css({
		"color":"white"
	})
	
</script>
</body>
</html>