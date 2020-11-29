package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.OrderList;

/**
 * Servlet implementation class returnServlet
 */
@WebServlet("/member/return")
public class returnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberservice;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public returnServlet() {
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
		
		if(orderList!=null) {
					
			request.setAttribute("rOrder", orderList);			
			request.getRequestDispatcher("/WEB-INF/views/member/returnProduct.jsp").forward(request, response);
			
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
