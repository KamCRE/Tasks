/**
 * 
 */
package vendingMachine;


/**
 * @author lancre
 *
 */
public class Products {
	private String myItem;
	private double itemPrice;
	
	
	public Products(String myItem, double itemPrice) {
		super();
		this.myItem = myItem;
		this.itemPrice = itemPrice;
	}

	public String getMyItem() {
		return myItem;
	}


	public double getItemPrice() {
		return itemPrice;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.myItem.hashCode() + 30;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == this) {
			return true;
		}
		if((obj == null) || (obj.getClass() != this.getClass())) {
			return false;
		}
		String objName = ((Products) obj).getMyItem();
		return this.myItem.equals(objName);
	}
	
	
	
	
	
	
	

}
