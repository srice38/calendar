package ku.sci.cs.myapp;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcSQLiteConnection {
	
	       
	public static void main(String[] args) {
		try {
			// setup
			Class.forName("org.sqlite.JDBC");
			String dbURL = "jdbc:sqlite:calendar.db";
			Connection conn = DriverManager.getConnection(dbURL);
			if (conn != null) {
				System.out.println("Connected to the database....");
			// display database information
			DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
			System.out.println("Driver name: " + dm.getDriverName());
			System.out.println("Product name: " + dm.getDatabaseProductName());
			// execute SQL statements
			System.out.println("----- Data in Book table -----");
			String query = "Select * from schedule";
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String date = resultSet.getString(2);
				String event = resultSet.getString(3);
				System.out.println("id:"+id+" date:"+date+"event: "+event);
			}
			
			
			
		      
			
			
			
			
			// close connection
			conn.close();
			}

			} catch (ClassNotFoundException ex) {
				ex.printStackTrace();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		
		}
	
}