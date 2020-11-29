package product.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import product.model.service.RecommendService;
import product.model.vo.Product;

/**
 * Servlet implementation class RecommendInsert
 */
@WebServlet("/recommend/insert")
public class RecommendInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RecommendService recommendservice;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecommendInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//------------------------------------ 업로드 된 파일을 upload폴더와 DB에 insert ---------------------------------------------
// WebContent는 개발하기 위한 workspace에 있는 폴더의 directory, 실행을 시키면 웹이 배포되는 서버에 옮겨짐		
		
		// WebContent/upload 저장
		// 파일을 업로드한 사용자를 가져옴
//		HttpSession session = request.getSession();
//		String fileUserId = ((Member)session.getAttribute("member")).getMemberId();
		// 파일 최대 사이즈 5MB로 제한
		int uploadFileSizeLimit = 5*1024*1024;
		// 인코딩 타입
		String encType = "utf-8";
		// 업로드 파일 경로(절대 경로), 실제 배포된 앱서버에서의 경로
		// 업로드한 파일은 개발하는 워크스페이스의 경로가 아닌 서버상의 웹어플리케이션의 임시 저장공간에 올라감 
		// getServletContext().getRealPath("업로드할 파일") -> 서버상에서 업로드한 파일이 들어가는 절대 경로를 가져옴
		String uploadFilePath = request.getServletContext().getRealPath("/upload");
		MultipartRequest multi
		= new MultipartRequest(request,uploadFilePath,uploadFileSizeLimit,encType, new DefaultFileRenamePolicy());
		// 서버상에 업로드된 파일에 대한 정보는 파일객체를 통해 가져온다.
//		File multiFile = multi.getFile("upFile");
		File multiFile = multi.getFile("upFile");
		String systemFileName = multi.getFilesystemName("upFile");
		String filePath = multiFile.getPath();
		// input태그의 값을 DB로 넘겨줌
		Product product = new Product();
		product.setpCode(multi.getParameter("pCode"));
		product.setSepCode(multi.getParameter("sepCode"));
		product.setpName(multi.getParameter("pName"));
		product.setpPrice(Integer.parseInt(multi.getParameter("pPrice")));
		product.setpContents(multi.getParameter("pContents"));
		product.setpCategory(multi.getParameter("category"));
		product.setpComcode(multi.getParameter("pComcode"));
		product.setRelatedProduct(multi.getParameter("relatedProduct"));
		product.setpFilepath(filePath);
//		System.out.println(recommend.toString());
//		System.out.println(systemFileName);
		// 매개변수 (완제품 입력값, 업로드파일이름,파일절대경로), 관리자 계정만 사용가능한 서블릿
		int result = new RecommendService().recommendInsert(product,systemFileName);
		if(result>0) {
			request.getRequestDispatcher("/recommendenroll/view").forward(request, response);
		}else {
			response.sendRedirect("/WEB-INF/views/service/ServiceError.html");
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
