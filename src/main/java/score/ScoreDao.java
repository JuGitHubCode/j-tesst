package score;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.DBConn;
import bean.Page;
import student.StudentVo;


public class ScoreDao implements ScoreInterface {
	Page page;
	PreparedStatement ps;
	Connection conn;
	ResultSet rs;
	
	ScoreDao(){
		this.conn=new DBConn().getConn();
	}
	
	public void closeDB() {
		try {
			if(ps!=null)ps.close();
			if(conn!=null)conn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String insert(ScoreVo vo) {
		String msg="";
		String sql="insert into score(id,nal,subject,score) value(?,?,?,?)";
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, vo.id);
			ps.setString(2, vo.nal);
			ps.setString(3, vo.subject);
			ps.setInt(4, vo.score);
			
			conn.setAutoCommit(false);
			int n=ps.executeUpdate();
			if(n>0) {
				msg="자료 저장 완료";
				conn.commit();
			}else {
				msg="저장 오류";
				conn.rollback();
			}
		}catch (Exception e) {
			msg=e.getMessage();
		}
		return msg;
	}

	@Override
	public String update(ScoreVo vo) {
		String msg="";
		String sql="update score set id=?,subject=?, nal=?, score=? where sno=?";
		
		try {
			ps=conn.prepareStatement(sql);
			
			ps.setString(1, vo.id);
			ps.setString(2, vo.subject);
			ps.setInt(4, vo.score);
			ps.setString(3, vo.nal);
			ps.setInt(5, vo.sno);
			conn.setAutoCommit(false);
			int n=ps.executeUpdate();
			if(n>0) {
				msg="수정 완료";
				conn.commit();
			}else {
				msg="수정 오류";
				conn.rollback();
			}
		}catch (Exception e) {
			msg=e.getMessage();
		}
		//closeDB();
		return msg;
	}

	@Override
	public String delete(int sno) {
		String msg="";
		String sql="delete from score where sno=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, sno);
			conn.setAutoCommit(false);
			int n=ps.executeUpdate();
			if(n>0) {
				msg="삭제완료";
				conn.commit();
			}else {
				msg="삭제오류";
				conn.rollback();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		//closeDB();
		return msg;
	}

	@Override
	public ScoreVo SelectOne(int sno) {
		String sql="Select * from score sc left join student st "
				+ "on st.id=sc.id "
				+ "where sno=?";
		ScoreVo v=new ScoreVo();
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, sno);
			rs=ps.executeQuery();
			if(rs.next()) {
				v.setSno(rs.getInt("sc.sno"));
				v.setId(rs.getString("sc.id"));
				v.setSubject(rs.getString("sc.subject"));
				v.setScore(rs.getInt("sc.score"));
				v.setNal(rs.getString("sc.nal"));
				
				v.setmName(rs.getString("st.mName"));
				v.setPhone(rs.getString("st.phone"));
				v.setEmail(rs.getString("st.email"));
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return v;
	}

	@Override
	public List<ScoreVo> select(Page page) {
		List<ScoreVo> list =new ArrayList<ScoreVo>();
		this.page=page;
		String sql="";
		int totSize=0;
		try {
			//nowPage
			//검색어 포함 전체건수
			sql="select count(sc.sno) cnt from score sc left join student st "
				+"on sc.id=st.id "
				+"where sc.id like ? or st.mName like ? "
				+"or sc.nal like ? or sc.subject like ? "
				;		
			ps=conn.prepareStatement(sql);
			ps.setString(1, "%"+page.getFindStr()+"%");
			ps.setString(2, "%"+page.getFindStr()+"%");
			ps.setString(3, "%"+page.getFindStr()+"%");
			ps.setString(4, "%"+page.getFindStr()+"%");
			
			
			rs=ps.executeQuery();
			if(rs.next()) {
				totSize=rs.getInt("cnt");
			}
			this.page.setTotSize(totSize);
			this.page.compute();
			
			//데이터 출력
			sql="select * from score sc left join student st "
				+"on sc.id=st.id "
				+"where sc.id like ? or st.mName like ? "
				+"or sc.nal like ? or sc.subject like ? "
				+"limit ?,? ";			
			ps=conn.prepareStatement(sql);
			ps.setString(1, "%"+page.getFindStr()+"%");
			ps.setString(2, "%"+page.getFindStr()+"%");
			ps.setString(3, "%"+page.getFindStr()+"%");
			ps.setString(4, "%"+page.getFindStr()+"%");
			ps.setInt(5, this.page.getStartNo()-1);
			ps.setInt(6, this.page.getListSize());
	
			rs=ps.executeQuery();
			while(rs.next()) {
				ScoreVo v=new ScoreVo();
				v.setSno(rs.getInt("sc.sno"));
				v.setId(rs.getString("sc.id"));
				v.setSubject(rs.getString("sc.subject"));
				v.setScore(rs.getInt("sc.score"));
				v.setNal(rs.getString("sc.nal"));
				
				v.setmName(rs.getString("st.mName"));
				v.setPhone(rs.getString("st.phone"));
				v.setEmail(rs.getString("st.email"));
				list.add(v);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		closeDB();
		return list;
	}

	@Override
	public Page getPage() {
		return this.page;
	}

	public String findName(String id) {
		String mName="";
		try {
			String sql="select mName from student where id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			rs=ps.executeQuery();
			if(rs.next()) {
				mName=rs.getString("mName");
			}
					
		}catch (Exception e) {
			mName=e.getMessage();
		}
		return mName;
	}
	
	public static void main(String[] args) {
		ScoreDao dao=new ScoreDao();
		ScoreVo vo = new ScoreVo();
		vo.setId("a002");
		vo.setSubject("영어");
		vo.setScore(90);
		vo.setNal("2022-05-19");
		
		String msg=dao.insert(vo);
		System.out.println(msg);
		
		vo.setSno(501);
		vo.setId("a002");
		vo.setSubject("수학");
		vo.setScore(80);
		vo.setNal("22-01-01");
		
	}
	
}
