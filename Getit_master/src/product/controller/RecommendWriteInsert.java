package product.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.vo.Member;
import product.model.service.RecommendService;


/**
 * Servlet implementation class RecommendWrite
 */
@WebServlet("/recommend/writeinsert")
public class RecommendWriteInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RecommendService recommendservice;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecommendWriteInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// 회원아이디받아야함
		HttpSession session = request.getSession();
		String memberId = ((Member)session.getAttribute("member")).getMemberId();
		// 완제품 코드 
		String pCode = request.getParameter("pCode");
		// 완제품 사진 다시 뿌려줘야 함 ㅁㅊ
		String pFilename = request.getParameter("pFilename");
		// 제목,내용
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		int result  = new RecommendService().insertReview(pCode,memberId,title,contents);
		if(result>0) {
			request.setAttribute("pCode", pCode);
			request.setAttribute("pFilename", pFilename);
			request.getRequestDispatcher("/recommend/detail").forward(request, response);
		}else {
			response.sendRedirect("서비스 요청 실패");
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
