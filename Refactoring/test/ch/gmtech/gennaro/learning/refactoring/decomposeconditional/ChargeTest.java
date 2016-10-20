package ch.gmtech.gennaro.learning.refactoring.decomposeconditional;

import static org.junit.Assert.*;

import java.sql.Date;
import org.junit.Test;

public class ChargeTest {

	
	@Test
	public void testCalculate() {
	
		Charge chargewinter = new Charge(4, new Date(2016, 10, 15));
		Charge chargesummer = new Charge(4, new Date(2016, 8, 15));
		
		assertEquals(110, chargewinter.calculate());
		assertEquals(60, chargesummer.calculate());
				
	}

}
