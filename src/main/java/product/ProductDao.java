package product;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;



import org.apache.ibatis.session.SqlSession;

import bean.Page;
import mybatis.MybaFactory;
import parts.PartsVo;

public class ProductDao implements ProductInterface{
	SqlSession session;
	Page page;
	
	public ProductDao() {
		System.out.println("dao");
		session=MybaFactory.getFactory().openSession();
	}
	
	
	@Override
	public String insert(ProductVo vo) {
		String msg="";
		
		try {
			int cnt=session.insert("product.insert",vo);
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
			System.out.println("msg ee: "+msg);
		}
		return msg;
	}

	@Override
	public List<ProductVo> select(Page page) {
		List<ProductVo> list= null;
		try {
			int totSize=session.selectOne("product.tot_size",page);
			page.setTotSize(totSize);
			page.compute();
			page.setStartNo(page.getStartNo()-1);
			
			
			list=session.selectList("product.select", page);
			this.page=page;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public ProductVo selectOne(int sno) {
		ProductVo vo=null;
		try {
			vo=session.selectOne("product.view",sno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return vo;
	}

	@Override
	public String update(ProductVo vo) {
		String msg="";
		try {
			int cnt=session.update("product.update",vo);
			if(cnt>0) {
				msg="수정 완료";
				session.commit();
			}else {
				msg="수정 오류";
				session.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
			msg=e.getMessage();
		}
		return msg;
	}

	@Override
	public String delete(int sno) {
		String msg="";
		
		try {
			int cnt=session.delete("product.delete",sno);
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

	@Override
	public List<PartsVo> findCode(String code) {
		System.out.println("code : "+code);
		System.out.println("findCode : ");
		List<PartsVo> list= null;
		try {
			list=session.selectList("product.find_code",code);
			System.out.println("list f : "+list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public Page getPage() {
		return page;
	}
	
	
}
