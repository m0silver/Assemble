package main.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import deal.model.service.DealService;
import deal.model.vo.Deal;
import main.model.service.MainService;
import product.model.vo.Product;

/**
 * Servlet implementation class MainPageView
 */
@WebServlet("/mainpage/view")
public class MainPageView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainPageView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 넘겨받은 파라미터 값 인코딩 처리
		request.setCharacterEncoding("utf-8");
		// 화면에 넘겨줄 완제품, 조립부품, 기타부품, 중고거래 데이터 불러오기
		// Product클래스를 리스트로 만들어서 전체 데이터를 가져옴
		ArrayList<Product> productList = new MainService().selectAllProduct();
//		System.out.println(productList.size());
		ArrayList<Deal> dList = new MainService().selectAllDeal();
		request.setAttribute("dList", dList);
		request.setAttribute("productList", productList);
		request.getRequestDispatcher("/WEB-INF/views/main/index.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
