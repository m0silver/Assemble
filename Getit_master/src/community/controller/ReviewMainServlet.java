package community.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import community.model.service.CommunityService;
import community.model.vo.PageData;
import community.model.vo.Review;

/**
 * Servlet implementation class ReviewMainServlet
 */
@WebServlet("/review/main")
public class ReviewMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommunityService communityservice;   
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewMainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage = 0;
		if(request.getParameter("currentPage") == null) {
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		PageData pageData = new CommunityService().selectReviewList(currentPage);
		ArrayList<Review> list = pageData.getPageList();
		if(!list.isEmpty()) {
			request.setAttribute("list", list);
			request.setAttribute("pageNavi", pageData.getPageReNavi());
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/community/Review.jsp");
			view.forward(request, response);
		} else {
			response.sendRedirect("/views/other/Error.html");
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
