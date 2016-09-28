package ch.gmtech.gennaro.learning.seminarenrollment;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

public class SEMINARTest {

	private Seminar seminario1;
	
	@Before
	public void testSEMINAR() {
	 seminario1 = new Seminar(new Course("JAVA", 5, "Java for dummies", new Date(2016, 3, 15, 8, 0, 0)), "Manno");
	}

	@Test
	public void testAddEnrollment() {
        seminario1.addEnrollment((new Student("Diego", "Maradona")));
        
        Iterator iter = seminario1.getStudentList().listIterator();
        
        while (iter.hasNext()){
       	 String value = iter.next().toString();
       	       	 
       	 if (value.equalsIgnoreCase("Diego Maradona")){
       		 assertTrue(true);
       	 } else
       		assertTrue(false);
        }
	}
	
	@Test
	public void testRemoveEnrollment() {
	
	seminario1.addEnrollment((new Student("Diego", "Maradona")));
	seminario1.addEnrollment((new Student("Antonio", "Conte")));
    seminario1.removeEnrollment( (new Student("Diego", "Maradona")));
    
    Iterator iter = seminario1.getStudentList().listIterator();
    
    while (iter.hasNext()){
    	String value = iter.next().toString();
    	
      	 if (value.equalsIgnoreCase("Diego Maradona")){
      		 assertTrue(false);      		 
      	 }
       }
    
	}	
}
