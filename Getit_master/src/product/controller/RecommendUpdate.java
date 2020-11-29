package product.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.vo.Member;
import product.model.service.RecommendService;

/**
 * Servlet implementation class reviewupdate
 */
@WebServlet("/recommend/update")
public class RecommendUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RecommendService recommendservice;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecommendUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String pCode = request.getParameter("pCode");
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		String pFilename = request.getParameter("pFilename");
		int result =0;
		int reviewNo =0;
		String memberId ="";
		//if(((Member)session.getAttribute("memeber")!=null)) {
		reviewNo = Integer.parseInt(request.getParameter("reviewNo"));
		memberId = ((Member)session.getAttribute("member")).getMemberId(); 
		result = new RecommendService().reviewUpdate(memberId,pCode,title,contents,reviewNo);
		//}
		
		  if(result>0) { request.setAttribute("pFilename", pFilename);
		  request.setAttribute("pCode", pCode);
		  request.getRequestDispatcher("/recommend/detail").forward(request, response);
		  }else { response.sendRedirect("서비스요청실패"); }
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
