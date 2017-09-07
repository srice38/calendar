package ku.sci.cs.myapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Schedule {
	
	private Map<String,String> memo =  new HashMap<String,String>();
	private ArrayList<String> date = new ArrayList<>();
	
	public void setMemo(String date, String event) {
		this.memo.put(date, event);
		this.date.add(date);
	}
	public String getMemo(String strDate) {	
		String strMemo;
		strMemo = memo.get(strDate);
		return strDate +" is "+ strMemo;
	}
	public String showMyMemo() {
		String strMemo="";
		for(int i = 0;i<memo.size();i++) {
			strMemo = date.get(i) +"  ====>  "+ memo.get(date.get(i)) +"\n"+strMemo;
			
		}
		return strMemo;
	}
	public ArrayList<String> getScheduleLenght(){
		return date  ;
	}

}
