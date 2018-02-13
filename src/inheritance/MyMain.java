/**
 * 
 */
package inheritance;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author lancre
 *
 */
public class MyMain {

	/**
	 * @param args
	 */
	private static Scanner scanner =  new Scanner(System.in);
	private static ArrayList<Animal> myAnimals = new ArrayList<Animal>();
	public static void main(String[] args) {
		
		intialize();		
		System.out.println("Enter Animal Name : ");
		int n = 0;
		boolean exit = false;
		while(!exit) {
			instructions();
			n = scanner.nextInt();
			switch(n) {
			case 0:
				printAnimals();
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
		
	}

	private static int getMyAnimal(String name) {
		for(int i = 0; i<myAnimals.size(); i++) {
			Animal animal = myAnimals.get(i);
			if(animal.getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}

	private static boolean enterItem() {
		System.out.println("Enter the name of an animal or '2' to exit: ");
		while (scanner.hasNext()) {
			String myAnimal = scanner.next().toLowerCase();
			if(myAnimal.equals("2")) {
				return true;
		        //break;
		    }
			int pos = getMyAnimal(myAnimal);
			if(pos>=0) {
				Animal animal = myAnimals.get(pos);
				System.out.println(animal.toString());
				System.out.println(scanner.nextLine());	
			}else {
				System.out.println("Invalid input");
			}
			
			
			System.out.println("Enter the name of an animal or '2' to exit: ");

		}
		
		
		
		return false;
	}



	private static void printAnimals() {		
		
		for(Animal a: myAnimals) {
			System.out.println(a.getName() + ", ");
		}
	}



	private static void instructions() {
		System.out.println("Select your choice :");
		System.out.println("Select 0 to print all animal. ");
		System.out.println("Select 1 enter an animal.");
		System.out.println("Select 2 to exit and Print your List");
	}



	private static void intialize() {
		Mammal man = new Mammal("Human Being".toLowerCase(), 10, true, "Fur/Hair");
		Mammal baboon = new Mammal("baboon".toLowerCase(), 7, true, "Fur/Hair");
		Mammal cat = new Mammal("cat".toLowerCase(), 10, true, "Fur/Hair");
		Mammal dog = new Mammal("Dog".toLowerCase(), 10, true, "Fur/Hair");

		
		Bird parrot = new Bird("Parrot".toLowerCase(),2,"Feathers");
		Bird eagle = new Bird("Eagle".toLowerCase(),2,"Feathers");
		Bird Hawk = new Bird("Hawk".toLowerCase(),2,"Feathers");
		Bird Dove = new Bird("Dove".toLowerCase(),2,"Feathers");

		
		Reptile crocodile  = new Reptile("Crocodile".toLowerCase(),30, false,"Scales");
		Reptile lizard  = new Reptile("lizard".toLowerCase(),5, false,"Scales");
		Reptile chameleone  = new Reptile("chameleone".toLowerCase(),5, false,"Scales");	
		myAnimals.add(man); myAnimals.add(baboon); myAnimals.add(cat); myAnimals.add(dog);myAnimals.add(parrot);
		myAnimals.add(eagle);myAnimals.add(Hawk);myAnimals.add(Dove);
		myAnimals.add(crocodile);myAnimals.add(lizard);myAnimals.add(chameleone);
	}
	

}
