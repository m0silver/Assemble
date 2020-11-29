package deal.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import deal.model.service.DealService;
import deal.model.vo.Deal;
import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class DealSelectServlet
 */
@WebServlet("/deal/select")
public class DealSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DealService DealService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DealSelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String memberId = ((Member)session.getAttribute("member")).getMemberId();
		
		int dealNo = Integer.parseInt(request.getParameter("dealNo"));
		Deal deal = new DealService().selectDeal(dealNo);
		Member member = new MemberService().selectMember(memberId);
		
		if (deal != null) {
			request.setAttribute("contents", deal);
			session.setAttribute("member", member);
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/deal/dealContents.jsp");
			view.forward(request, response);
		} else {
			// 게시물 내용 불러오지못할때 오류코드!
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
