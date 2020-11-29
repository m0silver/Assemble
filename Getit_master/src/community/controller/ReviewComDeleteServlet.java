package community.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import community.model.service.CommunityService;

/**
 * Servlet implementation class ReviewComDeleteServlet
 */
@WebServlet("/review/comdelete")
public class ReviewComDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommunityService communityservice;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewComDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int reviewNo = Integer.parseInt(request.getParameter("reviewNo"));
		int commentNo = Integer.parseInt(request.getParameter("commentNo"));
		int result = new CommunityService().deleteComReview(reviewNo, commentNo);
		if(result > 0) {
			response.sendRedirect("/review/select?reviewNo=" + reviewNo);
		} else {
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/review/error.html");
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
