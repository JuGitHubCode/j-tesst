package board;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet(urlPatterns="/board.do")
public class BoardServlet extends HttpServlet {
	String base="index.jsp?inc=./board/board_";
	RequestDispatcher rd;
	
    public BoardServlet() {
    }


	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
		
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String job="";
		String url="";
		if(req.getParameter("job")!=null) {
			job=req.getParameter("job");
		}
		switch (job) {
		case "select":
			select(req,resp);
			break;
		case "input":
			input(req,resp);
			break;
		case "view":
			view(req, resp);
			break;
		case "inputR":
			inputR(req, resp);
			break;
		case "modify":
			modify(req, resp);
			break;
		case "modifyR":
			modifyR(req, resp);
			break;
		case "deleteR":
			deleteR(req, resp);
			break;
		case "repl":
			repl(req, resp);
			break;
		case "replR":
			replR(req, resp);
			break;
			
		default:
			select(req,resp);
			break;
		}
	}

	
	public void select(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = base+"list.jsp";
		rd = req.getRequestDispatcher(url);
		rd.forward(req, resp);
	}
	public void input(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = base+"input.jsp";
		rd = req.getRequestDispatcher(url);
		rd.forward(req, resp);
	}
	public void view(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = base+"view.jsp";
		rd = req.getRequestDispatcher(url);
		rd.forward(req, resp);
	}
	public void inputR(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = base+"list.jsp";
		rd = req.getRequestDispatcher(url);
		rd.forward(req, resp);
	}
	public void modify(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = base+"modify.jsp";
		rd = req.getRequestDispatcher(url);
		rd.forward(req, resp);
	}
	public void deleteR(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = base+"list.jsp";
		rd = req.getRequestDispatcher(url);
		rd.forward(req, resp);
	}
	public void repl(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = base+"repl.jsp";
		rd = req.getRequestDispatcher(url);
		rd.forward(req, resp);
	}
	public void modifyR(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = base+"list.jsp";
		rd = req.getRequestDispatcher(url);
		rd.forward(req, resp);
	}
	public void replR(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = base+"list.jsp";
		rd = req.getRequestDispatcher(url);
		rd.forward(req, resp);
	}
	
}
