package ch.gmtech.gennaro.learning.refactoring.decomposeconditional;

import java.sql.Date;

public class Charge {
	
	public Date SUMMER_START = new Date(2016, 6, 21);
	public Date SUMMER_END = new Date(2016, 9, 21); 
	public Date date;
	public int charge, quantity;
	public int summerRate = 15;
	public int winterRate = 25;
	public int winterServiceCharge = 10;
	
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
		return charge = quantity * winterRate + winterServiceCharge;
		
	}
	
	private int summerCharge (){
		return charge = quantity * summerRate;
		
	}
	

	
}
