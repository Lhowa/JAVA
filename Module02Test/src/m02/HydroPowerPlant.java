package m02;
/**
 * Class HydroPowerPlant, extending from PowerPlant.
 * Includes constructor and class specific/overridden methods.
 * @author landonhowa
 *
 */
public class HydroPowerPlant extends PowerPlant{
	
	private boolean dam;
	
	/**
	 * Creates a new HydroPowerPlant.
	 * Params needed: {Capacity} {dam}
	 * Needs a positive capacity and whether
	 * or not this has a dam.
	 * @param capacity
	 * @param dam
	 */
	public HydroPowerPlant(int capacity, boolean dam) {
		super(capacity);
		this.dam = dam;
	}
	
	/**
	 * If the HydroPowerPlant has a dam, {dam} equals
	 * true. If HydroPowerPlant does not have a dam,
	 * {dam} equals false.
	 * @return
	 */
	public boolean hasDam() {
		if (dam == true) {
			return true;
		}else {
			return false;
		}
		
	}
	
	/**
	 * Overrides the method generateElectricity with the following:
	 * generating electricity from water.
	 */
	@Override
	public String generateElectricity() {
		return "generating electricity from water";
	}
	
	/**
 * Overrides the current to toString().
	 * The following is printed if dam is true:
	 * {Class Name} {Capacity}MW with a dam
	 * * The following is printed if dam is false:
	 * {Class Name} {Capacity}MW without a damn
	 */
	@Override
	public String toString() {
		if (hasDam() == true) {
			return super.toString() +  " with a dam";
		}else {
			return super.toString() +  " without a dam";
		}
		
	}
}
