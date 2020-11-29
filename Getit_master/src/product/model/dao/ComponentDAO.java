package product.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.JDBCTemplate;
import product.model.vo.Product;

public class ComponentDAO {
//	private COOLER COOLER;
//	private CPU CPU;
//	private GCARD GCARD;
//	private HDD HDD;
//	private MainBoard MainBoard;
//	private POWER POWER;
//	private RAM RAM;
//	private SKIN SKIN;
//	private SSD SSD;
	

	
	
//	CPU
	public ArrayList<Product> cpuList(Connection conn) {
		ArrayList<Product> productList = null;
		Statement stmt = null;
		ResultSet rset = null;
		String cpuQuery
		= "SELECT * FROM (SELECT * FROM PRODUCT WHERE SEP_CODE='COMPONENT') WHERE P_CODE LIKE '%CPU%'";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(cpuQuery);
			if( rset != null) {
				productList = new ArrayList<Product>();
				while(rset.next()) {
					Product pro = new Product();
					pro.setpCode(rset.getString("P_CODE"));
					pro.setSerialNo(rset.getInt("SERIAL_NO"));
					pro.setSepCode(rset.getString("SEP_CODE"));
					pro.setpName(rset.getString("P_NAME"));
					pro.setpPrice(rset.getInt("P_PRICE"));
					pro.setpAccount(rset.getInt("P_ACCOUNT"));
					pro.setpContents(rset.getString("P_CONTENTS"));
					pro.setpCategory(rset.getString("P_CATEGORY"));
					pro.setpComcode(rset.getString("P_COMCODE"));
					// File LINE
					pro.setpFilename(rset.getString("P_FILENAME"));
					pro.setpFilepath(rset.getString("P_FILEPATH"));
					
					pro.setRelatedProduct(rset.getString("RELATED_PRODUCT"));
					productList.add(pro);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		  return productList;
	}
	
	
	
//	MAIN BOARD
	public ArrayList<Product> mboardList(Connection conn) {
		ArrayList<Product> productList = null;
		Statement stmt = null;
		ResultSet rset = null;
		String mboardQuery 
		= "SELECT * FROM (SELECT * FROM PRODUCT WHERE SEP_CODE='COMPONENT') WHERE P_CODE LIKE '%MAINBOARD%'";

		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(mboardQuery);
			if( rset != null) {
				productList = new ArrayList<Product>();
				while(rset.next()) {
					Product pro = new Product();
					pro.setpCode(rset.getString("P_CODE"));
					pro.setSerialNo(rset.getInt("SERIAL_NO"));
					pro.setSepCode(rset.getString("SEP_CODE"));
					pro.setpName(rset.getString("P_NAME"));
					pro.setpPrice(rset.getInt("P_PRICE"));
					pro.setpAccount(rset.getInt("P_ACCOUNT"));
					pro.setpContents(rset.getString("P_CONTENTS"));
					pro.setpCategory(rset.getString("P_CATEGORY"));
					pro.setpComcode(rset.getString("P_COMCODE"));
					// File LINE
					pro.setpFilename(rset.getString("P_FILENAME"));
					pro.setpFilepath(rset.getString("P_FILEPATH"));
					
					pro.setRelatedProduct(rset.getString("RELATED_PRODUCT"));
					productList.add(pro);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		  return productList;
	}
	
	
	
//	COOLER
	public ArrayList<Product> coolerList(Connection conn) {
		ArrayList<Product> productList = null;
		Statement stmt = null;
		ResultSet rset = null;
		String coolerQuery 
		= "SELECT * FROM (SELECT * FROM PRODUCT WHERE SEP_CODE='COMPONENT') WHERE P_CODE LIKE '%COOLER%'";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(coolerQuery);
			if( rset != null) {
				productList = new ArrayList<Product>();
				while(rset.next()) {
					Product pro = new Product();
					pro.setpCode(rset.getString("P_CODE"));
					pro.setSerialNo(rset.getInt("SERIAL_NO"));
					pro.setSepCode(rset.getString("SEP_CODE"));
					pro.setpName(rset.getString("P_NAME"));
					pro.setpPrice(rset.getInt("P_PRICE"));
					pro.setpAccount(rset.getInt("P_ACCOUNT"));
					pro.setpContents(rset.getString("P_CONTENTS"));
					pro.setpCategory(rset.getString("P_CATEGORY"));
					pro.setpComcode(rset.getString("P_COMCODE"));
					// File LINE
					pro.setpFilename(rset.getString("P_FILENAME"));
					pro.setpFilepath(rset.getString("P_FILEPATH"));
					
					pro.setRelatedProduct(rset.getString("RELATED_PRODUCT"));
					productList.add(pro);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		  return productList;
	}
	
	
	
//	GPU(GCARD)
	public ArrayList<Product> gcardList(Connection conn) {
		ArrayList<Product> productList = null;
		Statement stmt = null;
		ResultSet rset = null;
		String gcardQuery 
		= "SELECT * FROM (SELECT * FROM PRODUCT WHERE SEP_CODE='COMPONENT') WHERE P_CODE LIKE '%GPU%'";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(gcardQuery);
			if( rset != null) {
				productList = new ArrayList<Product>();
				while(rset.next()) {
					Product pro = new Product();
					pro.setpCode(rset.getString("P_CODE"));
					pro.setSerialNo(rset.getInt("SERIAL_NO"));
					pro.setSepCode(rset.getString("SEP_CODE"));
					pro.setpName(rset.getString("P_NAME"));
					pro.setpPrice(rset.getInt("P_PRICE"));
					pro.setpAccount(rset.getInt("P_ACCOUNT"));
					pro.setpContents(rset.getString("P_CONTENTS"));
					pro.setpCategory(rset.getString("P_CATEGORY"));
					pro.setpComcode(rset.getString("P_COMCODE"));
					// File LINE
					pro.setpFilename(rset.getString("P_FILENAME"));
					pro.setpFilepath(rset.getString("P_FILEPATH"));
					
					pro.setRelatedProduct(rset.getString("RELATED_PRODUCT"));
					productList.add(pro);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		  return productList;
	}
	
	
	
//	HDD
	public ArrayList<Product> hddList(Connection conn) {
		ArrayList<Product> productList = null;
		Statement stmt = null;
		ResultSet rset = null;
		String hddQuery 
		= "SELECT * FROM (SELECT * FROM PRODUCT WHERE SEP_CODE='COMPONENT') WHERE P_CODE LIKE '%HDD%'";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(hddQuery);
			if( rset != null) {
				productList = new ArrayList<Product>();
				while(rset.next()) {
					Product pro = new Product();
					pro.setpCode(rset.getString("P_CODE"));
					pro.setSerialNo(rset.getInt("SERIAL_NO"));
					pro.setSepCode(rset.getString("SEP_CODE"));
					pro.setpName(rset.getString("P_NAME"));
					pro.setpPrice(rset.getInt("P_PRICE"));
					pro.setpAccount(rset.getInt("P_ACCOUNT"));
					pro.setpContents(rset.getString("P_CONTENTS"));
					pro.setpCategory(rset.getString("P_CATEGORY"));
					pro.setpComcode(rset.getString("P_COMCODE"));
					// File LINE
					pro.setpFilename(rset.getString("P_FILENAME"));
					pro.setpFilepath(rset.getString("P_FILEPATH"));
					
					pro.setRelatedProduct(rset.getString("RELATED_PRODUCT"));
					productList.add(pro);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		  return productList;
	}
	
	
	
//	POWER
	public ArrayList<Product> powerList(Connection conn) {
		ArrayList<Product> productList = null;
		Statement stmt = null;
		ResultSet rset = null;
		String powerQuery 
		= "SELECT * FROM (SELECT * FROM PRODUCT WHERE SEP_CODE='COMPONENT') WHERE P_CODE LIKE '%POWER%'";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(powerQuery);
			if( rset != null) {
				productList = new ArrayList<Product>();
				while(rset.next()) {
					Product pro = new Product();
					pro.setpCode(rset.getString("P_CODE"));
					pro.setSerialNo(rset.getInt("SERIAL_NO"));
					pro.setSepCode(rset.getString("SEP_CODE"));
					pro.setpName(rset.getString("P_NAME"));
					pro.setpPrice(rset.getInt("P_PRICE"));
					pro.setpAccount(rset.getInt("P_ACCOUNT"));
					pro.setpContents(rset.getString("P_CONTENTS"));
					pro.setpCategory(rset.getString("P_CATEGORY"));
					pro.setpComcode(rset.getString("P_COMCODE"));
					// File LINE
					pro.setpFilename(rset.getString("P_FILENAME"));
					pro.setpFilepath(rset.getString("P_FILEPATH"));
					
					pro.setRelatedProduct(rset.getString("RELATED_PRODUCT"));
					productList.add(pro);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		  return productList;
	}
	
	
	
//	RAM
	public ArrayList<Product> ramList(Connection conn) {
		ArrayList<Product> productList = null;
		Statement stmt = null;
		ResultSet rset = null;
		String ramQuery 
		= "SELECT * FROM (SELECT * FROM PRODUCT WHERE SEP_CODE='COMPONENT') WHERE P_CODE LIKE '%RAM%'";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(ramQuery);
			if( rset != null) {
				productList = new ArrayList<Product>();
				while(rset.next()) {
					Product pro = new Product();
					pro.setpCode(rset.getString("P_CODE"));
					pro.setSerialNo(rset.getInt("SERIAL_NO"));
					pro.setSepCode(rset.getString("SEP_CODE"));
					pro.setpName(rset.getString("P_NAME"));
					pro.setpPrice(rset.getInt("P_PRICE"));
					pro.setpAccount(rset.getInt("P_ACCOUNT"));
					pro.setpContents(rset.getString("P_CONTENTS"));
					pro.setpCategory(rset.getString("P_CATEGORY"));
					pro.setpComcode(rset.getString("P_COMCODE"));
					// File LINE
					pro.setpFilename(rset.getString("P_FILENAME"));
					pro.setpFilepath(rset.getString("P_FILEPATH"));
					
					pro.setRelatedProduct(rset.getString("RELATED_PRODUCT"));
					productList.add(pro);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		  return productList;
	}
	
	
	
//	SKIN
	public ArrayList<Product> skinList(Connection conn) {
		ArrayList<Product> productList = null;
		Statement stmt = null;
		ResultSet rset = null;
		String caseQuery 
		= "SELECT * FROM (SELECT * FROM PRODUCT WHERE SEP_CODE='COMPONENT') WHERE P_CODE LIKE '%CASE%'";
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(caseQuery);
			if( rset != null) {
				productList = new ArrayList<Product>();
				while(rset.next()) {
					Product pro = new Product();
					pro.setpCode(rset.getString("P_CODE"));
					pro.setSerialNo(rset.getInt("SERIAL_NO"));
					pro.setSepCode(rset.getString("SEP_CODE"));
					pro.setpName(rset.getString("P_NAME"));
					pro.setpPrice(rset.getInt("P_PRICE"));
					pro.setpAccount(rset.getInt("P_ACCOUNT"));
					pro.setpContents(rset.getString("P_CONTENTS"));
					pro.setpCategory(rset.getString("P_CATEGORY"));
					pro.setpComcode(rset.getString("P_COMCODE"));
					// File LINE
					pro.setpFilename(rset.getString("P_FILENAME"));
					pro.setpFilepath(rset.getString("P_FILEPATH"));
					
					pro.setRelatedProduct(rset.getString("RELATED_PRODUCT"));
					productList.add(pro);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		  return productList;
	}
	
	
	
//	SSD
	public ArrayList<Product> ssdList(Connection conn) {
		ArrayList<Product> productList = null;
		Statement stmt = null;
		ResultSet rset = null;
		String ssdQuery 
		= "SELECT * FROM (SELECT * FROM PRODUCT WHERE SEP_CODE='COMPONENT') WHERE P_CODE LIKE '%SSD%'";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(ssdQuery);
			if( rset != null) {
				productList = new ArrayList<Product>();
				while(rset.next()) {
					Product pro = new Product();
					pro.setpCode(rset.getString("P_CODE"));
					pro.setSerialNo(rset.getInt("SERIAL_NO"));
					pro.setSepCode(rset.getString("SEP_CODE"));
					pro.setpName(rset.getString("P_NAME"));
					pro.setpPrice(rset.getInt("P_PRICE"));
					pro.setpAccount(rset.getInt("P_ACCOUNT"));
					pro.setpContents(rset.getString("P_CONTENTS"));
					pro.setpCategory(rset.getString("P_CATEGORY"));
					pro.setpComcode(rset.getString("P_COMCODE"));
					// File LINE
					pro.setpFilename(rset.getString("P_FILENAME"));
					pro.setpFilepath(rset.getString("P_FILEPATH"));
					
					pro.setRelatedProduct(rset.getString("RELATED_PRODUCT"));
					productList.add(pro);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		  return productList;
	}
	
	
	
//	DESKTOP
	public ArrayList<Product> deskList(Connection conn) {
		ArrayList<Product> productList = null;
		Statement stmt = null;
		ResultSet rset = null;
		String deskQuery 
		= "SELECT * FROM (SELECT * FROM PRODUCT WHERE SEP_CODE='OTHER') WHERE P_CODE LIKE '%MT%'";

		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(deskQuery);
			if( rset != null) {
				productList = new ArrayList<Product>();
				while(rset.next()) {
					Product pro = new Product();
					pro.setpCode(rset.getString("P_CODE"));
					pro.setSerialNo(rset.getInt("SERIAL_NO"));
					pro.setSepCode(rset.getString("SEP_CODE"));
					pro.setpName(rset.getString("P_NAME"));
					pro.setpPrice(rset.getInt("P_PRICE"));
					pro.setpAccount(rset.getInt("P_ACCOUNT"));
					pro.setpContents(rset.getString("P_CONTENTS"));
					pro.setpCategory(rset.getString("P_CATEGORY"));
					pro.setpComcode(rset.getString("P_COMCODE"));
					// File LINE
					pro.setpFilename(rset.getString("P_FILENAME"));
					pro.setpFilepath(rset.getString("P_FILEPATH"));
					
					pro.setRelatedProduct(rset.getString("RELATED_PRODUCT"));
					productList.add(pro);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		  return productList;
	}
	
	
	
//	KEY BOARD
	public ArrayList<Product> keyList(Connection conn) {
		ArrayList<Product> productList = null;
		Statement stmt = null;
		ResultSet rset = null;
		String keyQuery 
		= "SELECT * FROM (SELECT * FROM PRODUCT WHERE SEP_CODE='OTHER') WHERE P_CODE LIKE '%K%'";
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(keyQuery);
			if( rset != null) {
				productList = new ArrayList<Product>();
				while(rset.next()) {
					Product pro = new Product();
					pro.setpCode(rset.getString("P_CODE"));
					pro.setSerialNo(rset.getInt("SERIAL_NO"));
					pro.setSepCode(rset.getString("SEP_CODE"));
					pro.setpName(rset.getString("P_NAME"));
					pro.setpPrice(rset.getInt("P_PRICE"));
					pro.setpAccount(rset.getInt("P_ACCOUNT"));
					pro.setpContents(rset.getString("P_CONTENTS"));
					pro.setpCategory(rset.getString("P_CATEGORY"));
					pro.setpComcode(rset.getString("P_COMCODE"));
					// File LINE
					pro.setpFilename(rset.getString("P_FILENAME"));
					pro.setpFilepath(rset.getString("P_FILEPATH"));
					
					pro.setRelatedProduct(rset.getString("RELATED_PRODUCT"));
					productList.add(pro);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		  return productList;
	}
	
	
	
//	MOUSE
	public ArrayList<Product> mouseList(Connection conn) {
		ArrayList<Product> productList = null;
		Statement stmt = null;
		ResultSet rset = null;
		String mouseQuery 
		= "SELECT * FROM (SELECT * FROM PRODUCT WHERE SEP_CODE='OTHER') WHERE P_CODE LIKE '%MS%'";
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(mouseQuery);
			if( rset != null) {
				productList = new ArrayList<Product>();
				while(rset.next()) {
					Product pro = new Product();
					pro.setpCode(rset.getString("P_CODE"));
					pro.setSerialNo(rset.getInt("SERIAL_NO"));
					pro.setSepCode(rset.getString("SEP_CODE"));
					pro.setpName(rset.getString("P_NAME"));
					pro.setpPrice(rset.getInt("P_PRICE"));
					pro.setpAccount(rset.getInt("P_ACCOUNT"));
					pro.setpContents(rset.getString("P_CONTENTS"));
					pro.setpCategory(rset.getString("P_CATEGORY"));
					pro.setpComcode(rset.getString("P_COMCODE"));
					// File LINE
					pro.setpFilename(rset.getString("P_FILENAME"));
					pro.setpFilepath(rset.getString("P_FILEPATH"));
					
					pro.setRelatedProduct(rset.getString("RELATED_PRODUCT"));
					productList.add(pro);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		  return productList;
	}
	
	
	
//	HEAD SET
	public ArrayList<Product> headSetList(Connection conn) {
		ArrayList<Product> productList = null;
		Statement stmt = null;
		ResultSet rset = null;
		String headQuery 
		= "SELECT * FROM (SELECT * FROM PRODUCT WHERE SEP_CODE='OTHER') WHERE P_CODE LIKE '%HEAD%'";
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(headQuery);
			if( rset != null) {
				productList = new ArrayList<Product>();
				while(rset.next()) {
					Product pro = new Product();
					pro.setpCode(rset.getString("P_CODE"));
					pro.setSerialNo(rset.getInt("SERIAL_NO"));
					pro.setSepCode(rset.getString("SEP_CODE"));
					pro.setpName(rset.getString("P_NAME"));
					pro.setpPrice(rset.getInt("P_PRICE"));
					pro.setpAccount(rset.getInt("P_ACCOUNT"));
					pro.setpContents(rset.getString("P_CONTENTS"));
					pro.setpCategory(rset.getString("P_CATEGORY"));
					pro.setpComcode(rset.getString("P_COMCODE"));
					// File LINE
					pro.setpFilename(rset.getString("P_FILENAME"));
					pro.setpFilepath(rset.getString("P_FILEPATH"));
					
					pro.setRelatedProduct(rset.getString("RELATED_PRODUCT"));
					productList.add(pro);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		  return productList;
	}
	
	
	
//	SPEAKER
	public ArrayList<Product> speakerList(Connection conn) {
		ArrayList<Product> productList = null;
		Statement stmt = null;
		ResultSet rset = null;
		String speakQuery 
		= "SELECT * FROM (SELECT * FROM PRODUCT WHERE SEP_CODE='OTHER') WHERE P_CODE LIKE '%SP%'";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(speakQuery);
			if( rset != null) {
				productList = new ArrayList<Product>();
				while(rset.next()) {
					Product pro = new Product();
					pro.setpCode(rset.getString("P_CODE"));
					pro.setSerialNo(rset.getInt("SERIAL_NO"));
					pro.setSepCode(rset.getString("SEP_CODE"));
					pro.setpName(rset.getString("P_NAME"));
					pro.setpPrice(rset.getInt("P_PRICE"));
					pro.setpAccount(rset.getInt("P_ACCOUNT"));
					pro.setpContents(rset.getString("P_CONTENTS"));
					pro.setpCategory(rset.getString("P_CATEGORY"));
					pro.setpComcode(rset.getString("P_COMCODE"));
					// File LINE
					pro.setpFilename(rset.getString("P_FILENAME"));
					pro.setpFilepath(rset.getString("P_FILEPATH"));
					
					pro.setRelatedProduct(rset.getString("RELATED_PRODUCT"));
					productList.add(pro);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		  return productList;
	}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
