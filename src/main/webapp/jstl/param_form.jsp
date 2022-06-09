<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<h1>param test</h1>

<form name="frm" method="post">

<label> Name </label>
<%-- <input type="text" name="irum" value="<%=request.getParameter('irum')%>"> 과 같음 --%>
<input type="text" name="irum" value="${param.irum }">
<label> gender </label>
<label><input type="radio"
${(param.gender=='m')? 'checked':'' }
name="gender" value="m" >남자</label>
<label><input type="radio"
${(param.gender=='f')? 'checked':'' }
name="gender" value="f">여자</label>
<br>


<label> hobby </label>
<label><input type=checkbox name="hobby" value="축구" >축구</label>
<label><input type=checkbox name="hobby" value="야구" >야구</label>
<label><input type=checkbox name="hobby" value="농구" >농구</label>
<label><input type=checkbox name="hobby" value="배구" >배구</label>
<label><input type=checkbox name="hobby" value="탁구" >탁구</label>
<br>
<label>과정선택</label>

<select name="subject" size="5">
	<option value="html">html</option>
	<option value="css">css</option>
	<option value="java">java</option>
	<option value="jsp">jsp</option>
</select>


<input type="submit">
<br> 

</form>
<hr>
<ul>
	<li>Name : ${param.irum }</li>
	<li>Gender : ${param.gender }</li>
	<li>hobby : 
		<ul>
			<c:forEach  var="i" items="${paramValues.hobby }">
			<li>${i }</li>
			</c:forEach>
		</ul>
	
	</li>
	
	<li>Sub : ${param.subject }</li>
</ul>

<Script>
 
 let frm=document.frm;
<c:forEach var="i" items="${paramValues.hobby}">
	 for(var j=0; j<frm.hobby.length;j++){
		if("${i}"==frm.hobby[j].value){
			frm.hobby[j].checked=true;
			break;
		} 
	 }
</c:forEach>



//select 상자 체크
let sel=document.frm.subject;
for(var i=0; i<sel.length;i++){
	if("${param.subject}"==sel.options[i].value){
		sel.options[i].selected=true;
	}
}

</Script>


</body>
</html>