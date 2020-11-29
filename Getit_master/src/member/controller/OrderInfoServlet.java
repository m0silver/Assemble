package member.controller;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class OrderInfoSevlet
 */
@WebServlet("/order/info")
public class OrderInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberservice;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderInfoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String userId = ((Member) session.getAttribute("member")).getMemberId();

		ArrayList<OrderList> oList = new MemberService().orderList(userId);
		System.out.println(oList);

		if (!oList.isEmpty()) {
			request.setAttribute("oList", oList);
			request.getRequestDispatcher("/WEB-INF/views/member/orderInfo.jsp").forward(request, response);

		} else {
			request.getRequestDispatcher("/WEB-INF/views/member/orderInfo.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
