package ku.sci.cs.myapp;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
	@FXML
    protected TextArea showMySchedule;
	@FXML
    protected Button save;
	@FXML
    protected TextField inpDate;
	@FXML
    protected TextField inpEvent;	
	@FXML
    protected TextField inpDel;	
	@FXML
	public void handlebtnInsert(ActionEvent event) {
		getText();
		addSchedule();
		showSchedule();
		
		
		
	}
	
	@FXML
	public void handleShowSchedule(ActionEvent event) {		
		showSchedule();
	}
	@FXML
	public void handleDeleteEvent(ActionEvent event) throws SQLException {			
		deleteEvent(Integer.parseInt(inpDel.getText()));
		showSchedule();
		inpDel.clear();
		
	}

	
	
	
	public void getText() {		
		temporaryDate = inpDate.getText();
		temporaryEvent = inpEvent.getText();		
		inpDate.clear();
		inpEvent.clear();
	}
	public void addSchedule() {
		calendar.setDate(temporaryDate);
		schedule.setMemo(calendar.getDate(), temporaryEvent);
		dataInsert(calendar.getDate(), temporaryEvent);
	}
	public void showSchedule() {
		showMySchedule.setText(this.selectAll());
	}
	
	Calendar calendar = new Calendar();
	Schedule schedule = new Schedule();	
	String temporaryDate = "";
	String temporaryEvent = "";
	String temporaryDel = "";
	
	
	//Database	
	public Connection databaseConnection() throws SQLException {
		Connection conn = null;
		try {
			// setup
			Class.forName("org.sqlite.JDBC");
			String dbURL = "jdbc:sqlite:calendar.db";
			conn = DriverManager.getConnection(dbURL);
			if (conn != null) {
				System.out.println("Connected to the database.");
			}
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return conn;
	}
	public void dataInsert(String date, String event) {
        String sql = "INSERT INTO schedule(id,date,event) VALUES(?,?,?)";
 
        try (Connection conn = this.databaseConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
        	//pstmt.setInt(1, schedule.getScheduleLenght().size()+1);
            pstmt.setString(2, date);
            pstmt.setString(3, event);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
	}

	
	 public String selectAll() {
	        String sql = "SELECT * FROM schedule";
	        String text = "";
	        
	        try (Connection conn = this.databaseConnection();
	             Statement stmt  = conn.createStatement();
	             ResultSet rs    = stmt.executeQuery(sql)){
	        	
	        	DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
				System.out.println("Driver name: " + dm.getDriverName());
				System.out.println("Product name: " + dm.getDatabaseProductName());
				
	            // loop through the result set
	            while (rs.next()) {
	                text = " Event ID: " + rs.getString("id") +" -----  Date: " + rs.getString("date") +" -----  Event: "+ rs.getString("event") +"\n" + text;
	            }
	            
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
			return text;
	    }
	 public void deleteEvent(int i) throws SQLException {
			String sql = "DELETE FROM schedule WHERE id = ?";
			try {Connection conn = this.databaseConnection();
				PreparedStatement pst = null;
				pst = conn.prepareStatement(sql);
				pst.setInt(1,i);
				pst.executeUpdate();
				System.out.println("Delete Event");
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} 
		
		}
	
	

}
