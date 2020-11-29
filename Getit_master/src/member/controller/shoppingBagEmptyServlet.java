package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class shoppingBagEmptyServlet
 */
@WebServlet("/member/shoppingBagEmpty")
public class shoppingBagEmptyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberservice;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public shoppingBagEmptyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		String userId = ((Member)session.getAttribute("member")).getMemberId();
		
		int result = 0;
		result = new MemberService().shoppingBagEmpty(userId);
		
		if(result>0) {
			response.sendRedirect("/member/shoppingbag?userId="+userId);
		}else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('삭제할 항목이 없습니다.'); location.href='/basket.jsp';</script>"); 
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
