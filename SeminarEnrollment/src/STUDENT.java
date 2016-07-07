
public class STUDENT {

	private String name, surname;
	
	public STUDENT (String pname, String psurname){
	name = pname;
	surname = psurname;
	}
	
		
	public String getInfo(){
		return getFullName();
	}
	
	
	private String getFullName(){
		return name + " " + surname;
	}
	
}
