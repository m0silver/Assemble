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
 * Servlet implementation class enrollServlet
 */
@WebServlet("/member/enroll")
public class enrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberservice;

    /**
     * Default constructor. 
     */
    public enrollServlet() {
    	super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩처리
		request.setCharacterEncoding("utf-8");
		//2. views 에서 보낸 값 변수에 저장
		
		Member member = new Member();
		
		// 데이터를 매개변수로 하나씩 하나씩 넘겨도 되지만
		// 멤버 객체 담아서 한꺼번에 보내도록 함.
		
		member.setMemberId(request.getParameter("userId"));
		member.setEmail(request.getParameter("email"));
		member.setMemberName(request.getParameter("userName"));
		member.setMemberPwd(request.getParameter("userPwd"));
		member.setPhone(request.getParameter("phone"));
		member.setAddress(request.getParameter("address"));
		member.setDetailAddress(request.getParameter("detailAddress"));
		member.setDob(request.getParameter("dob"));
		member.setGender(request.getParameter("gender"));
		member.setZipcode(request.getParameter("zipcode"));
		
		
		// 3. 비지니스 로직 처리 (DB에서 회원정보 저장)
		// DB에 저장한 결과는 int값, 성공하면 1이상, 실패하면 0
		
		int result = new MemberService().insertMember(member);
		
		if(result>0) { //성공
			response.sendRedirect("/mainpage/view");
		}else {//실패
			response.sendRedirect("/views/member/memberError.html");
			
			
			
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
