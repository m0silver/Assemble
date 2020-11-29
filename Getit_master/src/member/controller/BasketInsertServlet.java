package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;


/**
 * Servlet implementation class ShoppingBagInsertServlet
 */
@WebServlet("/basket/insert")
public class BasketInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberservice;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BasketInsertServlet() {
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
		
		
		if(session != null && (session.getAttribute("member") != null)) {
			String memberId = ((Member)session.getAttribute("member")).getMemberId();
			int result = new MemberService().basketInsert(memberId, pCode);
			if(result>0) {
				request.getRequestDispatcher("/mainpage/view").forward(request, response);
			}else {
				System.out.println("오류");
			}
		} else {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('로그인 후 이용 가능합니다.'); location.href='/mainpage/view';</script>");
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
