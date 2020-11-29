package community.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.JDBCTemplate;
import community.model.vo.Comments;
import community.model.vo.QnA;
import community.model.vo.Review;

public class CommunityDao {
	
	public CommunityDao() {}
	
	// QnA 전체목록 불러오는 메소드
		public ArrayList<QnA> selectQnaAll(Connection conn, int currentPage, int recordCountPerPage){
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			ArrayList<QnA> qnaList = null;
			String query = "select * from (select A.*, row_number() over(order by fix desc, qna_no desc) as num from (select * from qna)A)  where num between ? and ?";
			int start = currentPage*recordCountPerPage - (recordCountPerPage-1);
			int end = currentPage*recordCountPerPage;
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, start);
				pstmt.setInt(2, end);
				rset = pstmt.executeQuery();
				if(rset!=null) {
					qnaList= new ArrayList<QnA>();
					while(rset.next()) {
						QnA qna = new QnA();
						qna.setQnaNo(rset.getInt("qna_no"));
						qna.setQnaTitle(rset.getString("q_title"));
						qna.setQnaContents(rset.getString("q_contents"));
						qna.setQnaDate(rset.getDate("q_date"));
						qna.setMemberId(rset.getString("member_id"));
						qna.setFix(rset.getInt("fix"));
						qnaList.add(qna);
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(rset);
				JDBCTemplate.close(pstmt);
			}
			return qnaList;
		}
		
