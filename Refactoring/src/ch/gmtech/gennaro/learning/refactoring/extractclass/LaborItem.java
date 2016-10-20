package ch.gmtech.gennaro.learning.refactoring.extractclass;

public class LaborItem extends JobItem {

	private Employee employee;

	public LaborItem(int unitPrice, int quantity, Employee pemployee) {
		super(unitPrice, quantity);
		employee = pemployee;
	}

	public int getUnitPrice(){
		 return employee.getRate();
		 }
}
