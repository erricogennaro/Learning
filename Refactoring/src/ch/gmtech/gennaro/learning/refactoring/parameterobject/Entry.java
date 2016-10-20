package ch.gmtech.gennaro.learning.refactoring.parameterobject;

import java.sql.Date;

/*BEGINNING CLASS*/
public class Entry {

	private Date _chargeDate;
	private double _value;
	 
	 
	 Entry (double value, Date chargeDate) {
	 _value = value;
	 _chargeDate = chargeDate;
	 }
	 Date getDate(){
	 return _chargeDate;
	 }
	 double getValue(){
	 return _value;
	 }
	 
}