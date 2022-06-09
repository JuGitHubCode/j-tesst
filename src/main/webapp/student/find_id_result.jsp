<%@page import="student.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>find_id_result</title>
</head>
<body>

	<%
		StudentDao dao=new StudentDao();
		String msg=dao.findId(request);
	%>
	
	
	<script>
		alert("<%=msg%>");
		location.href="../index.jsp?inc=./student/form_login.jsp";
	</script>

</body>
</html>