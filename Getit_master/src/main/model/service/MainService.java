package main.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import deal.model.dao.DealDAO;
import deal.model.vo.Deal;
import main.model.dao.MainDao;
import product.model.vo.Product;

public class MainService {

	public JDBCTemplate factory;
	
	public MainService() {
		factory = JDBCTemplate.getConnection();
	}
	
	public ArrayList<Product> selectAllProduct() {
		Connection conn = null;
		ArrayList<Product> productList = null;
		try {
			conn = factory.createConnection();
			productList =  new MainDao().selectAllProduct(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return productList;
	}
	
	public ArrayList<Deal> selectAllDeal(){
		Connection conn = null;
		ArrayList<Deal> dList = null;
		try {
			conn = factory.createConnection();
			dList =  new MainDao().selectAllDeal(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return dList;
	}
}
