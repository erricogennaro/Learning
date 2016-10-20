package ch.gmtech.gennaro.learning.refactoring.preservewholeobject;

public class HeatingPlan {

	private TempRange _range;
	
//	 boolean withinRange (int low, int high) {
//	 return (low >= _range.getLow() && high <= _range.getHigh());
//	 }
	
	public HeatingPlan (TempRange temprange){
		_range = temprange;
	}
	
//	boolean withinRange (TempRange range) {
//		 return (range.getLow() >= _range.getLow() && range.getHigh() <= _range.getHigh());
//		 }
	
	boolean withinRange (TempRange range) {
	
			 return _range.includes(range);
		}
	 
	
}
