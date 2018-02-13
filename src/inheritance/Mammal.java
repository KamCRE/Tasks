/**
 * 
 */
package inheritance;

/**
 * @author lancre
 *
 */
public class Mammal extends Animal{
	
	private boolean isWarmBlooded;
	private String bodyCover;
	
	

	public Mammal(String name, int bodySize, boolean isWarmBlooded, String bodyCover) {
		super(name, bodySize);
		this.isWarmBlooded = isWarmBlooded;
		this.bodyCover = bodyCover;
	}

	@Override
	public String toString() {
		return "I am a Mammal.";
	}
	

}
