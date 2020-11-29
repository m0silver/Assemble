package deal.model.service;

import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

import common.JDBCTemplate;
import deal.model.dao.DealDAO;
import deal.model.vo.Deal;
import deal.model.vo.DealPageData;

public class DealService {
	private DealDAO DealDAO;
	private JDBCTemplate factory;
	
	public DealService () {
		factory = JDBCTemplate.getConnection();
	}
	
	public int insertDeal(Deal deal) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = factory.createConnection();
			result = new DealDAO().insertDeal(conn, deal);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (result>0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		return result;
	}
	
	
	
	
	
	public int modifyDeal (Deal deal) {
		int result = 0;
		Connection conn = null;
		
		try {
			conn = factory.createConnection();
			result = new DealDAO().modifyDeal(conn, deal);
			
			if (result > 0) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}
	
	
	public int deleteDeal (int dealNo) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = factory.createConnection();
			result = new DealDAO().deleteDeal(conn, dealNo);
			
			if (result > 0) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}
	
	
	
	public DealPageData dealList (int dealPageNo) {
		Connection conn = null;
		DealPageData dpd = new DealPageData();
		int recordCountDealPage = 12;
		int naviCountDealPage = 5;
		
		try {
			conn = factory.createConnection();
			dpd.setDealPageList(new DealDAO().dealList(conn,dealPageNo,recordCountDealPage));
			dpd.setDealPageNavi(new DealDAO().dealPageNavi(conn,dealPageNo,recordCountDealPage,naviCountDealPage));
			dpd.setDealPageNaviNonlogin(new DealDAO().dealPageNaviNonlogin(conn,dealPageNo,recordCountDealPage,naviCountDealPage));
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		
		return dpd;
	}
	
	
	public DealPageData dealSearchList (String search, int dealPageNo) {
		Connection conn = null;
		DealPageData dpd = new DealPageData();
		
		int recordCountDealPage = 12;
		int naviCountDealPage = 5;
		
		try {
			conn = factory.createConnection();
			dpd.setDealPageList(new DealDAO().dealSearchList(conn, search, dealPageNo, recordCountDealPage));
			dpd.setDealPageNavi(new DealDAO().dealSearchPageNavi(conn, search, dealPageNo, recordCountDealPage, naviCountDealPage));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return dpd;
	}
	
	
	
	public Deal selectDeal(int dealNo) {
		Deal deal = null;
		Connection conn = null;
		
		try {
			conn = factory.createConnection();
			deal = new DealDAO().selectDeal(conn, dealNo);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return deal;
	}
	
	
}
