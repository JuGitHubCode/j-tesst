package socket;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint("/test")//호출 조건(test라는 요청이 들어오면 소캣 구동)
public class TestWebSocket {
	
	//클라이언트가 접속했을때 자동 호출 됨
	@OnOpen//재정의
	public void onOpen(Session s) {//jakarta.websoket의 클래스 
		System.out.println("client longin");
		System.out.println("client IP Address : "+s.getRequestURI().getHost());
		
	}
	
	//누가 메시지 수신
	@OnMessage
	public void onMessage(String data, Session s) {//data는 전달받은 값, session s는 유저 또는 유저가 접속한 브라우져(IP)
		System.out.println("======================================== ");
		System.out.println("receive data : "+ data);
		
		//수신된 jsonStr(data)을 JSONObject로 변환;
		JSONParser parser=new JSONParser();
		try {
			JSONObject jsonObj=(JSONObject)parser.parse(data);
			System.out.println("======================================== ");
			System.out.println("jsonObj data : "+ jsonObj.get("msg"));
			System.out.println("commande data : "+ jsonObj.get("command"));
			System.out.println("nowPage data : "+ jsonObj.get("nowPage"));
			System.out.println("findStr data : "+ jsonObj.get("findStr"));
			
			
			
			//send message(response) to client
			JSONObject sendObj= new JSONObject();
			System.out.println("======================================== ");
			sendObj.put("commande", "receive");
			sendObj.put("id", "web socket server");
			sendObj.put("findStr","Hong gill dong");
			sendObj.put("nowPage", 50);
			sendObj.put("msg",jsonObj.get("msg"));
			
			String sendStr=JSONObject.toJSONString(sendObj);//json값을 스트링으로 변환 
			s.getBasicRemote().sendText(sendStr);//클라이언트에게 전달
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	
	//브라우저의 url이 현재를 벗어났을 때
	@OnClose
	public void onClose(Session s){
		System.out.println("client change the url(session end)");
	}

	//noti/socket_test.jsp에서 구동
}