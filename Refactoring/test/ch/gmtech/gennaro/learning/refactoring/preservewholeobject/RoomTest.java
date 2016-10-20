package ch.gmtech.gennaro.learning.refactoring.preservewholeobject;

import static org.junit.Assert.*;

import org.junit.Test;


public class RoomTest {
	
	@Test
	public void roomTest(){
		
		Room room1 = new Room(new TempRange(28, 10));		
		Room room2 = new Room(new TempRange(26, 19));
		Room room3 = new Room(new TempRange(25, 18));
		HeatingPlan heatingplan = new HeatingPlan(new TempRange(25, 18));
		
		assertFalse(room1.withinPlan(heatingplan));		
		assertFalse(room2.withinPlan(heatingplan));
		assertTrue(room3.withinPlan(heatingplan));
				
	}


}
