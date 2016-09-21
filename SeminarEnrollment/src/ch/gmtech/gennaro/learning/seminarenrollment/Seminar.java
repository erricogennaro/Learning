package ch.gmtech.gennaro.learning.seminarenrollment;
import java.util.ArrayList;
import java.util.Date;


public class Seminar implements Seminar_Interface {
	private Course course;
	private String location;
	private static ArrayList<String> studentList;
	private static int seats;
	
	public Seminar (Course pcourse, String plocation ){
		course = pcourse;
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
		System.out.println("Disiscrizione di "+pstudent.getInfo() + " per il corso di " + course.getName() + " avvenuta con successo!");
		seats = seats+1;
		}
		else{
		System.out.println("Disiscrizione di "+pstudent.getInfo() + " NON POSSIBILE in quanto non risulta essere iscritto/a al corso " + course.getName() );
		}
	}
	
	
	public Course getCourse() {
		return course;
	}

	
	@Override
	public int getSeatsLeft() {
		return seats;
	}

	@Override
	public ArrayList<String> getStudentList() {		
		return studentList;
	}

	@Override
	public String getLocation() {
		return location;
	}
	
	

}
