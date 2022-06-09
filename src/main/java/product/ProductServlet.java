package product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import bean.Page;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import parts.PartsVo;


/**
 * Servlet implementation class ProductServlet
 */
@WebServlet(urlPatterns = {"/product.do","/pro.do"})
public class ProductServlet extends HttpServlet {
	RequestDispatcher rd;
	String base="product/product_";
	ProductDao dao;
    /**
     * Default constructor. 
     */
    public ProductServlet() {
    	dao=new ProductDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("test");
		doPost(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * System.out.println("test"); PrintWriter
		 * out=resp.getWriter();//<%out.print(false)%>와 같음 out.print("right out.print");
		 * out.print("<h1>right out.print</h1>");
		 */

		System.out.println("test1");
		String job="";
		if(req.getParameter("job")!=null) {
			job=req.getParameter("job");
			System.out.println(job);
		}
		
		switch (job) {
		case "insert":
			System.out.println("insert : "+"insert");
			insert(req,resp);
			break;
		case "delete":
			System.out.println("delete : "+"delete");
			delete(req,resp);
			break;
		case "update":
			System.out.println("update : "+"update");
			update(req,resp);
			break;
		case "findCode":
			findCode(req,resp);
			break;
		case"view":
			System.out.println("view");
			selectOne(req, resp);
			break;
		case"select":
			System.out.println("sel");
			select(req, resp);
			break;
		case "":
			System.out.println("test2");
			//1page 목록 가져와서 반환
			select(req, resp);
			break;

		default:
			break;
		}
		
	}

	public void select(HttpServletRequest req, HttpServletResponse resp){
		System.out.println("test3");
		String url=base+"list.jsp";
		Page p=new Page();
		String temp = req.getParameter("nowPage");
		int nowPage=1;
		try {
			nowPage=Integer.parseInt(temp);
			
		} catch (Exception e) {
			nowPage=1;
		}
		System.out.println("now : "+nowPage);
		p.setNowPage(nowPage);
		
		String findStr=req.getParameter("findStr");
		if(findStr==null) {
			p.setFindStr("");
		}else {
			p.setFindStr(findStr);
		}
		
		List<ProductVo> list=dao.select(p);
		req.setAttribute("list", list);
		p=dao.getPage();
		req.setAttribute("page",p);
		
		rd=req.getRequestDispatcher(url);
		
		try {
			rd.forward(req,resp);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("teste");
		}
		
	}
	
	
	public void selectOne(HttpServletRequest req, HttpServletResponse resp)throws ServletException,IOException {
		String url=base+"input.jsp";
		int sno=Integer.parseInt(req.getParameter("sno"));
		ProductVo vo = dao.selectOne(sno);
		
		req.setAttribute("vo", vo);
		rd=req.getRequestDispatcher(url);
		rd.forward(req, resp);
	}

	public void findCode(HttpServletRequest req, HttpServletResponse resp)throws ServletException,IOException {
		String Code=req.getParameter("code");
		List<PartsVo> list=dao.findCode(Code);
		
		req.setAttribute("list", list);
		System.out.println(list);
		
		System.out.println("test1");
		
		
		String url=base+"search2.jsp";
		
		System.out.println(url);
		
		rd=req.getRequestDispatcher(url);
		rd.forward(req, resp);
	}
	
	public void insert(HttpServletRequest req, HttpServletResponse resp)throws ServletException,IOException {
		System.out.println("insert : "+"insert00");
		String code=req.getParameter("code");
		String codeName=req.getParameter("codeName");
		String nal=req.getParameter("nal");
		int ea=Integer.parseInt(req.getParameter("ea"));
		int price=Integer.parseInt(req.getParameter("price"));
		String msg="";
		
		ProductVo vo=new ProductVo();
		vo.setPrice(price);
		vo.setEa(ea);
		vo.setNal(nal);
		vo.setCode(code);

		System.out.println("test : "+"test");
		msg=dao.insert(vo);
		System.out.println("msg : "+msg);
		
		req.setAttribute("msg", msg);
		req.setAttribute("vo",vo);
		String url=base+"input.jsp";
		rd=req.getRequestDispatcher(url); 
		rd.forward(req, resp);
		
	}
	
	

	public void update(HttpServletRequest req, HttpServletResponse resp)throws ServletException,IOException {
		System.out.println("test : "+"test0");
		int sno=Integer.parseInt(req.getParameter("sno"));
		String code=req.getParameter("code");
		String codeName=req.getParameter("codeName");
		String nal=req.getParameter("nal");
		int ea=Integer.parseInt(req.getParameter("ea"));
		int price=Integer.parseInt(req.getParameter("price"));
		int amt=Integer.parseInt(req.getParameter("amt"));
		String msg="";
		
		ProductVo vo=new ProductVo();
		vo.setAmt(amt);
		vo.setPrice(price);
		vo.setEa(ea);
		vo.setNal(nal);
		vo.setCodeName(codeName);
		vo.setCode(code);
		vo.setSno(sno);

		System.out.println("test : "+"test");
		msg=dao.update(vo);
		System.out.println("msg : "+msg);
		
		req.setAttribute("msg", msg);
		req.setAttribute("vo",vo);
		String url=base+"input.jsp";
		rd=req.getRequestDispatcher(url); 
		rd.forward(req, resp);
		
	}
	
	
	public void delete(HttpServletRequest req, HttpServletResponse resp)throws ServletException,IOException {
		System.out.println("deletem : "+"deletem");
		int sno=Integer.parseInt(req.getParameter("sno"));
		String msg=dao.delete(sno);
		System.out.println("msg : "+msg);
		/*
		 * req.setAttribute("msg", msg); String url=base+"input.jsp";
		 * rd=req.getRequestDispatcher(url); rd.forward(req, resp);
		 */
	}
}
