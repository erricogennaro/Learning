package ch.gmtech.gennaro.learning.seminarenrollment;
import java.util.ArrayList;


public class Seminar implements Seminar_Interface {
	private String seminarName, description, location;
	private static ArrayList<String> studentList;
	private static int seats;
	
	public Seminar (Course course, String plocation ){
		seminarName = course.getName();
		description = course.getDescription();
		location = plocation;	
		seats = course.getNumber();
		studentList = new ArrayList<String>();		
	}

	public void addEnrollment(Student pstudent){
		if (seats > 0){
		studentList.add(pstudent.getInfo());
		System.out.println("Iscrizione di "+pstudent.getInfo() + " avvenuta con successo!");
		seats = seats-1;
		}
		else{
		System.out.println("Iscrizione di "+pstudent.getInfo() + " NON POSSIBILE! Posti disponibili terminati!");
		}
	}
	
	public void removeEnrollment(Student pstudent){
		if (studentList.contains(pstudent.getInfo()))
		{
			studentList.remove(pstudent.getInfo());
		System.out.println("Disiscrizione di "+pstudent.getInfo() + " per il corso di " + getName() + " avvenuta con successo!");
		seats = seats+1;
		}
		else{
		System.out.println("Disiscrizione di "+pstudent.getInfo() + " NON POSSIBILE in quanto non risulta essere iscritto/a al corso " + getName() );
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
