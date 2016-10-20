package ch.gmtech.gennaro.learning.refactoring.parameterobject;

import java.sql.Date;
import java.util.Enumeration;
import java.util.Vector;

/*BEGINNING Account
public class Account {

	private Vector _entries = new Vector();

	double getFlowBetween(Date start, Date end) {
		double result = 0;
		Enumeration e = _entries.elements();
		while (e.hasMoreElements()) {
			Entry each = (Entry) e.nextElement();
			if (each.getDate().equals(start)|| 
				each.getDate().equals(end)	|| 
				(each.getDate().after(start) && each.getDate().before(end))
				) {

				result += each.getValue();
			}
		}
		return result;
	}
*/

public class Account {

	private Vector _entries = new Vector();

	double getFlowBetween(DateRange pdaterange) {
		double result = 0;
		Enumeration e = _entries.elements();
		while (e.hasMoreElements()) {
			Entry each = (Entry) e.nextElement();
			if (pdaterange.include(each.getDate())
				) {

				result += each.getValue();
			}
		}
		return result;
	}

	public void addEntry (Entry element){
		_entries.add(element);
	}
}

/*
 * client code... double flow = anAccount.getFlowBetween(startDate, endDate);
 */
