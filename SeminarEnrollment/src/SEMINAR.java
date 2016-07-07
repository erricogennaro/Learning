import java.util.ArrayList;


public class SEMINAR implements SEMINAR_DETAILS {
	private String seminarName, description, location;
	private static ArrayList<String> studentList;
	private static int seats;
	
	public SEMINAR (COURSE course, String plocation ){
		seminarName = course.getName();
		description = course.getDescription();
		location = plocation;	
		seats = Integer.parseInt( course.getNumber() );
		studentList = new ArrayList<String>();		
	}

	public void addEnrollment(ENROLLMENT penrollment){
		if (seats > 0){
		studentList.add(penrollment.getInfo());
		System.out.println("Iscrizione di "+penrollment.getInfo() + " avvenuta con successo!");
		seats = seats-1;
		}
		else{
		System.out.println("Iscrizione di "+penrollment.getInfo() + " NON POSSIBILE! Posti disponibili terminati!");
		}
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return seminarName;
	}

	@Override
	public String getDescrition() {
		
		return description;
	}

	@Override
	public String getLocation() {
		
		return location;
	}

	@Override
	public int getSeatsLeft() {
			
		return seats;
	}

	@Override
	public ArrayList<String> getStudentList() {		
		return studentList;
				
	}

}
