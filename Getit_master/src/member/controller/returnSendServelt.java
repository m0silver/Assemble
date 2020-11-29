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
 * Servlet implementation class returnSendServelt
 */
@WebServlet("/member/returnSend")
public class returnSendServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberservice;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public returnSendServelt() {
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
		orderList.setReturnA(Integer.parseInt(request.getParameter("pAccount")));
		String returnRE = request.getParameter("returnRE");
		
		if(returnRE.equals("dsbs")) {
			orderList.setReturnRE("단순변심 상품이 맘에들지 않음.");
		}else if(returnRE.equals("diff")) {
			orderList.setReturnRE("상품이 설명과 다름");
		}else if(returnRE.equals("faulty")) {
			orderList.setReturnRE("상품 파손 및 불량품 배송");
		}
		
		int result = new MemberService().updateReturn(orderList);
		
		if(result>0) {
			request.getRequestDispatcher("/WEB-INF/views/main/index.jsp").forward(request, response);
			
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
