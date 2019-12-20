package docComments;
/**
 * Car class, contains constructor as well as getters for Car params.
 * @author landonhowa
 *
 */
public class Car {
	private String make;
	private String model;
	private int mpg;
	/**
	 * Constructor of class Car
	 * @param make
	 * @param model
	 * @param mpg
	 */
	public Car(String make, String model, int mpg) {
		this.make = make;
		this.model = model;
		this.mpg = mpg;
	}
	/**
	 * Returns the make of the car
	 * @return the make
	 */
	public String getMake() {
		return make;
	}
	/**
	 * Returns the model of the car
	 * @return the model
	 */
	public String getModel() {
		return model;
	}
	/**
	 * Returns the cars mpg
	 * @return the mpg
	 */
	public int getMpg() {
		return mpg;
	}

	
}
