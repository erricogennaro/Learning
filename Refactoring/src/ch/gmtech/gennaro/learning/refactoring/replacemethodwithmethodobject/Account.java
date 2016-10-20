package ch.gmtech.gennaro.learning.refactoring.replacemethodwithmethodobject;

public class Account {

// BEGINNING	
//	int gamma(int inputVal, int quantity, int yearToDate) {
//		int importantValue1 = (inputVal * quantity) + delta();
//		int importantValue2 = (inputVal * yearToDate) + 100;
//		if ((yearToDate - importantValue1) > 100)
//			importantValue2 -= 20;
//		int importantValue3 = importantValue2 * 7;
//		// and so on.
//		return importantValue3 - 2 * importantValue1;
//
//	}
	
	int gamma (int inputVal, int quantity, int yearToDate) {
		 return new Gamma(this, inputVal, quantity,yearToDate).compute();
		 }
	

	public int delta() {
		return 10;
	}
}