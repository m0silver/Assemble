package deal.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import deal.model.service.DealService;
import deal.model.vo.Deal;
import deal.model.vo.DealPageData;
import member.model.vo.Member;

/**
 * Servlet implementation class DealMain
 */
@WebServlet("/deal/main")
public class DealMain extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DealService DealService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DealMain() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int dealPageNo = 0;
		
		
		if (request.getParameter("dealPageNo")==null) {
			dealPageNo = 1;
		} else {
			dealPageNo = Integer.parseInt(request.getParameter("dealPageNo"));
		}
		
		
		DealPageData dealPageData = new DealService().dealList(dealPageNo);
		ArrayList<Deal> dList = dealPageData.getDealPageList();
		
		if (!dList.isEmpty()) {
			if(((Member)session.getAttribute("member")!=null)){
			Member member = (Member)session.getAttribute("member");
			request.setAttribute("member", member);
			}
			request.setAttribute("dList", dList);
			request.setAttribute("dealPageNavi", dealPageData.getDealPageNavi());
			request.setAttribute("dealPageNaviNonlogin", dealPageData.getDealPageNaviNonlogin());
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/deal/dealMain.jsp");
			view.forward(request, response);
			
		} else {
			// deal 페이지를 불러오지 못할때 코드!
			response.sendRedirect("/views/deal/Error.html");
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
