package ch.gmtech.gennaro.learning.refactoring.extractclass;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class JobItemTest {

	JobItem item1, item2;
	
	@Before
	public void init() {
		item1 = new JobItem(10, 5);
		item2 = new JobItem(15, 2);
				
	}

	@Test
	public void testGetTotalPrice() {
		
		assertEquals(50, item1.getTotalPrice() );
		assertEquals(30, item2.getTotalPrice() );
		
	}

	@Test
	public void testGetUnitPrice() {
		
		assertEquals(10, item1.getUnitPrice() );
		assertEquals(15, item2.getUnitPrice() );
		
	}

	@Test
	public void testGetQuantity() {
	
		assertEquals(5, item1.getQuantity() );
		assertEquals(2, item2.getQuantity() );
		
	}

}
