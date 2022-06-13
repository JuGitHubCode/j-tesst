package user;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/userMember.do")
public class UserMemberServlet extends HttpServlet{
	RequestDispatcher rd;
	String memberBase = "user/member/user_member_";
	
	String job="";
	String url = "";
	public UserMemberServlet() {}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		job = req.getParameter("job");
		
		switch(job) {
			case "memberLogin" :
				memberLogin();
				break;
			
			case "memberFindUidPhone" :
				memberFindUidPhone();
				break;
				

			case "memberFindUidEmail" :
				memberFindUidEmail();
				break;
			
			case "memberFindPwd" :
				memberFindPwd();
				break;
				
			default :
				
		}
	}
	
	public void memberLogin() {
		System.out.println("memberLogin");
	}
	
	public void memberFindUidPhone() {
		
	}
	
	public void memberFindUidEmail() {
		
	}
	
	public void memberFindPwd() {
		
	}
}
