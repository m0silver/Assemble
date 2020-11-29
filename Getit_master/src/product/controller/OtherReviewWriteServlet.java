package product.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.vo.Member;
import product.model.service.OtherService;

/**
 * Servlet implementation class OtherReviewWriteServlet
 */
@WebServlet("/other/write")
public class OtherReviewWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OtherService otherservice;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OtherReviewWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		String pCode = request.getParameter("pCode");
		System.out.println("contents: " + contents );
		System.out.println("pCode : " + pCode);
		if(session != null && (session.getAttribute("member") != null)) {
			String userId = ((Member)session.getAttribute("member")).getMemberId();
			int result = new OtherService().insertReview(title, contents, pCode, userId);
			if(result > 0) {
				response.sendRedirect("/other/content?pCode=" + pCode);
			} else {
				RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/other/otherError.html");
				view.forward(request, response);
			}
		} else {
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/other/serviceFailed.html");
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
