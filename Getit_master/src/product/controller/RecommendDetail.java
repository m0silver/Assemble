package product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import product.model.service.RecommendService;
import product.model.vo.PageData;
import product.model.vo.Product;
import product.model.vo.ProductReview;

/**
 * Servlet implementation class RecommendDetail
 */
@WebServlet("/recommend/detail")
public class RecommendDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RecommendService recommendservice;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecommendDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// 후기 글 페이징 처리
		int currentPage =0;
		
		if(request.getParameter("currentPage")==null) {
			currentPage =1;
		}else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		// 전체 리스트에서 선택한 완제품 상품코드 가져오기
		String pCode = request.getParameter("pCode");
		// 해당 완제품 사진이름 저장
		String pFilename = request.getParameter("pFilename");
		// 선택한 완제품에 대한 데이터 불러오기 (매개변수 pCode)
		ArrayList<Product> productList = new RecommendService().recommendDetail(pCode);
		// 후기게시글에 대한 페이징처리 및 데이터 불러오기 (매개변수 currentPage,pCode)
		PageData pagedata = new RecommendService().recommendReview(currentPage,pCode,pFilename);
		ArrayList<ProductReview> reviewList = pagedata.getPageReList();
		// 전체 합계
		int totalPrice = 0;
		
		for(int i=0; i<productList.size(); i++) {
			if(!productList.get(i).getpCode().equals(pCode)) {
				totalPrice += productList.get(i).getpPrice();
			}
		}
		
		if(reviewList!=null) {
			request.setAttribute("totalPrice", totalPrice);
			request.setAttribute("pCode", pCode);
			request.setAttribute("pFilename", pFilename);
			request.setAttribute("reviewpageNavi", pagedata.getPageNavi());
			request.setAttribute("reviewList", reviewList);
			request.setAttribute("productList", productList);
			request.getRequestDispatcher("/WEB-INF/views/recommend/recommendDetail.jsp").forward(request, response);
		}else {
			response.sendRedirect("오류페이지~");
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
