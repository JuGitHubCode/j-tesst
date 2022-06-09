/**
 * 
 */

(
	noti=function(){
		noti.nowPage=1;
		
		noti.socket=new WebSocket("ws://localhost:5555/web_project2/noti");
		noti.socket.onopen=function(){
			console.log("onopen	");
			
		};
		noti.socket.onclose=function(){
			console.log("onclose ");
			
			
		};
		noti.socket.onmessage=function(resp){
			console.log("onmessage ");
			console.log("resp ",resp.data);
			let jsonStr=resp.data;
			let jsonObj = JSON.parse(jsonStr);
			
			
			switch(jsonObj.command){
				case "init" :
					noti.init(jsonObj);
				break;
				case "insert" :
					noti.insert(jsonObj);
				break;
				case "update" :
					noti.update(jsonObj);
				break;
				case "delete" :
					noti.delete(jsonObj);
				break;
				case "select" :
					noti.select(jsonObj);
				break;

			}
			/*console.log("command : ", jsonObj.command);
			console.log("totPage : ", jsonObj.totPage);
			console.log("list length : ", jsonObj.list.length);
			console.log("subject : ", jsonObj.list[0].subject);
			console.log("nal : ", jsonObj.list[0].nal);
			console.log("doc : ", jsonObj.list[0].doc);
			
			console.log("sno : ", jsonObj.list[0].sno);*/
		};	
	}	

)()


noti.init=function(jsonObj){
	if(noti.nowPage==1){
		$(".btnPrev").attr("disabled",true);	
	}else{
		$(".btnPrev").attr("disabled",false);	
	}
	if(noti.nowPage==jsonObj.totPage){
		$(".btnNext").attr("disabled",true);
	}else{
		$(".btnNext").attr("disabled",false);
	}
	
	console.log("init js test");
	let items=$("#items");
	
	console.log("items : ", items);
	for(let vo of jsonObj.list){
		console.log("vo : ", vo);
		/*let temp=$(".temp");*/
		let temp=document.querySelector(".temp");
		console.log("temp : ", temp);
		/*temp 객체안의 content를 true=>자식태그들과 함께(false는 자식태그 제외) 복사*/
		let clone=document.importNode(temp.content, true);
		//temp의 하위태그까지 복사된 clone의 form태그의 정보를 frm변수에 입력
		let frm=clone.querySelector(".frm_list");
		let UpDel=clone.querySelector(".btnUpDel");
		
		if(sessionID==vo.id){
			$(UpDel).css("display", "block");
		}else{
			$(UpDel).css("display", "none");
		}
		
		
		frm.nal.value=vo.nal;
		frm.id.value=vo.id;
		frm.subject.value=vo.value;
		frm.doc.value=vo.doc;
		frm.sno.value=vo.sno;
		$(items).append(clone);
	}
}

noti.sendinsert=function(frm){
	//form 태그 frm의 정보를 JSONObj로 변경
	let vo={};
	vo.nal=frm.nal.value;
	vo.id=frm.id.value;
	vo.subject=frm.subject.value;
	vo.doc=frm.doc.value;
	
	
	let jsonObj={};
	jsonObj.command="insert";
	jsonObj.message="새 공지사항";
	jsonObj.vo=vo;
	
	console.log("jsonObj : ", jsonObj);
	
	
	//JSONObj-> JsonStr로 변경
	let jsonStr=JSON.stringify(jsonObj);
	
	console.log("jsonStr : ", jsonStr);
	
	//jsonStr을 전송
	noti.socket.send(jsonStr);
}

noti.insert=function(jsonObj){
	let vo=jsonObj.vo;
	let items=$("#items");
	
	
	let temp=document.querySelector(".temp");
	let clone=document.importNode(temp.content, true);
	
	let frm=clone.querySelector(".frm_list");
	
	frm.nal.value=vo.nal;
	frm.id.value=vo.id;
	frm.subject.value=vo.subject;
	frm.doc.value=vo.doc;
	frm.sno.value=vo.sno;
	
	$(items).prepend(clone);
	$('.msg').html(jsonObj.message);
	$(".msg").css("animation", "blink-info 2s step-end infinite");
}



