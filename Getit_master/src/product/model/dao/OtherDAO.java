package product.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import product.model.vo.Product;
import product.model.vo.ProductReview;

public class OtherDAO {
	public ArrayList<Product> selectOtherList(Connection conn, int currentPage, int recordCountPerPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Product> list = null;
		String query = "SELECT * FROM (SELECT PRODUCT.*, ROW_NUMBER() OVER(ORDER BY SERIAL_NO) AS NUM FROM PRODUCT WHERE SEP_CODE = 'OTHER') WHERE NUM BETWEEN ? AND ?";
		int start = currentPage * recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage * recordCountPerPage;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			list = new ArrayList<Product>();
			while(rset.next()) {
				Product product = new Product();
				product.setpCode(rset.getString("P_CODE"));
				product.setSerialNo(rset.getInt("SERIAL_NO"));
				product.setSepCode(rset.getString("SEP_CODE"));
				product.setpName(rset.getString("P_NAME"));
				product.setpPrice(rset.getInt("P_PRICE"));
				product.setpAccount(rset.getInt("P_ACCOUNT"));
				product.setpContents(rset.getString("P_CONTENTS"));
				product.setpCategory(rset.getString("P_CATEGORY"));
				product.setpComcode(rset.getString("P_COMCODE"));
				product.setpFilename(rset.getString("P_FILENAME"));
				product.setpFilepath(rset.getString("P_FILEPATH"));
				list.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	
	public ArrayList<Product> selectMonitorList(Connection conn, int currentPage, int recordCountPerPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Product> list = null;
		String query = "SELECT * FROM (SELECT PRODUCT.*, ROW_NUMBER() OVER(ORDER BY SERIAL_NO) AS NUM FROM PRODUCT WHERE P_CATEGORY = 'MONITOR') WHERE NUM BETWEEN ? AND ?";
		int start = currentPage * recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage * recordCountPerPage;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			list = new ArrayList<Product>();
			while(rset.next()) {
				Product product = new Product();
				product.setpCode(rset.getString("P_CODE"));
				product.setSerialNo(rset.getInt("SERIAL_NO"));
				product.setSepCode(rset.getString("SEP_CODE"));
				product.setpName(rset.getString("P_NAME"));
				product.setpPrice(rset.getInt("P_PRICE"));
				product.setpAccount(rset.getInt("P_ACCOUNT"));
				product.setpContents(rset.getString("P_CONTENTS"));
				product.setpCategory(rset.getString("P_CATEGORY"));
				product.setpComcode(rset.getString("P_COMCODE"));
				product.setpFilename(rset.getString("P_FILENAME"));
				product.setpFilepath(rset.getString("P_FILEPATH"));
				list.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	
	public ArrayList<Product> selectKeyboardList(Connection conn, int currentPage, int recordCountPerPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Product> list = null;
		String query = "SELECT * FROM (SELECT PRODUCT.*, ROW_NUMBER() OVER(ORDER BY SERIAL_NO) AS NUM FROM PRODUCT WHERE P_CATEGORY = 'KEYBOARD') WHERE NUM BETWEEN ? AND ?";
		int start = currentPage * recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage * recordCountPerPage;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			list = new ArrayList<Product>();
			while(rset.next()) {
				Product product = new Product();
				product.setpCode(rset.getString("P_CODE"));
				product.setSerialNo(rset.getInt("SERIAL_NO"));
				product.setSepCode(rset.getString("SEP_CODE"));
				product.setpName(rset.getString("P_NAME"));
				product.setpPrice(rset.getInt("P_PRICE"));
				product.setpAccount(rset.getInt("P_ACCOUNT"));
				product.setpContents(rset.getString("P_CONTENTS"));
				product.setpCategory(rset.getString("P_CATEGORY"));
				product.setpComcode(rset.getString("P_COMCODE"));
				product.setpFilename(rset.getString("P_FILENAME"));
				product.setpFilepath(rset.getString("P_FILEPATH"));
				list.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	
	public ArrayList<Product> selectMouseList(Connection conn, int currentPage, int recordCountPerPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Product> list = null;
		String query = "SELECT * FROM (SELECT PRODUCT.*, ROW_NUMBER() OVER(ORDER BY SERIAL_NO) AS NUM FROM PRODUCT WHERE P_CATEGORY = 'MOUSE') WHERE NUM BETWEEN ? AND ?";
		int start = currentPage * recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage * recordCountPerPage;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			list = new ArrayList<Product>();
			while(rset.next()) {
				Product product = new Product();
				product.setpCode(rset.getString("P_CODE"));
				product.setSerialNo(rset.getInt("SERIAL_NO"));
				product.setSepCode(rset.getString("SEP_CODE"));
				product.setpName(rset.getString("P_NAME"));
				product.setpPrice(rset.getInt("P_PRICE"));
				product.setpAccount(rset.getInt("P_ACCOUNT"));
				product.setpContents(rset.getString("P_CONTENTS"));
				product.setpCategory(rset.getString("P_CATEGORY"));
				product.setpComcode(rset.getString("P_COMCODE"));
				product.setpFilename(rset.getString("P_FILENAME"));
				product.setpFilepath(rset.getString("P_FILEPATH"));
				list.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	
	public ArrayList<Product> selectSpeakerList(Connection conn, int currentPage, int recordCountPerPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Product> list = null;
		String query = "SELECT * FROM (SELECT PRODUCT.*, ROW_NUMBER() OVER(ORDER BY SERIAL_NO) AS NUM FROM PRODUCT WHERE P_CATEGORY = 'SPEAKER') WHERE NUM BETWEEN ? AND ?";
		int start = currentPage * recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage * recordCountPerPage;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			list = new ArrayList<Product>();
			while(rset.next()) {
				Product product = new Product();
				product.setpCode(rset.getString("P_CODE"));
				product.setSerialNo(rset.getInt("SERIAL_NO"));
				product.setSepCode(rset.getString("SEP_CODE"));
				product.setpName(rset.getString("P_NAME"));
				product.setpPrice(rset.getInt("P_PRICE"));
				product.setpAccount(rset.getInt("P_ACCOUNT"));
				product.setpContents(rset.getString("P_CONTENTS"));
				product.setpCategory(rset.getString("P_CATEGORY"));
				product.setpComcode(rset.getString("P_COMCODE"));
				product.setpFilename(rset.getString("P_FILENAME"));
				product.setpFilepath(rset.getString("P_FILEPATH"));
				list.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	
	public ArrayList<Product> selectHeadsetList(Connection conn, int currentPage, int recordCountPerPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Product> list = null;
		String query = "SELECT * FROM (SELECT PRODUCT.*, ROW_NUMBER() OVER(ORDER BY SERIAL_NO) AS NUM FROM PRODUCT WHERE P_CATEGORY = 'HEADSET') WHERE NUM BETWEEN ? AND ?";
		int start = currentPage * recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage * recordCountPerPage;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			list = new ArrayList<Product>();
			while(rset.next()) {
				Product product = new Product();
				product.setpCode(rset.getString("P_CODE"));
				product.setSerialNo(rset.getInt("SERIAL_NO"));
				product.setSepCode(rset.getString("SEP_CODE"));
				product.setpName(rset.getString("P_NAME"));
				product.setpPrice(rset.getInt("P_PRICE"));
				product.setpAccount(rset.getInt("P_ACCOUNT"));
				product.setpContents(rset.getString("P_CONTENTS"));
				product.setpCategory(rset.getString("P_CATEGORY"));
				product.setpComcode(rset.getString("P_COMCODE"));
				product.setpFilename(rset.getString("P_FILENAME"));
				product.setpFilepath(rset.getString("P_FILEPATH"));
				list.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	
	public Product selectOther(Connection conn, String pCode) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Product product = null;
		String query = "SELECT * FROM PRODUCT WHERE P_CODE = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, pCode);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				product = new Product();
				product.setpCode(rset.getString("P_CODE"));
				product.setSerialNo(rset.getInt("SERIAL_NO"));
				product.setSepCode(rset.getString("SEP_CODE"));
				product.setpName(rset.getString("P_NAME"));
				product.setpPrice(rset.getInt("P_PRICE"));
				product.setpAccount(rset.getInt("P_ACCOUNT"));
				product.setpContents(rset.getString("P_CONTENTS"));
				product.setpCategory(rset.getString("P_CATEGORY"));
				product.setpComcode(rset.getString("P_COMCODE"));
				product.setpFilename(rset.getString("P_FILENAME"));
				product.setpFilepath(rset.getString("P_FILEPATH"));
				product.setPcFilename(rset.getString("P_CONT_FILENAME"));
				product.setPcFilepath(rset.getString("P_CONT_FILEPATH"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return product;
	}
	
	public ArrayList<Product> otherSearchList(Connection conn, String search, int currentPage, int recordCountPerPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM (SELECT PRODUCT.*, ROW_NUMBER() OVER(ORDER BY SERIAL_NO DESC) AS NUM FROM PRODUCT WHERE P_NAME LIKE ? AND SEP_CODE = 'OTHER') WHERE NUM BETWEEN ? AND ?";
		
		int start = currentPage*recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage*recordCountPerPage;
		
		ArrayList<Product> nList = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+search+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			nList = new ArrayList<Product>();
			while(rset.next()) {
				Product product = new Product();
				product.setpCode(rset.getString("P_CODE"));
				product.setSerialNo(rset.getInt("SERIAL_NO"));
				product.setSepCode(rset.getString("SEP_CODE"));
				product.setpName(rset.getString("P_NAME"));
				product.setpPrice(rset.getInt("P_PRICE"));
				product.setpAccount(rset.getInt("P_ACCOUNT"));
				product.setpContents(rset.getString("P_CONTENTS"));
				product.setpCategory(rset.getString("P_CATEGORY"));
				product.setpComcode(rset.getString("P_COMCODE"));
				product.setpFilename(rset.getString("P_FILENAME"));
				product.setpFilepath(rset.getString("P_FILEPATH"));
				nList.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return nList;
	}
	
	public ArrayList<ProductReview> selectOtherReview(Connection conn, int currentPage, int recordCountPerPage, String pCode) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ProductReview> list = null;
		String query = "SELECT * FROM (SELECT PRODUCT_REVIEW.*, ROW_NUMBER() OVER(ORDER BY PR_REVIEW_NO DESC) AS NUM FROM PRODUCT_REVIEW WHERE P_CODE = ?) WHERE NUM BETWEEN ? AND ?";
		int start = currentPage * recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage * recordCountPerPage;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, pCode);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			list = new ArrayList<ProductReview>();
			while(rset.next()) {
				ProductReview pr = new ProductReview();
				pr.setReviewNo(rset.getInt("PR_REVIEW_NO"));
				pr.setReviewTitle(rset.getString("PR_TITLE"));
				pr.setReviewContents(rset.getString("PR_CONTENTS"));
				pr.setEnrollDate(rset.getDate("PR_DATE"));
				pr.setMemberId(rset.getString("MEMBER_ID"));
				pr.setpCode(rset.getString("P_CODE"));
				list.add(pr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	
	public int insertReview(Connection conn, String title, String contents, String pCode, String userId) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO PRODUCT_REVIEW VALUES(PRODUCT_REVIEW_SEQ.NEXTVAL,?,?,SYSDATE,?,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, title);
			pstmt.setString(2, contents);
			pstmt.setString(3, userId);
			pstmt.setString(4, pCode);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public String getPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage) {
		int recordTotalCount = totalCount(conn);
		int pageTotalCount = 0;
		if(recordTotalCount % recordCountPerPage > 0) {
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		} else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}
		
		if(currentPage < 1) {
			currentPage = 1;
		} else if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}
		
		int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage - 1;
		
		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}
		
		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi == 1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}
		
		StringBuilder sb = new StringBuilder();
		if(needPrev) {
			sb.append("<li class='page-item'><a class='page-link' href='/other/allList?currentPage=" + (startNavi-1) + "'> < </a></li>");
		}
		for(int i = startNavi; i <= endNavi; i++) {
			if(i == currentPage) {
				sb.append("<li class='page-item'><a class='page-link' href='/other/allList?currentPage=" + i + "'>" + i + "</a></li>");
			} else {
				sb.append("<li class='page-item'><a class='page-link' href='/other/allList?currentPage=" + i + "'>" + i + "</a></li>");
			}
		}
		if(needNext) {
			sb.append("<li class='page-item'><a class='page-link' href='/other/allList?currentPage=" + (endNavi+1) + "'> > </a></li>");
		}
		return sb.toString();
	}
	
	public String getMonitorPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage) {
		int recordTotalCount = totalMonitorCount(conn);
		int pageTotalCount = 0;
		if(recordTotalCount % recordCountPerPage > 0) {
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		} else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}
		
		if(currentPage < 1) {
			currentPage = 1;
		} else if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}
		
		int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage - 1;
		
		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}
		
		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi == 1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}
		
		StringBuilder sb = new StringBuilder();
		if(needPrev) {
			sb.append("<li class='page-item'><a class='page-link' href='/other/monitor?currentPage=" + (startNavi-1) + "'> < </a></li>");
		}
		for(int i = startNavi; i <= endNavi; i++) {
			if(i == currentPage) {
				sb.append("<li class='page-item'><a class='page-link' href='/other/monitor?currentPage=" + i + "'>" + i + "</a></li>");
			} else {
				sb.append("<li class='page-item'><a class='page-link' href='/other/monitor?currentPage=" + i + "'>" + i + "</a></li>");
			}
		}
		if(needNext) {
			sb.append("<li class='page-item'><a class='page-link' href='/other/monitor?currentPage=" + (endNavi+1) + "'> > </a></li>");
		}
		return sb.toString();
	}
	
	public String getKeyboardPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage) {
		int recordTotalCount = totalKeyboardCount(conn);
		int pageTotalCount = 0;
		if(recordTotalCount % recordCountPerPage > 0) {
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		} else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}
		
		if(currentPage < 1) {
			currentPage = 1;
		} else if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}
		
		int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage - 1;
		
		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}
		
		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi == 1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}
		
		StringBuilder sb = new StringBuilder();
		if(needPrev) {
			sb.append("<li class='page-item'><a class='page-link' href='/other/keyboard?currentPage=" + (startNavi-1) + "'> < </a></li>");
		}
		for(int i = startNavi; i <= endNavi; i++) {
			if(i == currentPage) {
				sb.append("<li class='page-item'><a class='page-link' href='/other/keyboard?currentPage=" + i + "'>" + i + "</a></li>");
			} else {
				sb.append("<li class='page-item'><a class='page-link' href='/other/keyboard?currentPage=" + i + "'>" + i + "</a></li>");
			}
		}
		if(needNext) {
			sb.append("<li class='page-item'><a class='page-link' href='/other/keyboard?currentPage=" + (endNavi+1) + "'> > </a></li>");
		}
		return sb.toString();
	}
	
