package ch.gmtech.gennaro.learning.refactoring.preservewholeobject;

public class TempRange {

	private int low;
	private int high;

	public TempRange (int phigh, int plow){
		high = phigh;
		low = plow;
	}
	
	boolean includes (TempRange arg) {
		 return arg.getLow() >= this.getLow() && arg.getHigh() <= this.getHigh();
		 
	}

	public int getHigh() {
		return high;
	}

	public int getLow() {
		return low;
	}
}
