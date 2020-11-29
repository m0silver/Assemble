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
 * Servlet implementation class reviewdelete
 */
@WebServlet("/recommend/delete")
public class RecommendDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RecommendService recommendservice;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecommendDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// id 랑 상품코드 가져오기
		String pCode = request.getParameter("pCode");
		HttpSession session = request.getSession();
		String memberId = ((Member)session.getAttribute("member")).getMemberId();
		String pFilename = request.getParameter("pFilename");
		// 삭제하러 가즈아~
		int result =0;
		if(request.getParameter("reviewNo")!=null) {
		int reviewNo = Integer.parseInt(request.getParameter("reviewNo"));
		result = new RecommendService().reviewDelete(pCode,memberId,reviewNo);
		}
		if(result>0) {
			request.setAttribute("pFilename", pFilename);
			request.setAttribute("pCode", pCode);
			request.getRequestDispatcher("/recommend/detail").forward(request, response);
		}else {
			response.sendRedirect("실패");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
