package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbUtil {
	final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	final static String DB_URL = "jdbc:mysql://localhost:3306/db_englishlearningonline";
	final static String dbname = "root";
	final static String dbpwd = "root";
	
	  public static Connection getConnection() {
		  
	        Connection conn = null;
	        try {
	            InitDatabase.getInitDatabase();
				Class.forName(JDBC_DRIVER);
	            conn = DriverManager.getConnection(DB_URL,dbname, dbpwd);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return conn;
	    }
	  
	public static  boolean  existDatabase(){
			return  InitDatabase.exists_db(dbname);
	}
	  
	  public static void closeAll(PreparedStatement pstmt, ResultSet rs) {
		  
	  	   Connection conn = DbUtil.getConnection();
	        try {
	            if (rs != null) {
	                rs.close();
	            }
	            if (pstmt != null) {
	                pstmt.close();
	            }
	            if (conn != null) {
	                conn.close();
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	  
	    public static int executUpdate(String sql, Object[] param) {
	   	   Connection conn = DbUtil.getConnection();
	        int result = 0;
	        PreparedStatement pstmt = null;
	        try {
	            pstmt = conn.prepareStatement(sql);
	            if (param != null) {
	                for (int i = 0; i < param.length; i++) {
	                    pstmt.setObject(i + 1, param[i]);
	                }
	            }
	            result = pstmt.executeUpdate();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            closeAll(pstmt, null);
	        }
	        return result;
	    }
	    
	    public static ResultSet executQuery(String sql, String[] param) {
	    	
	    	   Connection conn = DbUtil.getConnection();
	    	   
	        PreparedStatement pstmt = null;
	        ResultSet result = null;
	        try {
	            pstmt = conn.prepareStatement(sql);
	            if (param != null) {
	                for (int i = 0; i < param.length; i++) {
	                    pstmt.setString(i + 1, param[i]);
	                }
	            }
	            result = pstmt.executeQuery();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            closeAll(pstmt, null);
	        } 
	        return result;
	    }
}
