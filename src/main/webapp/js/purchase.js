/**
 * 
 */

(
	purchase=function(){
		$("#left").load("./purchase/purchase_input.jsp");
		$("#right").load("./purchase/purchase_list.jsp");
	}
)()



//input
//코드 검색
purchase.findCode=function(){
	console.log("window")
	
	let frm=$("#frm_purchase_input")[0];
	let code=frm.code.value;
	
	var url="./purchase/purchase_search.jsp?code="+code;
	
	window.open(url,"win", "widht:300px","height:1600px");
}