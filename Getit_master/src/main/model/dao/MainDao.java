package main.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.JDBCTemplate;
import deal.model.vo.Deal;
import product.model.vo.Product;

public class MainDao {
	
	public MainDao() {}
	
	public ArrayList<Product> selectAllProduct(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<Product> productList = null;
		String query 
= "select * from(select A.*,row_number() OVER(PARTITION by A.sep_code order by A.serial_no desc) as num  from (select * from product)A) where num between 1and 4";
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
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
					productList.add(product);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		return productList;
	}
	
	public ArrayList<Deal> selectAllDeal(Connection conn){
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<Deal> dList = null;
		String query 
			= "select * from deal";
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			if(rset!=null) {
				dList = new ArrayList<Deal>();
				while(rset.next()) {
					Deal deal = new Deal();
					deal.setDealNo(rset.getInt("DEAL_NO"));
					deal.setDealTitle(rset.getString("DEAL_TITLE"));
					deal.setDealContents(rset.getString("DEAL_CONTENTS"));
					deal.setDealPrice(rset.getInt("DEAL_PRICE"));
					deal.setDealDate(rset.getDate("DEAL_DATE"));
					deal.setDealFileName(rset.getString("DEAL_FILENAME"));
					deal.setDealFilePath(rset.getString("DEAL_FILEPATH"));
					deal.setMemberId(rset.getString("MEMBER_ID"));
					dList.add(deal);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		return dList;
	}
}
