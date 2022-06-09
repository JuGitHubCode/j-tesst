<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>effect</title>
<script src="../lib/jquery-3.6.0.min.js"></script>
<script>
$(function(){
	$("#here").css({
		"height":"100px",
		"background-color":"#aaa"
	})
	
	$("#btnHide1").on("click",function(){
		$("#here").hide();
	})
	
	$("#btnHide2").on("click",function(){
		$("#here").hide("slow");
	})
	
	$("#btnHide3").on("click",function(){
		$("#here").hide("fast");
	})
	
	$("#btnHide4").on("click",function(){
		$("#here").hide(2000);
	})
		
		
		
		
	$("#btnShow1").on("click", function(){
		$("#here").show();
	})
	
	$("#btnShow2").on("click", function(){
		$("#here").show("slow");
	})
	
	$("#btnShow3").on("click", function(){
		$("#here").show("fast");
	})
	
	$("#btnShow4").on("click", function(){
		$("#here").show(2000);
	})
	
	
	
	$("#btnSlideUp").on("click", function(){
		$("#here").slideUp(2000);
	})
	
	$("#btnSlideDown").on("click", function(){
		$("#here").slideDown(2000);
	})
	
	
	$("#btnSlideToggle").on("click", function(){
		$("#here").slideToggle("slow");
	})
	
	$("#btnFadein").on("click", function(){
		$("#here").fadeIn(2000);
	})
	
	$("#btnFadeout").on("click", function(){
		$("#here").fadeOut(2000);
	})
	
})			

</script>
</head>
<body>

<h1>effect</h1>
<div id="here">here</div>

<fieldset>
<legend>show</legend>
	<button type="button" id="btnShow1">default</button>
	<button type="button" id="btnShow2">slow</button>
	<button type="button" id="btnShow3">fast</button>
	<button type="button" id="btnShow4">user</button>
</fieldset>


<fieldset>
	<legend>hide</legend>
	<button type="button" id="btnHide1">default</button>
	<button type="button" id="btnHide2">slow</button>
	<button type="button" id="btnHide3">fast</button>
	<button type="button" id="btnHide4">user</button>
</fieldset>


<fieldset>
	<legend>slide</legend>
	<button type="button" id="btnSlideUp">slidup</button>
	<button type="button" id="btnSlideDown">slidedown</button>
	<button type="button" id="btnSlideToggle">SlideToggle</button>
</fieldset>


<fieldset>
	<legend>fade</legend>
	<button type="button" id="btnFadein">btnFadein</button>
	<button type="button" id="btnFadeout">btnFadeout</button>
</fieldset>

</body>
</html>