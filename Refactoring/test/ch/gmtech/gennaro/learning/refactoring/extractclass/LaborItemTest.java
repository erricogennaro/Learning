package ch.gmtech.gennaro.learning.refactoring.extractclass;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LaborItemTest {

	LaborItem item1, item2;
	
	@Before
	public void init() {
		item1 = new LaborItem(10, 5, new Employee(20));
		item2 = new LaborItem(15, 2, new Employee(30));
				
	}
	
	@Test
	public void testGetTotalPrice() {
		
		assertEquals(100, item1.getTotalPrice() );
		assertEquals(60, item2.getTotalPrice() );
		
	}

	@Test
	public void testGetUnitPrice() {
		
		assertEquals(20, item1.getUnitPrice() );
		assertEquals(30, item2.getUnitPrice() );
		
	}

	@Test
	public void testGetQuantity() {
	
		assertEquals(5, item1.getQuantity() );
		assertEquals(2, item2.getQuantity() );
		
	}

}
