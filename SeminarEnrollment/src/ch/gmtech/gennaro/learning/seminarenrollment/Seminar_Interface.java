package ch.gmtech.gennaro.learning.seminarenrollment;
import java.util.ArrayList;


public interface Seminar_Interface {
	
	public String getName();
	public String getDescrition();
	public String getLocation();
	public int getSeatsLeft();
	public ArrayList<String> getStudentList();

}
