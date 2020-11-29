package community.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import community.model.dao.CommunityDao;
import community.model.vo.Comments;
import community.model.vo.PageData;
import community.model.vo.QnA;
import community.model.vo.QnaPageData;
import community.model.vo.Review;

public class CommunityService {
	
	public JDBCTemplate factory;
	private CommunityDao communitydao;
	
	public CommunityService() {
		factory = JDBCTemplate.getConnection();
	}
	
	public QnaPageData selectQnaAll(int currentPage) {
		Connection conn = null;
		QnaPageData pagedata = new QnaPageData();
		int recordCountPerPage= 5;
		int naviCountPerPage =5;
		try {
			conn = factory.createConnection();
			pagedata.setQnaList(new CommunityDao().selectQnaAll(conn,currentPage,recordCountPerPage));
			pagedata.setPageNavi(new CommunityDao().getPageNavi(conn,currentPage,recordCountPerPage,naviCountPerPage));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return pagedata;
	}
	// QnA 검색
	public QnaPageData qnaSearch(int currentPage, String search) {
		Connection conn = null;
		QnaPageData pagedata =new QnaPageData();
		int recordCountPerPage =10;
		int naviCountPerPage = 5;
		try {
			conn = factory.createConnection();
			pagedata.setQnaList(new CommunityDao().qnaSearch(conn,currentPage,recordCountPerPage,search));
			pagedata.setPageNavi(new CommunityDao().getSerachNavi(conn,currentPage,recordCountPerPage,naviCountPerPage,search));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return pagedata;
	}

	// QnA 등록
	public int qnaInsert(String memberId, String title, String contents) {
		Connection conn = null;
		int result =0;
		try {
			conn = factory.createConnection();
			result = new CommunityDao().qnaInsert(conn,memberId,title,contents);
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
	
	// QnA 세부페이지
	public QnA qnaDetail(int qnaNo) {
		Connection conn = null;
		QnA qna = new QnA();
		try {
			conn = factory.createConnection();
			qna = new CommunityDao().qnaDetail(conn,qnaNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return qna;
	}
	
	// QnA 수정
	public int qnaUpdate(int qnaNo, String title, String contents) {
		Connection conn = null;
		int result = 0;
		try {
			conn = factory.createConnection();
			result = new CommunityDao().qnaUpdate(conn,qnaNo,title,contents);
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
	
	// QnA 삭제
	public int qnaDelete(int qnaNo) {
		Connection conn =null;
		int result =0;
		try {
			conn =factory.createConnection();
			result = new CommunityDao().qnaDelete(conn,qnaNo);
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
	
	// QnA 댓글 등록
	public int qnaComInsert(int qnaNo, String contents, String memberId) {
		Connection conn = null;
		int result = 0;
		try {
			conn = factory.createConnection();
			result = new CommunityDao().qnaComInsert(conn, qnaNo,contents,memberId);
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
	
	// QnA 댓글내용 가져오기
	public ArrayList<Comments> commentsList(int qnaNo) {
		Connection conn = null;
		ArrayList<Comments> qnaComList =null;
		try {
			conn = factory.createConnection();
			qnaComList = new CommunityDao().commentsList(conn,qnaNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return qnaComList;
	}
	
	// QnA 댓글 삭제
	public int qnaComDelete(int commentNo,int qnaNo) {
		Connection conn =null;
		int result = 0;
		try { 
			conn = factory.createConnection();
			result = new CommunityDao().qnaComDelete(conn,commentNo,qnaNo);
			if(result>0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}
	
//================================================================================================================================
	
	public PageData selectReviewList(int currentPage) {
		Connection conn = null;
		int recordCountPerPage = 10;
		int naviCountPerPage = 5;
		
		PageData pd = new PageData();
		try {
			conn = factory.createConnection();
			pd.setPageList(new CommunityDao().selectReviewList(conn, currentPage, recordCountPerPage));
			pd.setPageReNavi(new CommunityDao().getPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return pd;
	}
	
	public int insertReview(Review review, String userId) {
		Connection conn = null;
		int result = 0;
		try {
			conn = factory.createConnection();
			result = new CommunityDao().insertReview(conn, review, userId);
			if(result > 0) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}
	
	public Review selectReview(int reviewNo) {
		Review review = null;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			
			// 조회수 증가
			new CommunityDao().updateViewCnt(conn, reviewNo);
			
			// 상세 정보 조회
			review = new CommunityDao().selectReview(conn, reviewNo);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return review;
	}
	
	public PageData selectReviewCom(int currentPage, int reviewNo) {
		Connection conn = null;
		int recordCountPerPage = 5;
		int naviCountPerPage = 5;
		PageData pd = new PageData();
//		ArrayList<ReviewCom> reviewCom = null;
		try {
			conn = factory.createConnection();
			pd.setPageComList(new CommunityDao().selectReviewCom(conn, currentPage, recordCountPerPage, reviewNo));
			pd.setPageComNavi(new CommunityDao().getComPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage, reviewNo));
//			reviewCom = new CommunityDao().selectReviewCom(conn, reviewNo);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return pd;
	}
	
	public int modifyReview(Review review) {
		int result = 0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			result = new CommunityDao().modifyReview(conn, review);
			if(result > 0) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}
	
	public int deleteReview(int reviewNo) {
		int result = 0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			result = new CommunityDao().deleteReview(conn, reviewNo);
			if(result > 0) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}
	
	public PageData reviewSearch(String search, int currentPage) {
		Connection conn = null;
		PageData pd = new PageData();
		int recordCountPerPage = 10;
		int naviCountPerPage = 5;
		try {
			conn = factory.createConnection();
			pd.setPageList(new CommunityDao().reviewSearch(conn, search, currentPage, recordCountPerPage));
			pd.setPageReNavi(new CommunityDao().getSearchPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage, search));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return pd;
	}
	
	public int insertComment(String contents, String userId, int reviewNo) {
		Connection conn = null;
		int result = 0;
		try {
			conn = factory.createConnection();
			result = new CommunityDao().insertComment(conn, contents, userId, reviewNo);
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
	
	public int deleteComReview(int reviewNo, int commentNo) {
		int result = 0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			result = new CommunityDao().deleteComReview(conn, reviewNo, commentNo);
			if(result > 0) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}
}
