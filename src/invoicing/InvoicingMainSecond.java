package invoicing;

import java.util.Iterator;
import java.util.Scanner;

public class InvoicingMainSecond {
	private static String[] product = { "bread", "milk", "coffee", "sugar", "tea" };

	private static int[] price = { 50, 80, 90, 100, 100 };
	private static String[] productList = new String[5];
	private static int[] quantityList = new int[5];
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
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
				exit = addItem();
				break;

			case 2:
				exit = true;
				break;
			default:
				break;
			}

		}

		/*
		 * if(productList[0].equals("milk")) { System.out.println(productList[0]);
		 * 
		 * }
		 */
		int sum = 0;
		System.out.println("Exited Loop");
		sum = sumItems(sum);

		System.out.println("You Have Selected the following Items in order of Price : ");
		String[] ordered = new String[5];
		for (String s : productList) {
			ordered = printInOrder(s, ordered);

		}
		for (int i = 0; i<ordered.length;i++) {
			if (ordered[i]!= null) {
				System.out.println(ordered[i] + " costs " + myPrices(ordered[i]));

			}

		}

		//

		System.out.println("The total cost is " + sum);

		scanner.close();

	}

	private static String[] printInOrder(String productList, String[] array) {
		for (int i = 0; i < product.length; i++) {
			if (productList != null) {
				if (productList.equals(product[i])) {
					array[i] = product[i];
				}

			}

		}
		return array;
	}

	private static int sumItems(int sum) {
		int i = 0;
		boolean state = true;
		while (state) {
			if (productList[i] != null) {
				if (productList[i].equals("coffee")) {
					sum += 90 * quantityList[i];
				} else if (productList[i].equals("tea")) {
					sum += 100 * quantityList[i];
				} else if (productList[i].equals("bread")) {
					sum += 50 * quantityList[i];
				} else if (productList[i].equals("milk")) {
					sum += 80 * quantityList[i];
				} else if (productList[i].equals("sugar")) {
					sum += 100 * quantityList[i];
				} else {
					System.out.println("Invalid input");
				}
				i++;
				if(i>=5) {
					state = false;
				}
				

			} else {
				state = false;
			}
		}
		return sum;

	}

	private static boolean addItem() {
		System.out.println("Enter an items to add  or '2'  to exit the loop: ");
		while (scanner.hasNext()) {
			String myItem = scanner.next().toLowerCase();
			if (myItem.equals("2")) {
				return true;
			}
			System.out.println("Enter the " + myItem + " quantity");
			int myQ = scanner.nextInt();
			if (!myItem.isEmpty()) {
				arrayStore(myItem, myQ);

			}
		}

		return false;
	}

	private static void arrayStore(String myItem, int myQ) {
		int bottom = 0;
		boolean state = false;
		while (!state) {
			if (productList[bottom] == null) {
				productList[bottom] = myItem;
				quantityList[bottom] = myQ;
				System.out.println("Item " + myItem + " Added. Add another Item or Enter '2' to exit ");
				state = true;
				break;
			} else {
				bottom++;
			}
		}
	}

	private static void instructions() {
		System.out.println("Select your choice :");
		System.out.println("Select 0 to print all items. ");
		System.out.println("Select 1 to add an item to your list.");
		System.out.println("Select 2 to exit and Print your List");
	}

	public static void printItems() {
		System.out.println("Below is a list of Items To Choose From: ");
		System.out.println("1. Bread  : 50");
		System.out.println("2. Milk   : 80 ");
		System.out.println("3. Sugar  : 100");
		System.out.println("4. Coffee : 90");
		System.out.println("5. Tea    : 100");
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

}
