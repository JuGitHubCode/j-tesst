package socket;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint("/test2")
public class TestWebSocket2 {
	
	@OnOpen
	public void onOpen(Session s) {
		System.out.println("Session : "+s);
	}
	
	@OnMessage
	public void onMessage(String jsonStr, Session s) {
		System.out.println("data : " +jsonStr);
		JSONParser parser =new JSONParser();
		
		try {
			JSONObject jsonObj=(JSONObject)parser.parse(jsonStr);
			System.out.println("receive Data....");
			System.out.println("id : "+jsonObj.get("id"));
			System.out.println("irum : "+jsonObj.get("irum"));
			System.out.println("phone : "+jsonObj.get("phone"));
			
			String sendStr=JSONObject.toJSONString(jsonObj);
			s.getBasicRemote().sendText(sendStr); 
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	@OnClose
	public void onClose(Session s) {
		System.out.println("onClose : "+s);
	}
	

}
