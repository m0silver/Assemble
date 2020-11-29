package community.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import community.model.service.CommunityService;
import member.model.vo.Member;

/**
 * Servlet implementation class ReviewCommentServlet
 */
@WebServlet("/review/comwrite")
public class ReviewCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommunityService communityservice;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String contents = request.getParameter("contents");
		int reviewNo = Integer.parseInt(request.getParameter("reviewNo"));
		HttpSession session = request.getSession();
		if(session != null && (session.getAttribute("member") != null)) {
			String userId = ((Member)session.getAttribute("member")).getMemberId();
			int result = new CommunityService().insertComment(contents, userId, reviewNo);
			if(result > 0) {
				response.sendRedirect("/review/select?reviewNo="+reviewNo);
			} else {
				RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/community/Error.html");
				view.forward(request, response);
			}
		} else {
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/community/serviceFailed.html");
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
