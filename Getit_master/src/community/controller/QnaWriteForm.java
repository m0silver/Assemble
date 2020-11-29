package community.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import community.model.service.CommunityService;
import member.model.vo.Member;

/**
 * Servlet implementation class QnaWriteForm
 */
@WebServlet("/qna/writeform")
public class QnaWriteForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommunityService communityservice;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaWriteForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		if((Member)session.getAttribute("member")!=null) {
			String memberId = ((Member)session.getAttribute("member")).getMemberId();
			request.setAttribute("memberId", memberId);
			request.getRequestDispatcher("/WEB-INF/views/community/qnaWrite.jsp").forward(request, response);
		}else {
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
