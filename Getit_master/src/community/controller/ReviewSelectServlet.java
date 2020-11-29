package community.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import community.model.service.CommunityService;
import community.model.vo.Comments;
import community.model.vo.PageData;
import community.model.vo.Review;
import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class ReviewSelectServlet
 */
@WebServlet("/review/select")
public class ReviewSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommunityService communityservice;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewSelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
		int reviewNo = Integer.parseInt(request.getParameter("reviewNo"));
		Review review = new CommunityService().selectReview(reviewNo);
		
		int currentPage = 0;
		if(request.getParameter("currentPage") == null) {
			currentPage = 1;
		} else { 
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		PageData pageData = new CommunityService().selectReviewCom(currentPage, reviewNo);
		ArrayList<Comments> list = pageData.getPageComList();
		
		if(review != null && session.getAttribute("member")!=null) {
			String memberId = ((Member)session.getAttribute("member")).getMemberId();
			request.setAttribute("contents", review);
			request.setAttribute("list", list);
			request.setAttribute("memberId", memberId);
			request.setAttribute("pageComNavi", pageData.getPageComNavi());
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/community/review_contents.jsp");
			view.forward(request, response);
		} else {
				response.setContentType("text/html; charset=utf-8");
				PrintWriter writer = response.getWriter();
				writer.println("<script>alert('로그인 후 이용 가능합니다.'); location.href='/login.html';</script>");
				writer.close();
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
