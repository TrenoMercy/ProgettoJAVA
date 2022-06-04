/**
 	A player is represented with the name and number to play with.
 */
public class Player extends Person{
	
	private int number;
	
	/** 
	    @param name the name of the player
	    @param n the number of the player
	*/
	public Player(String name, int n) {
		super(name);
		this.number=n;
	}
	
	/** 
	     Get the name of the player.
	     @return the name of the player
	 */
	public String getName() {
		return super.getName();
	}
	
	/**
	    Get the number of the player.
	    @return the number of the player
	 */
	public int getNumber() {
		return number;
	}
}
