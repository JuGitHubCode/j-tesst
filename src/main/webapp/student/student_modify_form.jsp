<%@page import="student.StudentVo"%>
<%@page import="student.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>student modify form</title>
<link rel="stylesheet" href="../css/student.css">
</head>
<body>

	<%
		String mid=request.getParameter("id");
		StudentDao dao=new StudentDao();
		StudentVo v=dao.selectOne(mid);
		request.setAttribute("v", v);
		//여기까지가 백앤드
		
	%>


	<div id="student">
		<form name="frm_student" id="frm_student" method="post">
			<h1>학생정보 입력</h1>
			<label>아이디</label>
			<input type ="text" name="id" size="15" readonly="readonly" value="${v.id}"><br>
			
			<label>성명</label>
			<input type ="text" name="mName" size="15" value="${v.mName}"><br>
			
			<label>성별</label>
			<input type="text" value="${v.gender}">
			<label>
			<input type ="radio" name="gender" value="m" ${(v.gender=='m')?'checked':''}>
			남자
			</label>
			
			<label>
			<input type ="radio" name="gender" value="f" ${(v.gender=='f')?'checked':''}>
			여자
			</label>
			<br>
						
			<label>연락처</label>
			<input type ="text" name="phone"size="15" value="${v.phone}"><br>
			
			<label>우편번호</label>
			<input type ="text" name="zipcode"size="7" readonly="readonly" value="${v.zipcode}">
			<button type="button" id="btnZipFind">검색</button>
			<br>
			
			<label>주소</label>
			<input type ="text" name="address"size="45" value="${v.address}"><br>
			
			<label>이메일</label>
			<input type ="text" name="email"size="15" autocomplete="none" value="${v.email }"><br>
			
			<label></label>
			<button type="button" id="btnUpdate">수정</button>
			<button type="button" id="btnDelete">삭제</button>
			<button type="button" id="btnlist">취소</button>
			
			<input type="text" name="findStr" value="${param.findStr}">
			<input type="text" name="nowPage" value="${param.nowPage}">
			
			<input type ="hidden" name="pwd" ><br>
		</form>
	</div>
	
	<script src="./js/student.js"></script>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</body>
</html>