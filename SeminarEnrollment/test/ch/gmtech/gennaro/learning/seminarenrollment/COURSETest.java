package ch.gmtech.gennaro.learning.seminarenrollment;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class COURSETest {
	
	private Course course;
	
	 @Before
	public void testCOURSE() {		
		course = new Course("pippo", 4, "java per dummies", new Date(2016, 3, 15, 8, 0, 0));		
		
	}

	@Test
	public void testGetName() {
		assertTrue(course.getName().equalsIgnoreCase("pippo"));
	}

	@Test
	public void testGetDescription() {
		assertTrue(course.getDescription().equalsIgnoreCase("java per dummies"));
	}

	@Test
	public void testGetNumber() {
		assertTrue(course.getNumber() == 4 );
	}

}
