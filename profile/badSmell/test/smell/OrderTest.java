package smell;

import static org.junit.Assert.*;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

public class OrderTest {
	
	
	private Vector<Item> items;
	private Order order;

	@Before
	public void init(){
		Item lineitem = new Item(1,55,1);
		lineitem.setUnitPrice(10);
		Item lineitem2 = new Item(2,56,3);
		lineitem2.setUnitPrice(20);
		items = new Vector<Item>();
		items.add(lineitem);
		items.add(lineitem2);
		order = new Order(items);
				 
	}
	

	@Test
	public void testEqualsObject() {
	
		Order order1 = new Order(items);
		Object object = new Object();		
		String string = new String ();
		
		assertFalse(order.equals(object));
		assertTrue(order.equals(order));
		assertTrue(order.equals(order1));
		assertFalse(order.equals(string));
		assertFalse(order.equals(null));
			
	}

	@Test
	public void testWriteOrder() {
		StringWriter out = new StringWriter();
		order.writeOrder(new PrintWriter(out));
		
		String expected = "Begin Line Item"+"\n"+
							"Product = 1"+"\n"+
							"Image = 55"+"\n"+
							"Quantity = 1"+"\n"+
							"Total = 10"+"\n"+
							"End Line Item"+"\n"+
							"Begin Line Item"+"\n"+
							"Product = 2"+"\n"+
							"Image = 56"+"\n"+
							"Quantity = 3"+"\n"+
							"Total = 60"+"\n"+
							"End Line Item"+"\n"+
							"Order total = 70"+"\n";
		//System.out.println(out.toString());
		assertEquals(expected, out.toString());
	}

	@Test
	public void testPrintAndGetTotal() {
		StringWriter out = new StringWriter();
		order.writeOrder(new PrintWriter(out));
		
		assertEquals(70, order.printAndGetTotal(items, new PrintWriter(System.out)));
		
	}

	
}
