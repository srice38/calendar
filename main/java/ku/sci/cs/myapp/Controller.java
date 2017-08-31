package ku.sci.cs.myapp;

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
	public void handlebtnSave(ActionEvent event) {
		getText();
		addSchedule();
		showSchedule();
	}
	
	Calendar calendar = new Calendar();
	Schedule schedule = new Schedule();
	String temporaryDate = "";
	String temporaryEvent = "";
	
	public void getText() {
		temporaryDate = inpDate.getText();
		temporaryEvent = inpEvent.getText();		
		inpDate.clear();
		inpEvent.clear();
	}
	public void addSchedule() {
		calendar.setDate(temporaryDate);
		schedule.setMemo(calendar.getDate(), temporaryEvent);
	}
	public void showSchedule() {
		showMySchedule.setText(schedule.showMyMemo());
	}
	

}
