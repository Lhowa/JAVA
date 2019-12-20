package m02;
/**
 * Class PowerPlant, this is the superclass. 
 * Origin methods are written here.
 * @author landonhowa
 *
 */
public class PowerPlant {
	private int capacity;

	/**
	 * Create a new PowerPalnt
	 * Parameters needed: {capacity} must be a positive number.
	 * @param capacity
	 */
	public PowerPlant(int capacity) {
		if (capacity >= 0) {
			this.capacity = capacity;
		}else {
			throw new IllegalArgumentException("Capacity needs to be a positive number.");
		}
	}
	
	/**
	 * Returns a string in the following format:
	 * generating electricity
	 * @return
	 */
	public String generateElectricity() {
		return "generating electricity";
		
	}

	/**
	 * toString method, outputs the following:
	 * {Current Class Name} {Capacity}MW
	 */
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " "+ capacity + "MW";
	}

	
}
