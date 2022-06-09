package parts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import bean.Page;
import mybatis.MybaFactory;

public class PartsDao implements PartsInterface {
	
	Page page;
	SqlSession session;
	
	public PartsDao() {
		session=MybaFactory.getFactory().openSession();
	}
	
	
	
	@Override
	public String insert(PartsVo vo) {
		String msg="in";
		
		try {
			int cnt=session.insert("parts.insert",vo);
			System.out.println("0000000000000000000000000000");
			System.out.println("cnt"+cnt);
			if(cnt>0) {
				msg="저장 완료";
				session.commit();
			}else {
				msg="저장 오류";
				session.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
			msg=e.getMessage();
		}
		
		
		
		return msg;
	}

	@Override
	public List<PartsVo> select(Page page) {
		List<PartsVo> list=null;
		
		try {
			int totSize=session.selectOne("parts.tot_size",page);
			
			page.setTotSize(totSize);
			page.compute();
			page.setStartNo(page.getStartNo()-1);

			list=session.selectList("parts.select",page);
			this.page=page;
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		return list;
	}

	@Override
	public PartsVo selectOne(String code) {
		
		PartsVo vo=null;
		try {
			vo=session.selectOne("parts.view",code);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return vo;
	}

	@Override
	public String update(PartsVo vo) {
		String msg="up";
		System.out.println("=======update==========update=============");
		System.out.println("updatemsg :"+msg);
		try {
			int cnt=session.update("parts.update",vo);
			System.out.println("cnt"+cnt);
			if(cnt>0) {
				msg="수정 완료";
				System.out.println("ifmsg :"+msg);
				session.commit();
			}else {
				msg="수정 오류";
				System.out.println("elsemsg :"+msg);
				session.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
			msg=e.getMessage();
			System.out.println("catchmsg :"+msg);
		}
		
		
		
		return msg;
	}

	@Override
	public String delete(String code) {
		String msg="de";
		
		try {
			int cnt=session.delete("parts.delete",code);

			System.out.println("cnt"+cnt);
			if(cnt>0) {
				msg="삭제 완료";
				session.commit();
			}else {
				msg="삭제 오류";
				session.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
			msg=e.getMessage();
		}
		
		
		
		return msg;
	}



	public Page getPage() {
		return page;
	}
	
	
	public static void main(String[] args) {
		PartsDao dao=new PartsDao();
		Page page=new Page();
		page.setFindStr("");
		page.setNowPage(1);
		
		dao.select(page);
		
		
	}
	
	
	
	

















	

	

}
