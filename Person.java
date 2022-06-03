/**
  	A person is represented by the name.
  */
public class Person {

	private String name;
	
	/**
    	Construct a Person object.
    	@param n the name of the person
    */
	public Person(String n) {
		this.name=n;
	}
	
	/**
		Get the name of the person.
		@return name of the person
	 */
	public String getName() {
		return name;
	}
}
