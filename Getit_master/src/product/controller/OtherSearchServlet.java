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
 * Servlet implementation class OtherSearchServlet
 */
@WebServlet("/other/search")
public class OtherSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OtherService otherservice;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OtherSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int currentPage = 0;
		if(request.getParameter("currentPage") == null) {
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		String search = request.getParameter("search1");
		PageData pageData = new OtherService().otherSearchList(search, currentPage);
		ArrayList<Product> nList = pageData.getPageList();
		if(!nList.isEmpty()) {
			request.setAttribute("nList", nList);
			request.setAttribute("pageNavi", pageData.getPageNavi());
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/other/Other_search.jsp");
			view.forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/views/other/otherError.html").forward(request, response);
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
