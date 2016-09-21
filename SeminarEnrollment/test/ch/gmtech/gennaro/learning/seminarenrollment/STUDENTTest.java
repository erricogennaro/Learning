package ch.gmtech.gennaro.learning.seminarenrollment;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class STUDENTTest {

	private Student student;
	
	@Before
	public void STUDENTTest() {
	 student = new Student("pippo", "baudo");
	}
	
	
	@Test
	public void testGetInfo() {
		assertTrue( student.getInfo().equalsIgnoreCase("pippo baudo") );
	}

}
