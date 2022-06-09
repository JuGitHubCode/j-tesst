<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인/아웃</title>

</head>
<body>
	<form name="frm_login_out" method="post">
		<%
			/* session.setAttribute("mId",null);*/
			String mId=(String)session.getAttribute("mId"); 
			if(mId==null){
		%>
				<button type="button" id="btn_login">로그인</button>
		<%
			}else{
		%>
			<output class="login_info">
			[<%=mId%>님] 반갑습니다.
			</output>
			<button type="button" id="btn_logout">로그아웃</button>
		<%	
			}
		%>

	</form>
<script src="./js/student.js"></script>

</body>
</html>