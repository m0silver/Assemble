package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class MyPageServlet
 */
@WebServlet("/member/mypage")
public class MyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberservice;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userId = request.getParameter("userId");
		
		Member member = new MemberService().selectMember(userId);
		
		if(member !=null) {
			request.setAttribute("member", member);
			request.getRequestDispatcher("/WEB-INF/views/member/myPage.jsp").forward(request, response);
		}else {
			response.sendRedirect("/WEB-INF/views/member/memberError.html");
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
