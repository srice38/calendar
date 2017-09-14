package ku.sci.cs.myapp;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Calendar {
	String strDate;
	Date date ;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public void setDate(String strDate) {
		this.strDate = strDate;
		try {
			this.date = sdf.parse(strDate);		
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}		
	}
	public String getDate(){
		return sdf.format(this.date);
	}
}
