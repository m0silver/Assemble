package community.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import community.model.service.CommunityService;
import community.model.vo.QnA;
import community.model.vo.QnaPageData;

/**
 * Servlet implementation class QnaSearch
 */
@WebServlet("/qna/search")
public class QnaSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommunityService communityservice;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String search = request.getParameter("search");
		int currentPage = 0;
		if(request.getParameter("currentPage")==null) {
			currentPage = 1;
		}else {
			currentPage = Integer.parseInt(request.getParameter("search"));
		}
		QnaPageData pagedata = new CommunityService().qnaSearch(currentPage,search);
		ArrayList<QnA> qnaList = pagedata.getQnaList();
		if(!qnaList.isEmpty()&&qnaList!=null) {
			request.setAttribute("qnaList", qnaList);
			request.setAttribute("getPageNavi", pagedata.getPageNavi());
			request.getRequestDispatcher("/WEB-INF/views/community/qnaReview.jsp").forward(request, response);
		}else {
			System.out.println("오류");
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
