package ch.gmtech.gennaro.learning.seminarenrollment;

public class Student {

	private String name, surname;
	
	public Student (String pname, String psurname){
	name = pname;
	surname = psurname;
	}
	
		
	public String getInfo(){
		return getName() + " " + getSurname();
	}
		
	private String getName(){
		return name ;
	}
	
	private String getSurname(){
		return surname;
	}
	
	
}
