/**
 * 
 */
package inheritance;

/**
 * @author lancre
 *
 */
public class Animal {
	private String name;
	private int bodySize;
	
	
	
	public Animal(String name, int bodySize) {
		super();
		this.name = name;
		this.bodySize = bodySize;
	}

	public void eat() {
		System.out.println("We eat to live");
	}
	
	public void move() {
		System.out.println("We move from place to place");
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "I am an Animal.";
	}

	public String getName() {
		return name;
	}
	
	
	

}
