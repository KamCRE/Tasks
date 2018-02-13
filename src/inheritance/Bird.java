/**
 * 
 */
package inheritance;

/**
 * @author lancre
 *
 */
public class Bird extends Animal{

	private String bodyCover;
	
	
	
	public Bird(String name, int bodySize, String bodyCover) {
		super(name, bodySize);
		this.bodyCover = bodyCover;
	}


	public void canFly() {
		System.out.println("I can Fly");
		
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "I am a Bird and I can fly";
	}
	
	

}