noti.sendUpdate=function(frm){
	let yn=confirm("수정하시겠습니까?");
	if(!yn)return;
	let jsonObj={};
	let vo={};
	
	vo.nal=frm.nal.value;
	vo.id=frm.id.value;
	vo.subject=frm.subject.value;
	vo.doc=frm.doc.value;
	vo.sno=frm.sno.value;
	
	jsonObj.command="update";
	jsonObj.message="수정 완료";
	jsonObj.vo=vo;
	
	let jsonStr=JSON.stringify(jsonObj);
	
	noti.socket.send(jsonStr);
}

noti.update=function(jsonObj){
	console.log(jsonObj.vo);
	
	console.log("up test1");
	let frms=$(".frm_list").toArray();
	let vo=jsonObj.vo;
	
	if(jsonObj.result=="result"){
		alert(jsonObj.message);
		
	}else{
		for(frm of frms){
			console.log("up test2", frm);
			if(frm.sno.value==vo.sno){
				console.log("up test3");
				frm.nal.value=vo.nal;
				frm.id.value=vo.id;
				frm.subject.value=vo.subject;
				frm.doc.value=vo.doc;
				$(frm).css("border","2px solid #f00")
				$('.msg').html(jsonObj.message);
				$(".msg").css("animation", "blink-info 2s step-end infinite");
				
				
				setTimeout(function(){
					console.log("up test4");
					$(".msg").css("animation","")
				},5000);
			}
		}
	}
	
	
}

noti.sendDelete=function(frm){
	console.log("SendDelete");
	let jsonObj={};
	let vo={};
	
	vo.sno=frm.sno.value;
	jsonObj.command="delete";
	jsonObj.message="삭제 완료";
	
	jsonObj.vo=vo;
	
	let jsonStr=JSON.stringify(jsonObj);
	noti.socket.send(jsonStr);
}

noti.delete=function(jsonObj){
	console.log("delete",jsonObj);
	let frms=$(".frm_list");
	
	let vo=jsonObj.vo;
	
	if(jsonObj.result=="reject"){
		
	console.log("reject : reject: ",jsonObje.result);
	}else{
		for(frm of frms){
			if(frm.sno.value==vo.sno){
				$("#items").find(frm).remove();
				break;
			}
		}
	}
}

noti.find=function(frm){
	noti.nowPage=1;
	let jsonStr;
	let jsonObj={};
	jsonObj.command="select";
	jsonObj.message="검색";
	jsonObj.findStr=frm.findStr.value;
	jsonObj.nowPage=noti.nowPage;
	
	jsonStr=JSON.stringify(jsonObj);
	noti.socket.send(jsonStr);
}

noti.select=function(jsonObj){
	if(noti.nowPage==1){
		$(".btnPrev").attr("disabled",true);	
	}else{
		$(".btnPrev").attr("disabled",false);	
	}
	if(noti.nowPage==jsonObj.totPage){
		$(".btnNext").attr("disabled",true);
	}else{
		$(".btnNext").attr("disabled",false);
	}
	
	
	
	let items=$("#items");
	$(items).empty();
	
	let temp=document.querySelector(".temp");
	
	for(vo of jsonObj.list){
		let clone=document.importNode(temp.content, true);
		let frm=clone.querySelector(".frm_list")
		let UpDel=clone.querySelector(".btnUpDel");
		
		if(sessionID==vo.id){
			$(UpDel).css("display", "block");
		}else{
			$(UpDel).css("display", "none");
		}
		
		frm.nal.value=vo.nal;
		frm.id.value=vo.id;
		frm.subject.value=vo.subject;
		frm.doc.value=vo.doc;
		frm.sno.value=vo.sno;
		
		$(items).append(clone);
	}



	
}
noti.movePage=function(page){
	noti.nowPage +=page;
	if(noti.nowPage<1)noti.nowPage=1;
	let jsonObj={};
	jsonObj.command="select";
	jsonObj.nowPage=noti.nowPage;
	jsonObj.findStr=$("#findStr").val();
		
	let jsonStr;
	jsonStr=JSON.stringify(jsonObj);
	noti.socket.send(jsonStr);
}


noti.ShowInputForm=function(){
	if(sessionID==null||sessionID==""){
		alert("로그인 필요");
	}else{
		console.log(sessionID);
		$(".frm_input").toggle(400);
	}
}	
	
	