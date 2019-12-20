package phones;
/**
 * Class Phone, this is the super class of all other Phone subclasses.
 * @author landonhowa
 *
 */
public class Phone {
	private String model;
	private Dimension dimension;
	/**
	 * @param model of the phone.
	 * @param demension of the phone(height,width,depth).
	 */
	protected Phone(String model, Dimension demension) {
		this.model = model;
		this.dimension = demension;
	}
	
	/**
	 * @param number Enter in the number to call
	 * @return "Calling {number}"
	 */
	public String call(long number) {
		return "Calling " + number;
		
	}

	@Override
	public String toString() {
		return model + " " + dimension;
	}
	
	
}
