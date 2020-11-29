package community.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import community.model.service.CommunityService;
import community.model.vo.Review;

/**
 * Servlet implementation class ReviewModifyServlet
 */
@WebServlet("/review/modify")
public class ReviewModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommunityService communityservice;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int uploadFileSizeLimit = 5*1024*1024;
		String encType = "UTF-8";
		String uploadFilePath = request.getServletContext().getRealPath("/rupload");
		MultipartRequest multi = new MultipartRequest(request, uploadFilePath, uploadFileSizeLimit, encType, new DefaultFileRenamePolicy());
		File multiFile = multi.getFile("image");
		String systemFileName = multi.getFilesystemName("image");
		String filePath = multiFile.getPath();
		
		Review review = new Review();
		review.setReviewNo(Integer.parseInt(multi.getParameter("reviewNo")));
		review.setrTitle(multi.getParameter("title"));
		review.setrContents(multi.getParameter("contents"));
		review.setrFilename(systemFileName);
		review.setrFilepath(filePath);
		
		System.out.println("title : " + multi.getParameter("title"));
		System.out.println("contents : " + multi.getParameter("contents"));
		
		System.out.println("reviewNo : " + Integer.parseInt(multi.getParameter("reviewNo")));
//		int reviewNo = Integer.parseInt(request.getParameter("reviewNo"));
		int result = new CommunityService().modifyReview(review);
		if(result > 0) {
			response.sendRedirect("/review/main");
		} else {
			request.getRequestDispatcher("/WEB-INF/views/community/error.html").forward(request, response);
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
