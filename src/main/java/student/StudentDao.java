package student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.AES;
import bean.Page;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class StudentDao implements StudentInterface {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	Page p;
	AES aes;
	
	public StudentDao(){
		this.conn=new DBConn().getConn();
		aes=new AES();
	}
	
	public String findId(HttpServletRequest req) {
		String msg="";
		HttpSession session=req.getSession();
		String phone=req.getParameter("Phone");
		String email=req.getParameter("Email");
		String sql="select * from student where phone =? or email=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, phone);
			ps.setString(2, email);
			rs=ps.executeQuery();
			if(rs.next()) {
				msg="아이디 : "+rs.getString("id");
			}else {
				msg="정보가 없습니다.";
			}
		}catch (Exception e) {
			msg=e.getMessage();
		}
		return msg;
	}
	
	public String findPwd(HttpServletRequest req) {
		String msg="";
		HttpSession session=req.getSession();
		String mId=req.getParameter("mId");
		String email=req.getParameter("Email");
		String sql="select * from student where id=? or email=?";
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, mId);
			ps.setString(2, email);
			rs=ps.executeQuery();
			if(rs.next()) {
				msg="암호 : "+rs.getString("pwd");
			}else {
				msg="정보가 없습니다.";
			}
		}catch (Exception e) {
			msg=e.getMessage();
		}
		
		return msg;
	}

	public String login(HttpServletRequest req) {
		String mId=req.getParameter("mId");
		String mPwd=req.getParameter("mPwd");
		
		String msg=String.format("id:%s, pwd:%s",mId,mPwd);
		HttpSession session=req.getSession();
		
		String sql="select * from student where id=? and pwd=?";
		
		try{
			//암호화
			
			ps=conn.prepareStatement(sql);
			ps.setString(1, mId);
			ps.setString(2, mPwd);
			rs=ps.executeQuery();
			if(rs.next()) {
				String mName=rs.getString("mName");
				msg="환영합니다. "+mName+"님";
				session.setAttribute("mId", mName);
			}else {
				msg="아이디 또는 암호를 확인해 주세요";
				session.setAttribute("mId", null);
			}
					
		}catch (Exception e) {
			msg=e.getMessage();
		}
	
		return msg;
	}
	
	public String logout(HttpServletRequest req) {
		String msg="";
		try {
			HttpSession session=req.getSession();
			session.setAttribute("mId",null);
			msg="정상적으로 로그아웃 되었습니다.";
		}catch (Exception e) {
			msg=e.getMessage();
		}
		
		return msg;
	}
	
	
	
	
	//학생정보 등록
	public String insert(HttpServletRequest req) {
		String msg="";
		String id=req.getParameter("id");
		String mName=req.getParameter("mName");
		String pwd=req.getParameter("pwd");
		String email=req.getParameter("email");
		String phone=req.getParameter("phone");
		String address=req.getParameter("address");
		int zipcode=Integer.parseInt(req.getParameter("zipcode"));
		String gender=req.getParameter("gender");
		
		String sql="insert into student(id,mName,pwd,email,phone,address,zipcode,gender) "
				+"values(?,?,?,?,?,?,?,?)";
		
		
		try {
			//암호화
	
			
			
			
			
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, mName);
			ps.setString(3, pwd);
			ps.setString(4, email);
			ps.setString(5, phone);
			ps.setString(6, address);
			ps.setInt(7, zipcode);
			ps.setString(8, gender);
			
			conn.setAutoCommit(false);
			int n=ps.executeUpdate();
			if(n>0) {
				conn.commit();
				msg="저장 완료";
			}else {
				conn.rollback();
				msg="저장 오류";
			}			
		}catch (Exception e) {
			msg=e.getMessage();
		}
		return msg;
	}
	
	
	
	
	
	
	
	
	
	

	@Override
	public boolean insert(StudentVo vo) {
		boolean b=false;
		String sql="insert into student(id, mName, pwd, email, phone) values(?,?,?,?,?)";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getmName());
			ps.setString(3, vo.getPwd());
			ps.setString(4, vo.getEmail());
			ps.setString(5, vo.getPhone());
			
			
			
			conn.setAutoCommit(false);
			int n=ps.executeUpdate();
			if(n>0) {
				b=true;
				conn.commit();
			}else {
				conn.rollback();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public List<StudentVo> select(String findStr, int nowPage) {
		List<StudentVo> list =new ArrayList<StudentVo>();
		String sql="";
		this.p=new Page();
		int totSize=0;
		try {
			//nowPage
			//검색어 포함 전체건수
			sql="select count(id) cnt from student where id like ? or mName like ? "
				+ "or email like ? or phone like ? or gender like ? "
				+ "or address like ? or zipcode like ? or pwd like ? "
				;		
			ps=conn.prepareStatement(sql);
			ps.setString(1, "%"+findStr+"%");
			ps.setString(2, "%"+findStr+"%");
			ps.setString(3, "%"+findStr+"%");
			ps.setString(4, "%"+findStr+"%");
			ps.setString(5, "%"+findStr+"%");
			ps.setString(6, "%"+findStr+"%");
			ps.setString(7, "%"+findStr+"%");
			ps.setString(8, "%"+findStr+"%");
			
			rs=ps.executeQuery();
			if(rs.next()) {
				totSize=rs.getInt("cnt");
			}
			p.setTotSize(totSize);
			p.setNowPage(nowPage);
			p.compute();
			
			//데이터 출력
			sql="select * from student where id like ? or mName like ? "
				+ "or email like ? or phone like ? or gender like ? "
				+ "or address like ? or zipcode like ? or pwd like ? "
				+ "limit ?,?";			
			ps=conn.prepareStatement(sql);
			ps.setString(1, "%"+findStr+"%");
			ps.setString(2, "%"+findStr+"%");
			ps.setString(3, "%"+findStr+"%");
			ps.setString(4, "%"+findStr+"%");
			ps.setString(5, "%"+findStr+"%");
			ps.setString(6, "%"+findStr+"%");
			ps.setString(7, "%"+findStr+"%");
			ps.setString(8, "%"+findStr+"%");
			ps.setInt(9, p.getStartNo()-1);
			ps.setInt(10, p.getListSize());
	
			rs=ps.executeQuery();
			while(rs.next()) {
				StudentVo vo=new StudentVo();
				vo.setId(rs.getString("id"));
				vo.setmName(rs.getString("mName"));
				vo.setEmail(rs.getString("email"));
				vo.setPhone(rs.getString("phone"));
				vo.setAddress(rs.getString("address"));
				vo.setZipcode(rs.getInt("zipcode"));
				vo.setPwd(rs.getString("pwd"));
				vo.setGender(rs.getString("gender"));
				list.add(vo);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	
	//페이지 객체를 반환하는 메서드
	public Page getP() {
		return p;
	}

	

	@Override
	public StudentVo selectOne(String id) {
		String sql="select * from student where id=?";
		StudentVo vo=null;
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1,id);
			rs=ps.executeQuery();
			if(rs.next()) {
				vo=new StudentVo();
				vo.setId(rs.getString("id"));
				vo.setmName(rs.getString("mName"));
				vo.setEmail(rs.getString("email"));
				vo.setPhone(rs.getString("phone"));
				vo.setAddress(rs.getString("address"));
				vo.setZipcode(rs.getInt("zipcode"));
				vo.setPwd(rs.getString("pwd"));
				vo.setGender(rs.getString("gender"));
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return vo;
	}

	
	
	public String update(HttpServletRequest req) {
		String msg="자료 수정 완료";
		String sql= "update student set mName=?,email=?, gender=?, zipcode=?, "
				+ "address=?, phone=? where id=? and pwd=? ";
		
		try {
			//암호화
			
			
			ps=conn.prepareStatement(sql);
			ps.setString(1, req.getParameter("mName"));
			ps.setString(2, req.getParameter("email"));
			ps.setString(3, req.getParameter("gender"));
			ps.setString(4, req.getParameter("zipcode"));
			ps.setString(5, req.getParameter("address"));
			ps.setString(6, req.getParameter("phone"));
			ps.setString(7, req.getParameter("id"));
			ps.setString(7, req.getParameter("pwd"));
			
			
	
			
			
			
			
			conn.setAutoCommit(false);
			int n=ps.executeUpdate();
			if(n>0) {
				conn.commit();
			}else {
				conn.rollback();
			}
			conn.close();
		}catch (Exception e) {
			msg=e.getMessage();
		}
		return msg;
	}
	
	
	

	
	
	
	
	
	
	
	
	
	@Override
	public boolean update(StudentVo vo) {
		boolean b=false;
		String sql="update student set mName=?,email=?,phone=? where id=? and pwd=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, vo.getmName());
			ps.setString(2, vo.getEmail());
			ps.setString(3, vo.getPhone());
			ps.setString(4, vo.getId());
			ps.setString(5, vo.getPwd());
			
			conn.setAutoCommit(false);
			int n=ps.executeUpdate();
			if(n>0) {
				b=true;
				conn.commit();
			}else {
				conn.rollback();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	
	public String delete(HttpServletRequest req) {
		String msg="삭제 완료";
		String sql="delete from student where id=? and pwd=?";
		String id=req.getParameter("id");
		String pwd=req.getParameter("pwd");
		try {
			//암호화 
			
			
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2,pwd);
			
			conn.setAutoCommit(false);
			int n=ps.executeUpdate();
			if(n>0) {
				
				conn.commit();
			}else {
				conn.rollback();
			}
			conn.close();
		}catch (Exception e) {
			msg=e.getMessage();
		}	
		return msg;
	}
	
	
	
	
	
	
	@Override
	public boolean delete(String id, String pwd) {
		boolean b=false;
		String sql="delete from student where id=? and pwd=?";
		try {
			pwd=aes.dec(pwd);
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2,pwd);
			
			conn.setAutoCommit(false);
			int n=ps.executeUpdate();
			if(n>0) {
				b=true;
				conn.commit();
			}else {
				conn.rollback();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}	
		return b;
	}
}
