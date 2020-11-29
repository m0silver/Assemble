package community.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import community.model.service.CommunityService;
import member.model.vo.Member;

/**
 * Servlet implementation class QnaComInsert
 */
@WebServlet("/qna/cominsert")
public class QnaComInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommunityService communityservice;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaComInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		int qnaNo  = Integer.parseInt(request.getParameter("qnaNo"));
		String contents = request.getParameter("contents");
		if((Member)session.getAttribute("member")!=null) {
		String memberId = ((Member)session.getAttribute("member")).getMemberId();
		int result = new CommunityService().qnaComInsert(qnaNo,contents,memberId);
		if(result>0) {
		request.setAttribute("qnaNo", qnaNo);
		request.getRequestDispatcher("/qna/detail").forward(request, response);
		}else {
			System.out.println("서비스 요청 실패");
		}
		}
		else {
			PrintWriter writer = response.getWriter();
			response.setContentType("text/html; charset=utf-8");
			writer.println("<script>alert('로그인 후 이용 가능합니다.'); location.href='/qna/detail?qna=" + qnaNo +"</script>");
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
