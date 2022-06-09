/**
 * 
 */

//학생관리와 관련된 스크립트
var btnLogin = document.getElementById("btn_login");
var btnLogout= document.getElementById("btn_logout");
var btnLogin2= document.getElementById("btn_login2");

var findId= document.getElementById("find_id_info");
var findPwd= document.getElementById("find_pwd_info");

var btnFindId= document.getElementById("btnFindId");
var btnFindPwd= document.getElementById("btnFindPwd");

//index에서 로그인 버튼이 클릭된 경우
if(btnLogin!=null){
	btnLogin.onclick=function(){
		let url="index.jsp?inc=./student/form_login.jsp";
		location.href=url;
	}
}
if(btnLogout!=null){
	btnLogout.onclick=function(){
		let url="./student/logout_result.jsp";
		let frm=document.frm_login_out;
		frm.action=url;
		frm.submit();
	}
}

//form_login 
//form_login 에서 로그인 버튼 클릭시
if(btnLogin2!=null){
	btnLogin2.onclick=function(){
		let url="./student/login_result.jsp";
		let frm=document.frm_login;
		frm.action=url;
		frm.submit();
	}
}


//form_login 에서 아이디찾기
if(findId!=null){
	findId.onclick=function(){
		let url="index.jsp?inc=./student/form_find_id.jsp";
		location.href=url;
	}
}

//암호찾기
if(findPwd!=null){
	findPwd.onclick=function(){
		let url="index.jsp?inc=./student/form_find_pwd.jsp";
		location.href=url;
	}
}


//form_find_id 에서 찾기 버튼 클릭시
if(btnFindId!=null){
	btnFindId.onclick=function(){
		let url="./student/find_id_result.jsp";
		let frm=document.find_id;
		frm.action=url;
		frm.submit();
	}
}


//form_find_pwd 에서 찾기 버튼 클릭시
if(btnFindPwd!=null){
	btnFindPwd.onclick=function(){
		let url="./student/find_pwd_result.jsp";
		let frm=document.find_pwd;
		frm.action=url;
		frm.submit();
	}
}


//student_list
//student_list의 생성 버튼
var btnCreate=document.getElementById("btnCreate");
if(btnCreate!=null){
	btnCreate.onclick=function(){
		let frm=document.frm_student;
		let url="index.jsp?inc=./student/student_input_form.jsp";
		frm.action=url;
		frm.submit();
		
	}
}

//student_list의 검색 버튼
var btnFind=document.getElementById("btnFind");
if(btnFind!=null){
	btnFind.onclick=function(){
		let frm=document.frm_student;
		let url="index.jsp?inc=./student/student_list.jsp";
		frm.nowPage.value=1;
		frm.action=url;
		frm.submit();//submit은 무조건 새로고침 현상은 발생됨		
	}
}


//student_list의 페이징
function movePage(page){
	let frm=document.frm_student;
	let url="index.jsp?inc=./student/student_list.jsp";
	frm.nowPage.value=page;
	frm.action=url;
	frm.submit();
}
//맨처음
//이전
//1
//2
//3
//4
//다음
//맨끝


//student_input_form
//student_input_form의 저장버튼
var btnSave=document.getElementById("btnSave");
if(btnSave!=null){
	btnSave.onclick=function(){
		let url="student/student_input_result.jsp";
		let frm=document.frm_student;
		frm.action=url;
		frm.submit();
	}
}


//student_input_form의 저장버튼
var btnZipFind=document.getElementById("btnZipFind");
if(btnZipFind!=null){
	btnZipFind.onclick=function(){
		let frm=document.frm_student;
		new daum.Postcode({
				 oncomplete : function(data){
					 frm.zipcode.value=data.zonecode;
					 frm.address.value=data.address;
				 }
			 }).open();
	}
}



//student_input_form의 취소버튼
var btnlist=document.getElementById("btnlist");
if(btnlist!=null){
	btnlist.onclick=function(){
		let frm=document.frm_student;
		let url="index.jsp?inc=./student/student_list.jsp";
		frm.action=url;
		frm.submit();
	}
}



//modify
//list
function modify(id){
	let url="index.jsp?inc=./student/student_modify_form.jsp"
	let frm=document.frm_student;
	frm.id.value=id;
	frm.action=url;
	frm.submit();
}


//update
var btnUpdate=document.getElementById("btnUpdate");
if(btnUpdate!=null){
	btnUpdate.onclick=function(){
		let pwd=prompt("암호 입력	");
		if(pwd==null){
			reutrn;
		}
		let frm=document.frm_student;
		let url="index.jsp?inc=./student/student_modify_result.jsp";
		frm.pwd.value=pwd;
		frm.action=url;
		frm.submit();
	}
}


//update
var btnDelete=document.getElementById("btnDelete");
if(btnDelete!=null){
	btnDelete.onclick=function(){
		let frm=document.frm_student;
		let url="index.jsp?inc=./student/student_delete_result.jsp";
		let pwd=prompt("암호 입력");
		if(pwd==null){
			reutrn;
		}
		frm.pwd.value=pwd;
		frm.action=url;
		frm.submit();
	}
}



function foucs(){
	if(event.keyCode==13){
		console.log("f2");
		document.getElementById("mPwd").focus();
	}
}


function press(){
	if(event.keyCode==13){
		console.log("test");
		document.getElementById("btn_login2").click();
	}
}
