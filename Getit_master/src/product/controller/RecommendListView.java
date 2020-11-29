package product.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import product.model.service.RecommendService;
import product.model.vo.PageData;
import product.model.vo.Product;

/**
 * Servlet implementation class RecommendListView
 */
@WebServlet("/recommend/listview")
public class RecommendListView extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RecommendService recommendservice;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecommendListView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int currentPage =0;
		if(request.getParameter("currentPage")==null) {
			currentPage =1;
		}else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		PageData pagedata = new PageData();
		ArrayList<Product> recomList = new ArrayList<Product>();
		// 카테고리 분류
		String category = request.getParameter("category");
		// 가격등급이 null인 경우
		if(request.getParameter("pricegrade")==null) {
		 // 첫화면 or 전체를 눌렀을 때
		if(category==null || category.equals("전체")) {
			pagedata = new RecommendService().recommendAll(currentPage); 
			recomList = pagedata.getPageList();
		}
		//  첫화면 and 전체화면이 아닐 때
		else{  
			/* if(!(category==null && category.equals("전체"))) */
			pagedata = new RecommendService().recommendFilter(currentPage,category);
			recomList = pagedata.getPageList();
		}
		}
		else {
		//	첫화면 and 전체화면 아니면서 가격으로 분류 했을 때
			String pricegrade = request.getParameter("pricegrade");
			pagedata = new RecommendService().recommendPrice(currentPage,category,pricegrade);
			recomList = pagedata.getPageList();
		}
		
		if(!recomList.isEmpty()&&recomList!=null) {
			request.setAttribute("recomList", recomList);
			request.setAttribute("pageNavi", pagedata.getPageNavi());
			request.getRequestDispatcher("/WEB-INF/views/recommend/recommendMain.jsp").forward(request, response);
		}else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('해당 상품이 없습니다.'); location.href='/recommend/listview'; </script>");
			writer.close();
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
