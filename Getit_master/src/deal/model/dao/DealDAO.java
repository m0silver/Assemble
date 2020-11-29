package deal.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.JDBCTemplate;
import deal.model.vo.Deal;
import deal.model.vo.DealPageData;

public class DealDAO {
	private Deal Deal;
	private DealPageData DealPageData;
	
	public int insertDeal (Connection conn, Deal deal) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO DEAL VALUES(DEAL_SEQ.NEXTVAL,?,?,?,SYSDATE,?,?,?)";
		// 0은 조회수이고 기본값 0으로 넣음
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, deal.getDealTitle());
			pstmt.setString(2, deal.getDealContents());
			pstmt.setInt(3, deal.getDealPrice());
			pstmt.setString(4, deal.getDealFileName());
			pstmt.setString(5, deal.getDealFilePath());
			pstmt.setString(6, deal.getMemberId());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	
	
	
	
	public int modifyDeal (Connection conn, Deal deal) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "UPDATE DEAL SET DEAL_TITLE = ?, DEAL_CONTENTS = ?, DEAL_PRICE = ?, DEAL_DATE = SYSDATE, DEAL_FILENAME = ?, DEAL_FILEPATH =? WHERE DEAL_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, deal.getDealTitle());
			pstmt.setString(2, deal.getDealContents());
			pstmt.setInt(3, deal.getDealPrice());
			pstmt.setString(4, deal.getDealFileName());
			pstmt.setString(5, deal.getDealFilePath());
			pstmt.setInt(6, deal.getDealNo());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	
	public int deleteDeal(Connection conn, int dealNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "DELETE FROM DEAL WHERE DEAL_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, dealNo);
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	
	
	public Deal selectDeal(Connection conn, int dealNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM DEAL WHERE DEAL_NO =?";
		// DEAL_NO와 일치하는 사진들 불러올것!
		Deal deal = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, dealNo);
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				deal = new Deal();
				deal.setDealNo(rset.getInt("DEAL_NO"));
				deal.setDealTitle(rset.getString("DEAL_TITLE"));
				deal.setDealContents(rset.getString("DEAL_CONTENTS"));
				deal.setDealPrice(rset.getInt("DEAL_PRICE"));
				deal.setDealDate(rset.getDate("DEAL_DATE"));
				deal.setDealFileName(rset.getString("DEAL_FILENAME"));
				deal.setDealFilePath(rset.getString("DEAL_FILEPATH"));
				deal.setMemberId(rset.getString("MEMBER_ID"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return deal;
	}
	
	
	
	public ArrayList<Deal> dealList (Connection conn, int dealPageNo,int recordCountDealPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * FROM (SELECT DEAL.*, ROW_NUMBER() OVER(ORDER BY DEAL_NO DESC) AS NUM FROM DEAL) WHERE NUM BETWEEN ? AND ?";
		// 게시물 전체를 불러오는 쿼리문 작성
		
		int start = dealPageNo*recordCountDealPage - (recordCountDealPage-1);
		int end = dealPageNo*recordCountDealPage;
		
		ArrayList<Deal> dList = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			
			dList = new ArrayList<Deal>();
			
			while(rset.next()) {
				Deal dealOne = new Deal();
				dealOne.setDealNo(rset.getInt("DEAL_NO"));
				dealOne.setDealTitle(rset.getString("DEAL_TITLE"));
				dealOne.setDealContents(rset.getString("DEAL_CONTENTS"));
				dealOne.setDealPrice(rset.getInt("DEAL_PRICE"));
				dealOne.setDealDate(rset.getDate("DEAL_DATE"));
				dealOne.setDealFileName(rset.getString("DEAL_FILENAME"));
				dealOne.setDealFilePath(rset.getString("DEAL_FILEPATH"));
				dealOne.setMemberId(rset.getString("MEMBER_ID"));
				dList.add(dealOne);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return dList;
	}
	
	
	
	public String dealPageNavi (Connection conn, int dealPageNo, int recordCountDealPage, int naviCountDealPage) {
		// 전체 게시물의 개수
		int recordTotalCount = totalCount(conn);
		// 전체 페이지의 개수
		int pageTotalCount = 0;
		
		if (recordTotalCount % recordCountDealPage > 0) {
			pageTotalCount = recordTotalCount/recordCountDealPage+1;
		} else {
			pageTotalCount = recordTotalCount/recordCountDealPage;
		}
		
		// 오류방지코드
		if (dealPageNo<1) {
			dealPageNo = 1;
		} else if (dealPageNo > pageTotalCount) {
			dealPageNo = pageTotalCount;
		}
		
		
		int startNavi = ((dealPageNo-1)/naviCountDealPage)*naviCountDealPage+1;
		int endNavi = startNavi+naviCountDealPage-1;
		
		// 오류방지코드
		if (endNavi>pageTotalCount) {
			endNavi=pageTotalCount;
		}
		
		boolean needPrev = true;
		boolean needNext = true;
		
		if (startNavi == 1) {
			needPrev = false;
		}
		
		if (endNavi == pageTotalCount) {
			needNext = false;
		}
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("<ul class='pagination'>");
		if(needPrev) {
			sb.append("<li class='page-item'><a class='page-link' href='/deal/main?dealPageNo=" + (startNavi-1) + "' aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a></li>");
		}
		for(int i=startNavi; i<=endNavi; i++) {
			if(i==dealPageNo) {
				sb.append("<li class='page-item'><a class='page-link' href='/deal/main?dealPageNo=" + i + "'>" +"<b>" + i + "</b></a></li>" );
			}else {
				sb.append("<li class='page-item'><a class='page-link' href='/deal/main?dealPageNo=" + i + "'>" +  i   + "</a></li>");
			}
		}
		
		if(needNext) {
			sb.append("<li class='page-item'><a class='page-link' href='/deal/main?dealPageNo=" +(endNavi+1) + "' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>");
		}

		sb.append("<form action=\"/deal/writeform\" method=\"post\" id=\"writeForm\">\r\n" + 
				"<button type=\"submit\" class=\"btn btn-secondary\">글쓰기</button>\r\n" + 
				"</form></ul>");
		return sb.toString();
	}
	
	
	public String dealPageNaviNonlogin (Connection conn, int dealPageNo, int recordCountDealPage, int naviCountDealPage) {
		// 전체 게시물의 개수
		int recordTotalCount = totalCount(conn);
		// 전체 페이지의 개수
		int pageTotalCount = 0;
		
		if (recordTotalCount % recordCountDealPage > 0) {
			pageTotalCount = recordTotalCount/recordCountDealPage+1;
		} else {
			pageTotalCount = recordTotalCount/recordCountDealPage;
		}
		
		// 오류방지코드
		if (dealPageNo<1) {
			dealPageNo = 1;
		} else if (dealPageNo > pageTotalCount) {
			dealPageNo = pageTotalCount;
		}
		
		
		int startNavi = ((dealPageNo-1)/naviCountDealPage)*naviCountDealPage+1;
		int endNavi = startNavi+naviCountDealPage-1;
		
		// 오류방지코드
		if (endNavi>pageTotalCount) {
			endNavi=pageTotalCount;
		}
		
		boolean needPrev = true;
		boolean needNext = true;
		
		if (startNavi == 1) {
			needPrev = false;
		}
		
		if (endNavi == pageTotalCount) {
			needNext = false;
		}
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("<ul class='pagination'>");
		if(needPrev) {
			sb.append("<li class='page-item'><a class='page-link' href='/deal/main?dealPageNo=" + (startNavi-1) + "' aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a></li>");
		}
		for(int i=startNavi; i<=endNavi; i++) {
			if(i==dealPageNo) {
				sb.append("<li class='page-item'><a class='page-link' href='/deal/main?dealPageNo=" + i + "'>" +"<b>" + i + "</b></a></li>" );
			}else {
				sb.append("<li class='page-item'><a class='page-link' href='/deal/main?dealPageNo=" + i + "'>" +  i   + "</a></li>");
			}
		}
		
		if(needNext) {
			sb.append("<li class='page-item'><a class='page-link' href='/deal/main?dealPageNo=" +(endNavi+1) + "' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>");
		}

		sb.append("<form action=\"/login.html\" method=\"post\" id=\"writeForm\" onclick=\"loginError2()\">\r\n" + 
				"<button type=\"submit\" class=\"btn btn-secondary\">글쓰기</button>\r\n" + 
				"</form></ul>");
		return sb.toString();
	}
	
	
	
	public int totalCount (Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM DEAL";
		int totalCount = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				totalCount = rset.getInt("TOTALCOUNT");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return totalCount;
	}
	
	
	
	
	public ArrayList<Deal> dealSearchList (Connection conn, String search, int dealPageNo, int recordCountDealPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Deal> dList =  null;
		String query = "SELECT * FROM(SELECT DEAL.*,ROW_NUMBER() OVER (ORDER BY DEAL_DATE DESC) AS NUM FROM DEAL WHERE DEAL_TITLE LIKE ?) WHERE NUM BETWEEN ? AND ?";
		
		int start = dealPageNo*recordCountDealPage - (recordCountDealPage-1);
		int end = dealPageNo*recordCountDealPage;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+search+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			
			rset = pstmt.executeQuery();
			
			if (rset != null) {
				dList = new ArrayList<Deal>();
				
				while(rset.next()) {
					Deal dealOne = new Deal();
					dealOne.setDealNo(rset.getInt("DEAL_NO"));
					dealOne.setDealTitle(rset.getString("DEAL_TITLE"));
					dealOne.setDealContents(rset.getString("DEAL_CONTENTS"));
					dealOne.setDealPrice(rset.getInt("DEAL_PRICE"));
					dealOne.setDealDate(rset.getDate("DEAL_DATE"));
					dealOne.setDealFileName(rset.getString("DEAL_FILENAME"));
					dealOne.setDealFilePath(rset.getString("DEAL_FILEPATH"));
					dealOne.setMemberId(rset.getString("MEMBER_ID"));
					dList.add(dealOne);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}		
		return dList;
	}
	
	
	
	
	public String dealSearchPageNavi (Connection conn, String search, int dealPageNo, int recordCountDealPage, int naviCountDealPage) {
		int recordTotalCount = dealSearchTotalCount(conn, search);
		int pageTotalCount = 0;
		
		if (recordTotalCount % recordCountDealPage > 0) {
			pageTotalCount = recordTotalCount / recordCountDealPage+1;
		} else {
			pageTotalCount = recordTotalCount / recordCountDealPage;
		}
		
		// 오류방지코드
		if (dealPageNo<1) {
			dealPageNo = 1;
		} else if (dealPageNo > pageTotalCount) {
			dealPageNo = pageTotalCount;
		}
		int startNavi = ((dealPageNo-1) / naviCountDealPage) * naviCountDealPage+1;
		int endNavi = startNavi+naviCountDealPage-1;
		
		// 오류방지코드
		if (endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		} 
		
		// prev, next를 준비하기 위해 필요한 변수
		boolean needPrev = true;
		boolean needNext = true;
		
		if (startNavi == 1) {
			needPrev = false;
		}
		
		if (endNavi == pageTotalCount) {
			needNext = false;
		}
		
		// a 태그를 만드는 코드
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("<ul class='pagination'>");
		if(needPrev) {
			sb.append("<li class='page-item'><a class='page-link' href='/deal/main?dealPageNo=" + (startNavi-1) + "' aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a></li>");
		}
		for(int i=startNavi; i<=endNavi; i++) {
			if(i==dealPageNo) {
				sb.append("<li class='page-item'><a class='page-link' href='/deal/main?dealPageNo=" + i + "'>" +"<b>" + i + "</b></a></li>" );
			}else {
				sb.append("<li class='page-item'><a class='page-link' href='/deal/main?dealPageNo=" + i + "'>" +  i   + "</a></li>");
			}
		}
		
		if(needNext) {
			sb.append("<li class='page-item'><a class='page-link' href='/deal/main?dealPageNo=" +(endNavi+1) + "' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>");
		}

		sb.append("</ul>");
		return sb.toString();
	}
	
	
	
	public int dealSearchTotalCount (Connection conn, String search) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM DEAL WHERE DEAL_TITLE LIKE ?";
		int recordTotalCount = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+search+"%");
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				recordTotalCount = rset.getInt("TOTALCOUNT");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return recordTotalCount;
	}
	
	
}