	public String getMousePageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage) {
		int recordTotalCount = totalMouseCount(conn);
		int pageTotalCount = 0;
		if(recordTotalCount % recordCountPerPage > 0) {
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		} else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}
		
		if(currentPage < 1) {
			currentPage = 1;
		} else if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}
		
		int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage - 1;
		
		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}
		
		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi == 1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}
		
		StringBuilder sb = new StringBuilder();
		if(needPrev) {
			sb.append("<li class='page-item'><a class='page-link' href='/other/mouse?currentPage=" + (startNavi-1) + "'> < </a></li>");
		}
		for(int i = startNavi; i <= endNavi; i++) {
			if(i == currentPage) {
				sb.append("<li class='page-item'><a class='page-link' href='/other/mouse?currentPage=" + i + "'>" + i + "</a></li>");
			} else {
				sb.append("<li class='page-item'><a class='page-link' href='/other/mouse?currentPage=" + i + "'>" + i + "</a></li>");
			}
		}
		if(needNext) {
			sb.append("<li class='page-item'><a class='page-link' href='/other/mouse?currentPage=" + (endNavi+1) + "'> > </a></li>");
		}
		return sb.toString();
	}
	
	public String getSpeakerPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage) {
		int recordTotalCount = totalSpeakerCount(conn);
		int pageTotalCount = 0;
		if(recordTotalCount % recordCountPerPage > 0) {
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		} else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}
		
		if(currentPage < 1) {
			currentPage = 1;
		} else if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}
		
		int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage - 1;
		
		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}
		
		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi == 1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}
		
		StringBuilder sb = new StringBuilder();
		if(needPrev) {
			sb.append("<li class='page-item'><a class='page-link' href='/other/speaker?currentPage=" + (startNavi-1) + "'> < </a></li>");
		}
		for(int i = startNavi; i <= endNavi; i++) {
			if(i == currentPage) {
				sb.append("<li class='page-item'><a class='page-link' href='/other/speaker?currentPage=" + i + "'>" + i + "</a></li>");
			} else {
				sb.append("<li class='page-item'><a class='page-link' href='/other/speaker?currentPage=" + i + "'>" + i + "</a></li>");
			}
		}
		if(needNext) {
			sb.append("<li class='page-item'><a class='page-link' href='/other/speaker?currentPage=" + (endNavi+1) + "'> > </a></li>");
		}
		return sb.toString();
	}
	
	public String getHeadsetPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage) {
		int recordTotalCount = totalHeadsetCount(conn);
		int pageTotalCount = 0;
		if(recordTotalCount % recordCountPerPage > 0) {
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		} else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}
		
		if(currentPage < 1) {
			currentPage = 1;
		} else if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}
		
		int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage - 1;
		
		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}
		
		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi == 1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}
		
		StringBuilder sb = new StringBuilder();
		if(needPrev) {
			sb.append("<li class='page-item'><a class='page-link' href='/other/headset?currentPage=" + (startNavi-1) + "'> < </a></li>");
		}
		for(int i = startNavi; i <= endNavi; i++) {
			if(i == currentPage) {
				sb.append("<li class='page-item'><a class='page-link' href='/other/headset?currentPage=" + i + "'>" + i + "</a></li>");
			} else {
				sb.append("<li class='page-item'><a class='page-link' href='/other/headset?currentPage=" + i + "'>" + i + "</a></li>");
			}
		}
		if(needNext) {
			sb.append("<li class='page-item'><a class='page-link' href='/other/headset?currentPage=" + (endNavi+1) + "'> > </a></li>");
		}
		return sb.toString();
	}
	
	public String getSearchPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage, String search) {
		int recordTotalCount = searchTotalCount(conn, search);
		int pageTotalCount = 0;
		if(recordTotalCount % recordCountPerPage > 0) {
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		} else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}
		// 오류방지용 코드
		if(currentPage < 1) {
			currentPage = 1;
		} else if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}
		int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage - 1;
		
		// 오류방지용 코드
		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}
		// prev, next를 준비하기 위한 필요한 변수
		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi == 1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}
		
		StringBuilder sb = new StringBuilder();
		if(needPrev) {
			sb.append("<li class='page-item'><a class='page-link' href='/other/search?search1=" + search + "&currentPage=" + (startNavi - 1) + "'> < </a></li>");
		}
		for(int i = startNavi; i <= endNavi; i++) {
			if(i == currentPage) {
				sb.append("<li class='page-item'><a class='page-link' href='/other/search?search1=" + search + "&currentPage=" + i + "'>" + i + "</a></li>");
			} else {
				sb.append("<li class='page-item'><a class='page-link' href='/other/search?search1=" + search + "&currentPage=" + i + "'>" + i + "</a></li>");
			}
		}
		if(needNext) {
			sb.append("<li class='page-item'><a class='page-link' href='/other/search?search1=" + search + "&currentPage=" + (endNavi + 1) + "'> > </a></li>");
		}
		return sb.toString();
	}
	
	public String getOtherReviewPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage, String pCode) {
		int recordTotalCount = OtherReviewtotalCount(conn, pCode);
		int pageTotalCount = 0;
		if(recordTotalCount % recordCountPerPage > 0) {
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		} else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}
		if(currentPage < 1) {
			currentPage = 1;
		} else if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}
		int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage - 1;
		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}
		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi == 1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}
		StringBuilder sb = new StringBuilder();
		if(needPrev) {
			sb.append("<li class='page-item'><a class='page-link' href='/other/content?pCode=" + pCode + "&&currentPage=" + (startNavi-1) + "'> < </a></li>");
		}
		for(int i = startNavi; i <= endNavi; i++) {
			if(i == currentPage) {
				sb.append("<li class='page-item'><a class='page-link' href='/other/content?pCode=" + pCode + "&&currentPage=" + i + "'>" + i + " </a></li>");
			} else {
				sb.append("<li class='page-item'><a class='page-link' href='/other/content?pCode=" + pCode + "&&currentPage=" + i + "'>" + i + " </a></li>");
			}
		}
		if(needNext) {
			sb.append("<li class='page-item'><a class='page-link' href='/other/content?pCode=" + pCode + "&&currentPage=" + (endNavi+1) + "'> > </a></li>");
		}
		
		return sb.toString();
	}
	
	public int totalCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM PRODUCT WHERE SEP_CODE = 'OTHER'";
		int recordTotalCount = 0;
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				recordTotalCount = rset.getInt("TOTALCOUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return recordTotalCount;
	}
	
	public int totalMonitorCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM PRODUCT WHERE P_CATEGORY = 'MONITOR'";
		int recordTotalCount = 0;
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				recordTotalCount = rset.getInt("TOTALCOUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return recordTotalCount;
	}
	
	public int totalKeyboardCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM PRODUCT WHERE P_CATEGORY = 'KEYBOARD'";
		int recordTotalCount = 0;
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				recordTotalCount = rset.getInt("TOTALCOUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return recordTotalCount;
	}
	
	public int totalMouseCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM PRODUCT WHERE P_CATEGORY = 'MOUSE'";
		int recordTotalCount = 0;
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				recordTotalCount = rset.getInt("TOTALCOUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return recordTotalCount;
	}
	
	public int totalSpeakerCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM PRODUCT WHERE P_CATEGORY = 'SPEAKER'";
		int recordTotalCount = 0;
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				recordTotalCount = rset.getInt("TOTALCOUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return recordTotalCount;
	}
	
	public int totalHeadsetCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM PRODUCT WHERE P_CATEGORY = 'HEADSET'";
		int recordTotalCount = 0;
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				recordTotalCount = rset.getInt("TOTALCOUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return recordTotalCount;
	}
	
	public int searchTotalCount(Connection conn, String search) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		// 게시글의 총 갯수를 알아오는 쿼리
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM PRODUCT WHERE P_NAME LIKE ?";
		int recordTotalCount = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+search+"%");
			rset = pstmt.executeQuery();
			if(rset.next()) {
				// 쿼리한 결과 값이 하나의 컬럼에 number값이므로 1줄로 끝
				recordTotalCount = rset.getInt("TOTALCOUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return recordTotalCount;
	}
	
	public int OtherReviewtotalCount(Connection conn, String pCode) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM PRODUCT_REVIEW WHERE P_CODE = ?";
		int recordTotalCount = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, pCode);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				recordTotalCount = rset.getInt("TOTALCOUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return recordTotalCount;
	}
}
