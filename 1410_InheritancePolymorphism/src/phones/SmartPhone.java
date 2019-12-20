package phones;
/**
 * Class SmartPhone, type of class Phone
 * @author landonhowa
 *
 */
public class SmartPhone extends Phone{
	private int storage;

	/**
	 * @param model The phones model
	 * @param dimension The phones dimensions (height,width,depth)
	 * @param storage The phones storage in GB's
	 * Checks for positive number, if negative throws exception.
	 */
	public SmartPhone(String model, Dimension dimension, int storage) {
		super(model, dimension);
		if(storage >= 1) {
			this.storage = storage;
		}else {
			throw new IllegalArgumentException("Storage needs to be assigned a positive value.");
		}
	}
	
	/**
	 * @param number Enter in the number to call
	 * @return "Calling {number} by selecting the number"
	 */
	public String call(long number) {
		return "Calling " + number + " by selecting the number";
		
	}
	
	/**
	 * @return "Browsing the web"
	 */
	public String browse() {
		return "Browsing the web";
	}
	
	/**
	 * @return A string based on a random number generated
	 * each time the method is called.
	 */
	public String takePicture() {
		int tmp = (int) ( Math.random() * 2 + 1);
		if(tmp == 1) {
			return "Taking a horizontal picture.";
		}else {
			return "Taking a vertical picture.";
		}
		
	}
	
	/**
	 * Returns "{model} {dimension} {storage}GB"
	 */
	@Override
	public String toString() {
		return super.toString() + " " + storage + "GB";
	}
	
	
}
