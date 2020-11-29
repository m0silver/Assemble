package adminPage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adminPage.service.AdminService;

/**
 * Servlet implementation class adminServlet
 */
@WebServlet("/member/admin")
public class adminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		int depositC = new AdminService().depositCount();
		int payC = new AdminService().payCompleteCount();
		int rfd = new AdminService().rfdCount();
		int deliveryC = new AdminService().deliveringCount();
		int dCompleteC = new AdminService().dCompleteCount();
		int returnC = new AdminService().returnCount();
		int changeC = new AdminService().changeCount();
		
		System.out.println(depositC);
		System.out.println(payC);
		System.out.println(rfd);
		System.out.println(deliveryC);
		System.out.println(dCompleteC);
		System.out.println(returnC);
		
		if(depositC >=0 || payC >=0 || rfd >=0 || deliveryC >=0 || dCompleteC >=0 ||  returnC >=0 || changeC >=0) {
			request.setAttribute("depositC", depositC);
			request.setAttribute("payC", payC );
			request.setAttribute("rfd", rfd );
			request.setAttribute("deliveryC", deliveryC );
			request.setAttribute("dCompleteC", dCompleteC);
			request.setAttribute("returnC", returnC );
			request.setAttribute("changeC", changeC );
			request.getRequestDispatcher("/WEB-INF/views/admin/adminPage.jsp").forward(request, response);
			
		}else {
			request.getRequestDispatcher("/WEB-INF/views/admin/adminPage.jsp").forward(request, response);
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
