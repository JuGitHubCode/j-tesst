/**
 * 
 */

let userBook = {};

userBook.cart = function(frm) {
	//로그인 확인
	let loginState = "";
	var testId = document.getElementById('testID');
	if(testId.value == "test"){
		loginState = null;
	}
	
	if(loginState != null){
		//해당 user의 마이페이지 - 장바구니 Page로 이동
		frm.action='userBook.do?job=cart';
		frm.submit();
	}
	else{
		//로그인 필요알람
		alert("로그인이 필요한 페이지입니다.");
		//login main Page로 이동
		frm.action='userBook.do?job=login';
		frm.submit();
	}
}

userBook.login = function(frm){
	frm.action='userBook.do?job=login';
	frm.submit();
}


userBook.findStr = function(frm){
	//let param = $(frm).serialize();
	//console.log("param : " + param);
	
	//let findStr = $("#findStr").val();
	//console.log("findStr : " + findStr);
	//$.post("userBook.do?job=search", param);
	
	//console.log("findStr : " + str);
	frm.action='userBook.do?job=search';
	frm.submit();
}

userBook.category = function(frm){
	console.log(frm);
	//let frm = document.getElementById('frm_index_category');
	//let findStr = $("#findStr").val();
	frm.action='userBook.do?job=category';
	frm.submit();
}


userBook.details = function(frmName, code){
	//console.log("frm : " + frm);
	//let param = $(frm).serialize();
	//console.log("param : " + param);
	
	//$.post("userBook.do?job=details", param);
	
	//console.log(frm);
	let frm = document.getElementById(frmName);
	frm.action='userBook.do?job=details' + "book=" + code;
	frm.submit();
}
