<%@page import="score.ScoreVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL</title>
<style>
h2{
	background-color:#aaa;
}

</style>
</head>
<body>

	<h1>jstl example</h1>
	<li>Name :<c:out value="홍길동"/> </li>
	<li>Address :<c:out value="" default="서울"></c:out></li>
	<li> tag : <c:out value="<h3>tag</h3>" escapeXml="false"/>
	<li> tag : <c:out value="<h3>tag</h3>" escapeXml="true"/>
	
	
	<h2>c:set|c:remove</h2>
	<c:set var="name" value="hongilldong"/>
	<li>Name : ${name}</li>
	<c:remove var="name"/>
	<li>Name(remove 이후) : ${name}</li>
	
	
	<h2 >c:if</h2>
	<div>
		변수 x에 임의의 값을 대입한 후 x값이 60 이상이면 "합격" 출력
		<% 
			int num=(int)(Math.random()*100);
			request.setAttribute("score", num);
		
		%>
		
		<c:set var="x" value="${score }"/>
		<li>result :<c:out value="${x }"/>점</li>
		<c:if test="${x>=60 }">
		<span>합격</span>
		</c:if>
	
	<h2 >c:forEach</h2>
	<fieldset>
		<c:set var="x" value="1"/>
		<c:set var="y" value="10"/>
		<c:forEach var="i" begin="${x }" end="${y }" step="2" varStatus="st">
			
		 <li>${i }-${st.count}-${st.index}</li>
		</c:forEach>
	
	</fieldset>
	
	<fieldset>
	배열에 임의의 값들을 저장한 후 forEach문장 사용 출력
	<% 
		String[]names={"k","l","p","ch","h"};
		List<String> list=new ArrayList();
		list.add("강아지");
		list.add("고양이");
		list.add("송아지");
		
		request.setAttribute("names", names);
		request.setAttribute("list", list);
	%>
	
	<c:set var="array" value="[1,2,3,4,5]"/>
	
	<li>배열값 출력</li>
	<c:forEach var="item" items="${requestScope.names }">
		<span>${item }</span>
	</c:forEach>
	
	<li>list</li>
	<c:forEach	var="ani" items="${requestScope.list }">
		<span>${ani }</span>
	</c:forEach>
	
	</fieldset>
	
	<h3>forEach를 이용한 Object출력</h3>
	
	
	<%
		//서버의 처리결과
		List<ScoreVo> scoreList=new ArrayList<ScoreVo>();
		ScoreVo v1=new ScoreVo();
		v1.setId("k");v1.setSubject("국어");
		
		ScoreVo v2=new ScoreVo();
		v2.setId("l");v2.setSubject("영");
		
		ScoreVo v3=new ScoreVo();
		v3.setId("j");v3.setSubject("수");
		
		scoreList.add(v1);
		scoreList.add(v2);
		scoreList.add(v3);
		
		request.setAttribute("score", scoreList);
	%>
	
	<table border="1" width="400">
		<c:forEach var="vo" items="${score }">
			<tr>
				<!--vo.getId, vo.getsubject를 실행  -->
				<td>${vo.id }</td>
				<td>${vo.subject }</td>
				
			</tr>
		
		</c:forEach>
	
	</table>
	
	</div>
	
</body>
</html>