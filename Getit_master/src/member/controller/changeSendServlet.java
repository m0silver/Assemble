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
 * Servlet implementation class changeSendServlet
 */
@WebServlet("/member/changeSend")
public class changeSendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberservice;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changeSendServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		OrderList orderList = new OrderList();
		orderList.setOrderNo(Integer.parseInt(request.getParameter("orderNo")));
		orderList.setChangeA(Integer.parseInt(request.getParameter("pAccount")));
		String changeRE = request.getParameter("changeRE");
		
		if(changeRE.equals("mdelivery")) {
			orderList.setChangeRE("판매자의 오배송으로 인한 교환신청");
			
		}else if(changeRE.equals("diff")) {
			orderList.setChangeRE("상품이 설명과 다름");
			
		}else if(changeRE.equals("faulty")) {
			orderList.setChangeRE("상품 파손 및 불량품 배송");
			
		}
		
		
		
		int result = new MemberService().updateChange(orderList);
		
		if(result>0) {
			request.getRequestDispatcher("/WEB-INF/views/member/index.jsp").forward(request, response);
			
		}
		else {
			request.getRequestDispatcher("/WEB-INF/views/member/memberError.html").forward(request, response);
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
