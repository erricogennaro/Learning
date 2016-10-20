package ch.gmtech.gennaro.learning.refactoring.decomposeconditional;

import java.sql.Date;

public class Charge {
	
	private Date SUMMER_START = new Date(2016, 6, 21);
	private Date SUMMER_END = new Date(2016, 9, 21); 
	private Date date;
	private int quantity;
	private int summerRate = 15;
	private int winterRate = 25;
	private int winterServiceCharge = 10;
	
	public Charge (int pquantity, Date pdate) {
		date = pdate;
		quantity = pquantity;		
	}
	
//	if (date.before (SUMMER_START) || date.after(SUMMER_END))
//	 charge = quantity * _winterRate + _winterServiceCharge;
//	 else charge = quantity * _summerRate;
//
//}
	
	public int calculate (){
	
	if (isSummer())
		 return summerCharge();
	 else return winterCharge();
	
	}
	
	private boolean isSummer () {
			
		if (date.after(SUMMER_START) && date.before(SUMMER_END))
			return true;
			
			return false;
	}
	
	private int winterCharge (){
		return quantity * winterRate + winterServiceCharge;
		
	}
	
	private int summerCharge (){
		return quantity * summerRate;
		
	}
	

	
}
