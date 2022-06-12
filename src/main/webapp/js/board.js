/**
 * 게시판 관련 스크립트
 * date:2022.06
 */

let board={};
board.init=function(){
		fonts=["맑은고딕", "돋음", "궁서", "굴림", "굴림체", "궁서체",
		 "바탕", "바탕체", "HY엽서체M", "휴먼옛체"];
		fonts.sort();
		console.log("test", fonts);
		console.log($("#summernote").summernote());
		$("#summernote").summernote({
		});
	}


board.input=function(frm){
	console.log("input : ", frm );
	frm.action="board.do?job=input";
	frm.submit();
}

board.find=function(frm){
	frm.nowPage.value=1;
	board.select(frm);
}

board.select=function(frm){
	console.log("select : ", frm );
	frm.action="board.do?job=select";
	frm.submit();
	
}


board.view=function(sno){
	/*$.post("board.do?job=view");*/
	let frm=$(".frm_board_list")[0];
	frm.sno.value=sno;
	frm.action='board.do?job=view';
	frm.submit();
}

board.movePage=function(page){
	let frm=$(".frm_board_list")[0];
	frm.nowPage.value=page;
	frm.action='board.do?job=select';
	frm.submit();
}

board.inputR=function(frm){
	frm.action='board.do?job=inputR';
	frm.submit();
}

board.deleteR=function(frm){
	frm.action='board.do?job=deleteR';
	frm.submit();
}

board.replR=function(frm){
	frm.action='board.do?job=replR';
	frm.submit();
}

board.modify=function(frm){
	frm.action='board.do?job=modify';
	frm.submit();
}

board.repl=function(frm){
	frm.action='board.do?job=modify';
	frm.submit();
}

board.modifyR=function(frm){
	let yn=confirm("삭제 확인");
	if(!yn)return;
	frm.action='board.do?job=modifyR';
	frm.submit();
}
