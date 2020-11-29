package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class BasketSelfInsertServlet
 */
@WebServlet("/basketS/insert")
public class BasketSelfInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberservice;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BasketSelfInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
		String cpu = request.getParameter("sendCPU");
		String mboard = request.getParameter("sendMainBoard");
		String ram = request.getParameter("sendRAM");
		String gcard = request.getParameter("sendGCARD");
		String cooler = request.getParameter("sendCOOLER");
		String ssd = request.getParameter("sendSSD");
		String power = request.getParameter("sendPOWER");
		String skin = request.getParameter("sendSKIN");
		String hdd = request.getParameter("sendHDD");
		String desktop = request.getParameter("sendDESKTOP");
		String keyboard = request.getParameter("sendKEYBOARD");
		String mouse = request.getParameter("sendMOUSE");
		String headset = request.getParameter("sendHEADSET");
		String speaker = request.getParameter("sendSPEAKER");
		
		String[] component = new String[14];
		component[0] = cpu;
		component[1] = mboard;
		component[2] = ram;
		component[3] = gcard;
		component[4] = cooler;
		component[5] = ssd;
		component[6] = power;
		component[7] = skin;
		component[8] = hdd;
		component[9] = desktop;
		component[10] = keyboard;
		component[11] = mouse;
		component[12] = headset;
		component[13] = speaker;

		
		if(session != null && (session.getAttribute("member") != null)) {
			String memberId = ((Member)session.getAttribute("member")).getMemberId();
			int result = new MemberService().basketSelfInsert(memberId, component);
			if(result > 0) {
				request.getRequestDispatcher("/mainpage/view").forward(request, response);
			}else {
				System.out.println("오류");
			}
		} else {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('로그인 후 이용 가능합니다.'); location.href='/login.html';</script>");
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
