package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class ModifyServlet
 */
@WebServlet("/member/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberservice;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		Member member = new Member();	
		member.setMemberId(request.getParameter("userId"));
		member.setMemberPwd(request.getParameter("userPwdRe"));
		member.setPhone(request.getParameter("phone"));
		member.setZipcode(request.getParameter("zipcode"));
		member.setAddress(request.getParameter("address"));
		member.setDetailAddress(request.getParameter("detailAddress"));
		
		
		int result = new MemberService().updateMember(member);
		
		if(result > 0) {
			request.getRequestDispatcher("/WEB-INF/views/main/index.jsp").forward(request, response);
			
		}else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('수정 오류, 조건에 맞도록 작성 부탁드립니다.'); location.href='/WEB-INF/views/main/index.jsp';</script>"); 
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
