package smell;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Vector;
 
public class Order {
 
	private Vector<Item> items;


	public Order(Vector<Item> lis) {
		items = lis;
    }
 
    public boolean equals(Object aThat) {
            if ( this == aThat ) return true;
        if ( !(aThat instanceof Order) ) return false;
            Order that = (Order)aThat;
        return this.items.equals(that.items);
    }
 
    // writes this order object to the specified print writer
    public void writeOrder(PrintWriter pw) {
 
        pw.println("Order total = " + printAndGetTotal(items, pw));
        
    }
 
	public int printAndGetTotal(Vector<smell.Item> vector, PrintWriter pw) {

		// create an iterator for the vector
        Iterator<Item> iter = items.iterator();
        Item item;
        // set total to zero
        int total = 0;
            while (iter.hasNext()) {
                item = (Item)iter.next();
 
                pw.println("Begin Line Item");
                pw.println("Product = " + item.getProductID());
                pw.println("Image = " + item.getImageID());
                pw.println("Quantity = " + item.getQuantity());
                pw.println("Total = " + item.getUnitPrice() * item.getQuantity());
                pw.println("End Line Item");
 
                total += item.getUnitPrice() * item.getQuantity();
            }
            return total;
    }
 


}
