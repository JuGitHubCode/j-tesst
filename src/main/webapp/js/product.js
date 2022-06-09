/**
 * 
 */


(
	product=function(){
		$("#left").load("./product/product_input.jsp",function(){
			let frm=$("#frm_product_input")[0];
			frm.nal.valueAsDate=new Date();
		});
		$("#right").load("product.do");
		let oldpos=-1//사용자 선택 행 위치
	}
)()

//input
//코드 검색
//lecure
product.findCode=function(){
	console.log("window");
	
	let frm=$("#frm_product_input")[0];
	let code=frm.code.value;

	var url="./product/product_search2.jsp?code="+code;
	window.open(url,"win","width=300px", "height=600px");
}


//ju's code
product.findCode2=function(){
	console.log("window");
	var url="./product/product_search.jsp";
	window.open(url,"search","width=300px", "height=600px");
}

product.select=function(){
	console.log("select");
	let frm=$("#frm_product_search")[0];
	let code=$("#item").code;
	frm.code_select.value=code;
}




//amt calculate
product.compute=function(frm){
	let ea=Number(frm.ea.value);
	let price=Number(frm.price.value);
	let amt=(ea*price).toLocaleString("ko");
	frm.amt.value=amt;
	
}



//list
//조회
product.findSelect=function(frm){
	frm.nowPage.value=1;
	let param=$(frm).serialize();
	$("#right").load("product.do?job=select",param);
}


product.view=function(sts, sno){
	let frm=$(".frm_product_list")[0];
	let array=$(".item").toArray();
	$(array[sts]).css("background-color","#aaa");
	
	
	if(product.oldPos>=0){
		$(array[product.oldPos]).css("background-color","");	
	}
	product.oldPos=sts;
	
	
	
	frm.sno.value=sno;
	let param=$(frm).serialize();
	$("#left").load("product.do?job=view",param, function(){
		

		$(".btnUpdate").attr("disabled",false);
		$(".btnDelete").attr("disabled",false);
		$(".btnInsert").attr("disabled",true);
	});
}


product.movePage=function(page){
	console.log(page);
	let frm=$(".frm_product_list")[0];
	frm.nowPage.value=page;
	
	let param=$(".frm_product_list").serialize();
	$("#right").load("product.do?job=select", param);
	console.log(param);
	
}


product.insert=function(){
	console.log("insert");
	let param=$("#frm_product_input").serialize();
	$.post("product.do?job=insert",param,function(){
		let frm=$(".frm_product_list")[0];
		product.findSelect(frm);
	})
}






product.update=function(){
	//수정 확인 창
	let yn=confirm("수정하시겠습니까?");
	if(!yn)return;
	
	//입력폼안의 정보를 param으로 생성
	let param=$("#frm_product_input").serialize();
	console.log(param);
	//$.post를 사용 job=update 파라메터와 함께 product.do를 실행
	$.post("product.do?job=update", param,function(){
		let param2=$(".frm_product_list").serialize();
		console.log(param2);
		$("#right").load("product.do?job=select",param2,function(){
			let ary=$(".item").toArray();
			$(ary[product.oldPos]).css("background","#99f")
		})
	});
}



product.delete=function(){
	let yn=confirm("삭제하시겠습니까?");
	if(!yn)return;

	let param=$("#frm_product_input").serialize();
	console.log(param);
	$.post("product.do?job=delete",param,function(){
		let param2=$(".frm_product_list").serialize();
		$("#right").load("product.do?job=select",param2)
	})
}


product.cancle=function(){
	console.log("cancle");
	let frm=$("#frm_product_input")[0];
	
	frm.sno.value="";
	frm.code.value="";
	frm.codeName.value="";
	frm.nal.value="";
	frm.ea.value="";
	frm.price.value="";
	frm.amt.value="";
	
	$(".btnUpdate").attr("disabled",true);
	$(".btnDelete").attr("disabled",true);
	$(".btnInsert").attr("disabled",false);
}

