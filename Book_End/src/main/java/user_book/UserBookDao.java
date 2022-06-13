package user_book;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import bean.Page;
import jakarta.websocket.Session;
import mybatis.MybaFactory;


public class UserBookDao implements UserBookInterface {
	SqlSession session;
	Page page;
	
	
	
	public UserBookDao() {
		session = MybaFactory.getFactory().openSession();
	}
	
	
	
	@Override
	public List<UserBookVo> select(Page p) {
		List<UserBookVo> list = null;
		
		try {
			int totSize = session.selectOne("user_book.tot_size", p);
			p.setTotSize(totSize);
			p.compute();
			
			p.setStartNo(p.getStartNo()-1);
			this.page = p;
			
			list = session.selectList("user_book.select", page);
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return list;
	}
	







	public Page getPage() {
		return page;
	}
}
