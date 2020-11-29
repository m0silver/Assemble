package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;
import member.model.vo.OrderList;

/**
 * Servlet implementation class changeServlet
 */
@WebServlet("/member/change")
public class changeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberservice;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			
			String orderNo=request.getParameter("orderNo");
			OrderList orderList = new MemberService().selectOrderList(orderNo);
			
			HttpSession session = request.getSession();
			Member member = (Member)session.getAttribute("member");
			
			if(orderList!=null) {
				session.setAttribute("member", member);	
				request.setAttribute("cOrder", orderList);
				
				request.getRequestDispatcher("/WEB-INF/views/member/changeProduct.jsp").forward(request, response);
				
			}else {
				response.sendRedirect("/WEB-INF/views/member/memberError.html");
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
