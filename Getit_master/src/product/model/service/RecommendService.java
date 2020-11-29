package product.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import product.model.dao.RecommendDao;
import product.model.vo.PageData;
import product.model.vo.Product;

public class RecommendService {
	private RecommendDao recommeddao;
	
	public JDBCTemplate factory;
	
	public RecommendService() {
		factory = JDBCTemplate.getConnection();
	}

	public PageData recommendAll(int currentPage){
		Connection conn = null;
		int recordCountPerPage = 16;
		int naviCountPerPage = 5;
		PageData pagedata = new PageData();
		try {
			conn = factory.createConnection();
			pagedata.setPageList(new RecommendDao().recommendAll(conn,currentPage,recordCountPerPage));
			pagedata.setPageNavi(new RecommendDao().getPageNavi(conn,currentPage,recordCountPerPage,naviCountPerPage));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return pagedata;
	}
	
	public PageData recommendReview(int currentPage, String pCode, String pFilename) {
		Connection conn = null;
		int recordCountPerPage = 5;
		int naviCountPerPage=5;
		PageData pagedata = new PageData();
		try {
			conn = factory.createConnection();
//			pagedata.setPageList(new RecommendDao().recommendDetail(conn,pCode));
			pagedata.setPageReList(new RecommendDao().recommendReview(conn,currentPage,recordCountPerPage,pCode));
			pagedata.setPageNavi(new RecommendDao().reviewPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage,pCode, pFilename));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return pagedata;
	}
	// 완제품 상세내용 가져오는 메소드
	public ArrayList<Product> recommendDetail(String pCode) {
		Connection conn = null;
		ArrayList<Product> productList = null;
		try {
			conn = factory.createConnection();
			productList = new RecommendDao().recommendDetail(conn,pCode);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return productList;
	}
	// 사무용,게임용,그래픽용,방송용 별로 가져오는 메소드
	public PageData recommendFilter(int currentPage, String category){
		Connection conn = null;
		PageData pagedata = new PageData();
		int recordCountPerPage = 16;
		int naviCountPerPage = 5;
		try {
			conn = factory.createConnection();
			pagedata.setPageList(new RecommendDao().recommendFilter(conn,currentPage,recordCountPerPage,category));
			pagedata.setPageNavi(new RecommendDao().getFilterNavi(conn,currentPage,recordCountPerPage,naviCountPerPage,category));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return pagedata;
	}
	
	// 검색 기능 메소드
	public PageData recommendSearch(int currentPage,String search) {
		Connection conn = null;
		PageData pagedata = new PageData();
		int recordCountPerPage = 16;
		int naviCountPerPage = 5;
		try {
			conn = factory.createConnection();
			pagedata.setPageList(new RecommendDao().recommendSearch(conn,currentPage,recordCountPerPage,search));
			pagedata.setPageNavi(new RecommendDao().getSearchNavi(conn,currentPage,recordCountPerPage,naviCountPerPage,search));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return pagedata;
	}
	
	// 가격대 별로 가져오는 메소드
	public PageData recommendPrice(int currentPage, String category, String pricegrade) {
		Connection conn = null;
		PageData pagedata = new PageData();
		int recordCountPerPage = 16;
		int naviCountPerPage = 5;
		try {
			conn = factory.createConnection();
			pagedata.setPageList(new RecommendDao().recommendPrice(conn,currentPage,recordCountPerPage,category,pricegrade));
			pagedata.setPageNavi(new RecommendDao().getPriceNavi(conn,currentPage,recordCountPerPage,naviCountPerPage,category,pricegrade));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return pagedata;
	}
	
	// 후기 등록
	public int insertReview(String pCode, String memberId,String title,String contents) {
		int result =0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			result = new RecommendDao().insertReview(conn,pCode,memberId,title,contents);
			if(result>0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}
	
	// 후기 삭제
	public int reviewDelete(String pCode,String memberId, int reviewNo) {
		Connection conn = null;
		int result = 0;
		try {
			conn = factory.createConnection();
			result = new RecommendDao().reviewDelete(conn,pCode,memberId,reviewNo);
			if(result>0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}
	
	public int reviewUpdate(String memberId, String pCode, String title, String contents,int reviewNo) {
		Connection conn = null;
		int result = 0;
		try {
			conn = factory.createConnection();
			result = new RecommendDao().reviewUpdate(conn,memberId,pCode,title,contents,reviewNo);
			if(result>0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}
	
	// 상품등록
	public int recommendInsert(Product product, String systemFileName){
		Connection conn = null;
		int result =0;
		try {
			conn = factory.createConnection();
			result = new RecommendDao().recommendInsert(conn, product, systemFileName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			JDBCTemplate.close(conn);
		}
		return result;
	}
}
