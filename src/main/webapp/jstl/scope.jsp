<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>scope</title>
</head>
<body>
<h1>Scope</h1>
<%

//servlet에서 실행되는 코드
String msg="저장 완료";//db처리결과
request.setAttribute("msg", msg);
request.setAttribute("mid", "주");

request.setAttribute("email","request@gmail.com");
session.setAttribute("email","session@gmail.com");
%>

<h3>result</h3>
<hr>
<li>처리결과 : ${requestScope.msg }</li>
<li>[${sessionScope.mid }님 방가]</li>
<li>${mid }</li>
<li>${email }</li>
<li>requset: ${requestScope.email }</li>
<li>session: ${sessionScope.email}</li> 
</body>
</html>