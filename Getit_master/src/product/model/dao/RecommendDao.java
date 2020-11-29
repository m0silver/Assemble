package product.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.JDBCTemplate;
import product.model.vo.Product;
import product.model.vo.ProductReview;

public class RecommendDao {
	// 추천견적 전체 리스트 가져오는 메소드
	public ArrayList<Product> recommendAll(Connection conn,int currentPage,int recordCountPerPage){
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Product> recomList = null;
		String query 
		= "select * from (select A.*,row_number() over(order by A.serial_no desc) as num from (select * from product where sep_code='recommend')A) where num between ? and ?";
		int start = currentPage * recordCountPerPage - (recordCountPerPage-1);
		int end  = currentPage*recordCountPerPage;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			if(rset!=null) {
				recomList = new ArrayList<Product>();
				while(rset.next()) {
					Product product = new Product();
					product.setpCode(rset.getString("p_code"));
					product.setSerialNo(rset.getInt("serial_no"));
					product.setSepCode(rset.getString("sep_code"));
					product.setpName(rset.getString("p_name"));
					product.setpPrice(rset.getInt("p_price"));
					product.setpAccount(rset.getInt("p_account"));
					product.setpContents(rset.getString("p_contents"));
					product.setpCategory(rset.getString("p_category"));
					product.setpComcode(rset.getString("p_comcode"));
					product.setpFilename(rset.getString("p_filename"));
					product.setpFilepath(rset.getString("p_filepath"));
					product.setRelatedProduct(rset.getString("related_product"));
					recomList.add(product);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return recomList;
	}
	// 추천견적 전체리스트 페이징 처리
	public String getPageNavi(Connection conn, int currentPage,int recordCountPerPage,int naviCountPerPage) {
		// 페이지 총 갯수
		int recordTotalCount = totalCount(conn);
		// navi 개수
		int pageTotalCount =0;
		if(recordTotalCount % recordCountPerPage > 0) {
			pageTotalCount = recordTotalCount/recordCountPerPage + 1;
		}else {
			pageTotalCount = recordTotalCount/recordCountPerPage;
		}

		// navi 시작,끝 정하기
		int startNavi = ((currentPage-1)/naviCountPerPage)*naviCountPerPage +1;
		int endNavi = startNavi + naviCountPerPage -1;

		// 페이지 오류 방지
		if(currentPage<1) {
			currentPage = 1;
		}else if( currentPage>pageTotalCount) {
			currentPage = pageTotalCount;
		}

		// navi오류방지 코드
		if(endNavi>pageTotalCount) {
			endNavi = pageTotalCount;
		}

		// 이전,다음 페이지
		boolean needPrev = true;
		boolean needNext = true;

		// 페이지가 처음과 끝일 때 동작 못하게함
		if(startNavi ==1) {
			needPrev = false;
		}
		if (endNavi==pageTotalCount) {
			needNext = false;
		}

		// String타입을 연결해주는 클래스 선언
		StringBuilder sb = new StringBuilder();

		sb.append("<ul class='pagination'>");
		if(needPrev) {
			sb.append("<li class='page-item'><a class='page-link' href='/recommend/listview?currentPage=" + (startNavi-1) + "' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>");
		}
		for(int i=startNavi; i<=endNavi; i++) {
			if(i==currentPage) {
				sb.append("<li class='page-item'><a class='page-link' href='/recommend/listview?currentPage=" + i + "'>" +"<b>" + i + "</b></a></li>" );
			}else {
				sb.append("<li class='page-item'><a class='page-link' href='/recommend/listview?currentPage=" + i + "'>" +  i   + "</a></li>");
			}
		}
		if(needNext) {
			sb.append("<li class='page-item'><a class='page-link' href='/recommend/listview?currentPage=" +(endNavi+1) + "' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>");
		}
		sb.append("</ul>");
		return sb.toString();
	}
	// 추천견적 전체 갯수 가져오는 메소드
	public int totalCount(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		int recordTotalCount = 0;
		String query = "select count(*) as totalcount from product where sep_code='recommend'";
		try {
			stmt = conn.createStatement();
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

	// 해당 상품리뷰 전체 가져오는 메소드
	public ArrayList<ProductReview> recommendReview(Connection conn,int currentPage,int recordCountPerPage, String pCode){
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ProductReview> reviewList = null;
		String query ="select * from (select A.*,row_number() over(order by pr_review_no desc) as num  from (select * from PRODUCT_REVIEW where p_code=?)A) where num between ? and ?";
		int start = recordCountPerPage*currentPage -(recordCountPerPage-1);
		int end  = recordCountPerPage*currentPage;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, pCode);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			if(rset!=null) {
				reviewList = new ArrayList<ProductReview>();	
				while(rset.next()) {
					ProductReview review = new ProductReview();
					review.setReviewNo(rset.getInt("pr_review_no"));
					review.setReviewTitle(rset.getString("pr_title"));
					review.setReviewContents(rset.getString("pr_contents"));
					review.setEnrollDate(rset.getDate("pr_date"));
					review.setMemberId(rset.getString("member_id"));
					review.setpCode(rset.getString("p_code"));
					reviewList.add(review);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return reviewList;
	}

	// 해당 상품리뷰 페이징처리
	public String reviewPageNavi(Connection conn, int currentPage,int recordCountPerPage,int naviCountPerPage,String pCode, String pFilename) {
		int recordTotalCount = reviewTotalCount(conn,pCode);
		int pageTotalCount = 0;
		if(recordTotalCount % recordCountPerPage>0) {
			pageTotalCount = recordTotalCount/recordCountPerPage +1;
		}else {
			pageTotalCount = recordTotalCount/recordCountPerPage;
		}

		int startNavi = ((currentPage-1)/naviCountPerPage)*naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage -1;

		if(currentPage<1) {
			currentPage =1;
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
		if(endNavi == pageTotalCount) {
			needNext = false;
		}
		// String을 연결해주는 클래스
		StringBuilder sb = new StringBuilder();
		// 이전페이지를 누르면 해당 페이지의 게시물을 가져옴
		sb.append("<ul class='pagination'>");
		if(needPrev) {
			sb.append("<li class='page-item'><a class='page-link' href='/recommend/detail?currentPage=" + (startNavi-1) + "&pCode="+ pCode + "&pFilename=" + pFilename + "' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>");
		}
		for(int i=startNavi; i<=endNavi; i++) {
			if(i==currentPage) {
				sb.append("<li class='page-item'><a class='page-link' href='/recommend/detail?currentPage=" + i + "&pCode=" + pCode + "&pFilename=" + pFilename + "'>" +"<b>" + i + "</b></a></li>" );
			}else {
				sb.append("<li class='page-item'><a class='page-link' href='/recommend/detail?currentPage=" + i + "&pCode=" + pCode + "&pFilename=" + pFilename + "'>" +  i   + "</a></li>");
			}
		}

		if(needNext) {
			sb.append("<li class='page-item'><a class='page-link' href='/recommend/detail?currentPage=" +(endNavi+1) +  "&pCode=" + pCode + "&pFilename=" + pFilename + "' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>");
		}
		sb.append("</ul>");
		return sb.toString();
	}
	// 해당 상품의 갯수 가져오는 메소드
	public int reviewTotalCount(Connection conn, String pCode) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int recordTotalCount = 0;
		String query = "select count(*) as totalcount from product_review where p_code=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, pCode);
			rset  = pstmt.executeQuery();
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
	// 상품상세내용 가져오는 메소드
	public ArrayList<Product> recommendDetail(Connection conn, String pCode) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Product> productList =null;
		String query ="select * from product where p_code=? or related_product=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, pCode);
			pstmt.setString(2, pCode);
			rset = pstmt.executeQuery();
			if(rset!=null) {
				productList = new ArrayList<Product>();
				while(rset.next()) {
					Product product = new Product();
					product.setpCode(rset.getString("p_code"));
					product.setSerialNo(rset.getInt("serial_no"));
					product.setSepCode(rset.getString("sep_code"));
					product.setpName(rset.getString("p_name"));
					product.setpPrice(rset.getInt("p_price"));
					product.setpAccount(rset.getInt("p_account"));
					product.setpContents(rset.getString("p_contents"));
					product.setpCategory(rset.getString("p_category"));
					product.setpComcode(rset.getString("p_comcode"));
					product.setpFilename(rset.getString("p_filename"));
					product.setpFilepath(rset.getString("p_filepath"));
					product.setRelatedProduct(rset.getString("related_product"));
					productList.add(product);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return productList;
	}

	// 추천견적 필터링(사무용,게임용,그래픽용,방송용)해서 가져오는 메소드
	public ArrayList<Product> recommendFilter(Connection conn,int currentPage,int recordCountPerPage,String category){
		ArrayList<Product> productFilter = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query ="select * from (select A.*,row_number() over(order by A.serial_no desc)as num from (select * from (select * from product where sep_code='recommend' and p_category=?))A)where num between ? and ?";
		int start = currentPage*recordCountPerPage - (recordCountPerPage-1);
		int end = currentPage*recordCountPerPage;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, category);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			if(rset!=null) {
				productFilter = new ArrayList<Product>();
				while(rset.next()) {
					Product product = new Product();
					product.setpCode(rset.getString("p_code"));
					product.setSerialNo(rset.getInt("serial_no"));
					product.setSepCode(rset.getString("sep_code"));
					product.setpName(rset.getString("p_name"));
					product.setpPrice(rset.getInt("p_price"));
					product.setpAccount(rset.getInt("p_account"));
					product.setpContents(rset.getString("p_contents"));
					product.setpCategory(rset.getString("p_category"));
					product.setpComcode(rset.getString("p_comcode"));
					product.setpFilename(rset.getString("p_filename"));
					product.setpFilepath(rset.getString("p_filepath"));
					product.setRelatedProduct(rset.getString("related_product"));
					productFilter.add(product);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return productFilter;
	}

	// 추천견적 필터한 상품의 페이징 처리 메소드
	public String getFilterNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage, String category) {
		// 전체 페이지의 들어가는 갯수
		int recordTotalCount = filterTotalCount(conn,category);
		// navi 갯수
		int pageTotalCount = 0;
		if(recordTotalCount%recordCountPerPage>0) {
			pageTotalCount = recordTotalCount/recordCountPerPage + 1;
		}else {
			pageTotalCount = recordTotalCount/recordCountPerPage;
		}
		// navi 시작과 끝 구하기
		int startNavi = ((currentPage-1)/naviCountPerPage)*naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage -1;
		// 페이지갯수 오류방지 코드
		if(currentPage<0) {
			currentPage =1;
		}else if(currentPage>pageTotalCount) {
			currentPage = pageTotalCount;
		}
		// navi 오류방지 코드
		if(endNavi>pageTotalCount) {
			endNavi = pageTotalCount;
		}
		// 이전,다음 이동
		boolean needPrev = true;
		boolean needNext = true;

		// 오류방지 코드
		if(startNavi==1) {
			needPrev = false;
		}
		if(endNavi==pageTotalCount) {
			needNext = false;
		}

		// String을 연결해주는 클래스
		StringBuilder sb = new StringBuilder();
		// 이전페이지를 누르면 해당 페이지의 게시물을 가져옴
		sb.append("<ul class='pagination'>");
		if(needPrev) {
			sb.append("<li class='page-item'><a class='page-link' href='/recommend/listview?currentPage=" + (startNavi-1) + "&category="+ category + "' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>");
		}
		for(int i=startNavi; i<=endNavi; i++) {
			if(i==currentPage) {
				sb.append("<li class='page-item'><a class='page-link' href='/recommend/listview?currentPage=" + i + "&category=" + category +  "'>" +"<b>" + i + "</b></a></li>" );
			}else {
				sb.append("<li class='page-item'><a class='page-link' href='/recommend/listview?currentPage=" + i + "&category=" + category +"'>" +  i   + "</a></li>");
			}
		}

		if(needNext) {
			sb.append("<li class='page-item'><a class='page-link' href='/recommend/listview?currentPage=" +(endNavi+1) +  "&category=" + category + "' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>");
		}
		sb.append("</ul>");
		return sb.toString();

	}

	// 필터한 상품의 총 갯수 가져오는 메소드
	public int filterTotalCount(Connection conn, String category) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int recordTotalCount = 0;
		String query ="select count(*) as totalcount from product where sep_code='recommend' and p_category=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, category);
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
	
	// 검색한 완제품 리스트 가져오는 메소드
	public ArrayList<Product> recommendSearch(Connection conn, int currentPage, int recordCountPerPage, String search ){
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Product> productSearch = null;
		String query ="select * from (select A.*, row_number() over(order by A.serial_no desc) as num from (select * from product where sep_code='recommend' and upper(p_name) like upper(?))A) where num between ? and ?";
		int start = currentPage*recordCountPerPage - (recordCountPerPage-1);
		int end = currentPage * recordCountPerPage;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+search+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			if(rset!=null) {
				productSearch = new ArrayList<Product>();
				while(rset.next()) {
					Product product = new Product();
					product.setpCode(rset.getString("p_code"));
					product.setSerialNo(rset.getInt("serial_no"));
					product.setSepCode(rset.getString("sep_code"));
					product.setpName(rset.getString("p_name"));
					product.setpPrice(rset.getInt("p_price"));
					product.setpAccount(rset.getInt("p_account"));
					product.setpContents(rset.getString("p_contents"));
					product.setpCategory(rset.getString("p_category"));
					product.setpComcode(rset.getString("p_comcode"));
					product.setpFilename(rset.getString("p_filename"));
					product.setpFilepath(rset.getString("p_filepath"));
					product.setRelatedProduct(rset.getString("related_product"));
					productSearch.add(product);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return productSearch;
	}
	
	// 검색상품 페이징 처리
	public String getSearchNavi(Connection conn,int currentPage,int recordCountPerPage,int naviCountPerPage,String search) {
		int recordTotalCount = searchTotalCount(conn,search);
		int pageTotalCount = 0;
		if(recordTotalCount%recordCountPerPage>0) {
			pageTotalCount = recordTotalCount/recordCountPerPage +1;
		}else {
			pageTotalCount = recordTotalCount/recordCountPerPage;
		}
		
		int startNavi = ((currentPage-1)/naviCountPerPage)*naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage -1;
		
		if(currentPage<1) {
			currentPage=1;
		}else if(currentPage>pageTotalCount) {
			currentPage=pageTotalCount;
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
			sb.append("<li class='page-item'><a class='page-link' href='/recommend/search?currentPage=" + (startNavi-1) + "&search="+ search + "' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>");
		}
		for(int i=startNavi; i<=endNavi; i++) {
			if(i==currentPage) {
				sb.append("<li class='page-item'><a class='page-link' href='/recommend/search?currentPage=" + i + "&search=" + search +  "'>" +"<b>" + i + "</b></a></li>" );
			}else {
				sb.append("<li class='page-item'><a class='page-link' href='/recommend/search?currentPage=" + i + "&search=" + search +"'>" +  i   + "</a></li>");
			}
		}
		if(needNext) {
			sb.append("<li class='page-item'><a class='page-link' href='/recommend/search?currentPage=" +(endNavi+1) +  "&search=" + search + "' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>");
		}
		sb.append("</ul>");
		return sb.toString();
	}
	
	// 검색한 상품의 갯수
	public int searchTotalCount(Connection conn, String search) {
		PreparedStatement pstmt =null;
		ResultSet rset = null;
		int recordTotalCount = 0;
		String query ="select count(*) as totalcount from product where sep_code='recommend' and upper(p_name) like ? ";
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
	
	// 완제품 카테고리와 가격으로 분류하는 메소드(등급으로 구분)
	public ArrayList<Product> recommendPrice(Connection conn,int currentPage,int recordCountPerPage,String category,String pricegrade) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Product> productPrice = null;
		String query ="";
		if(pricegrade.equals("A")) {
			query = "select * from (select A.*, row_number() over(order by A.serial_no desc) as num from (select* from (select * from product where sep_code='recommend' and p_category=? and p_price>=?))A)where num between ? and ?";
		}else if(pricegrade.equals("B")) {
			query = "select * from (select A.*, row_number() over(order by A.serial_no desc) as num from (select* from (select * from product where sep_code='recommend' and p_category=? and p_price between ? and ?))A)where num between ? and ?";
		}else if(pricegrade.equals("C")){
			query = "select * from (select A.*, row_number() over(order by A.serial_no desc) as num from (select* from (select * from product where sep_code='recommend' and p_category=? and p_price<=?))A)where num between ? and ?";
		}
		int start = currentPage*recordCountPerPage - (recordCountPerPage-1);
		int end = currentPage*recordCountPerPage;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, category);
			if(pricegrade.equals("A")) {
				pstmt.setInt(2, 1200000);
				pstmt.setInt(3, start);
				pstmt.setInt(4, end);
			}else if(pricegrade.equals("B")) {
				pstmt.setInt(2, 600000);
				pstmt.setInt(3, 1200000);
				pstmt.setInt(4, start);
				pstmt.setInt(5, end);
			}else if(pricegrade.equals("C")) {
				pstmt.setInt(2, 600000);
				pstmt.setInt(3, start);
				pstmt.setInt(4, end);
			}
			rset = pstmt.executeQuery();
			if(rset!=null) {
				productPrice = new ArrayList<Product>();
				while(rset.next()) {
					Product product = new Product();
					product.setpCode(rset.getString("p_code"));
					product.setSerialNo(rset.getInt("serial_no"));
					product.setSepCode(rset.getString("sep_code"));
					product.setpName(rset.getString("p_name"));
					product.setpPrice(rset.getInt("p_price"));
					product.setpAccount(rset.getInt("p_account"));
					product.setpContents(rset.getString("p_contents"));
					product.setpCategory(rset.getString("p_category"));
					product.setpComcode(rset.getString("p_comcode"));
					product.setpFilename(rset.getString("p_filename"));
					product.setpFilepath(rset.getString("p_filepath"));
					product.setRelatedProduct(rset.getString("related_product"));
					productPrice.add(product);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return productPrice;
	}
	
	// 페이지 갯수
	public String getPriceNavi(Connection conn, int currentPage,int recordCountPerPage, int naviCountPerPage, String category, String pricegrade) {
		int recordTotalCount = priceTotalCount(conn,category,pricegrade);
		int pageTotalCount = 0;
		if(recordTotalCount%recordCountPerPage>0) {
			pageTotalCount = recordTotalCount/recordCountPerPage + 1;
		}else {
			pageTotalCount = recordTotalCount/recordCountPerPage;
		}
		
		int startNavi = ((currentPage-1)/naviCountPerPage)*naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage -1;
		
		if(currentPage<0) {
			currentPage =1;
		}else if(currentPage==pageTotalCount) {
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
			sb.append("<li class='page-item'><a class='page-link' href='/recommend/listview?currentPage=" + (startNavi-1) + "&category="+ category + "&pricegrade=" + pricegrade + "' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>");
		}
		for(int i=startNavi; i<=endNavi; i++) {
			if(i==currentPage) {
				sb.append("<li class='page-item'><a class='page-link' href='/recommend/listview?currentPage=" + i + "&category=" + category + "&pricegrade=" + pricegrade + "'>" +"<b>" + i + "</b></a></li>" );
			}else {
				sb.append("<li class='page-item'><a class='page-link' href='/recommend/listview?currentPage=" + i + "&category=" + category + "&pricegrade=" + pricegrade + "'>" +  i   + "</a></li>");
			}
		}
		if(needNext) {
			sb.append("<li class='page-item'><a class='page-link' href='/recommend/listview?currentPage=" +(endNavi+1) +  "&category=" + category + "&pricegrade=" + pricegrade + "' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>");
		}
		sb.append("</ul>");
		return sb.toString();
	}
	
	// 카테고리 + 가격별로 조회했을 때 나오는 갯수(등급 별)
	public int priceTotalCount(Connection conn, String category, String pricegrade) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int recordTotalCount = 0;
		String query ="";
		if(pricegrade.equals("A")) {
			query ="select count(*) as totalcount from product where sep_code='recommend' and p_category=? and p_price>=?";
		}else if(pricegrade.equals("B")) {
			query ="select count(*) as totalcount from product where sep_code='recommend' and p_category=? and p_price between ? and ?";
		}else if(pricegrade.equals("C")){
			query ="select count(*) as totalcount from product where sep_code='recommend' and p_category=? and p_price<=?";
		}
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, category);
			if(pricegrade.equals("A")) {
				pstmt.setInt(2, 1200000);
			}else if(pricegrade.equals("B")) {
				pstmt.setInt(2, 600000);
				pstmt.setInt(3, 1200000);
			}else if(pricegrade.equals("C")){
				pstmt.setInt(2, 600000 );
			}
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
	
	// 상품 후기 등록
	public int insertReview(Connection conn, String pCode, String memberId,String title, String contents) {
		PreparedStatement pstmt = null;
		int result =0;
		String query ="insert into product_review values(product_review_seq.nextval,?,?,sysdate,?,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, title);
			pstmt.setString(2, contents);
			pstmt.setString(3, memberId);
			pstmt.setString(4, pCode);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	// 상품 후기 삭제
	public int reviewDelete(Connection conn, String pCode, String memberId,int reviewNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query ="delete from product_review where p_code=? and member_id=? and pr_review_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, pCode);
			pstmt.setString(2, memberId);
			pstmt.setInt(3, reviewNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	// 상품 후기 수정
	public int reviewUpdate(Connection conn, String memberId, String pCode, String title, String contents,int reviewNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update product_review set pr_title=?, pr_contents=? where p_code=? and member_id=? and pr_review_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, title);
			pstmt.setString(2, contents);
			pstmt.setString(3, pCode);
			pstmt.setString(4, memberId);
			pstmt.setInt(5, reviewNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	// 상품 등록
	public int recommendInsert(Connection conn,Product product,String systemFileName) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query 
		="insert into product values(?,SERIAL_NO_SEQ.nextval,?,?,?,1,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, product.getpCode());
			pstmt.setString(2, product.getSepCode());
			pstmt.setString(3, product.getpName());
			pstmt.setInt(4, product.getpPrice());
			pstmt.setString(5, product.getpContents());
			pstmt.setString(6, product.getpCategory());
			pstmt.setString(7, product.getpComcode());
			pstmt.setString(8, systemFileName);
			pstmt.setString(9, product.getpFilepath());
			pstmt.setString(10, product.getRelatedProduct());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
}
