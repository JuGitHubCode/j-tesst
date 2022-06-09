package noti;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONObject;

import bean.Page;
import mybatis.MybaFactory;

public class NotiDao implements NotiInterface{
	SqlSession session;
	Page page;
	
	public NotiDao() {
		session=MybaFactory.getFactory().openSession();
	}
	
	
	@Override
	public boolean insert(JSONObject map) {
		System.out.println("insert : "+map);
		boolean b=false;
		
		try {
			int cnt=session.insert("noti.insert",map);
			if(cnt>0) {
				session.commit();
				b=true;
				System.out.println("insert suc : "+b);
			}else {
				session.rollback();

				System.out.println("insert : "+"rollback");
			}
		} catch (Exception e) {
			System.out.println("insert : "+"오류");
			e.getMessage();
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public List<Map> select(Page page) {
		System.out.println("selectdao : "+page);

		System.out.println("page.getFindStr() dao : "+page.getFindStr());
		System.out.println("page.getNowPage() dao : "+page.getNowPage());
		int totSize=0;
		List<Map> list=null;
		try {
			totSize=session.selectOne("noti.totSize", page);
			System.out.println("totSizedao  : "+totSize);
			page.setTotSize(totSize);
			page.compute();
			page.setStartNo(page.getStartNo()-1);
			System.out.println("page.getTotPage() compute dao : "+page.getFindStr());
			this.page=page;
			System.out.println("this.page.getFindStr() dao : "+page.getFindStr());
			System.out.println("this.page.getNowPage() dao : "+page.getNowPage());
			System.out.println("this.page.startNo() dao : "+page.getStartNo());
			System.out.println("this.page.listSize() dao : "+page.getListSize());
			
			
			list=session.selectList("noti.select", page);

			System.out.println("listdao  : "+list);
			
		} catch (Exception e) {
			System.out.println("select : "+"오류");
			System.out.println("totSize : "+totSize);
			System.out.println("list : "+list);
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Map SelectLastOne() {
		System.out.println("SelectLastOne : ");
		Map map=null;
		
		try {
			map=session.selectOne("noti.selectLastOne");
			System.out.println("map : "+map);
			
		} catch (Exception e) {
			System.out.println("SelectLastOne : "+"오류");
			e.printStackTrace();
			
		}
		
		
		return map;
	}

	@Override
	public boolean update(JSONObject map) {
		boolean b=false;
		System.out.println("update : "+map);
		
		try {
			int cnt=session.insert("noti.update",map);
			if(cnt>0) {
				session.commit();
				b=true;
				System.out.println("update suc : "+b);
			}else {
				session.rollback();
				System.out.println("update rollback : ");
			}
		} catch (Exception e) {
			System.out.println("update : "+"오류");
			e.getMessage();
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public boolean delete(JSONObject map) {
		boolean b=false;
		System.out.println("deleteDAO : "+map);
		
		try {
			int cnt=session.insert("noti.delete",map);
			System.out.println("deleteDAO cnt : "+b);
			if(cnt>0) {
				session.commit();
				b=true;
				System.out.println("deleteDAO suc : "+b);
			}else {
				session.rollback();
				System.out.println("deleteDAO : "+"rollback");
			}
		} catch (Exception e) {
			System.out.println("delete : "+"오류");
			e.getMessage();
			e.printStackTrace();
		}
		return b;
	}
	
	public Page getPage() {
		return page;
	}

}
