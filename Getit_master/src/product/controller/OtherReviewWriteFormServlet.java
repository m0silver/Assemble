package product.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.vo.Member;
import product.model.service.OtherService;

/**
 * Servlet implementation class OtherReviewWriteFormServlet
 */
@WebServlet("/other/writeform")
public class OtherReviewWriteFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OtherService otherservice;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OtherReviewWriteFormServlet() {
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
		if(session.getAttribute("member")!=null) {
			String memberId = ((Member)session.getAttribute("member")).getMemberId();
			request.setAttribute("memberId", memberId);
			request.setAttribute("pCode", pCode);
			request.getRequestDispatcher("/WEB-INF/views/other/otherWrite.jsp").forward(request, response);			
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('로그인 후 이용가능합니다.'); location.href='/login.html';</script>"); 
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
