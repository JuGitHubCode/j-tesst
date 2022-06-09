package socket;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import bean.Page;
import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;
import noti.NotiDao;


@ServerEndpoint("/noti")
public class WebSocketServer implements WebSocketInterface{
	NotiDao dao;	
	
	public WebSocketServer() {
		dao=new NotiDao();
	}
	
	
	//접속된 클라이언트(Session)을 서버의 공유자원에 등록하여 사용
	private static Set<Session> clients=Collections.synchronizedSet(new HashSet<Session>());
			
	@Override
	@OnOpen
	public void onOpen(Session s) {
		System.out.println("onOpen 작동 : "+s);
		
		//접속자가 다수일 경우 접속자 전부에게 공지사항을 보여주기 위하여 clients변수에 접속자를 저장
		//신규 접속자
		if(clients.contains(s))return;//clients에 신규접속자s가 있으면 돌아가고, 없으면 아래 로직 진행
		//신규 접속자 clients에 추가
		clients.add(s);
		//기존 등록된 공지사항 목록을 신규 접속자에게 전달
		Page page=new Page();
		page.setNowPage(1);
		page.setFindStr("");
		List list=dao.select(page);	
		page=dao.getPage();
		
		JSONObject jsonObj=new JSONObject();
		jsonObj.put("command", "init");//맨처음 접속했기때문에 그 표시를 해줌("init")
		jsonObj.put("page", page.getTotPage());
		jsonObj.put("list", list);
		
		String jsonStr=JSONObject.toJSONString(jsonObj);
		System.out.println("init 작동 : ");
		System.out.println("jsonStr 작동 : "+jsonStr);
		
		try {
			s.getBasicRemote().sendText(jsonStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	@OnMessage
	public void onMessage(String jsonString, Session s) {
		JSONParser jParser=new JSONParser();
		
		try {
			JSONObject obj=(JSONObject)jParser.parse(jsonString);
			String command=(String)obj.get("command");
			
			switch(command){
			case "insert":
				insert(obj);
				break;
			case "update":
				update(obj, s);
				break;
			case "delete":
				delete(obj, s);
				break;
			case "select":
				select(obj, s);
				break;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	@OnClose
	public void onClose(Session s) {
		System.out.println("onClose 작동 : "+s);
		
		//접속자가 접속을 끊을 경우 clients에 저장되어 있던 접속자 정보를 삭제해줘야함
		clients.remove(s);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(JSONObject map) {
		System.out.println("insert : "+map);
		
		JSONObject vo=(JSONObject) map.get("vo");
		Map last=null;
		JSONObject jsonObj=new JSONObject();

		System.out.println("vo : "+vo);
		
		if(dao.insert(vo)) {
			last=dao.SelectLastOne();
			System.out.println("last : "+last);
			
			jsonObj.put("command", "insert");
			jsonObj.put("message", map.get("message"));
			jsonObj.put("vo", last);
			
			String jsonStr=JSONObject.toJSONString(jsonObj);
			
			for(Session s : clients) {
				try {
					s.getBasicRemote().sendText(jsonStr);
				} catch (Exception e) {
					e.printStackTrace();
				} 
				
		
			}
			
		}else {
			System.out.println("저장 오류");
		}
		
		
	}

	@Override
	public void select(JSONObject map, Session target) {
		System.out.println("select : "+map);
		String jsonStr="";
		
		try {
			Page page=new Page();
			Long templong=(Long)map.get("nowPage");//map의 정수형은 무조곤 long 타입
			
			int nowPage=templong.intValue();//정수형으로 long 타입의 templong을 가져와 nowPage에 담음
			System.out.println("select nowPage : "+nowPage);
			String findStr=(String)map.get("findStr");
			System.out.println("select findStr : "+findStr);
			
			page.setNowPage(nowPage);
			page.setFindStr(findStr);
			System.out.println("select page : "+page.getFindStr());
			List<Map> list=dao.select(page);
			System.out.println("select test : ");
			page=dao.getPage();
			System.out.println("select list : "+list);
			System.out.println("select test 왜 자꾸 close 되는걸까");
			map.put("totPage",page.getTotPage());
			map.put("list", list);
			/* map.put("command", "select"); */
			jsonStr=JSONObject.toJSONString(map);
			target.getBasicRemote().sendText(jsonStr);

			System.out.println("target");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(JSONObject map, Session target) {
		System.out.println("update : "+map);
		String jsonStr="";
		JSONObject obj=new JSONObject();
		
		JSONObject vo=(JSONObject)map.get("vo");
		
		try {
			if(dao.update(vo)) {//boolean type의 반환형
				jsonStr=JSONObject.toJSONString(map);	

				System.out.println("update jsonStr : "+jsonStr);
				for(Session s : clients) {
					s.getBasicRemote().sendText(jsonStr);
				}
				
				
			}else {
				map.put("message", "수정 중 오류 발생");
				map.put("result", "reject");
				jsonStr=JSONObject.toJSONString(map);	
				target.getBasicRemote().sendText(jsonStr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public void delete(JSONObject map, Session target) {
		System.out.println("delete : "+map);
		String jsonStr="";
		JSONObject obj=new JSONObject();
		JSONObject vo=(JSONObject)map.get("vo");
		System.out.println("vo : "+vo);
		
		try {
			if(dao.delete(vo)) {
				jsonStr=JSONObject.toJSONString(map);
				for(Session s:clients){
					s.getBasicRemote().sendText(jsonStr);
				}
			}else {

				System.out.println("dao.delete(vo) : "+dao.delete(vo));
				map.put("message","삭제중 오류 발생");
				map.put("result", "reject");
				jsonStr=JSONObject.toJSONString(map);
				target.getBasicRemote().sendText(jsonStr);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
