/**
 * 성적 관리
 */




function getId(id){
	return document.getElementById(id);
}




//List
if(getId("btnFind")!=null){
	getId("btnFind").onclick=function(){
		let frm=document.frm_score;
		frm.nowPage.value="1";
		frm.action="score.do?job=list";
		frm.submit();
	}
}
;
//성적 입력
if(getId("btnCreate")!=null){
	getId("btnCreate").onclick=function(){
		let frm=document.frm_score;
		frm.action="score.do?job=input";
		frm.submit();
	}
}
;

//상세보기
function view(sno){
	let frm=document.frm_score;
	frm.sno.value=sno;
	frm.action="score.do?job=view";
	frm.submit();
}
;





//상세조회===============================================================
//수정
if(getId("btnModify")!=null){
	getId("btnModify").onclick=function(){
		console.log("test");
		let frm=document.frm_score;
		frm.action="score.do?job=modify";
		frm.submit();
	}
}
;
//삭제
if(getId("btnDelete")!=null){
	getId("btnDelete").onclick=function(){
		console.log("test2");
		let frm=document.frm_score;
		frm.action="score.do?job=deleteR";
		frm.submit();
	}
}
;


function movePage(page){
	let frm=document.frm_score;
	frm.nowPage.value=page;
	frm.action="score.do?job=list";
	frm.submit();
}

//수정 화면=========================================================
if(getId("btnModifyR")!=null){
	getId("btnModifyR").onclick=function(){
		let frm=document.frm_score;
		frm.action="score.do?job=modifyR";
		frm.submit();
	}
}
;


//======================================================================
//성적 입력
/*score_input*/
/*검색 버튼*/

//저장버튼
if(getId("btnInputR")!=null){
	getId("btnInputR").onclick=function(){
		let frm=document.frm_score;
		frm.action="score.do?job=inputR";
		frm.submit();
	}
}

//취소버튼
if(getId("btnList")!=null){
	getId("btnList").onclick=function(){
		let frm=document.frm_score;
		frm.action="score.do?job=list";
		frm.submit();
	}
}


if(getId("btnFindName")!=null){
	getId("btnFindName").onclick=function(){
		console.log("test");
		var url="score.do?job=findName";
		window.open(url,"","width=350px, height=600px");
	}
}


