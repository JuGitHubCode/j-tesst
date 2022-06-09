<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
<link rel="stylesheet" type="text/css" href="./css/index.css">
</head>
<body>
<%
	String inc=request.getParameter("inc");//student.js의 inc값을 가져옴
	if(inc==null){
		inc="./temp.jsp";
	}
%>
	<div id="main">
		<header id="header">
			<%@include file="./student/login_out.jsp" %>
		</header>
		<div id="top">top
			<nav id="nav">
				<ul>
					<li><a href="index.jsp">Home</a></li>
					<li><a href="index.jsp?inc=student/student_list.jsp">학생관리</a></li>
					<li><a href="./score.do">성적관리</a></li>
					<li><a href="index.jsp?inc=parts/parts_main.jsp">제품관리</a></li>
					<li><a href="index.jsp?inc=product/product_main.jsp">생산관리</a></li>
					<li><a href="index.jsp?inc=purchase/purcahse_main.jsp">구매관리</a></li>
					<li><a href="index.jsp?inc=noti/noti_main.jsp">공지사항</a></li>
					<li>게시판관리</li>				
				</ul>
			</nav>
			<div id="ci"></div>
		</div>
		<section id="section">
			<jsp:include page="<%=inc %>"/>
		</section>
		<footer id="footer">
			서울 봉천 노랑계란 7층<br/>
			tel:02-1111-1111<br/>
			fax:02-1111-2222
		</footer>	
	</div>


</body>
</html>