package adminPage.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import adminPage.dao.AdminDAO;
import adminPage.vo.OrderM;
import common.JDBCTemplate;

public class AdminService {
	
	private JDBCTemplate factory;
	
	public AdminService() {
		factory = JDBCTemplate.getConnection();
	}
	
	
	public ArrayList<OrderM> depositSearch(){
		ArrayList<OrderM> orderM = null;
		
		try {
			Connection conn = factory.createConnection();
			orderM = new AdminDAO().depositSearch(conn);
			JDBCTemplate.close(conn);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderM;
		
		
	}
	public ArrayList<OrderM> payCompleteSearch(){
		ArrayList<OrderM> orderM = null;
		
		try {
			Connection conn = factory.createConnection();
			orderM = new AdminDAO().payCompleteSearch(conn);
			JDBCTemplate.close(conn);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderM;
		
		
	}
	public ArrayList<OrderM> rdfSearch(){
		ArrayList<OrderM> orderM = null;
		
		try {
			Connection conn = factory.createConnection();
			orderM = new AdminDAO().rdfSearch(conn);
			JDBCTemplate.close(conn);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderM;
		
		
	}
	public ArrayList<OrderM> deliveryingSearch(){
		ArrayList<OrderM> orderM = null;
		
		try {
			Connection conn = factory.createConnection();
			orderM = new AdminDAO().deliveryingSearch(conn);
			JDBCTemplate.close(conn);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderM;
		
		
	}
	public ArrayList<OrderM> dCompletedSearch(){
		ArrayList<OrderM> orderM = null;
		
		try {
			Connection conn = factory.createConnection();
			orderM = new AdminDAO().dCompletedSearch(conn);
			JDBCTemplate.close(conn);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderM;
		
		
	}
	public ArrayList<OrderM> returnSearch(){
		ArrayList<OrderM> orderM = null;
		
		try {
			Connection conn = factory.createConnection();
			orderM = new AdminDAO().returnSearch(conn);
			JDBCTemplate.close(conn);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderM;
		
		
	}
	public ArrayList<OrderM> changeSearch(){
		ArrayList<OrderM> orderM = null;
		
		try {
			Connection conn = factory.createConnection();
			orderM = new AdminDAO().changeSearch(conn);
			JDBCTemplate.close(conn);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderM;
		
		
	}
	public int depositCount() {
		int result = 0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			result = new AdminDAO().depositCount(conn);
			
			
			if (result > 0) {
				JDBCTemplate.commit(conn);

			}else {
				JDBCTemplate.rollback(conn);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);			
		}


		return result;
		
	}
	
	public int payCompleteCount() {
		int result = 0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			result = new AdminDAO().payCompleteCount(conn);
			
			
			if (result > 0) {
				JDBCTemplate.commit(conn);

			}else {
				JDBCTemplate.rollback(conn);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);			
		}


		return result;
		
	}
	
	public int rfdCount() {
		int result = 0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			result = new AdminDAO().rfdCount(conn);
			
			
			if (result > 0) {
				JDBCTemplate.commit(conn);

			}else {
				JDBCTemplate.rollback(conn);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);			
		}


		return result;
		
	}public int deliveringCount() {
		int result = 0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			result = new AdminDAO().deliveringCount(conn);
			
			
			if (result > 0) {
				JDBCTemplate.commit(conn);

			}else {
				JDBCTemplate.rollback(conn);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);			
		}


		return result;
		
	}public int dCompleteCount() {
		int result = 0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			result = new AdminDAO().dCompleteCount(conn);
			
			
			if (result > 0) {
				JDBCTemplate.commit(conn);

			}else {
				JDBCTemplate.rollback(conn);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);			
		}


		return result;
		
	}public int returnCount() {
		int result = 0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			result = new AdminDAO().returnCount(conn);
			
			
			if (result > 0) {
				JDBCTemplate.commit(conn);

			}else {
				JDBCTemplate.rollback(conn);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);			
		}


		return result;
		
	}
	public int changeCount() {
		int result = 0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			result = new AdminDAO().changeCount(conn);
			
			
			if (result > 0) {
				JDBCTemplate.commit(conn);

			}else {
				JDBCTemplate.rollback(conn);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);			
		}


		return result;
		
	}
	public int sendPayC(int orderNo) {
		int result = 0;
		Connection conn = null;
		
		try {
			conn = factory.createConnection();
			result = new AdminDAO().sendPayC(conn,orderNo);
			
			
			if (result > 0) {
				JDBCTemplate.commit(conn);

			}else {
				JDBCTemplate.rollback(conn);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);			
		}


		return result;
		
	}
	public int sendRDF(int orderNo) {
		int result = 0;
		Connection conn = null;
		
		try {
			conn = factory.createConnection();
			result = new AdminDAO().sendRDF(conn,orderNo);
			
			
			if (result > 0) {
				JDBCTemplate.commit(conn);

			}else {
				JDBCTemplate.rollback(conn);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);			
		}


		return result;
		
	}
	public int sendDelivering(int orderNo) {
		int result = 0;
		Connection conn = null;
		
		try {
			conn = factory.createConnection();
			result = new AdminDAO().sendDelivering(conn,orderNo);
			
			
			if (result > 0) {
				JDBCTemplate.commit(conn);

			}else {
				JDBCTemplate.rollback(conn);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);			
		}


		return result;
		
	}
	public int sendDC(int orderNo) {
		int result = 0;
		Connection conn = null;
		
		try {
			conn = factory.createConnection();
			result = new AdminDAO().sendDC(conn,orderNo);
			
			
			if (result > 0) {
				JDBCTemplate.commit(conn);

			}else {
				JDBCTemplate.rollback(conn);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);			
		}


		return result;
		
	}
	public int sendChange(int orderNo) {
		int result = 0;
		Connection conn = null;
		
		try {
			conn = factory.createConnection();
			result = new AdminDAO().sendChange(conn,orderNo);
			
			
			if (result > 0) {
				JDBCTemplate.commit(conn);

			}else {
				JDBCTemplate.rollback(conn);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);			
		}


		return result;
		
	}
	public int sendReturn(int orderNo) {
		int result = 0;
		Connection conn = null;
		
		try {
			conn = factory.createConnection();
			result = new AdminDAO().sendReturn(conn,orderNo);
			
			
			if (result > 0) {
				JDBCTemplate.commit(conn);

			}else {
				JDBCTemplate.rollback(conn);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);			
		}


		return result;
		
	}
	
}