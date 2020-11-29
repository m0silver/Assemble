package community.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import community.model.service.CommunityService;
import community.model.vo.Comments;
import community.model.vo.QnA;

/**
 * Servlet implementation class QnaDetail
 */
@WebServlet("/qna/detail")
public class QnaDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommunityService communityservice;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		int qnaNo = Integer.parseInt(request.getParameter("qnaNo"));
		QnA qna = new CommunityService().qnaDetail(qnaNo);
		ArrayList<Comments> qnaComList = new CommunityService().commentsList(qnaNo);
		if(qna!=null) {
			request.setAttribute("qnaComList", qnaComList);
			request.setAttribute("qna", qna);
			request.getRequestDispatcher("/WEB-INF/views/community/qnacomment.jsp").forward(request, response);
		}else {
			System.out.println("서비스요청 실패");
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
