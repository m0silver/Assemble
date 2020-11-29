package member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.JDBCTemplate;
import member.model.vo.Member;
import member.model.vo.OrderList;
import member.model.vo.ShoppingBag;
import product.model.vo.Product;

public class MemberDAO {


	public int insertMember(Connection conn, Member member) {

		PreparedStatement pstmt = null;
		int result=0;
		String query = "INSERT INTO MEMBER_TBL VALUES(?,?,?,?,?,?,SYSDATE,?,?,?,?,?,?)";

		try {
			//연결코드 다 삭제 , Template 로 옮겨졌기 때문
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberName());
			pstmt.setString(3, member.getGender());
			pstmt.setString(4, member.getDob());
			pstmt.setString(5, member.getEmail());
			pstmt.setString(6, member.getPhone());
			pstmt.setString(7, "Y");
			pstmt.setDate(8, null);
			pstmt.setString(9, member.getMemberPwd());
			pstmt.setString(10, member.getAddress());
			pstmt.setString(11, member.getDetailAddress());
			pstmt.setString(12, member.getZipcode());



			result=pstmt.executeUpdate();
			// DB 순서대로 코딩 짜야됨.


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}


		return result;
	}

	public Member selectOne(Connection conn, String userId, String userPwd) {
		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT*FROM MEMBER_TBL WHERE MEMBER_ID='"+ userId+ "'AND PASSWORD='" + userPwd+"'";
		Member member = null;

		try {
			stmt = conn.createStatement();
			rset= stmt.executeQuery(query);

			if(rset.next()) {
				member = new Member();
				member.setMemberId(rset.getString("MEMBER_ID"));
				member.setMemberName(rset.getString("MEMBER_NAME"));
				member.setGender(rset.getString("GENDER"));
				member.setDob(rset.getString("BIRTH"));
				member.setEmail(rset.getString("EMAIL"));
				member.setPhone(rset.getString("PHONE"));
				member.setEnrollDate(rset.getDate("ENROLL_DATE"));
				member.setOutYN(rset.getString("OUT_YN"));
				member.setOutDate(rset.getDate("OUT_DATE"));
				member.setMemberPwd(rset.getString("PASSWORD"));
				member.setAddress(rset.getString("ADDRESS"));
				member.setDetailAddress(rset.getString("DETAILADDRESS"));
				member.setZipcode(rset.getString("ZIPCODE"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}

		return member;


	}
	public Member selectOne(Connection conn, String userId) {
		PreparedStatement pstmt=null;
		ResultSet rset = null;
		String query ="SELECT*FROM MEMBER_TBL WHERE MEMBER_ID=?";
		Member member = null;

		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, userId);
			rset=pstmt.executeQuery();

			if(rset.next()) {
				member = new Member();
				member.setMemberId(rset.getString("MEMBER_ID"));
				member.setMemberName(rset.getString("MEMBER_NAME"));
				member.setGender(rset.getString("GENDER"));
				member.setDob(rset.getString("BIRTH"));
				member.setEmail(rset.getString("EMAIL"));
				member.setPhone(rset.getString("PHONE"));
				member.setEnrollDate(rset.getDate("ENROLL_DATE"));
				member.setOutYN(rset.getString("OUT_YN"));
				member.setOutDate(rset.getDate("OUT_DATE"));
				member.setMemberPwd(rset.getString("PASSWORD"));
				member.setAddress(rset.getString("ADDRESS"));
				member.setDetailAddress(rset.getString("DETAILADDRESS"));
				member.setZipcode(rset.getString("ZIPCODE"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return member;

	}
	public int updateMember(Connection conn, Member member) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "UPDATE MEMBER_TBL SET PASSWORD=?, PHONE=?, ZIPCODE=?, ADDRESS=?, DETAILADDRESS=? WHERE MEMBER_ID=?";
		
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getMemberPwd());
			pstmt.setString(2, member.getPhone());
			pstmt.setString(3, member.getZipcode());
			pstmt.setString(4, member.getAddress());
			pstmt.setString(5, member.getDetailAddress());
			pstmt.setString(6, member.getMemberId());
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
		
	}
	
	public int deleteMember  (Connection conn, String userId) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "DELETE FROM MEMBER_TBL WHERE MEMBER_ID=?";
		
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, userId);
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(pstmt);
				
			}
			return result;
			
		
		
	}
	public ArrayList<OrderList> orderList(Connection conn, String userId) {
		ArrayList<OrderList> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		/* String query = "SELECT*FROM BASKET WHERE MEMBER_ID=?"; */
		String query = "SELECT * FROM ORDER_INFO JOIN PAY USING (PAY_NO) JOIN PRODUCT USING (P_CODE) WHERE PAY.MEMBER_ID=?";
				
			/*	"select * from(select A.*,row_number() over(order by a_no desc) as num from \r\n"
				+ "    (select * from (select * from end_product \r\n"
				+ "            join power_tbl using(power_code) \r\n"
				+ "            join ssd using(ssd_code) \r\n"
				+ "            join skin using(skin_code)\r\n"
				+ "            join gpu using(gpu_code) \r\n"
				+ "            join hdd using (hdd_code)\r\n"
				+ "            join cpu using (cpu_code)\r\n"
				+ "            join mainboard using (mainboard_code) \r\n"
				+ "            join cpucooler using (ccl_code) \r\n"
				+ "            join ram using(ram_code)))A)\r\n"
				+ "                where MEMBER_ID=?";*/
//		ShoppingBag shoppingbag = null;
		
			try {
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1, userId);
				rset = pstmt.executeQuery();
				list = new ArrayList<OrderList>();
				
				while(rset.next()) {
					/*
					 * shoppingbag = new ShoppingBag();
					 * shoppingbag.setBasketNo(rset.getInt("BASKET_NO"));
					 * shoppingbag.setBasketAddress(rset.getString("BAKSET_ADDRESS"));
					 * shoppingbag.setMemberId(rset.getString("MEMBER_ID"));
					 * shoppingbag.setoProductNo(rset.getInt("O_PRODUCT_NO"));
					 * shoppingbag.setaNo(rset.getInt("A_NO"));
					 * shoppingbag.setDelivery(rset.getInt("DELIVERY"));
					 * shoppingbag.setAllPrice(rset.getInt("ALLPRICE"));
					 * shoppingbag.setCpuCode(rset.getString("CPU_CODE"));
					 * shoppingbag.setMainboardCode(rset.getString("MAINBOARD_CODE"));
					 * shoppingbag.setGpuCode(rset.getString("GPU_CODE"));
					 * shoppingbag.setRamCode(rset.getString("RAM_CODE"));
					 * shoppingbag.setSsdCode(rset.getString("SSD_CODE"));
					 * shoppingbag.setHddCode(rset.getString("HDD_CODE"));
					 * shoppingbag.setPowerCode(rset.getString("POWER_CODE"));
					 * shoppingbag.setCclCode(rset.getString("CCL_CODE"));
					 * shoppingbag.setSkinCode(rset.getString("SKIN_CODE"));
					 */
					OrderList orderList = new OrderList();
					orderList.setpCode(rset.getString("P_CODE"));
					orderList.setPayNo(rset.getInt("PAY_NO"));
					orderList.setOrderNo(rset.getInt("ORDER_NO"));
					orderList.setChangeYN(rset.getString("CHANGE_YN"));
					orderList.setChangeA(rset.getInt("CHANGE_A"));
					orderList.setChangeRE(rset.getString("CHANGE_RE"));
					orderList.setReturnYN(rset.getString("RETURN_YN"));
					orderList.setReturnA(rset.getInt("RETURN_A"));
					orderList.setReturnRE(rset.getString("RETURN_RE"));
					orderList.setdMessage(rset.getString("D_MESSAGE"));
					orderList.setPayYN(rset.getString("PAY_YN"));
					orderList.setdStatus(rset.getString("D_STATUS"));
					orderList.setPayDate(rset.getDate("PAY_DATE"));
					orderList.setMemberId(rset.getString("MEMBER_ID"));
					orderList.setDeliveryAddress(rset.getString("DELIVERY_ADDRESS"));
					orderList.setAllPrice(rset.getInt("ALLPRICE"));
					orderList.setSerialNo(rset.getInt("SERIAL_NO"));
					orderList.setSepCode(rset.getString("SEP_CODE"));
					orderList.setpName(rset.getString("P_NAME"));
					orderList.setpPrice(rset.getInt("P_PRICE"));
					orderList.setpAccount(rset.getInt("P_ACCOUNT"));
					orderList.setpContents(rset.getString("P_CONTENTS"));  
					orderList.setpCategory(rset.getString("P_CATEGORY"));
					orderList.setpComCode(rset.getString("P_COMCODE"));
					orderList.setpFileName(rset.getString("P_FILENAME"));
					orderList.setpFilePath(rset.getString("P_FILEPATH"));
					orderList.setRelatedProduct(rset.getString("RELATED_PRODUCT"));
					
					
					list.add(orderList);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(pstmt);
				JDBCTemplate.close(rset);
				
			}
			return list;
		
	}
	
	
	public ArrayList<ShoppingBag> shoppingList(Connection conn, String userId){
		ArrayList<ShoppingBag> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM BASKET JOIN PRODUCT USING (P_CODE) WHERE BASKET.MEMBER_ID=?";
		
		
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, userId);
				rset = pstmt.executeQuery();
				list = new ArrayList<ShoppingBag>();
				
				while(rset.next()) {
					ShoppingBag shoppingbag = new ShoppingBag();
					shoppingbag.setpCode(rset.getString("P_CODE"));
					shoppingbag.setBasketNo(rset.getInt("BASKET_NO"));
					// shoppingbag.setBasketAddress(rset.getString("BASKET_ADDRESS"));
					shoppingbag.setMemberId(rset.getString("MEMBER_ID"));
					// shoppingbag.setDeliveryAddress(rset.getString("DELIVERY_ADDRESS"));
					// shoppingbag.setAllPrice(rset.getInt("ALLPRICE"));
					shoppingbag.setSerialNo(rset.getInt("SERIAL_NO"));
					shoppingbag.setSepCode(rset.getString("SEP_CODE"));
					shoppingbag.setpName(rset.getString("P_NAME"));
					shoppingbag.setpPrice(rset.getInt("P_PRICE"));
					shoppingbag.setpAccount(rset.getInt("P_ACCOUNT"));
					shoppingbag.setpContents(rset.getString("P_CONTENTS"));
					shoppingbag.setpCategory(rset.getString("P_CATEGORY"));
					shoppingbag.setpComcode(rset.getString("P_COMCODE"));
					shoppingbag.setpFileName(rset.getString("P_FILENAME"));
					shoppingbag.setRelatedProduct(rset.getString("RELATED_PRODUCT"));
		
					
					list.add(shoppingbag);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(pstmt);
				JDBCTemplate.close(rset);
				
			}
			
		
		
		return list;
		
		
	}
	public OrderList selectOrderList(Connection conn, String orderNo) {
		OrderList orderList = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM ORDER_INFO JOIN PAY USING (PAY_NO) JOIN PRODUCT USING (P_CODE) WHERE ORDER_INFO.ORDER_NO=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, orderNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				orderList= new OrderList();
				orderList.setpCode(rset.getString("P_CODE"));
				orderList.setPayNo(rset.getInt("PAY_NO"));
				orderList.setOrderNo(rset.getInt("ORDER_NO"));
				orderList.setChangeYN(rset.getString("CHANGE_YN"));
				orderList.setChangeA(rset.getInt("CHANGE_A"));
				orderList.setChangeRE(rset.getString("CHANGE_RE"));
				orderList.setReturnYN(rset.getString("RETURN_YN"));
				orderList.setReturnA(rset.getInt("RETURN_A"));
				orderList.setReturnRE(rset.getString("RETURN_RE"));
				orderList.setdMessage(rset.getString("D_MESSAGE"));
				orderList.setPayYN(rset.getString("PAY_YN"));
				orderList.setdStatus(rset.getString("D_STATUS"));
				orderList.setPayDate(rset.getDate("PAY_DATE"));
				orderList.setMemberId(rset.getString("MEMBER_ID"));
				orderList.setSerialNo(rset.getInt("SERIAL_NO"));
				orderList.setSepCode(rset.getString("SEP_CODE"));
				orderList.setpName(rset.getString("P_NAME"));
				orderList.setpPrice(rset.getInt("P_PRICE"));
				orderList.setpAccount(rset.getInt("P_ACCOUNT"));
				orderList.setpContents(rset.getString("P_CONTENTS"));
				orderList.setpCategory(rset.getString("P_CATEGORY"));
				orderList.setpComCode(rset.getString("P_COMCODE"));
				orderList.setpFileName(rset.getString("P_FILENAME"));
				orderList.setpFilePath(rset.getString("P_FILEPATH"));
				orderList.setRelatedProduct(rset.getString("RELATED_PRODUCT"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return orderList;
	}
	
	
	public int updateReturn(Connection conn, OrderList orderList ) {
		
		PreparedStatement pstmt = null;
		int result=0;
		String query = "UPDATE ORDER_INFO SET RETURN_YN=?, RETURN_A=?,RETURN_RE=? WHERE ORDER_NO=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "Y");
			pstmt.setInt(2,  orderList.getReturnA());
			pstmt.setString(3,  orderList.getReturnRE());
			pstmt.setInt(4,  orderList.getOrderNo());
			
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	public int updateChange(Connection conn, OrderList orderList ) {
		
		PreparedStatement pstmt = null;
		int result=0;
		String query = "UPDATE ORDER_INFO SET CHANGE_YN=?, CHANGE_A=?,CHANGE_RE=? WHERE ORDER_NO=?";
		
		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "Y");
			pstmt.setInt(2,  orderList.getChangeA());
			pstmt.setString(3,  orderList.getChangeRE());
			pstmt.setInt(4,  orderList.getOrderNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	public int shoppingPayInsert(Connection conn, StringBuilder sb, String userId, String[] pCode, int allPrice,
			String dMessage) {

		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT ALL INTO PAY VALUES (PAY_SEQ.NEXTVAL, SYSDATE,?,?,?,?, PAYBASKET_SEQ.NEXTVAL) INTO ORDER_INFO VALUES (ORDER_INFO_SEQ.NEXTVAL, 'N', null,null, 'N', null,null,?,'N',null,PAY_SEQ.NEXTVAL) SELECT * FROM DUAL";
		
		for(int i = 0; i < pCode.length; i++) {
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, userId);
				pstmt.setString(2, pCode[i]);
				pstmt.setString(3, sb.toString());
				pstmt.setInt(4, allPrice);
				pstmt.setString(5, dMessage);
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(pstmt);

			}
		}
		return result;
	}
	
	public void shoppingPayDelete(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		String query = "DELETE FROM BASKET WHERE MEMBER_ID = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
	}
	
	public int shoppingPayInsertCurr(Connection conn, StringBuilder sb, String userId, String[] pCode, int allPrice, String dMessage) {

		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT ALL INTO PAY VALUES (PAY_SEQ.NEXTVAL, SYSDATE,?,?,?,?, PAYBASKET_SEQ.CURRVAL) INTO ORDER_INFO VALUES (ORDER_INFO_SEQ.NEXTVAL, 'N', null,null, 'N', null,null,?,'N',null,PAY_SEQ.NEXTVAL) SELECT * FROM DUAL";
		
		for(int i = 0; i < pCode.length; i++) {
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, userId);
				pstmt.setString(2, pCode[i]);
				pstmt.setString(3, sb.toString());
				pstmt.setInt(4, allPrice);
				pstmt.setString(5, dMessage);
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(pstmt);

			}
		}
		return result;

	}
	
	public int insertPay(Connection conn, String pCode, String userId, StringBuilder sb, int allPrice) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO PAY VALUES(PAY_SEQ.NEXTVAL, SYSDATE, ?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setString(2, pCode);
			pstmt.setInt(3, allPrice);
			pstmt.setString(4, sb.toString());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			JDBCTemplate.close(pstmt);
		}
		
		return result;
		
		
	}
	
	public void deleteBasket(Connection conn, String pCode, String userId) {
		PreparedStatement pstmt = null;
		String query = "DELETE FROM BASKET WHERE P_CODE = ? AND MEMBER_ID = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, pCode);
			pstmt.setString(2, userId);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
	}
	
	public Product selectProduct(Connection conn, String pCode) {
		Product product = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT*FROM PRODUCT WHERE P_CODE=?";
		
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
				product.setRelatedProduct(rset.getString("RELATED_PRODUCT"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		
		return product;
		
		
		
		
	}
	public int shoppingListDelete(Connection conn, int basketNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query= "DELETE FROM BASKET WHERE BASKET_NO=?";
		
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, basketNo);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
		
	}
	
	public int shoppingBagEmpty(Connection conn, String userId) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query= "DELETE FROM BASKET WHERE MEMBER_ID=?";
		
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public int basketInsert(Connection conn, String memberId, String pCode) {
		PreparedStatement pstmt = null;
		int result =0;
		String query ="INSERT INTO BASKET VALUES(BASKET_SEQ.NEXTVAL, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			pstmt.setString(2, pCode);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int basketSelfInsert(Connection conn, String memberId, String[] component) {
		PreparedStatement pstmt = null;
		int result =0;
		String query ="INSERT INTO BASKET VALUES(BASKET_SEQ.NEXTVAL, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			for(int i =0; i<component.length; i++) {
				if(component[i]!="") {
					pstmt.setString(1, memberId);
					pstmt.setString(2,component[i]);
					result = pstmt.executeUpdate();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

}
