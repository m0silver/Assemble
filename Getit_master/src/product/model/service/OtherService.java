package product.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import common.JDBCTemplate;
import product.model.dao.OtherDAO;
import product.model.vo.PageData;
import product.model.vo.Product;

public class OtherService {
	private JDBCTemplate factory;
	private OtherDAO OtherDAO;
	
	public OtherService() {
		factory = JDBCTemplate.getConnection();
	}
	
	public PageData selectProductList(int currentPage) {
		Connection conn = null;
		int recordCountPerPage = 12;
		int naviCountPerPage = 5;
		PageData pd = new PageData();
		try {
			conn = factory.createConnection();
			pd.setPageList(new OtherDAO().selectOtherList(conn, currentPage, recordCountPerPage));
			pd.setPageNavi(new OtherDAO().getPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return pd;
	}
	
	public PageData selectProductMonitor(int currentPage) {
		Connection conn = null;
		int recordCountPerPage = 12;
		int naviCountPerPage = 5;
		PageData pd = new PageData();
		try {
			conn = factory.createConnection();
			pd.setPageList(new OtherDAO().selectMonitorList(conn, currentPage, recordCountPerPage));
			pd.setPageNavi(new OtherDAO().getMonitorPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return pd;
	}
	
	public PageData selectProductKeyboard(int currentPage) {
		Connection conn = null;
		int recordCountPerPage = 12;
		int naviCountPerPage = 5;
		PageData pd = new PageData();
		try {
			conn = factory.createConnection();
			pd.setPageList(new OtherDAO().selectKeyboardList(conn, currentPage, recordCountPerPage));
			pd.setPageNavi(new OtherDAO().getKeyboardPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return pd;
	}
	
	public PageData selectProductMouse(int currentPage) {
		Connection conn = null;
		int recordCountPerPage = 12;
		int naviCountPerPage = 5;
		PageData pd = new PageData();
		try {
			conn = factory.createConnection();
			pd.setPageList(new OtherDAO().selectMouseList(conn, currentPage, recordCountPerPage));
			pd.setPageNavi(new OtherDAO().getMousePageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return pd;
	}
	
	public PageData selectProductSpeaker(int currentPage) {
		Connection conn = null;
		int recordCountPerPage = 12;
		int naviCountPerPage = 5;
		PageData pd = new PageData();
		try {
			conn = factory.createConnection();
			pd.setPageList(new OtherDAO().selectSpeakerList(conn, currentPage, recordCountPerPage));
			pd.setPageNavi(new OtherDAO().getSpeakerPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return pd;
	}
	
	public PageData selectProductHeadset(int currentPage) {
		Connection conn = null;
		int recordCountPerPage = 12;
		int naviCountPerPage = 5;
		PageData pd = new PageData();
		try {
			conn = factory.createConnection();
			pd.setPageList(new OtherDAO().selectHeadsetList(conn, currentPage, recordCountPerPage));
			pd.setPageNavi(new OtherDAO().getHeadsetPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return pd;
	}
	
	public Product selectOther(String pCode) {
		Product product = null;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			product = new OtherDAO().selectOther(conn, pCode);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return product;
	}
	
	public PageData otherSearchList(String search, int currentPage) {
		Connection conn = null;
		PageData pd = new PageData();
		int recordCountPerPage = 12;
		int naviCountPerPage = 5;
		try {
			conn = factory.createConnection();
			pd.setPageList(new OtherDAO().otherSearchList(conn, search, currentPage, recordCountPerPage));
			pd.setPageNavi(new OtherDAO().getSearchPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage, search));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return pd;
	}
	
	public PageData selectOtherReview(int currentPage, String pCode) {
		Connection conn = null;
		int recordCountPerPage = 5;
		int naviCountPerPage = 5;
		PageData pd = new PageData();
		try {
			conn = factory.createConnection();
			// setPageList() 메소드는 10개의 게시물을 저장
			pd.setPageReList(new OtherDAO().selectOtherReview(conn, currentPage, recordCountPerPage, pCode));
			// setPageNavi() 메소드는 a링크 10개를 저장
			pd.setPageReNavi(new OtherDAO().getOtherReviewPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage, pCode));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);			
		}
		return pd;
	}
	
	public int insertReview(String title, String contents, String pCode, String userId) {
		Connection conn = null;
		int result = 0;
		try {
			conn = factory.createConnection();
			result = new OtherDAO().insertReview(conn, title, contents, pCode, userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}
}
