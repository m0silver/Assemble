package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class payCompleteServlet
 */
@WebServlet("/member/payComplete")
public class payCompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberservice;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public payCompleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(); 
		 String address=((Member)session.getAttribute("member")).getAddress();
		 String detailAddress =((Member)session.getAttribute("member")).getDetailAddress();
		 String zipcode =((Member)session.getAttribute("member")).getZipcode();
		 
		 StringBuilder sb = new StringBuilder();
		 sb.append(address);
		 sb.append(detailAddress);
		 sb.append(zipcode);
		 
		 sb.toString();
		
		String pCode = request.getParameter("pCode");
		String userId = request.getParameter("userId");
		int allPrice = Integer.parseInt(request.getParameter("allPrice"));
		
		
		int result = new MemberService().insertPay(pCode, userId, sb, allPrice);
		
		if(result>0) {
			
			 response.setContentType("text/html; charset=UTF-8");
				PrintWriter writer = response.getWriter();
				writer.println("<script>alert('결제가 완료 되었습니다.'); location.href='/WEB-INF/views/member/orderInfo.jsp';</script>"); 
				writer.close();
			 
		 }else {
			 response.setContentType("text/html; charset=UTF-8");
				PrintWriter writer = response.getWriter();
				writer.println("<script>alert('결제 실패! 다시 시도해주세요.'); location.href='/basket.jsp';</script>"); 
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
