package ku.sci.cs.myapp;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyAppTest {

	@Test
	public void ScheduleTest() {
		//fail("Not yet implemented");
		Schedule s = new Schedule();
	    Calendar c = new Calendar();
	    c.setDate("12/01/2538");    	
	    s.setMemo(c.getDate(), "birthday");
	    String result = s.getMemo("12/01/2538");
	    System.out.println(result);
	    assertEquals("12/01/2538 is birthday",result);
	    
	    
	    
	}

}
