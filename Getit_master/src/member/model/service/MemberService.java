package member.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import member.model.dao.MemberDAO;
import member.model.vo.Member;
import member.model.vo.OrderList;
import member.model.vo.ShoppingBag;
import product.model.vo.Product;

public class MemberService {

	private JDBCTemplate factory;
	private MemberDAO memberdao;
	public MemberService() {
		factory = JDBCTemplate.getConnection();

	}



	public Member selectMember(String userId, String userPwd) {
		Member member = null;
		Connection conn = null;

		try {
			conn= factory.createConnection();
			member = new MemberDAO().selectOne(conn, userId, userPwd);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}


		return member;
	}

	public Member selectMember(String userId) {
		Member member = null;
		Connection conn;

		try {
			conn=factory.createConnection();
			member = new MemberDAO().selectOne(conn, userId);
			JDBCTemplate.close(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return member;

	}
	public int updateMember(Member member) {
		int result = 0;
		Connection conn;

		try {
			conn = factory.createConnection();
			result = new MemberDAO().updateMember(conn, member);
			JDBCTemplate.close(conn);

			if(result >0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;


	}

	public int deleteMember(String userId) {
		int result = 0;
		Connection conn;

		try {
			conn = factory.createConnection();
			result = new MemberDAO().deleteMember(conn, userId);
			JDBCTemplate.close(conn);

			if (result > 0) {
				JDBCTemplate.commit(conn);

			}else {
				JDBCTemplate.rollback(conn);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return result;


	}
	public int insertMember(Member member) {
		int result = 0;

		try {
			Connection conn = factory.createConnection();
			result =new MemberDAO().insertMember(conn, member);
			JDBCTemplate.close(conn);

			if (result > 0) {
				JDBCTemplate.commit(conn);

			}else {
				JDBCTemplate.rollback(conn);

			}


		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 리턴 타입 int와 리턴값은 자료형이 같아야함.
		return result;
	}

	public ArrayList<OrderList> orderList(String userId) {
		ArrayList<OrderList> list = null;


		try {
			Connection conn=factory.createConnection();
			list  = new MemberDAO().orderList(conn, userId);
			JDBCTemplate.close(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list ;


	}
	public ArrayList<ShoppingBag> shoppingList(String userId){
		ArrayList<ShoppingBag> list = null;

		try {
			Connection conn = factory.createConnection();
			list = new MemberDAO().shoppingList(conn, userId);
			JDBCTemplate.close(conn);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}
	public OrderList selectOrderList(String orderNo){
		OrderList orderList = new OrderList();

		try {
			Connection conn = factory.createConnection();
			orderList = new MemberDAO().selectOrderList(conn, orderNo);
			JDBCTemplate.close(conn);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return orderList;
	}
	public int updateReturn(OrderList orderList) {
		int result = 0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			result =new MemberDAO().updateReturn(conn, orderList);

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

	public int updateChange(OrderList orderList) {
		int result = 0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			result =new MemberDAO().updateChange(conn, orderList);
			

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
	public int shoppingPayInsert(StringBuilder sb, String userId, String[] pCode, int allPrice,String dMessage){
		int result = 0;
		Connection conn =null;
		try {
			conn = factory.createConnection();
			result = new MemberDAO().shoppingPayInsert(conn, sb, userId, pCode, allPrice, dMessage);
			
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
	
	public int shoppingPayInsertCurr(StringBuilder sb, String userId, String[] pCode, int allPrice,String dMessage){
		int result = 0;
		Connection conn =null;
		try {
			conn = factory.createConnection();
			result = new MemberDAO().shoppingPayInsertCurr(conn, sb, userId, pCode, allPrice, dMessage);
			
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
	
	public int insertPay(String pCode , String userId , StringBuilder sb , int allPrice) {
		int result = 0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			result = new MemberDAO().insertPay(conn, pCode, userId, sb , allPrice);
			
			new MemberDAO().deleteBasket(conn, pCode, userId);
			
			if(result > 0) {
				JDBCTemplate.commit(conn);
				
			}
			else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);			
		}
		
		return result;
	}
	
	public Product selectProduct(String pCode) {
		Product product = new Product();
		
		try {
			Connection conn = factory.createConnection();
			product = new MemberDAO().selectProduct(conn, pCode);
			JDBCTemplate.close(conn);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return product;
		
	}
	
	public int shoppingListDelete(int basketNo) {
		int result = 0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			result = new MemberDAO().shoppingListDelete(conn, basketNo);
			
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
	
	public int shoppingBagEmpty(String userId) {
		int result = 0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			result = new MemberDAO().shoppingBagEmpty(conn, userId);
			
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

	public int basketInsert(String memberId, String pCode) {
		Connection conn = null;
		int result = 0;
		try {
			conn = factory.createConnection();
			result = new MemberDAO().basketInsert(conn, memberId, pCode);
			if(result>0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}



	public int basketSelfInsert(String memberId, String[] component) {
		Connection conn = null;
		int result = 0;
		try {
			conn = factory.createConnection();
			result = new MemberDAO().basketSelfInsert(conn, memberId, component);
			if(result>0) {
				JDBCTemplate.commit(conn);
			}else {
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
