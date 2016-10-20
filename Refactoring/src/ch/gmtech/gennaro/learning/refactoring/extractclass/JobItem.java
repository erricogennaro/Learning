package ch.gmtech.gennaro.learning.refactoring.extractclass;

public class JobItem {
	
	 private int _unitPrice;
	 private int _quantity;
	 //private Employee _employee;
	 //private boolean _isLabor;
	 	 
 	 public JobItem (int unitPrice, int quantity ) { //, Employee employee  boolean isLabor,
	 _unitPrice = unitPrice;
	 _quantity = quantity;
	 //_isLabor = isLabor;
	 //_employee = employee;
	 }
 	 
	 public int getTotalPrice() {
	 return getUnitPrice() * _quantity;
	 }
	 
	 public int getUnitPrice(){
	 //return (_isLabor) ? _employee.getRate(): _unitPrice;
		 return _unitPrice;
	 }
	 
	 public int getQuantity(){
	 return _quantity;
	 }
	 
//	 public Employee getEmployee() {
//	 return _employee;
//	 }

	
	
}
