package ch.gmtech.gennaro.learning.refactoring.preservewholeobject;

public class Room {
	
	 private TempRange _tempRange;
	 
	 public Room (TempRange tempRange){
		 
		 _tempRange = tempRange; 
		 
	 }

// BEGINNING	 
//	boolean withinPlan(HeatingPlan plan) {
//	 int low = daysTempRange().getLow();
//	 int high = daysTempRange().getHigh();
//	 return plan.withinRange(low, high);
//	 }
	boolean withinPlan(HeatingPlan plan) {
		 
		 return plan.withinRange(daysTempRange());
		 }

	private TempRange daysTempRange() {
		
		return _tempRange;
	}
	
	 
	
}
