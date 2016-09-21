package ch.gmtech.gennaro.learning.seminarenrollment;

import java.util.Date;

public class Course {
	private String name, description;
	int number;
	Date startDate;
		
	public Course (String pname, int pnumber, String pdescription, Date pstartDate){
		name = pname;
		number = pnumber;
		description = pdescription;
		startDate = pstartDate;
	}

	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getNumber() {
		return number;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
}