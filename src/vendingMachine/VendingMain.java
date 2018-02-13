/**
 * 
 */
package vendingMachine;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

/**
 * @author lancre
 *
 */
public class VendingMain {

	private static Scanner scanner = new Scanner(System.in);
	private static Map<Integer, Products> myProducts = new HashMap<>();
	private static MySelections transactions = new MySelections(null, 0, 0);

	public static void main(String[] args) {
		intialize();
		int n = 0;
		boolean exit = false;
		while (!exit) {

			instructions();
			n = scanner.nextInt();
			switch (n) {
			case 0:
				printItems();
				break;
			case 1:
				exit = enterItem();
				break;
			case 2:
				exit = true;
				break;
			default:
				break;
			}

		}
		transactions.printSelections();
		balance();

	}

	private static void balance() {

		boolean data = false;
		do {
			System.out.println("Enter amount to Pay for the items selected : ");
			double amount = scanner.nextDouble();
			if (amount > transactions.getTotal() || amount == transactions.getTotal()) {
				System.out.println("The balance is " + (amount - transactions.getTotal()));
				data = true;
			} else {
				System.out.println("Insufficient funds!!!!!!");
			}

		} while (!data);

	}

	private static void printItems() {
		for (Map.Entry<Integer, Products> m : myProducts.entrySet()) {
			System.out.println(
					m.getKey() + "	" + m.getValue().getMyItem() + " each @	:	" + m.getValue().getItemPrice());

		}
		System.out.println();
	}

	private static boolean enterItem() {
		System.out.println("Enter the number  of the item or '0' to exit: ");
		int n = 1;
		while (scanner.hasNext()) {
			try {
				int item = scanner.nextInt();
				System.out.println(n);
				if (item == 0) {
					return true;
				}
				Products product = myProducts.get(item);
				if (product != null) {
					System.out.println("Enter the " + product.getMyItem() + " quantity");
					int myQ = scanner.nextInt();
					Products ms = new MySelections(product.getMyItem(), product.getItemPrice(), myQ);
					if (transactions.storeTransactions(n, (MySelections) ms)) {
						System.out.println(
								"Item " + product.getMyItem() + " Added. Select another Item or Enter 0 to exit ");
					}
					n++;
				} else {
					throw new NullPointerException("Enter a number between 1 and 6");
				}

			} catch (NullPointerException ex) {
				System.out.println(ex);
				System.out.println("Enter a number between 1 and 6");
				scanner.nextLine(); // Discard input

			} catch (InputMismatchException ex) {
				// System.out.println(ex);
				System.out.println("Input is not a number . Enter a number only!!!");
				scanner.nextLine(); // Discard input

			}

		}

		return false;
	}

	private static void intialize() {
		Products product = new Products("Chocolate", 150);
		myProducts.put(1, product);
		product = new Products("Canned Soda", 80);
		myProducts.put(2, product);
		product = new Products("Crackles", 200);
		myProducts.put(3, product);
		product = new Products("KDF", 100);
		myProducts.put(4, product);
		product = new Products("Sweets", 50);
		myProducts.put(5, product);
		product = new Products("Stationary", 70);
		myProducts.put(6, product);

	}

	private static void instructions() {
		System.out.println("Select your choice :");
		System.out.println("Select 0 to print all items. ");
		System.out.println("Select 1 enter an item.");
		System.out.println("Select 2 to exit and Print your item List");
	}

}
