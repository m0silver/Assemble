package deal.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import deal.model.service.DealService;
import deal.model.vo.Deal;

/**
 * Servlet implementation class DealModifyFormServlet
 */
@WebServlet("/deal/modifyform")
public class DealModifyFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DealService DealService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DealModifyFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int dealNo = Integer.parseInt(request.getParameter("dealNo"));
		Deal deal = new DealService().selectDeal(dealNo);
		
		if (deal != null) {
			request.setAttribute("deal", deal);
			request.getRequestDispatcher("/WEB-INF/views/deal/dealModify.jsp").forward(request, response);
		} else {
			// 수정이 불가능할때 나올 코드!
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
