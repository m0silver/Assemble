package deal.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import deal.model.service.DealService;
import deal.model.vo.Deal;

/**
 * Servlet implementation class DealModifyServlet
 */
@WebServlet("/deal/modify")
public class DealModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DealService DealService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DealModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// HttpSession session = request.getSession();
		
		// 여기부터는 사진 파일에 대한 내용
		// MultipartRequest 밑으로는 request를 쓰면 안됨
		
		// String fileUserId = ((Member)session.getAttribute("member")).getMemberId();
		int uploadImageSize = 5*1024*1024;
		String encType = "utf-8";
		
		// 웹서버내의 파일 절대경로
		String uploadImagePath = request.getServletContext().getRealPath("\\WEB-INF\\image");
		MultipartRequest multi = new MultipartRequest(request, uploadImagePath, uploadImageSize, encType, new DefaultFileRenamePolicy());
		File multiFile = multi.getFile("image");
	    String systemImageName = multi.getFilesystemName("image");
	    String filePath = multiFile.getPath();
		
	    Deal deal = new Deal();
	    deal.setDealNo(Integer.parseInt(multi.getParameter("dealNo")));
	    deal.setDealTitle(multi.getParameter("title"));
	    deal.setDealContents(multi.getParameter("contents"));
	    deal.setDealPrice(Integer.parseInt(multi.getParameter("price")));
	    deal.setDealFileName(systemImageName);
	    deal.setDealFilePath(filePath);
	    
	    int result = new DealService().modifyDeal(deal);
		
		if (result > 0) {
			response.sendRedirect("/deal/main");
		} else {
			// 오류 페이지
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
