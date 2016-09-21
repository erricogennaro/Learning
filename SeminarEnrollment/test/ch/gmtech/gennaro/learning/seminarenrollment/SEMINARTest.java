package ch.gmtech.gennaro.learning.seminarenrollment;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

public class SEMINARTest {

	private Seminar seminario1;
	
	@Before
	public void testSEMINAR() {
	 seminario1 = new Seminar(new Course("JAVA", 5, "Java for dummies"), "Manno");
	}

	@Test
	public void testAddEnrollment() {
        seminario1.addEnrollment((new Student("Diego", "Maradona")));
        
        Iterator iter = seminario1.getStudentList().listIterator();
        
        while (iter.hasNext()){
       	 
       	 if (!iter.next().toString().equalsIgnoreCase("Diego Maradona")){
       		 assertTrue(true);
       	 }
        }        
	}
		
}
