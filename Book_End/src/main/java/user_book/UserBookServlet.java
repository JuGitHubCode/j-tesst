package user_book;

import java.io.IOException;
import java.util.List;

import bean.Page;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/userBook.do")
public class UserBookServlet extends HttpServlet{
	
	RequestDispatcher rd;
	String bookBase = "user/book/user_book_";
	String memberBase = "user/member/user_member_";
	UserBookDao dao;
	
	String job="";
	String url = "";
	List<UserBookVo> list = null;
	int nowPage = 0;
	Page page = null;
	
	
	//카테고리 숫자 -> 문자
	public String Category(int number){
		String str = "";
		switch(number) {
		case 0:
			str = "소설";
			break;
		case 1:
			str = "시/에세이";
			break;
		case 2:
			str = "인문";
			break;
		case 3:
			str = "자기계발";
			break;
		case 4:
			str = "교재/참고서";
			break;
		}
		return str;
	}
		
	public UserBookServlet() {
		dao = new UserBookDao();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		
		
		if(req.getParameter("job") != null) {
			job = req.getParameter("job");
		}
		switch(job) {
		case "category":		//카테고리
			Category(req,resp);
			break;
		case "search":			//검색
			Search(req,resp);
			break;
		case "details":			//상세
			Details(req,resp);
			break;
		case "login":			//로그인
			Login(req,resp);
			break;
		case "cart":			//장바구니
			Cart(req,resp);
			break;
		default:				//메인
			Index(req,resp);
			break;
		}
	}
	//카테고리 페이지
	public void Category(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		String findStr = req.getParameter("findStr");
		System.out.println("findStr : " + findStr);
		
		try {
			nowPage = 1;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		page = new Page();
		page.setFindStr(findStr);
		page.setNowPage(nowPage);
		
		list = dao.select(page);
		page = dao.getPage();
		
		req.setAttribute("list", list);
		req.setAttribute("page", page);
		
		System.out.println("list.count : " + list.size());
		url = bookBase + "category.jsp";
		rd = req.getRequestDispatcher(url);
		rd.forward(req,resp);
	}
	//검색 페이지
	public void Search(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		
		String findStr = req.getParameter("findStr");
		System.out.println("findStr : " + findStr);
		
		try {
			nowPage = 1;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		page = new Page();
		page.setFindStr(findStr);
		page.setNowPage(nowPage);
		
		list = dao.select(page);
		page = dao.getPage();
		
		req.setAttribute("list", list);
		req.setAttribute("page", page);
		
		url = bookBase + "search.jsp";
		rd = req.getRequestDispatcher(url);
		rd.forward(req,resp);
	}
	//상세 페이지
	public void Details(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		url = bookBase + "details.jsp";
		rd = req.getRequestDispatcher(url);
		rd.forward(req,resp);
	}
	//로그인
	public void Login(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		url = memberBase + "login.jsp";
		rd = req.getRequestDispatcher(url);
		rd.forward(req,resp);
	}
	//장바구니
	public void Cart(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		url = memberBase + "cart.jsp";
		rd = req.getRequestDispatcher(url);
		rd.forward(req,resp);
	}
	//메인 페이지
	public void Index(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		url = "index_main.jsp";
		rd = req.getRequestDispatcher(url);
		rd.forward(req,resp);
	}
	
	
	//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	

}
