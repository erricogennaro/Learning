package ch.gmtech.gennaro.learning.refactoring.parameterobject;

import static org.junit.Assert.*;

import java.sql.Date;
import org.junit.Before;
import org.junit.Test;

/*BEGINNING TEST
public class AccountTest {

	Date start;
	Date end;
	Account account;

	@Before
	public void init(){
		start = new Date(2016, 10, 5);
		end = new Date(2016, 10, 15);
		account = new Account();
		account.addEntry(new Entry(5.5, new Date(2016, 10, 7)));
		account.addEntry(new Entry(5.1, new Date(2016, 10, 10)));
	}
	
	
	@Test
	public void testgetFlowBetween() {
		
		System.out.println ( account.getFlowBetween(start, end));
		
	}
*/

public class AccountTest {

	DateRange daterange;
	Account account;

	@Before
	public void init(){
				
		daterange = new DateRange(new Date(2016, 10, 5), new Date(2016, 10, 15));
		
		account = new Account();
		account.addEntry(new Entry(5.5, new Date(2016, 10, 7)));
		account.addEntry(new Entry(5.1, new Date(2016, 10, 10)));
	}
	
	
	@Test
	public void testgetFlowBetween() {
		
		System.out.println ( account.getFlowBetween(daterange));
		
	}


}
