package community.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import community.model.service.CommunityService;
import community.model.vo.Review;

/**
 * Servlet implementation class ReviewModifyFormServlet
 */
@WebServlet("/review/modifyform")
public class ReviewModifyFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommunityService communityservice;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewModifyFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int reviewNo = Integer.parseInt(request.getParameter("reviewNo"));
		Review review = new CommunityService().selectReview(reviewNo);
		if(review != null) {
			request.setAttribute("review", review);
			request.getRequestDispatcher("/WEB-INF/views/community/reviewModify.jsp").forward(request, response);
		} else {
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/community/error.html");
			view.forward(request, response);
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
