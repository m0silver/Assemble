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
import product.model.vo.ProductReview;

/**
 * Servlet implementation class OtherContentServlet
 */
@WebServlet("/other/content")
public class OtherContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OtherService otherservice;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OtherContentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pCode = request.getParameter("pCode");
		Product product = new OtherService().selectOther(pCode);
		
		int currentPage = 0;
		if(request.getParameter("currentPage") == null) {
			currentPage = 1;
		} else { 
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		PageData pageData = new OtherService().selectOtherReview(currentPage, pCode);
		ArrayList<ProductReview> list = pageData.getPageReList();
		if(product != null) {
			request.setAttribute("content", product);
			request.setAttribute("list", list);
			request.setAttribute("pageReNavi", pageData.getPageReNavi());
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/other/Other_contents.jsp");
			view.forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/views/Error.jsp").forward(request, response);
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
