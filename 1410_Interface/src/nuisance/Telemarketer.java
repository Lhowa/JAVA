package nuisance;
/**
 * class Telemarketer, this class extends class Person.
 * the constructor and additional Telemarketer methods are located here.
 * @author landonhowa
 *
 */
public class Telemarketer extends Person implements Nuisance{

	/**
	 * 
	 * @param name of the Telemarketer
	 * @param age f the Telemarketer
	 */
	public Telemarketer(String name, int age) {
		super(name, age);
	}
	
	/**
	 * Returns a string as described:
	 * {name} pressures others to buy stuff
	 * @return
	 */
	public String giveSalesPitch() {
		return getName() + " pressures others to buy stuff";
	}

	/**
	 * Ovverides the abstract annoy() as described:
	 * {name} annoys by giving sales pitch.
	 * @return
	 */
	@Override
	public String annoy() {
		return getName() + " annoys by giving sales pitch";
	}
}
