package score;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import bean.Page;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import student.StudentDao;

@WebServlet(urlPatterns="/score.do")
public class ScoreServlet extends HttpServlet {
	String base="index.jsp?inc=score/score_";//항상 공통 URL, 사용자에게 되돌려줄 경로
	String job="/";//사용자의 요청처리(score.do?job=input)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		job=req.getParameter("job");
		String url="";
		ScoreDao dao=new ScoreDao();
		ScoreVo vo=new ScoreVo();
		
		int sno=0;
		String msg="";
		String nal="";
		String id="";
		String subject="";
		int score=0;
		String mName="";

		
		RequestDispatcher rd=null;
		if(job==null)job="";
		
		switch(job) {
		case"list"://score.do?=list
			//url=base+"list.jsp";
			select(req,resp);
			break;
		case"input":
			url=base+"input.jsp";
			rd=req.getRequestDispatcher(url);
			rd.forward(req, resp);
			
			//
			break;
		case"modify":
			sno=Integer.parseInt(req.getParameter("sno"));
			url=base+"modify.jsp";
			vo=dao.SelectOne(sno);
			req.setAttribute("vo", vo);
			rd=req.getRequestDispatcher(url);
			rd.forward(req, resp);
			break;
			
		case"view":
			url=base+"view.jsp";
			sno=Integer.parseInt(req.getParameter("sno"));
			vo=dao.SelectOne(sno);
			req.setAttribute("vo", vo);
			rd=req.getRequestDispatcher(url);
			rd.forward(req, resp);
			break;
		case"inputR"://데이터 저장후 리스트 변환
			url=base+"list.jsp";
			msg="";
			nal=req.getParameter("nal");
			id=req.getParameter("id");
			subject=req.getParameter("subject");
			score=Integer.parseInt(req.getParameter("score"));
			msg=dao.insert(vo=new ScoreVo(0,id,nal,subject,score));
			select(req,resp);
			break;
		case"modifyR"://데이터 수정 후 score_list로 전환
			url=base+"list.jsp";
			
			msg="";
			sno=Integer.parseInt(req.getParameter("sno"));
			nal=req.getParameter("nal");
			id=req.getParameter("id");
			subject=req.getParameter("subject");
			mName=req.getParameter("mName");
			score=Integer.parseInt(req.getParameter("score"));
			
			msg=dao.update(vo=new ScoreVo(sno,id,nal,subject,score));
			
			select(req,resp);
			break;
		case"deleteR"://데이터 삭제 후 score_delete로 전환
			url=base+"list.jsp";
			
			msg="";
			sno=Integer.parseInt(req.getParameter("sno"));
			System.out.println("222222222222222222222222");
			System.out.println(sno);
			msg=dao.delete(sno);
			System.out.println(msg);
			select(req,resp);
			break;
			
		case"findName":
			System.out.println("test");
			id=req.getParameter("id");
			System.out.println(id);
			mName=dao.findName(id);
			System.out.println(mName);
			req.setAttribute("mName", mName);
			
			url="score/score_find_name.jsp";
			rd=req.getRequestDispatcher(url);
			rd.forward(req, resp);
			break;
		default:
			select(req,resp);
			
			
		}

		
	}
	
	public void select(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url="";
		Page page=new Page();
		ScoreDao dao=new ScoreDao();
		int now=1;
		if(req.getParameter("nowPage")==null||req.getParameter("nowPage")=="") {
			now=1;
		}else {
			now=Integer.parseInt(req.getParameter("nowPage"));
		}
		String findStr="";
		if(req.getParameter("findStr")!=null) {
			findStr=req.getParameter("findStr");
		}
	
		page.setNowPage(now);
		page.setFindStr(findStr);

		List<ScoreVo> list=dao.select(page);
		page=dao.getPage();
		req.setAttribute("list", list);
		req.setAttribute("page", page);
		
		url=base+"list.jsp";
		
		RequestDispatcher rd=req.getRequestDispatcher(url);
		rd.forward(req, resp);
	}
}



