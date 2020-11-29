package adminPage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import adminPage.vo.OrderM;
import common.JDBCTemplate;

public class AdminDAO {
	
	public ArrayList<OrderM> depositSearch(Connection conn){
		ArrayList<OrderM> list = null;
		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT*FROM ORDER_INFO JOIN PAY USING (PAY_NO) JOIN PRODUCT USING (P_CODE) JOIN MEMBER_TBL USING(MEMBER_ID) WHERE PAY_YN='N'";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			list = new ArrayList<OrderM>();
			
			while(rset.next()) {
				OrderM orderM = new OrderM();
				
				orderM.setpCode(rset.getString("P_CODE"));
				orderM.setPayNo(rset.getInt("PAY_NO"));
				orderM.setOrderNo(rset.getInt("ORDER_NO"));
				orderM.setChangeYN(rset.getString("CHANGE_YN"));
				orderM.setChangeA(rset.getInt("CHANGE_A"));
				orderM.setChangeRE(rset.getString("CHANGE_RE"));
				orderM.setReturnYN(rset.getString("RETURN_YN"));
				orderM.setReturnA(rset.getInt("RETURN_A"));
				orderM.setReturnRE(rset.getString("RETURN_RE"));
				orderM.setdMessage(rset.getString("D_MESSAGE"));
				orderM.setPayYN(rset.getString("PAY_YN"));
				orderM.setdStatus(rset.getString("D_STATUS"));
				orderM.setPayDate(rset.getDate("PAY_DATE"));
				orderM.setMemberId(rset.getString("MEMBER_ID"));
				orderM.setDeliveryAddress(rset.getString("DELIVERY_ADDRESS"));
				orderM.setAllPrice(rset.getInt("ALLPRICE"));
				orderM.setSerialNo(rset.getInt("SERIAL_NO"));
				orderM.setSepCode(rset.getString("SEP_CODE"));
				orderM.setpName(rset.getString("P_NAME"));
				orderM.setpPrice(rset.getInt("P_PRICE"));
				orderM.setpAccount(rset.getInt("P_ACCOUNT"));
				orderM.setpContents(rset.getString("P_CONTENTS"));
				orderM.setpCategory(rset.getString("P_CATEGORY"));
				orderM.setpComCode(rset.getString("P_COMCODE"));
				orderM.setpFileName(rset.getString("P_FILENAME"));
				orderM.setpFilePath(rset.getString("P_FILEPATH"));
				orderM.setRelatedProduct(rset.getString("RELATED_PRODUCT"));
				
				orderM.setMemberName(rset.getString("MEMBER_NAME"));
				orderM.setGender(rset.getString("GENDER"));
				orderM.setDob(rset.getString("BIRTH"));
				orderM.setEmail(rset.getString("EMAIL"));
				orderM.setPhone(rset.getString("PHONE"));
				orderM.setEnrollDate(rset.getDate("ENROLL_DATE"));
				orderM.setOutYN(rset.getString("OUT_YN"));
				orderM.setOutDate(rset.getDate("OUT_DATE"));
				orderM.setMemberPwd(rset.getString("PASSWORD"));
				orderM.setAddress(rset.getString("ADDRESS"));
				orderM.setDetailAddress(rset.getString("DETAILADDRESS"));
				orderM.setZipcode(rset.getString("ZIPCODE"));
				
				list.add(orderM);				
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		
		return list;
	}
	
	public ArrayList<OrderM> payCompleteSearch(Connection conn){
		ArrayList<OrderM> list = null;
		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT*FROM ORDER_INFO JOIN PAY USING (PAY_NO) JOIN PRODUCT USING (P_CODE) JOIN MEMBER_TBL USING(MEMBER_ID) WHERE PAY_YN='Y' AND D_STATUS IS NULL";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			list = new ArrayList<OrderM>();
			
			while(rset.next()) {
				OrderM orderM = new OrderM();
				
				orderM.setpCode(rset.getString("P_CODE"));
				orderM.setPayNo(rset.getInt("PAY_NO"));
				orderM.setOrderNo(rset.getInt("ORDER_NO"));
				orderM.setChangeYN(rset.getString("CHANGE_YN"));
				orderM.setChangeA(rset.getInt("CHANGE_A"));
				orderM.setChangeRE(rset.getString("CHANGE_RE"));
				orderM.setReturnYN(rset.getString("RETURN_YN"));
				orderM.setReturnA(rset.getInt("RETURN_A"));
				orderM.setReturnRE(rset.getString("RETURN_RE"));
				orderM.setdMessage(rset.getString("D_MESSAGE"));
				orderM.setPayYN(rset.getString("PAY_YN"));
				orderM.setdStatus(rset.getString("D_STATUS"));
				orderM.setPayDate(rset.getDate("PAY_DATE"));
				orderM.setMemberId(rset.getString("MEMBER_ID"));
				orderM.setDeliveryAddress(rset.getString("DELIVERY_ADDRESS"));
				orderM.setAllPrice(rset.getInt("ALLPRICE"));
				orderM.setSerialNo(rset.getInt("SERIAL_NO"));
				orderM.setSepCode(rset.getString("SEP_CODE"));
				orderM.setpName(rset.getString("P_NAME"));
				orderM.setpPrice(rset.getInt("P_PRICE"));
				orderM.setpAccount(rset.getInt("P_ACCOUNT"));
				orderM.setpContents(rset.getString("P_CONTENTS"));
				orderM.setpCategory(rset.getString("P_CATEGORY"));
				orderM.setpComCode(rset.getString("P_COMCODE"));
				orderM.setpFileName(rset.getString("P_FILENAME"));
				orderM.setpFilePath(rset.getString("P_FILEPATH"));
				orderM.setRelatedProduct(rset.getString("RELATED_PRODUCT"));
				
				orderM.setMemberName(rset.getString("MEMBER_NAME"));
				orderM.setGender(rset.getString("GENDER"));
				orderM.setDob(rset.getString("BIRTH"));
				orderM.setEmail(rset.getString("EMAIL"));
				orderM.setPhone(rset.getString("PHONE"));
				orderM.setEnrollDate(rset.getDate("ENROLL_DATE"));
				orderM.setOutYN(rset.getString("OUT_YN"));
				orderM.setOutDate(rset.getDate("OUT_DATE"));
				orderM.setMemberPwd(rset.getString("PASSWORD"));
				orderM.setAddress(rset.getString("ADDRESS"));
				orderM.setDetailAddress(rset.getString("DETAILADDRESS"));
				orderM.setZipcode(rset.getString("ZIPCODE"));
				
				list.add(orderM);				
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		
		return list;
	}
	
	public ArrayList<OrderM> rdfSearch(Connection conn){
		ArrayList<OrderM> list = null;
		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT*FROM ORDER_INFO JOIN PAY USING (PAY_NO) JOIN PRODUCT USING (P_CODE) JOIN MEMBER_TBL USING(MEMBER_ID) WHERE PAY_YN='Y' AND D_STATUS='B'";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			list = new ArrayList<OrderM>();
			
			while(rset.next()) {
				OrderM orderM = new OrderM();
				
				orderM.setpCode(rset.getString("P_CODE"));
				orderM.setPayNo(rset.getInt("PAY_NO"));
				orderM.setOrderNo(rset.getInt("ORDER_NO"));
				orderM.setChangeYN(rset.getString("CHANGE_YN"));
				orderM.setChangeA(rset.getInt("CHANGE_A"));
				orderM.setChangeRE(rset.getString("CHANGE_RE"));
				orderM.setReturnYN(rset.getString("RETURN_YN"));
				orderM.setReturnA(rset.getInt("RETURN_A"));
				orderM.setReturnRE(rset.getString("RETURN_RE"));
				orderM.setdMessage(rset.getString("D_MESSAGE"));
				orderM.setPayYN(rset.getString("PAY_YN"));
				orderM.setdStatus(rset.getString("D_STATUS"));
				orderM.setPayDate(rset.getDate("PAY_DATE"));
				orderM.setMemberId(rset.getString("MEMBER_ID"));
				orderM.setDeliveryAddress(rset.getString("DELIVERY_ADDRESS"));
				orderM.setAllPrice(rset.getInt("ALLPRICE"));
				orderM.setSerialNo(rset.getInt("SERIAL_NO"));
				orderM.setSepCode(rset.getString("SEP_CODE"));
				orderM.setpName(rset.getString("P_NAME"));
				orderM.setpPrice(rset.getInt("P_PRICE"));
				orderM.setpAccount(rset.getInt("P_ACCOUNT"));
				orderM.setpContents(rset.getString("P_CONTENTS"));
				orderM.setpCategory(rset.getString("P_CATEGORY"));
				orderM.setpComCode(rset.getString("P_COMCODE"));
				orderM.setpFileName(rset.getString("P_FILENAME"));
				orderM.setpFilePath(rset.getString("P_FILEPATH"));
				orderM.setRelatedProduct(rset.getString("RELATED_PRODUCT"));
				
				orderM.setMemberName(rset.getString("MEMBER_NAME"));
				orderM.setGender(rset.getString("GENDER"));
				orderM.setDob(rset.getString("BIRTH"));
				orderM.setEmail(rset.getString("EMAIL"));
				orderM.setPhone(rset.getString("PHONE"));
				orderM.setEnrollDate(rset.getDate("ENROLL_DATE"));
				orderM.setOutYN(rset.getString("OUT_YN"));
				orderM.setOutDate(rset.getDate("OUT_DATE"));
				orderM.setMemberPwd(rset.getString("PASSWORD"));
				orderM.setAddress(rset.getString("ADDRESS"));
				orderM.setDetailAddress(rset.getString("DETAILADDRESS"));
				orderM.setZipcode(rset.getString("ZIPCODE"));
				
				list.add(orderM);				
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		
		return list;
	}
	
	public ArrayList<OrderM> deliveryingSearch(Connection conn){
		ArrayList<OrderM> list = null;
		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT*FROM ORDER_INFO JOIN PAY USING (PAY_NO) JOIN PRODUCT USING (P_CODE) JOIN MEMBER_TBL USING(MEMBER_ID) WHERE PAY_YN='Y' AND D_STATUS='D'";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			list = new ArrayList<OrderM>();
			
			while(rset.next()) {
				OrderM orderM = new OrderM();
				
				orderM.setpCode(rset.getString("P_CODE"));
				orderM.setPayNo(rset.getInt("PAY_NO"));
				orderM.setOrderNo(rset.getInt("ORDER_NO"));
				orderM.setChangeYN(rset.getString("CHANGE_YN"));
				orderM.setChangeA(rset.getInt("CHANGE_A"));
				orderM.setChangeRE(rset.getString("CHANGE_RE"));
				orderM.setReturnYN(rset.getString("RETURN_YN"));
				orderM.setReturnA(rset.getInt("RETURN_A"));
				orderM.setReturnRE(rset.getString("RETURN_RE"));
				orderM.setdMessage(rset.getString("D_MESSAGE"));
				orderM.setPayYN(rset.getString("PAY_YN"));
				orderM.setdStatus(rset.getString("D_STATUS"));
				orderM.setPayDate(rset.getDate("PAY_DATE"));
				orderM.setMemberId(rset.getString("MEMBER_ID"));
				orderM.setDeliveryAddress(rset.getString("DELIVERY_ADDRESS"));
				orderM.setAllPrice(rset.getInt("ALLPRICE"));
				orderM.setSerialNo(rset.getInt("SERIAL_NO"));
				orderM.setSepCode(rset.getString("SEP_CODE"));
				orderM.setpName(rset.getString("P_NAME"));
				orderM.setpPrice(rset.getInt("P_PRICE"));
				orderM.setpAccount(rset.getInt("P_ACCOUNT"));
				orderM.setpContents(rset.getString("P_CONTENTS"));
				orderM.setpCategory(rset.getString("P_CATEGORY"));
				orderM.setpComCode(rset.getString("P_COMCODE"));
				orderM.setpFileName(rset.getString("P_FILENAME"));
				orderM.setpFilePath(rset.getString("P_FILEPATH"));
				orderM.setRelatedProduct(rset.getString("RELATED_PRODUCT"));
				
				orderM.setMemberName(rset.getString("MEMBER_NAME"));
				orderM.setGender(rset.getString("GENDER"));
				orderM.setDob(rset.getString("BIRTH"));
				orderM.setEmail(rset.getString("EMAIL"));
				orderM.setPhone(rset.getString("PHONE"));
				orderM.setEnrollDate(rset.getDate("ENROLL_DATE"));
				orderM.setOutYN(rset.getString("OUT_YN"));
				orderM.setOutDate(rset.getDate("OUT_DATE"));
				orderM.setMemberPwd(rset.getString("PASSWORD"));
				orderM.setAddress(rset.getString("ADDRESS"));
				orderM.setDetailAddress(rset.getString("DETAILADDRESS"));
				orderM.setZipcode(rset.getString("ZIPCODE"));
				
				list.add(orderM);				
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		
		return list;
	}
	
	public ArrayList<OrderM> dCompletedSearch(Connection conn){
		ArrayList<OrderM> list = null;
		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT*FROM ORDER_INFO JOIN PAY USING (PAY_NO) JOIN PRODUCT USING (P_CODE) JOIN MEMBER_TBL USING(MEMBER_ID) WHERE PAY_YN='Y' AND D_STATUS='C'";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			list = new ArrayList<OrderM>();
			
			while(rset.next()) {
				OrderM orderM = new OrderM();
				
				orderM.setpCode(rset.getString("P_CODE"));
				orderM.setPayNo(rset.getInt("PAY_NO"));
				orderM.setOrderNo(rset.getInt("ORDER_NO"));
				orderM.setChangeYN(rset.getString("CHANGE_YN"));
				orderM.setChangeA(rset.getInt("CHANGE_A"));
				orderM.setChangeRE(rset.getString("CHANGE_RE"));
				orderM.setReturnYN(rset.getString("RETURN_YN"));
				orderM.setReturnA(rset.getInt("RETURN_A"));
				orderM.setReturnRE(rset.getString("RETURN_RE"));
				orderM.setdMessage(rset.getString("D_MESSAGE"));
				orderM.setPayYN(rset.getString("PAY_YN"));
				orderM.setdStatus(rset.getString("D_STATUS"));
				orderM.setPayDate(rset.getDate("PAY_DATE"));
				orderM.setMemberId(rset.getString("MEMBER_ID"));
				orderM.setDeliveryAddress(rset.getString("DELIVERY_ADDRESS"));
				orderM.setAllPrice(rset.getInt("ALLPRICE"));
				orderM.setSerialNo(rset.getInt("SERIAL_NO"));
				orderM.setSepCode(rset.getString("SEP_CODE"));
				orderM.setpName(rset.getString("P_NAME"));
				orderM.setpPrice(rset.getInt("P_PRICE"));
				orderM.setpAccount(rset.getInt("P_ACCOUNT"));
				orderM.setpContents(rset.getString("P_CONTENTS"));
				orderM.setpCategory(rset.getString("P_CATEGORY"));
				orderM.setpComCode(rset.getString("P_COMCODE"));
				orderM.setpFileName(rset.getString("P_FILENAME"));
				orderM.setpFilePath(rset.getString("P_FILEPATH"));
				orderM.setRelatedProduct(rset.getString("RELATED_PRODUCT"));
				
				orderM.setMemberName(rset.getString("MEMBER_NAME"));
				orderM.setGender(rset.getString("GENDER"));
				orderM.setDob(rset.getString("BIRTH"));
				orderM.setEmail(rset.getString("EMAIL"));
				orderM.setPhone(rset.getString("PHONE"));
				orderM.setEnrollDate(rset.getDate("ENROLL_DATE"));
				orderM.setOutYN(rset.getString("OUT_YN"));
				orderM.setOutDate(rset.getDate("OUT_DATE"));
				orderM.setMemberPwd(rset.getString("PASSWORD"));
				orderM.setAddress(rset.getString("ADDRESS"));
				orderM.setDetailAddress(rset.getString("DETAILADDRESS"));
				orderM.setZipcode(rset.getString("ZIPCODE"));
				
				list.add(orderM);				
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		
		return list;
	}
	
	public ArrayList<OrderM> returnSearch(Connection conn){
		ArrayList<OrderM> list = null;
		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT*FROM ORDER_INFO JOIN PAY USING (PAY_NO) JOIN PRODUCT USING (P_CODE) JOIN MEMBER_TBL USING(MEMBER_ID) WHERE RETURN_YN='Y'";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			list = new ArrayList<OrderM>();
			
			while(rset.next()) {
				OrderM orderM = new OrderM();
				
				orderM.setpCode(rset.getString("P_CODE"));
				orderM.setPayNo(rset.getInt("PAY_NO"));
				orderM.setOrderNo(rset.getInt("ORDER_NO"));
				orderM.setChangeYN(rset.getString("CHANGE_YN"));
				orderM.setChangeA(rset.getInt("CHANGE_A"));
				orderM.setChangeRE(rset.getString("CHANGE_RE"));
				orderM.setReturnYN(rset.getString("RETURN_YN"));
				orderM.setReturnA(rset.getInt("RETURN_A"));
				orderM.setReturnRE(rset.getString("RETURN_RE"));
				orderM.setdMessage(rset.getString("D_MESSAGE"));
				orderM.setPayYN(rset.getString("PAY_YN"));
				orderM.setdStatus(rset.getString("D_STATUS"));
				orderM.setPayDate(rset.getDate("PAY_DATE"));
				orderM.setMemberId(rset.getString("MEMBER_ID"));
				orderM.setDeliveryAddress(rset.getString("DELIVERY_ADDRESS"));
				orderM.setAllPrice(rset.getInt("ALLPRICE"));
				orderM.setSerialNo(rset.getInt("SERIAL_NO"));
				orderM.setSepCode(rset.getString("SEP_CODE"));
				orderM.setpName(rset.getString("P_NAME"));
				orderM.setpPrice(rset.getInt("P_PRICE"));
				orderM.setpAccount(rset.getInt("P_ACCOUNT"));
				orderM.setpContents(rset.getString("P_CONTENTS"));
				orderM.setpCategory(rset.getString("P_CATEGORY"));
				orderM.setpComCode(rset.getString("P_COMCODE"));
				orderM.setpFileName(rset.getString("P_FILENAME"));
				orderM.setpFilePath(rset.getString("P_FILEPATH"));
				orderM.setRelatedProduct(rset.getString("RELATED_PRODUCT"));
				
				orderM.setMemberName(rset.getString("MEMBER_NAME"));
				orderM.setGender(rset.getString("GENDER"));
				orderM.setDob(rset.getString("BIRTH"));
				orderM.setEmail(rset.getString("EMAIL"));
				orderM.setPhone(rset.getString("PHONE"));
				orderM.setEnrollDate(rset.getDate("ENROLL_DATE"));
				orderM.setOutYN(rset.getString("OUT_YN"));
				orderM.setOutDate(rset.getDate("OUT_DATE"));
				orderM.setMemberPwd(rset.getString("PASSWORD"));
				orderM.setAddress(rset.getString("ADDRESS"));
				orderM.setDetailAddress(rset.getString("DETAILADDRESS"));
				orderM.setZipcode(rset.getString("ZIPCODE"));
				
				list.add(orderM);				
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		
		return list;
	}
	public ArrayList<OrderM> changeSearch(Connection conn){
		ArrayList<OrderM> list = null;
		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT*FROM ORDER_INFO JOIN PAY USING (PAY_NO) JOIN PRODUCT USING (P_CODE) JOIN MEMBER_TBL USING(MEMBER_ID) WHERE CHANGE_YN='Y'";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			list = new ArrayList<OrderM>();
			
			while(rset.next()) {
				OrderM orderM = new OrderM();
				
				orderM.setpCode(rset.getString("P_CODE"));
				orderM.setPayNo(rset.getInt("PAY_NO"));
				orderM.setOrderNo(rset.getInt("ORDER_NO"));
				orderM.setChangeYN(rset.getString("CHANGE_YN"));
				orderM.setChangeA(rset.getInt("CHANGE_A"));
				orderM.setChangeRE(rset.getString("CHANGE_RE"));
				orderM.setReturnYN(rset.getString("RETURN_YN"));
				orderM.setReturnA(rset.getInt("RETURN_A"));
				orderM.setReturnRE(rset.getString("RETURN_RE"));
				orderM.setdMessage(rset.getString("D_MESSAGE"));
				orderM.setPayYN(rset.getString("PAY_YN"));
				orderM.setdStatus(rset.getString("D_STATUS"));
				orderM.setPayDate(rset.getDate("PAY_DATE"));
				orderM.setMemberId(rset.getString("MEMBER_ID"));
				orderM.setDeliveryAddress(rset.getString("DELIVERY_ADDRESS"));
				orderM.setAllPrice(rset.getInt("ALLPRICE"));
				orderM.setSerialNo(rset.getInt("SERIAL_NO"));
				orderM.setSepCode(rset.getString("SEP_CODE"));
				orderM.setpName(rset.getString("P_NAME"));
				orderM.setpPrice(rset.getInt("P_PRICE"));
				orderM.setpAccount(rset.getInt("P_ACCOUNT"));
				orderM.setpContents(rset.getString("P_CONTENTS"));
				orderM.setpCategory(rset.getString("P_CATEGORY"));
				orderM.setpComCode(rset.getString("P_COMCODE"));
				orderM.setpFileName(rset.getString("P_FILENAME"));
				orderM.setpFilePath(rset.getString("P_FILEPATH"));
				orderM.setRelatedProduct(rset.getString("RELATED_PRODUCT"));
				
				orderM.setMemberName(rset.getString("MEMBER_NAME"));
				orderM.setGender(rset.getString("GENDER"));
				orderM.setDob(rset.getString("BIRTH"));
				orderM.setEmail(rset.getString("EMAIL"));
				orderM.setPhone(rset.getString("PHONE"));
				orderM.setEnrollDate(rset.getDate("ENROLL_DATE"));
				orderM.setOutYN(rset.getString("OUT_YN"));
				orderM.setOutDate(rset.getDate("OUT_DATE"));
				orderM.setMemberPwd(rset.getString("PASSWORD"));
				orderM.setAddress(rset.getString("ADDRESS"));
				orderM.setDetailAddress(rset.getString("DETAILADDRESS"));
				orderM.setZipcode(rset.getString("ZIPCODE"));
				
				list.add(orderM);				
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		
		return list;
	}
	
	
public int depositCount(Connection conn) {
		
		int result = 0;
		Statement stmt = null;
		ResultSet rset = null;
		String query ="SELECT COUNT(*) FROM ORDER_INFO WHERE PAY_YN='N'";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				result= rset.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		return result;
		
	}
	
	public int payCompleteCount(Connection conn) {
		
		int result = 0;
		Statement stmt = null;
		ResultSet rset = null;
		String query ="SELECT COUNT(*) FROM ORDER_INFO WHERE PAY_YN='Y' AND D_STATUS IS NULL";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				result= rset.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		return result;
		
	}
	
public int rfdCount(Connection conn) {
		
		int result = 0;
		Statement stmt = null;
		ResultSet rset = null;
		String query ="SELECT COUNT(*) FROM ORDER_INFO WHERE D_STATUS='B'";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				result= rset.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		return result;
		
	}public int deliveringCount(Connection conn) {
		
		int result = 0;
		Statement stmt = null;
		ResultSet rset = null;
		String query ="SELECT COUNT(*) FROM ORDER_INFO WHERE D_STATUS='D'";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				result= rset.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		return result;
		
	}public int dCompleteCount(Connection conn) {
		
		int result = 0;
		Statement stmt = null;
		ResultSet rset = null;
		String query ="SELECT COUNT(*) FROM ORDER_INFO WHERE D_STATUS='C'";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				result= rset.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		return result;
		
	}public int returnCount(Connection conn) {
		
		int result = 0;
		Statement stmt = null;
		ResultSet rset = null;
		String query ="SELECT COUNT(*) FROM ORDER_INFO WHERE RETURN_YN='Y'";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				result= rset.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		return result;
		
	}public int changeCount(Connection conn) {
		
		int result = 0;
		Statement stmt = null;
		ResultSet rset = null;
		String query ="SELECT COUNT(*) FROM ORDER_INFO WHERE CHANGE_YN='Y'";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				result= rset.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		return result;
		
	}
	
	public int sendPayC(Connection conn, int orderNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query="UPDATE ORDER_INFO SET PAY_YN='Y' WHERE ORDER_NO=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, orderNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	public int sendRDF(Connection conn, int orderNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query="UPDATE ORDER_INFO SET D_STATUS='B' WHERE ORDER_NO=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, orderNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	public int sendDelivering(Connection conn, int orderNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query="UPDATE ORDER_INFO SET D_STATUS='D' WHERE ORDER_NO=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, orderNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	public int sendDC(Connection conn, int orderNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query="UPDATE ORDER_INFO SET D_STATUS='C' WHERE ORDER_NO=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, orderNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	public int sendChange(Connection conn, int orderNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query="UPDATE ORDER_INFO SET CHANGE_YN=null WHERE ORDER_NO=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, orderNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	public int sendReturn(Connection conn, int orderNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query="UPDATE ORDER_INFO SET RETURN_YN=null WHERE ORDER_NO=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, orderNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	

}
