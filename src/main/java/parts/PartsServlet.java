package parts;

import java.io.IOException;
import java.util.List;

import bean.Page;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/parts.do")
public class PartsServlet extends HttpServlet{
	RequestDispatcher rd;
	String base="parts/parts_";
	PartsDao dao;
	
	
	public PartsServlet() {
		dao=new PartsDao();
	}
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String job=req.getParameter("job");
		String url="";
		Page page=null;
		int nowPage=0;
		String findStr="";
		String code="";		
		PartsVo vo=null;
		String	msg="";
		
		
		List<PartsVo> list=null;
		
		if(job==null||job.equals("")) {
			job="/";
		}
		
		
		
		switch (job) {
		case "select":
			findStr=req.getParameter("findStr");
			try {
			nowPage=Integer.parseInt(req.getParameter("nowPage"));
			}catch (Exception e) {
				nowPage=1;
			}
			System.out.println("findStr : "+findStr);
			System.out.println("nowPage : "+nowPage);
			
			page=new Page();
			page.setFindStr(findStr);
			page.setNowPage(nowPage);
			list=dao.select(page);
			System.out.println("nowPage : "+nowPage);
			page=dao.getPage();
			
			System.out.println("list : "+list);
			System.out.println("page totsize : "+page.getTotSize());
			System.out.println("page start : "+page.getStartNo());
			
			req.setAttribute("list", list);
			req.setAttribute("page", page);
			
			url=base+"list.jsp";
			System.out.println("url : "+url);
			rd=req.getRequestDispatcher(url);
			break;
		case "view":
			url=base+"input.jsp";
			rd=req.getRequestDispatcher(url);
			
			code=req.getParameter("code");
			System.out.println("code : "+code);
			
			vo=dao.selectOne(code);
			req.setAttribute("vo",vo);
			
			break;
		case "update":
			
			String temp=req.getParameter("code");
			System.out.println("==============================");
			System.out.println("tempcode :"+temp);
			
			vo=new PartsVo();
			
			
			vo.setCode(req.getParameter("code"));
			vo.setcodeName(req.getParameter("codeName"));
			vo.setPrice(Integer.parseInt(req.getParameter("price")));
			vo.setSpec(req.getParameter("spec"));
			
			
			System.out.println("==============================");
			System.out.println("code :"+vo.getCode());
			
			
			msg=dao.update(vo);
			System.out.println("==============================");
			System.out.println("daomsg"+msg);

			
			
			
			url=base+"input.jsp";
			req.setAttribute("vo",vo);
			req.setAttribute("msg", msg);
			
			
			rd=req.getRequestDispatcher(url);
			
			break;
		
		case "delete":
			
			vo=new PartsVo();
			code=req.getParameter("code");
			msg=dao.delete(code);
			
			req.setAttribute("vo",vo);
			req.setAttribute("msg", msg);
			System.out.println("==============================");
			System.out.println("msg"+msg);
			
			url=base+"input.jsp";
			rd=req.getRequestDispatcher(url);
			
			break;
			
			
		case "insert":
			
			vo=new PartsVo();
			vo.setCode(req.getParameter("code"));
			vo.setcodeName(req.getParameter("codeName"));
			vo.setPrice(Integer.parseInt(req.getParameter("price")));
			vo.setSpec(req.getParameter("spec"));
			msg=dao.insert(vo);
			
			req.setAttribute("msg", msg);
			System.out.println("==============================");
			System.out.println("msg"+msg);
			
			url=base+"input.jsp";
			rd=req.getRequestDispatcher(url);
			
			break;
			
		default:
			page=new Page();
			page.setFindStr("");
			page.setNowPage(1);
			list=dao.select(page);
			page=dao.getPage();
			
			System.out.println("list : "+list);
			System.out.println("page : "+page);
			
			req.setAttribute("list", list);
			req.setAttribute("page", page);
			
			url=base+"list.jsp";
			
			rd=req.getRequestDispatcher(url);
			break;
		}
		rd.forward(req,resp);
	}
}
