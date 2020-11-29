package product.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import product.model.dao.ComponentDAO;
import product.model.vo.Product;
public class ComponentService {
	private ComponentDAO conponentdao;
	
	private JDBCTemplate factory;
	public ComponentService() {
		factory = JDBCTemplate.getConnection();
	}
	
//	private ComponentDAO ComponentDAO;
	
	
	
	
	// COMPONENT LIST
//	public ArrayList<Product> productList() {
//		ArrayList<Product> productList = null;
//		Connection conn = null;
//		try {
//			conn = factory.createConnection();
//			productList = new ComponentDAO().productList(conn);
//			JDBCTemplate.close(conn);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return productList ;
//	}

	
//	CPU
	public ArrayList<Product> cpuList() {
		ArrayList<Product> cpuList = null;
		Connection conn = null;
		
		try {
			conn = factory.createConnection();
			cpuList = new ComponentDAO().cpuList(conn);
			JDBCTemplate.close(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cpuList;
	}
	
	
	
//	MainBoard
	public ArrayList<Product> mboardbList() {
		ArrayList<Product> mboardList = null;
		Connection conn = null;
		
		try {
			conn = factory.createConnection();
			mboardList = new ComponentDAO().mboardList(conn);
			JDBCTemplate.close(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mboardList;
	}
	
	
	
//	Cooler
	public ArrayList<Product> coolerList() {
		ArrayList<Product> coolerList = null;
		Connection conn = null;
		
		try {
			conn = factory.createConnection();
			coolerList = new ComponentDAO().coolerList(conn);
			JDBCTemplate.close(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return coolerList;
	}
	
	
	
//	GPU(GCARD)
	public ArrayList<Product> gcardList() {
		ArrayList<Product> gcardList = null;
		Connection conn = null;
		
		try {
			conn = factory.createConnection();
			gcardList = new ComponentDAO().gcardList(conn);
			JDBCTemplate.close(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return gcardList;
	}
	
	
	
//	HDD
	public ArrayList<Product> hddList() {
		ArrayList<Product> hddList = null;
		Connection conn = null;
		
		try {
			conn = factory.createConnection();
			hddList = new ComponentDAO().hddList(conn);
			JDBCTemplate.close(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hddList;
	}
	
	
	
//	POWER
	public ArrayList<Product> powerList() {
		ArrayList<Product> powerList = null;
		Connection conn = null;
		
		try {
			conn = factory.createConnection();
			powerList = new ComponentDAO().powerList(conn);
			JDBCTemplate.close(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return powerList;
	}
	
	
	
//	RAM
	public ArrayList<Product> ramList() {
		ArrayList<Product> ramList = null;
		Connection conn = null;
		
		try {
			conn = factory.createConnection();
			ramList = new ComponentDAO().ramList(conn);
			JDBCTemplate.close(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ramList;
	}
	
	
	
//	SKIN
	public ArrayList<Product> skinList() {
		ArrayList<Product> skinList = null;
		Connection conn = null;
		
		try {
			conn = factory.createConnection();
			skinList = new ComponentDAO().skinList(conn);
			JDBCTemplate.close(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return skinList;
	}
	
	
	
//	SSD
	public ArrayList<Product> ssdList() {
		ArrayList<Product> ssdList = null;
		Connection conn = null;
		
		try {
			conn = factory.createConnection();
			ssdList = new ComponentDAO().ssdList(conn);
			JDBCTemplate.close(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ssdList;
	}
	
	
	//	DESKTOP
	public ArrayList<Product> deskList() {
		ArrayList<Product> deskList = null;
		Connection conn = null;
		
		try {
			conn = factory.createConnection();
			deskList = new ComponentDAO().deskList(conn);
			JDBCTemplate.close(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return deskList;
	}
	
	
	//	KEY BOARD
	public ArrayList<Product> keyList() {
		ArrayList<Product> keyList = null;
		Connection conn = null;
		
		try {
			conn = factory.createConnection();
			keyList = new ComponentDAO().keyList(conn);
			JDBCTemplate.close(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return keyList;
	}
	
	
	
//	MOUSE
	public ArrayList<Product> mouseList() {
		ArrayList<Product> mouseList = null;
		Connection conn = null;
		
		try {
			conn = factory.createConnection();
			mouseList = new ComponentDAO().mouseList(conn);
			JDBCTemplate.close(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mouseList;
	}
	
	
	
//	HEAD SET
	public ArrayList<Product> headSetList() {
		ArrayList<Product> headSetList = null;
		Connection conn = null;
		
		try {
			conn = factory.createConnection();
			headSetList = new ComponentDAO().headSetList(conn);
			JDBCTemplate.close(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return headSetList;
	}
	
	
	
//	SPEAKER
	public ArrayList<Product> speakerList() {
		ArrayList<Product> speakerList = null;
		Connection conn = null;
		
		try {
			conn = factory.createConnection();
			speakerList = new ComponentDAO().speakerList(conn);
			JDBCTemplate.close(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return speakerList;
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
