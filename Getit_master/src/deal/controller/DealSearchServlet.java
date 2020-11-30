package deal.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.tagext.PageData;

import deal.model.service.DealService;
import deal.model.vo.Deal;
import deal.model.vo.DealPageData;

/**
 * Servlet implementation class DealSearchServlet
 */
@WebServlet("/deal/search")
public class DealSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DealService DealService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DealSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int dealPageNo = 0;
		
		if (request.getParameter("dealPageNo") == null) {
			dealPageNo = 1;
		} else {
			dealPageNo = Integer.parseInt(request.getParameter("dealPageNo"));
		}
		
		String search = request.getParameter("search");
		DealPageData dealPageData = new DealService().dealSearchList(search, dealPageNo);
		ArrayList<Deal> dList = dealPageData.getDealPageList();
		
		if (!dList.isEmpty()) {
			request.setAttribute("dList", dList);
			request.setAttribute("dealPageNavi", dealPageData.getDealPageNavi());
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/deal/dealMain.jsp");
			view.forward(request, response);
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('검색된 게시물이 없습니다.'); location.href='/deal/main';</script>");
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
