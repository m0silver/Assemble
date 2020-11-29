package deal.controller;

import java.io.File;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import deal.model.service.DealService;
import deal.model.vo.Deal;

/**
 * Servlet implementation class DealWriteServlet
 */
@WebServlet("/deal/write")
public class DealWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DealService DealService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DealWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
		// 여기부터는 사진 파일에 대한 내용
		// MultipartRequest 밑으로는 request를 쓰면 안됨
		
		// String fileUserId = ((Member)session.getAttribute("member")).getMemberId();
		int uploadImageSize = 5*1024*1024;
		String encType = "utf-8";
		
		// 웹서버내의 파일 절대경로
		String uploadImagePath = request.getServletContext().getRealPath("\\img");
		MultipartRequest multi = new MultipartRequest(request, uploadImagePath, uploadImageSize, encType, new DefaultFileRenamePolicy());
		File multiFile = multi.getFile("image");
	    String systemImageName = multi.getFilesystemName("image");
	    String filePath = multiFile.getPath();
		
	    Deal deal = new Deal();
	    deal.setDealTitle(multi.getParameter("title"));
	    deal.setDealContents(multi.getParameter("contents"));
	    deal.setDealPrice(Integer.parseInt(multi.getParameter("price")));
	    deal.setDealFileName(systemImageName);
	    deal.setDealFilePath(filePath);
	    deal.setMemberId(multi.getParameter("memberId"));

	    int result = new DealService().insertDeal(deal);
	    
//	    String memberId = deal.getMemberId();
//	    String memberId = ((Member)session.getAttribute("member")).getMemberId();
//		if (session != null && (session.getAttribute("deal")!=null)) {
//			memberId = ((Member)session.getAttribute("member")).getMemberId();
			if (result > 0) {
				response.sendRedirect("/deal/main");
			} else {
				// insert가 실패했을때 넣을 메시지!
			}
			
//		} else {
//			// 로그인을 하지 않았을때 넣을 메시지!
//		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
