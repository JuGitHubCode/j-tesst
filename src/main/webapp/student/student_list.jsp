<%@page import="bean.Page"%>
<%@page import="student.StudentVo"%>
<%@page import="student.StudentDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>student_list</title>
<link rel="stylesheet" href="./css/student.css">
</head>
</head>
<body>
	<%
		StudentDao dao=new StudentDao();
		int nowPage=1;
		if(request.getParameter("nowPage")!=null){
			nowPage=Integer.parseInt(request.getParameter("nowPage"));
		}
		String findStr=request.getParameter("findStr");
		if(findStr==null){findStr="";};
		List<StudentVo> list=dao.select(findStr, nowPage);
		Page p=dao.getP();
	%>

	<div id="studentList">
		<h1>학생 정보 조회</h1>
		<form name="frm_student" id="frm_student" method="post">
			<input type="button" name="btnCreate" id="btnCreate" value="생성">
			<input type="text" name="findStr" id="findStr" size=30 
			value='${param.findStr}'>
			<input type="button" name="btnFind" id="btnFind" value="검색">
			<input type="text" name="nowPage" value="${param.nowPage}">
			<input type="hidden" name="id" >
		</form>
		<div id="list">my
			<div class="title">
				<span class="no">No</span>
				<span class="id">아이디</span>
				<span class="pwd">암호</span>
				<span class="name">성명</span>
				<span class="gender">성별</span>
				<span class="phone">전화번호</span>
				<span class="email">이메일</span>
				<span class="zipcode">우편번호</span>
				<span class="address">주소</span>
			</div>
			<div class="items">
				<%
				int no=p.getStartNo();
				for(StudentVo v:list){ %>
				<div class=item onclick="modify('<%=v.getId()%>')">
				<span class="no"><%=no%></span>
				<span class="id"><%=v.getId()%></span>
				<span class="pwd"><%=v.getPwd()%></span>
				<span class="name"><%=v.getmName() %></span>
				<span class="gender"><%=v.getGender()%></span>
				<span class="phone"><%=v.getPhone() %></span>
				<span class="email"><%=v.getEmail() %></span>
				<span class="zipcode"><%=v.getZipcode() %></span>
				<span class="address"><%=v.getAddress() %></span>
				</div>
				<%no++;
				};%>
			</div>
			<div class="paging">
				<%if(p.getStartPage()>1){ %>
				<button type="button" class="btnFirst" onclick="movePage(<%=1%>)">맨처음</button>
				<button type="button" class="btnPrev" onclick="movePage(<%=p.getStartPage()-1%>)">이전</button>
				<%}%>
				
				<% for(int i=p.getStartPage(); i<=p.getEndPage();i++){ %>
				<button type="button" class="first" onclick='movePage(<%=i%>)'><%=i%></button>
				<%}%>
				
				<%if(p.getEndPage()<p.getTotPage()){ %>
				<button type="button" class="btnNext"onclick="movePage(<%=p.getEndPage()+1%>)">다음</button>
				<button type="button" class="btnLast"onclick="movePage(<%=p.getTotPage()%>)">맨끝</button>
				<%}%>
			</div>
		</div>
	</div>
	<script src="./js/student.js"></script>
</body>
</html>