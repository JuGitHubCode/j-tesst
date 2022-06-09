/**
 * 
 */

(//이미디에이트
	parts=function(){//이미디에이트 안에 선언한 함수는 오브젝트로 생성됨(parts라는 오브젝트가 생성됨)
		$(".left").load("parts/parts_input.jsp");
		$(".right").load("parts.do");
		let oldPos=1;
	}
)()

//list
parts.select=function(){
	let frm=$(".frm_parts_list")[0];
	frm.nowPage.value=1;
	var param=$(".frm_parts_list").serializeArray();
	console.log(param);
	$(".right").load("parts.do?job=select",param); 
}


parts.movePage=function(page){
	let frm=$(".frm_parts_list")[0];
	frm.nowPage.value=page;
	
	var param=$(".frm_parts_list").serializeArray();
	$(".right").load("parts.do?job=select",param); 
}



parts.view=function(pos, code){
	let frm=$(".frm_parts_list")[0];
	let prarm;
	let array=$(".item").toArray();
	//현재 선택된 행
	$(array[pos]).css("background-color","#faa");
	//이전 선택된 행
	
	if(parts.oldPos!=-1){
		$(array[parts.oldPos]).css("background-color","");
	}
	parts.oldPos=pos;
	frm.code.value=code;
	param=$(frm).serializeArray();
	$(".left").load("parts.do?job=view", param, function(){//함수는 앞의 로드가 다끝나고 후에 뭐할건지....(수정,삭제 등등 후에) //param은 post type으로 넘겨줌
		$(".btnInsert").attr("disabled",true);
		$(".btnUpdate").attr("disabled",false);
		$(".btnDelete").attr("disabled",false);
		$("#frm_parts_input input[name=code]").attr('readonly',true);
	});
}


parst.cancel=function(){
	$(".btnInsert").attr("disabled",false);
	$(".btnUpdate").attr("disabled",true);
	$(".btnDelete").attr("disabled",true);
}




/*
parts.view=function(pos, code){
	let frm=$(".frm_parts_list")[0];
	let prarm;
	let array=$(".item").toArray();
	//현재 선택된 행
	$(array[code]).css("background-color","#faa");
	console.log(array["code"]);
	
	//이전 선택된 행
	
	if(parts.oldCode!=""){
		$(array[parts.oldPos]).css("background-color","");
	}
	parts.oldCode=code;
	frm.code.value=code;
	param=$(frm).serializeArray();
	$(".left").load("parts.do?job=view", param, function(){//함수는 앞의 로드가 다끝나고 후에 뭐할건지....(수정,삭제 등등 후에) //param은 post type으로 넘겨줌
		$(".btnInsert").attr("disabled",true);
		$(".btnUpdate").attr("disabled",false);
		$(".btnDelete").attr("disabled",false);
		$(".btnCancel").attr("disabled",false);
	});
}
*/

parts.update=function(){
	let yn=confirm("수정하시겠습닏까?");
	if(!yn)return ;
	console.log("test_update");
	let param = $("#frm_parts_input").serialize();
	//right에서 갱신 후, left의 그리드에 갱신된 데이터가 반영될수 있도록 load가 아닌 post 사용
	$(".left").load("parts.do?job=update", param,function(){//콜배함수
		param=$(".frm_parts_list").serialize();
		$(".right").load("parts.do?job=select", param, function(){//수정뒤 수정한 레코드의 하이라이트가 남아있게 해주는 콜백함수
			let array=$(".item").toArray();
			$(array[parts.oldPos]).css("background-color","#faa");
		});
	})
}


parts.delete=function(){
	let yn=confirm("삭제 확인");
	if(!yn)return;
	
	console.log("test_delete");
	
	let param=$("#frm_parts_input").serializeArray();
	$(".left").load("parts.do?job=delete", param,function(){
		param=$(".frm_parts_list").serializeArray();
		$(".right").load("parts.do?job=select",param);
	})
}


parts.insert=function(){
	let param=$("#frm_parts_input").serialize();
	$(".left").load("parts.do?job=insert", param,function(){
		param=$(".frm_parts_list").serializeArray();
		$(".right").load("parts.do?job=select",param);
	})
}










function press(){
	if(event.keyCode==13){
		console.log("test");
		document.getElementById("btnFind").click();
	}
}



























