<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>search</title>
<style>
	form{
		margin-bottom:5px;
	}
	
	form label{
		display: inline-block;
		width:70px;
	}
	
	form input[name=code]{
		width:260px;		
	}
	select{
		width:350px;
		height:400px;
	}
	
</style>

</head>
<body>
	<div id="search">
		<form name="frm_product_search" class="frm_product_search" action="/web_project2/product.do?job=findCode" method="post">
			<label>코드</label>
			<input type="text" name="code" value="${param.code }">
			<button>검색</button>
		
		
			<select name="sel" size="20" ondblclick="choice()">
				<c:forEach var="vo" items="${list }">
					<option value="${vo.code }/${vo.codeName }/${vo.price }">${vo.codeName }</option>
				</c:forEach>
			</select>
		</form>
	</div>
	
	<script>
		let openFrm=opener.document.frm_product_input;
		let localFrm=document.frm_product_search;
		/*localFrm.code.value=opeFrm.code.Value;*/
		
		choice = function(){
			let index=localFrm.sel.selectedIndex;
			let array=localFrm.sel[index].value.split("/");
			console.log(index);
			console.log(array);
			
			openFrm.code.value=array[0];
			openFrm.codeName.value=array[1];
			openFrm.price.value=array[2];
			self.close();
		}
	</script>
	
	
</body>
</html>