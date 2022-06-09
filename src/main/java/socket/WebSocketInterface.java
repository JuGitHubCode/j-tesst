package socket;

import org.json.simple.JSONObject;

import jakarta.websocket.Session;

public interface WebSocketInterface {
	public void onOpen(Session s);
	public void onMessage(String jsonString, Session s);
	public void onClose(Session s);
	
	/*message 내용중 command가 insert 일때*/
	public void insert(JSONObject map);
	//target은 데이터를 전송한 클라이언트
	public void select(JSONObject map,Session target);
	public void update(JSONObject map,Session target);
	public void delete(JSONObject map,Session target);
	

}
