/* 회원가입 */

member = {};

// 회원가입 클릭
member.join = function(frm){
	/*
	let uId = frm.uId.value;
	let pwd = frm.pwd.value;
	let name = frm.name.value;
	let email = frm.email.value;
	let phone = frm.phone.value;
	let birth = frm.birth.value;
		
	
	if(!isUid(uId)) {
		alert("아이디를 확인해주세요.");
		return
	} else if(!isPwd(pwd)) {
		alert("비밀번호를 확인해주세요.");
		return
	} else if(!isName(name)) {
		alert("이름을 확인해주세요.");
		return
	} else if(!isEmail(email)) {
		alert("이메일을 확인해주세요.");
		return
	} else if(!isPhone(phone)) {
		alert("휴대폰 번호를 확인해주세요.");
		return
	} else if(!isBirth(birth)) {
		alert("생년월일을 확인해주세요.");
		return
	} else{
		
	}
	*/
	let param = $(frm).serialize();
	console.log(param);
	$.post("../../userMember.do?job=memberLogin");
}
member.test = function(frm){
	frm.action = '../../userMember.do?job=memberLogin';
	frm.submit();
}
// 우편번호 검색
member.findZipcode = function(){
	let frm = document.frm_user_join;
	
	new daum.Postcode({
		oncomplete: function(data) {
			frm.zipcode.value = data.zonecode;
			frm.address1.value = data.address;
		}
   	}).open();
}

$("#uId").on("blur", function(){
	let uId = $(this).val();

	if(!isUid(uId)){
		$("#uIdValidation").text("영어 소문자, 숫자를 사용하여 6~12자리로 입력해주세요.")
	} else {
		$("#uIdValidation").text("");
		// 중복회원 db로 조회하기
	}
})

$("#pwd").on("blur", function(){
	let pwd = $(this).val();
	
	if(!isPwd(pwd)){
		$("#pwdValidation").text("대소문자 영어, 숫자를 사용하여 8~16자리로 입력해주세요.")
	} else{
		$("#pwdValidation").text("")
	}
})

$("#name").on("blur", function(){
	let name = $(this).val();	

	if(!isName(name)){
		$("#nameValidation").text("한글 2~6자리의 이름을 입력해주세요.")
	} else{
		$("#nameValidation").text("")
	}
})

$("#email").on("blur", function(){
	let email = $(this).val();
	
	if(!isEmail(email)){
		$("#emailValidation").text("이메일을 정확하게 입력해주세요.")
	} else{
		$("#emailValidation").text("")
		// 중복 테스트
	}
})

$("#phone").on("blur", function(){
	let phone = $(this).val();
	
	if(!isPhone(phone)){
		$("#phoneValidation").text("휴대폰 번호를 다시 확인해주세요.")
	} else{
		$("#phoneValidation").text("")
		// 중복 테스트
	}
})

$("#birth").on("blur", function(){
	let birth = $(this).val();
	
	if(!isBirth(birth)){
		$("#birthValidation").text("생년월일을 다시 확인해주세요.");
	} else {
		$("#birthValidation").text("");
	}
})

$("#pwdCheck").on("keyup", function(){
	if($("#pwd").val() != $("#pwdCheck").val()){
		$("#pwdCheckValidation").text("비밀번호를 확인해주세요");
	} else{
		$("#pwdCheckValidation").text("");
	}
})

// 정규식으로 유효성 검사
function isUid(uId){
	let uidRegExp = /^[a-z0-9]{6,12}$/;		// a~z,0~9를 포함한 6~12자리

	return uidRegExp.test(uId);
}

function isPwd(pwd){
	let pwdRegExp = /^[A-Za-z0-9]{8,16}$/; 	// 대소문자 영어,숫자 8~16자리

	return pwdRegExp.test(pwd);
}

function isName(name){
	let nameRegExp = /^[가-힣]{2,6}$/;	// 이름 2 ~ 6 자리
	
	return nameRegExp.test(name);
}

function isEmail(email){
	let emailRegExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	
	return emailRegExp.test(email)
}

function isPhone(phone){
	let phoneRegExp = /^01([0|1|6|7|8|9]?)?([0-9]{3,4})?([0-9]{4})$/; 
	
	return phoneRegExp.test(phone)
}

// 생년월일검사
function isBirth(birth) {

	var year = Number(birth.substr(0,4)); // 입력한 값의 0~4자리까지 (연)
	var month = Number(birth.substr(4,2)); // 입력한 값의 4번째 자리부터 2자리 숫자 (월)
	var day = Number(birth.substr(6,2)); // 입력한 값 6번째 자리부터 2자리 숫자 (일)
	var today = new Date(); // 날짜 변수 선언
	var yearNow = today.getFullYear(); // 올해 연도 가져옴

	if (birth.length <=8) {
		if (1900 > year || year > yearNow){ // 연도의 경우 1900 보다 작거나 yearNow 보다 크다면 false를 반환합니다.
			return false;
		} else if (month < 1 || month > 12) {
			return false;
		} else if (day < 1 || day > 31) {
			return false;
		} else if ((month==4 || month==6 || month==9 || month==11) && day==31) {
			return false;
		} else if (month == 2) {
			var isleap = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)); //윤년
			if (day>29 || (day==29 && !isleap)) {
				return false;
			} else {
				return true;
			} //end of if (day>29 || (day==29 && !isleap))
		} else {
			return true;
		}
	}
	else {
		return false; // 입력된 생년월일이 8자 초과
	}
}

/* 아이디 찾기 버튼에 따라 보여주기*/
$("#btnPhoneCertify").on("click", function(){
	$(".findUidPhone").css("display", "block");
	$(".findUidEmail").css("display", "none");
	$(this).css("border-bottom", "2px solid #000");
	$("#btnEmailCertify").css("border-bottom", "none");
	$("#name").val("")
	$("#email").val("")
})
$("#btnEmailCertify").on("click", function(){
	$(".findUidPhone").css("display", "none");
	$(".findUidEmail").css("display", "block");
	$(this).css("border-bottom", "2px solid #000");
	$("#btnPhoneCertify").css("border-bottom", "none");
	$("#name").val("")
	$("#phone").val("")
})
