package ch.gmtech.gennaro.learning.refactoring.parameterobject;

import java.sql.Date;

public class DateRange {

	private final Date start;
	private final Date end;

	public DateRange(Date pstart, Date pend) {
		start = pstart;
		end = pend;
	}

	Date getStart() {
		return start;
	}

	Date getEnd() {
		return end;
	}

	boolean include(Date pdate) {
		return pdate.equals(getStart())|| 
				pdate.equals(getEnd())	|| 
			(pdate.after(getStart()) && pdate.before(getEnd()));
	}
}
