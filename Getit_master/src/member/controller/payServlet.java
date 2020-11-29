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
import product.model.vo.Product;

/**
 * Servlet implementation class payServlet
 */
@WebServlet("/member/pay")
public class payServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberservice;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public payServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
				
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("member");
		
		String pCode = request.getParameter("pCode");
		/*
		 * String pName = request.getParameter("pName"); String pPrice =
		 * request.getParameter("pPrice");
		 */
		Product product = new MemberService().selectProduct(pCode);
		
		if(product != null) {
			request.setAttribute("pCode", pCode);
			session.setAttribute("member", member);
			request.setAttribute("product", product);
			request.getRequestDispatcher("/WEB-INF/views/member/pay.jsp").forward(request, response);
		}
		else {
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
