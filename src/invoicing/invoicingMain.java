/**
 * 
 */
package invoicing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author lancre
 
 */
public class invoicingMain {
	private static ArrayList<Product> myChoiceList = new ArrayList<Product>();
	private static Scanner scanner = new Scanner(System.in);

	

	public static void main(String[] args) {
		int n = 0;
		boolean exit = false;
		while(!exit) {
			instructions();
			n = scanner.nextInt();
			switch(n) {
			case 0:
				printItems();
				break;
			case 1:
				exit = addItem();
				break;
				
			case 2:
				exit = true;
				break;
			default:
				break;
			}
			
		}
		int sum = 0;
		System.out.println("Exited Loop");
		Iterator<Product> ltr = myChoiceList.listIterator();
		while(ltr.hasNext()) {
			Product s = (Product) ltr.next();
			switch(s.getProductName()) {
			case "coffee":
				sum+= 90 * s.getQuantity();
				break;
			case "tea":
				sum+=100 * s.getQuantity();
				break;
			case "bread":
				sum+=50 * s.getQuantity();
				break;
			case "milk":
				sum+=80 * s.getQuantity();
				break;
			case "sugar":
				sum+=100 * s.getQuantity();
				break;
			default:
				System.out.println("Invalid input");
				break;
			}
		}
		System.out.println("You Have Selected the following Items : ");
		
		for(Product s: myChoiceList ) {
			System.out.println("Product " + s.getProductName() + " each costs "+ myPrices(s.getProductName()) 
			+" Quantity ordered is " + s.getQuantity() + " summing to " + myPrices(s.getProductName()) * s.getQuantity());
		}
		System.out.println("The total cost is " + sum);
		
		
		scanner.close();
		


	}
	private static int myPrices(String productName) {
		int price = 0;
		switch(productName) {
		case "coffee":
			price = 90;
			break;
		case "tea":
			price = 100;
			break;
		case "bread":
			price = 50;
			break;
		case "milk":
			price = 80;
			break;
		case "sugar":
			price=100;
			break;
		default:
			System.out.println("Invalid input");
			break;
		}
		return price;
	}
	private static void instructions() {
		System.out.println("Select your choice :");
		System.out.println("Select 0 to print all items. ");
		System.out.println("Select 1 to add an item to your list.");
		System.out.println("Select 2 to exit and Print your List");
	}
	private static boolean addItem() {
		System.out.println("Enter an items to add  or '2'  to exit the loop: ");
		while(scanner.hasNext()) {

			String myItem = scanner.next().toLowerCase();
			if(myItem.equals("2")) {
				return true;
		        //break;
		    }
			
			System.out.println("Enter the "+myItem+ " quantity");
			int myQ = scanner.nextInt();
			if(myQ==0) {
		        break;
		    }
			if(myItem!="") {
				invoicingMain invoice = new invoicingMain();
				invoicingMain.Product myProduct = invoice.new Product(myItem, myQ);
				myChoiceList.add(myProduct);
				System.out.println("Item "+ myItem + " Added. Add another Item or Enter '2' to exit ");
				
			}
		}
		return false;
		
		
		//System.out.println("Item "+ myItem + " Added");
		
			
	
		
	}
	public static void printItems() {
		System.out.println("Below is a list of Items To Choose From: ");
		System.out.println("1. Bread  : 50");
		System.out.println("2. Milk   : 80 ");
		System.out.println("3. Sugar  : 100");
		System.out.println("4. Coffee : 90");
		System.out.println("5. Tea    : 100");
	}
	private class Product{
		private String productName;
		private int quantity;
		
		
		public Product(String productName, int quantity) {
			super();
			this.productName = productName;
			this.quantity = quantity;
		}
		public String getProductName() {
			return productName;
		}
		public int getQuantity() {
			return quantity;
		}
		
		
		
		
		
		
	}
}
