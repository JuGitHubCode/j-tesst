package user;

import org.apache.ibatis.session.SqlSession;

import bean.AES;
import bean.RandomPwd;
import bean.SendMail;
import jakarta.servlet.http.HttpSession;
import mybatis.MybaFactory;


public class UserMemberDao {
	SqlSession session;
	HttpSession s;	// id 저장용
	
	AES aes;
	
	public UserMemberDao() {
		session = MybaFactory.getFactory().openSession();
		aes = new AES();
		
	}
	
	public String userMemberLogin(UserMemberVo vo) {
		String pwd = aes.enc(vo.getPwd());
		vo.setPwd(pwd);
		
		String uId = session.selectOne("user_member.member_login", vo);
	
		return uId;
	}
	
	public String userMemberFindPhone(UserMemberVo vo) {
		String uId = session.selectOne("user_member.member_find_phone", vo);
		
		return uId;
	}
	
	public String userMemberFindEmail(UserMemberVo vo) {
		String uId = session.selectOne("user_member.member_find_email", vo);
		
		return uId;
	}
	
	public String userMemberTempPwd(UserMemberVo vo) {
		String tempPwd = RandomPwd.getRamdomPassword(12); // 랜덤 비밀번호 생성
		String encTempPwd = aes.enc(tempPwd);	
		vo.setPwd(encTempPwd);	// 암호화 하여 DB에 저장

		int cnt = session.insert("user_member.member_temp_pwd", vo);
		
		if(cnt > 0) {
			session.commit();
		} else {
			session.rollback();
			tempPwd = "";
		}
		
		return tempPwd; 	// 사용자에게 보여줄 비밀번호는 암호화 전
	}
	
	public boolean userMemberJoin(UserMemberVo vo) {
		boolean b = false;
		String pwd = aes.enc(vo.getPwd());
		vo.setPwd(pwd);
		
		int cnt = session.insert("user_member.member_insert", vo);
		if(cnt > 0) {
			b = true;
			session.commit();
		} else {
			session.rollback();
		}
		
		return b;
	}
	
	public String userMemberUidValdation(String uId) {
		String result = session.selectOne("user_member.member_uId_validation", uId);
		return result;
	}
	
	public String userMemberEmailValdation(String email) {
		String result = session.selectOne("user_member.member_email_validation", email);
		return result;
	}
	
	public String userMemberPhoneValdation(String phone) {
		String result = session.selectOne("user_member.member_phone_validation", phone);	
		return result;
	}
}

