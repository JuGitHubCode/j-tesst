<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<c:if test="${not empty uIdValidation }">
	중복된 아이디입니다. 확인해주세요.
</c:if>
<c:if test="${not empty emailValidation}">
	중복된 이메일입니다. 확인해주세요.
</c:if>
<c:if test="${not empty phoneValidation }">
	중복된 휴대폰 번호입니다. 확인해주세요.
</c:if>
</body>
</html>