package application;

//STEP 1. Import required packages
import java.sql.*;

public class DBConnection {
	
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/library";
	
	// Database credentials
	static final String USER = "root";
	static final String PASS = "";
	
	private Connection conn = null;
	private Statement stmt = null;
	 
	public DBConnection() {
		
		try {
			// register jdbc driver
			Class.forName(JDBC_DRIVER);
			
			// open a connection
			this.conn = DriverManager.getConnection(DB_URL, USER, PASS);
			this.stmt = conn.createStatement();
		}catch(SQLException e) {
			
			e.printStackTrace();
		}catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
	}
	
	public Connection getConn() {
		
		return this.conn;
	}

	public Statement getStmt() {
		
		return this.stmt;
	}
}