		public String getPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage) {
			int recordTotalCount = qnaTotalCount(conn);
			int pageTotalCount = 0;
			if(recordTotalCount%recordCountPerPage>0) {
				pageTotalCount = recordTotalCount/recordCountPerPage +1;
			}else {
				pageTotalCount = recordTotalCount/recordCountPerPage;
			}
			int startNavi = ((currentPage-1)/naviCountPerPage)*naviCountPerPage +1;
			int endNavi = startNavi + naviCountPerPage - 1;
			
			if(currentPage<1) {
				currentPage=1;
			}else if(currentPage>pageTotalCount) {
				currentPage=pageTotalCount;
			}
			
			if(endNavi>pageTotalCount) {
				endNavi=pageTotalCount;
			}
			
			boolean needPrev = true;
			boolean needNext = true;
			
			if(startNavi==1) {
				needPrev = false;
			}
			if(endNavi==pageTotalCount) {
				needNext = false;
			}
			
			StringBuilder sb = new StringBuilder();
			
			sb.append("<ul class='pagination'>");
			if(needPrev) {
				sb.append("<li class='page-item'><a class='page-link' href='/qna/main?currentPage=" + (startNavi-1) + "' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>");
			}
			for(int i=startNavi; i<=endNavi; i++) {
				if(i==currentPage) {
					sb.append("<li class='page-item'><a class='page-link' href='/qna/main?currentPage=" + i + "'>" +"<b>" + i + "</b></a></li>" );
				}else {
					sb.append("<li class='page-item'><a class='page-link' href='/qna/main?currentPage=" + i + "'>" +  i   + "</a></li>");
				}
			}
			if(needNext) {
				sb.append("<li class='page-item'><a class='page-link' href='/qna/main?currentPage=" +(endNavi+1) + "' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>");
			}
			sb.append("</ul>");
			return sb.toString();
		}
		
		public int qnaTotalCount(Connection conn) {
			Statement stmt = null;
			ResultSet rset =null;
			int recordTotalCount = 0;
			String query = "select count(*) as totalcount from qna";
			try {
				stmt =conn.createStatement();
				rset = stmt.executeQuery(query);
				if(rset.next()) {
					recordTotalCount = rset.getInt("totalcount");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(rset);
				JDBCTemplate.close(stmt);
			}
			return recordTotalCount;
		}
		// QnA 검색 목록 불러오는 메소드
		public ArrayList<QnA> qnaSearch(Connection conn,int currentPage,int recordCountPerPage,String search){
			PreparedStatement pstmt= null;
			ResultSet rset = null;
			ArrayList<QnA> qnaList = null;
			String query ="select * from (select A.*, row_number() over(order by fix desc, qna_no desc) as num from (select * from qna where q_title like ? or fix ='1')A)  where num between ? and ?";
			int start = currentPage*recordCountPerPage - (recordCountPerPage-1);
			int end = currentPage*recordCountPerPage;
			try {
				pstmt= conn.prepareStatement(query);
				pstmt.setString(1, "%"+search+"%");
				pstmt.setInt(2, start);
				pstmt.setInt(3, end);
				rset = pstmt.executeQuery();
				if(rset!=null) {
					qnaList = new ArrayList<QnA>();
					while(rset.next()) {
						QnA qna = new QnA();
						qna.setQnaNo(rset.getInt("qna_no"));
						qna.setQnaTitle(rset.getString("q_title"));
						qna.setQnaContents(rset.getString("q_contents"));
						qna.setQnaDate(rset.getDate("q_date"));
						qna.setMemberId(rset.getString("member_id"));
						qna.setFix(rset.getInt("fix"));
						qnaList.add(qna);
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(rset);
				JDBCTemplate.close(pstmt);
			}
			return qnaList;
		}
		
		public String getSerachNavi(Connection conn,int currentPage, int recordCountPerPage, int naviCountPerPage, String search) {
			int recordTotalCount = searchTotalCount(conn,search);
			int pageTotalCount = 0;
			if(recordTotalCount%recordCountPerPage>0) {
				pageTotalCount = recordTotalCount/recordCountPerPage+1;
			}else {
				pageTotalCount= recordTotalCount/recordCountPerPage;
			}
			
			int startNavi = ((currentPage-1)/naviCountPerPage)*naviCountPerPage + 1;
			int endNavi = startNavi + naviCountPerPage -1;
			
			if(currentPage<1) {
				currentPage=1;
			}else if(currentPage>pageTotalCount) {
				currentPage = pageTotalCount;
			}
			
			if(endNavi>pageTotalCount) {
				endNavi = pageTotalCount;
			}
			
			boolean needPrev = true;
			boolean needNext = true;
			
			if(startNavi==1) {
				needPrev = false;
			}
			if(endNavi==pageTotalCount) {
				needNext = false;
			}
			
			StringBuilder sb = new StringBuilder();
			
			sb.append("<ul class='pagination'>");
			if(needPrev) {
				sb.append("<li class='page-item'><a class='page-link' href='/qna/main?currentPage=" + (startNavi-1) +"&search=" + search +  "' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>");
			}
			for(int i=startNavi; i<=endNavi; i++) {
				if(i==currentPage) {
					sb.append("<li class='page-item'><a class='page-link' href='/qna/main?currentPage=" + i + "&search=" + search + "'>" +"<b>" + i + "</b></a></li>" );
				}else {
					sb.append("<li class='page-item'><a class='page-link' href='/qna/main?currentPage=" + i + "&search=" + search + "'>" +  i   + "</a></li>");
				}
			}
			if(needNext) {
				sb.append("<li class='page-item'><a class='page-link' href='/qna/main?currentPage=" +(endNavi+1) + "&search=" + search + "' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>");
			}
			sb.append("</ul>");
			return sb.toString();
		}
		
		public int searchTotalCount(Connection conn, String search) {
			PreparedStatement pstmt = null;
			ResultSet rset= null;
			int recordTotalCount = 0;
			String query = "select count(*) as totalcount from qna where fix='1' or q_title like ?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, "%"+search+"%");
				rset = pstmt.executeQuery();
				if(rset.next()) {
					recordTotalCount = rset.getInt("totalcount");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(rset);
				JDBCTemplate.close(pstmt);
			}
			return recordTotalCount;
		}
		
		// QnA 게시글 등록
		public int qnaInsert(Connection conn, String memberId, String title, String contents) {
			PreparedStatement pstmt = null;
			int result =0;
			String query ="";
			if(memberId.equals("admin")) {
		    query ="insert into qna values(qna_seq.nextval,?,?,sysdate,?,1)";
			}else {
		    query = "insert into qna values(qna_seq.nextval,?,?,sysdate,?,0)";
			}
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, title);
				pstmt.setString(2, contents);
				pstmt.setString(3, memberId);
				result =pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(pstmt);
			}
			return result;
		}
		
		// QnA 세부내용
		public QnA qnaDetail(Connection conn, int qnaNo) {
			PreparedStatement pstmt= null;
			ResultSet rset = null;
			String query ="select * from qna where qna_no=?";
			QnA qna =null;
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, qnaNo);
				rset = pstmt.executeQuery();
				if(rset.next()) {
					qna = new QnA();
					qna.setQnaNo(rset.getInt("qna_no"));
					qna.setQnaTitle(rset.getString("q_title"));
					qna.setQnaContents(rset.getString("q_contents"));
					qna.setQnaDate(rset.getDate("q_date"));
					qna.setMemberId(rset.getString("member_id"));
					qna.setFix(rset.getInt("fix"));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(pstmt);
				JDBCTemplate.close(rset);
			}
			return qna;
		}
		
		// QnA 게시글 수정
		public int qnaUpdate(Connection conn, int qnaNo, String title, String contents) {
			PreparedStatement pstmt = null;
			int result =0;
			String query="update qna set q_title=?,q_contents=? where qna_no=?";
			try {
				pstmt =conn.prepareStatement(query);
				pstmt.setString(1, title);
				pstmt.setString(2, contents);
				pstmt.setInt(3, qnaNo);
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(pstmt);
			}
			return result;
		}
		
		// QnA 게시글 삭제
		public int qnaDelete(Connection conn, int qnaNo) {
			PreparedStatement pstmt= null;
			int result =0;
			String query ="delete from qna where qna_no=?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, qnaNo);
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(pstmt);
			}
			return result;
		}
		
		
		// QnA 상세 게시글 댓글 입력
		public int qnaComInsert(Connection conn,int qnaNo,String contents, String memberId) {
			PreparedStatement pstmt = null;
			int result =0;
			String query ="insert into comments values(comments_seq.nextval,?,sysdate,?,null,?)";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, contents);
				pstmt.setInt(2, qnaNo);
				pstmt.setString(3, memberId);
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(pstmt);
			}
			return result;
		}
		
		// QnA 상세 게시글 여러개 가져오기
		public ArrayList<Comments> commentsList(Connection conn,int qnaNo){
			PreparedStatement pstmt =null;
			ArrayList<Comments> qnaComList = null;
			ResultSet rset = null;
			String query ="select * from comments where qna_no=? order by 1";
			try {
				pstmt  = conn.prepareStatement(query);
				pstmt.setInt(1, qnaNo);
				rset = pstmt.executeQuery();
				if(rset!=null) {
					qnaComList = new ArrayList<Comments>();
					while(rset.next()) {
						Comments comments = new Comments();
						comments.setcNo(rset.getInt("comment_no"));
						comments.setcContents(rset.getString("c_contents"));
						comments.setcDate(rset.getDate("c_date"));
						comments.setQnaNo(rset.getInt("qna_no"));
						comments.setReview_no(rset.getInt("review_no"));
						comments.setMemberId(rset.getString("member_id"));
						qnaComList.add(comments);
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(rset);
				JDBCTemplate.close(pstmt);
			}
			return qnaComList;
		}
		
		// QnA 댓글 삭제
		public int qnaComDelete(Connection conn, int commentNo, int qnaNo) {
			PreparedStatement pstmt = null;
			int result =0;
			String query ="delete from comments where comment_no=? and qna_no=?";
			try {
				pstmt =conn.prepareStatement(query);
				pstmt.setInt(1, commentNo);
				pstmt.setInt(2, qnaNo);
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(pstmt);
			}
			return result;
		}
	
//================================================================================================================================
	
	public ArrayList<Review> selectReviewList(Connection conn, int currentPage, int recordCountPerPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Review> list = null;
		String query = "SELECT T.* FROM (SELECT RV.*, CASE WHEN RV.MEMBER_ID = 'ADMIN' THEN '1' ELSE '0' END TEST_PR FROM REVIEW RV WHERE 1=1) T WHERE REVIEW_NO BETWEEN ? AND ? ORDER BY T.TEST_PR DESC, REVIEW_NO DESC";
		int start = currentPage * recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage * recordCountPerPage;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			list = new ArrayList<Review>();
			while(rset.next()) {
				Review review = new Review();
				review.setReviewNo(rset.getInt("REVIEW_NO"));
				review.setrTitle(rset.getString("R_TITLE"));
				review.setrContents(rset.getString("R_CONTENTS"));
				review.setrDate(rset.getDate("R_DATE"));
				review.setMemberId(rset.getString("MEMBER_ID"));
				review.setrFilename(rset.getString("R_FILENAME"));
				review.setrFilepath(rset.getString("R_FILEPATH"));
				review.setViewCnt(rset.getInt("VIEW_CNT"));
				list.add(review);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	
	public int insertReview(Connection conn, Review review, String userId) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO REVIEW VALUES(REVIEW_SEQ.NEXTVAL,?,?,SYSDATE,?,?,?,DEFAULT)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, review.getrTitle());
			pstmt.setString(2, review.getrContents());
			pstmt.setString(3, userId);
			pstmt.setString(4, review.getrFilename());
			pstmt.setString(5, review.getrFilepath());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public Review selectReview(Connection conn, int reviewNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Review review = null;
		String query = "SELECT * FROM REVIEW WHERE REVIEW_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, reviewNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				review = new Review();
				review.setReviewNo(rset.getInt("REVIEW_NO"));
				review.setrTitle(rset.getString("R_TITLE"));
				review.setrContents(rset.getString("R_CONTENTS"));
				review.setrDate(rset.getDate("R_DATE"));
				review.setMemberId(rset.getString("MEMBER_ID"));
				review.setrFilename(rset.getString("R_FILENAME"));
				review.setrFilepath(rset.getString("R_FILEPATH"));
				review.setViewCnt(rset.getInt("VIEW_CNT"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return review;
	}
	
	public ArrayList<Comments> selectReviewCom(Connection conn, int currentPage, int recordCountPerPage, int reviewNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Comments> reviewCom = null;
		String query = "SELECT * FROM (SELECT COMMENTS.*, ROW_NUMBER() OVER(ORDER BY COMMENT_NO DESC) AS NUM FROM COMMENTS WHERE REVIEW_NO = ?) WHERE NUM BETWEEN ? AND ?";
		
		int start = currentPage * recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage * recordCountPerPage;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, reviewNo);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			reviewCom = new ArrayList<Comments>();
			while(rset.next()) {
				Comments rCom = new Comments();
				rCom.setcNo(rset.getInt("COMMENT_NO"));
				rCom.setcContents(rset.getString("C_CONTENTS"));
				rCom.setcDate(rset.getDate("C_DATE"));
				rCom.setReview_no(rset.getInt("REVIEW_NO"));
				rCom.setMemberId(rset.getString("MEMBER_ID"));
				reviewCom.add(rCom);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return reviewCom;
	}
	
	public void updateViewCnt(Connection conn, int reviewNo) {
		PreparedStatement pstmt = null;
		String query = "UPDATE REVIEW SET VIEW_CNT = (VIEW_CNT+1) WHERE REVIEW_NO = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, reviewNo);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int modifyReview(Connection conn, Review review) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "UPDATE REVIEW SET R_TITLE = ?, R_CONTENTS = ?, R_DATE = SYSDATE, R_FILENAME = ?, R_FILEPATH = ? WHERE REVIEW_NO = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, review.getrTitle());
			pstmt.setString(2, review.getrContents());
			pstmt.setString(3, review.getrFilename());
			pstmt.setString(4, review.getrFilepath());
			pstmt.setInt(5, review.getReviewNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public int deleteReview(Connection conn, int reviewNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "DELETE FROM REVIEW WHERE REVIEW_NO = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, reviewNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public ArrayList<Review> reviewSearch(Connection conn, String search, int currentPage, int recordCountPerPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT T.* FROM (SELECT RV.*, CASE WHEN RV.MEMBER_ID = 'ADMIN' THEN '1' ELSE '0' END TEST_PR FROM REVIEW RV WHERE 1=1) T WHERE R_TITLE LIKE ? AND REVIEW_NO BETWEEN ? AND ? ORDER BY T.TEST_PR DESC, REVIEW_NO DESC";
		int start = currentPage*recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage*recordCountPerPage;
		ArrayList<Review> nList = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+search+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			nList = new ArrayList<Review>();
			while(rset.next()) {
				Review review = new Review();
				review.setReviewNo(rset.getInt("REVIEW_NO"));
				review.setrTitle(rset.getString("R_TITLE"));
				review.setrContents(rset.getString("R_CONTENTS"));
				review.setrDate(rset.getDate("R_DATE"));
				review.setMemberId(rset.getString("MEMBER_ID"));
				review.setrFilename(rset.getString("R_FILENAME"));
				review.setrFilepath(rset.getString("R_FILEPATH"));
				review.setViewCnt(rset.getInt("VIEW_CNT"));
				nList.add(review);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return nList;
	}
	
	public int insertComment(Connection conn, String contents, String userId, int reviewNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO COMMENTS VALUES (COMMENTS_SEQ.NEXTVAL,?,SYSDATE,NULL,?,?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, contents);
			pstmt.setInt(2, reviewNo);
			pstmt.setString(3, userId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public int deleteComReview(Connection conn, int reviewNo, int commentNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "DELETE FROM COMMENTS WHERE COMMENT_NO = ? AND REVIEW_NO = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, commentNo);
			pstmt.setInt(2, reviewNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public String getPageReNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage) {
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
			sb.append("<li class='page-item'><a class='page-link' href='/review/main?currentPage=" + (startNavi - 1) + "'> < </a></li>");
		}
		for(int i = startNavi; i <= endNavi; i++) {
			if(i == currentPage) {
				sb.append("<li class='page-item'><a class='page-link' href='/review/main?currentPage=" + i + "'>" + i + "</a></li>");
			} else {
				sb.append("<li class='page-item'><a class='page-link' href='/review/main?currentPage=" + i + "'>" + i + "</a></li>");
			}
		}
		if(needNext) {
			sb.append("<li class='page-item'><a class='page-link' href='/review/main?currentPage=" + (endNavi + 1) + "'> > </a></li>");
		}
		return sb.toString();
	}
	
	public String getSearchPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage, String search) {
		int recordTotalCount = searchReTotalCount(conn, search);
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
			sb.append("<a href='/review/search?search1=" + search + "currentPage=" + (startNavi - 1) + "'> < </a>");
		}
		for(int i = startNavi; i <= endNavi; i++) {
			if(i == currentPage) {
				sb.append("<a href='/review/search?search1=" + search + "currentPage=" + i + "'><b>" + i + "</b></a>");
			} else {
				sb.append("<a href='/review/search?search1=" + search + "currentPage=" + i + "'>" + i + "</a>");
			}
		}
		if(needNext) {
			sb.append("<a href='/review/search?search1=" + search + "currentPage=" + (endNavi + 1) + "'> > </a>");
		}
		return sb.toString();
	}
	
	public String getComPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage, int reviewNo) {
		int recordTotalCount = totalComCount(conn, reviewNo);
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
			sb.append("<a href='/review/select?reviewNo=" + reviewNo +"&&currentPage=" + (startNavi-1) + "'> < </a>");
		}
		for(int i = startNavi; i <= endNavi; i++) {
			if(i == currentPage) {
				sb.append("<a href='/review/select?reviewNo=" + reviewNo + "&&currentPage=" + i + "'><b>" + i + " </b></a>");
			} else {
				sb.append("<a href='/review/select?reviewNo=" + reviewNo + "&&currentPage=" + i + "'>" + i + " </a>");
			}
		}
		if(needNext) {
			sb.append("<a href='/review/select?reviewNo=" + reviewNo + "&&currentPage=" + (endNavi+1) + "'> > </a>");
		}
		return sb.toString();
	}
	
	public int totalCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM REVIEW";
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
	
	public int searchReTotalCount(Connection conn, String search) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM REVIEW WHERE R_TITLE LIKE ?";
		int recordTotalCount = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+search+"%");
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
	
	public int totalComCount(Connection conn, int reviewNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM COMMENTS WHERE REVIEW_NO = ?";
		int recordTotalCount = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, reviewNo);
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
