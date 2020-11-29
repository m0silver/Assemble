package product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import product.model.service.OtherService;
import product.model.vo.PageData;
import product.model.vo.Product;

/**
 * Servlet implementation class OtherKeyboardServlet
 */
@WebServlet("/other/keyboard")
public class OtherKeyboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OtherService otherservice;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OtherKeyboardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage = 0;
		if(request.getParameter("currentPage") == null) {
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		PageData pageData = new OtherService().selectProductKeyboard(currentPage);
		ArrayList<Product> list = pageData.getPageList();
		if(!list.isEmpty()) {
			request.setAttribute("list", list);
			request.setAttribute("pageNavi", pageData.getPageNavi());
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/other/Other_keyboard.jsp");
			view.forward(request, response);
		} else {
			response.sendRedirect("/views/other/Error.html");
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
