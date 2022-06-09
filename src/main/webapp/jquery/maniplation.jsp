<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>manipulation</title>
<script src="../lib/jquery-3.6.0.min.js"></script>
<script>
$(function(){
	$("div").css({
		"border":"2px solid #aaa",
		"padding":"10px",
		"margin":"10px",
		"diplay":"inline-block"
	})
	
	let div="<div id='me'>ME</div>";
	$("#btnWrap").on("click",function(){
		$("#here").wrap(div);
	});
	
	
	$("#btnAppend").on("click",function(){
		$("#here").append(div);
	})
	
	$("#btnPrepend").on("click",function(){
		$("#here").prepend(div);
	})
	
	$("#btnBefore").on("click",function(){
	$("#here").before(div);
	})
	
	
	$("#btnAfter").on("click",function(){
	$("#here").after(div);
	})
	
})

</script>
</head>
<body>

<h1>manipulation</h1>
<div id="here">here	</div>
<button type="button" id="btnWrap">Wrap</button>
<button type="button" id="btnAppend">Append</button>
<button type="button" id="btnPrepend">Prepend</button>
<button type="button" id="btnBefore">Before</button>
<button type="button" id="btnAfter">After</button>


</body>
</html>