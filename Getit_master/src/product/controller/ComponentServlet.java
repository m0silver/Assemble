package product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import product.model.service.ComponentService;
import product.model.vo.Product;



@WebServlet("/getit/Component")
public class ComponentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ComponentService componentservice;
    public ComponentServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// 메인부품 List
		ArrayList<Product> cpuList = new ComponentService().cpuList();
		ArrayList<Product> mboardList = new ComponentService().mboardbList();
		ArrayList<Product> coolerList = new ComponentService().coolerList();
		ArrayList<Product> gcardList = new ComponentService().gcardList();
		ArrayList<Product> hddList = new ComponentService().hddList();
		ArrayList<Product> powerList = new ComponentService().powerList();
		ArrayList<Product> ramList = new ComponentService().ramList();
		ArrayList<Product> skinList = new ComponentService().skinList();
		ArrayList<Product> ssdList = new ComponentService().ssdList();
		//기타부품 List
		ArrayList<Product> deskTopList = new ComponentService().deskList();
		ArrayList<Product> keyBoardList = new ComponentService().keyList();
		ArrayList<Product> mouseList = new ComponentService().mouseList();
		ArrayList<Product> headSetList = new ComponentService().headSetList();
		ArrayList<Product> speakerList = new ComponentService().speakerList();
		
		if( !( cpuList.isEmpty() && mboardList.isEmpty() && coolerList.isEmpty() && 
				gcardList.isEmpty() && hddList.isEmpty() && powerList.isEmpty() &&
				ramList.isEmpty() && skinList.isEmpty() && ssdList.isEmpty() &&
				deskTopList.isEmpty() && keyBoardList.isEmpty() && mouseList.isEmpty() && 
				headSetList.isEmpty() && speakerList.isEmpty() )) {
		
//		if( !( cpuList.isEmpty() || mboardList.isEmpty() || coolerList.isEmpty() || 
//				gcardList.isEmpty() || hddList.isEmpty() || powerList.isEmpty() ||
//				ramList.isEmpty() && skinList.isEmpty() && ssdList.isEmpty() &&
//				deskTopList.isEmpty() || keyBoardList.isEmpty() || mouseList.isEmpty() || 
//				headSetList.isEmpty() || speakerList.isEmpty() )) {
//			request.setAttribute("comList", componentList);
			// 메인부품 속성
			request.setAttribute("cpuL", cpuList);
			request.setAttribute("mboardL", mboardList);
			request.setAttribute("coolL", coolerList);
			request.setAttribute("gcardL", gcardList);
			request.setAttribute("hddL", hddList);
			request.setAttribute("powerL", powerList);
			request.setAttribute("ramL", ramList);
			request.setAttribute("skinL", skinList);
			request.setAttribute("ssdL", ssdList);
			// 기타부품 속성
			request.setAttribute("deskTopL", deskTopList);
			request.setAttribute("keyBoardL", keyBoardList);
			request.setAttribute("mouseL", mouseList);
			request.setAttribute("headSetL", headSetList);
			request.setAttribute("speakerL", speakerList );

			request.getRequestDispatcher("/WEB-INF/views/self/ComponentSelfPage.jsp").forward(request, response);
		}else {
			System.out.println("3번이상 안되면 존나 자바삭제");
			System.out.println(cpuList);
		}
}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
