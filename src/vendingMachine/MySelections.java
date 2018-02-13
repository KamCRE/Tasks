/**
 * 
 */
package vendingMachine;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lancre
 *
 */
public class MySelections extends Products {
	private int quantity;
	private Map<Integer, MySelections> transactions;
	private double total = 0;


	public MySelections(String myItem, double itemPrice, int quantity) {
		super(myItem, itemPrice);
		this.quantity = quantity;
		this.transactions = new HashMap<>();

	}

	public int getQuantity() {
		return quantity;
	}

	public double calculateTotal(int q, double p) {
		return q * p;
	}
	

	public boolean storeTransactions(int n, MySelections mySelections) {
		if (mySelections.getMyItem()!=null) {
			transactions.put(n, mySelections);
			return true;
		} else {
			return false;
		}
	}
	public void printSelections() {
		System.out.println("The items selected were :  ");
		for (Map.Entry<Integer, MySelections> m : transactions.entrySet()) {
	        int key=m.getKey();
	        Products p =m.getValue();

			System.out.println(key + ". " + p.getMyItem() + " Quantity " + ((MySelections)p).getQuantity()
					+ " Total for the items is " + calculateTotal(((MySelections)p).getQuantity(), p.getItemPrice()));
			this.total+=calculateTotal(((MySelections)p).getQuantity(),p.getItemPrice());
		
		}
		System.out.println();
		System.out.println("The total cost of Items selected is " + total);

	}
	
	public double getTotal() {
		return total;
	}

	

}
