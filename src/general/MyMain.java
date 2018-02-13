/**
 * 
 */
package general;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author lancre
 *
 */
public class MyMain {

	/**
	 * @param args
	 */
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
			
			System.out.println("Enter Person Salary : ");
			int n = 0;
			boolean exit = false;
			while(!exit) {
				instructions();
				n = scanner.nextInt();
				switch(n) {
				case 1:
					exit = enterItem(new Employee("Alan Kuria"));
					break;
					
				case 2:
					exit = true;
					break;
				default:
					break;
				}
				
			}


	}

	private static boolean enterItem(Person person) {
		Employee employee = ((Employee) person);
		System.out.println("Enter the amount or '2' to exit: ");
		while (scanner.hasNext()) {
			try {
				double salary = scanner.nextDouble();
				if (salary == 2) {
					return true;
				}
				employee.setSalary(salary);
				System.out.println("Gross Pay        :  " + employee.getSalary());
				System.out.println("NHIF deductions  :  " + employee.nhifDeductions());
				System.out.println("NSSF deductions  :  " + employee.nssfDeductions());
				System.out.println("Tax deductions   :  " + employee.taxDeductions());
				System.out.println("------------------------------------------------");
				System.out.println("Total Deductions :  " + employee.totalDeductions());
				System.out.println("------------------------------------------------");
				System.out.println("Net Pay        :  " + employee.getNetSalary());

				System.out.println("Enter the amount or '2' to exit: ");

			} catch (InputMismatchException ex) {
				ex.getStackTrace();
				System.out.println(ex);
				System.out.println("Try again. (Incorrect input: an integer or double is required)");
				scanner.nextLine(); // Discard input
			}

		}

		return false;
	}

	private static void instructions() {
		System.out.println("Select your choice :");
		System.out.println("Select 1 enter amount.");
		System.out.println("Select 2 to exit");
	}

}
