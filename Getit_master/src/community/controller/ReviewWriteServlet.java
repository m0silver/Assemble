package community.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import community.model.service.CommunityService;
import community.model.vo.Review;
import member.model.vo.Member;

/**
 * Servlet implementation class ReviewWriteServlet
 */
@WebServlet("/review/write")
public class ReviewWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommunityService communityservice;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
		int uploadFileSizeLimit = 5*1024*1024;
		String encType = "UTF-8";
		String uploadFilePath = request.getServletContext().getRealPath("/rupload");
		MultipartRequest multi = new MultipartRequest(request, uploadFilePath, uploadFileSizeLimit, encType, new DefaultFileRenamePolicy());
		File multiFile = multi.getFile("image");
		String systemFileName = multi.getFilesystemName("image");
		String filePath = multiFile.getPath();
		
		Review review = new Review();
		review.setrTitle(multi.getParameter("title"));
		review.setrContents(multi.getParameter("contents"));
		review.setrFilename(systemFileName);
		review.setrFilepath(filePath);
		
		if(session != null && (session.getAttribute("member") != null)) {
			String userId = ((Member)session.getAttribute("member")).getMemberId();
			int result = new CommunityService().insertReview(review, userId);
			if(result > 0) {
				response.sendRedirect("/review/main");
			} else {
				RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/community/error.html");
				view.forward(request, response);
			}
		} else {
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/community/login_error.html");
			view.forward(request, response);
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
