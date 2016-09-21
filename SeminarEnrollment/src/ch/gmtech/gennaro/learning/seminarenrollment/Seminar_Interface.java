package ch.gmtech.gennaro.learning.seminarenrollment;
import java.util.ArrayList;


public interface Seminar_Interface {
	
	public Course getCourse();
	public String getLocation();
	public int getSeatsLeft();
	public ArrayList<String> getStudentList();

}
