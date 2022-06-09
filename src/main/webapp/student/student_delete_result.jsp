<%@page import="student.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>student delete result</title>
</head>
<body>
<%
String msg="";
StudentDao dao=new StudentDao();
msg=dao.delete(request);
%>
<form name="frm_student" method="post">
<input type="text" name="findStr" value="${param.findStr }">
<input type="text" name="nowPage" value="${param.nowPage }">
</form>
<script>
	alert("<%=msg%>");
	let url="./index.jsp?inc=./student/student_list.jsp";
	let frm=document.frm_student;
	frm.action=url;
	frm.submit();
</script>
</body>
</html>