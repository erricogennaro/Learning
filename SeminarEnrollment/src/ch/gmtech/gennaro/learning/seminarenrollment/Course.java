package ch.gmtech.gennaro.learning.seminarenrollment;

public class Course {
	private String name, description;
	int number;
		
	public Course (String pname, int pnumber, String pdescription){
		name = pname;
		number = pnumber;
		description = pdescription;
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
	
	
}