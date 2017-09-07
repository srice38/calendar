package ku.sci.cs.myapp;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application
{
	@Override
    public void start(Stage primaryStage) throws Exception{
		Parent root = FXMLLoader.load(getClass().getResource("View.fxml"));
		primaryStage.setTitle("Schedule");
		primaryStage.setScene(new Scene(root, 1041, 802));
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	    //Schedule s = new Schedule();
	    //Calendar c = new Calendar();
	    //c.setDate("12/01/2538");    	
	    //s.setMemo(c.getDate(), "birthday");
	    //c.setDate("27/2/2550");
	    //s.setMemo(c.getDate(), "My fuze");
	    //System.out.println(s.showMyMemo());
	}
		
    
}
