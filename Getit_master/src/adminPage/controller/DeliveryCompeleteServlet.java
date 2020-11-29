package adminPage.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adminPage.service.AdminService;
import adminPage.vo.OrderM;

/**
 * Servlet implementation class DeliveryCompeleteServlet
 */
@WebServlet("/admin/deliveryCompelete")
public class DeliveryCompeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeliveryCompeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		ArrayList<OrderM> dcList = new AdminService().dCompletedSearch();
		System.out.println(dcList);

		if (!dcList.isEmpty()) {
			request.setAttribute("dcList", dcList);
			request.getRequestDispatcher("/WEB-INF/views/admin/deliveringComplete.jsp").forward(request, response);

		} else {
			request.getRequestDispatcher("/WEB-INF/views/admin/deliveringComplete.jsp").forward(request, response);
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
