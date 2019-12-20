package m02;
/**
 * Class WindFarm, extending from PowerPlant.
 * Includes constructor and class specific/overridden methods.
 * @author landonhowa
 *
 */
public class WindFarm extends PowerPlant{
	
	private boolean offshore;
	

	/**
	 * Create a new WindFarm.
	 * Parameters needed: {capacity} {offshore}
	 * You must enter a positive capacity and whether or not
	 * the WindFarm is offshore.
	 * @param capacity
	 * @param offshore
	 */
	public WindFarm(int capacity, boolean offshore) {
		super(capacity);
		this.offshore = offshore;
	}

	/**
	 * Returns whether or not the WindFarm was created offshore.
	 * @return the offshore
	 */
	public boolean isOffshore() {
		return offshore;
	}
	
	/**
	 * Overrides the method generateElectricity with the following:
	 * generating electricity from wind.
	 */
	@Override
	public String generateElectricity() {
		return "generating electricity from wind";
	}

	/**
	 * Overrides the current to toString().
	 * The following is printed if offshore is true:
	 * {Class Name} {Capacity}MW ~~~
	 * * The following is printed if offshore is false:
	 * {Class Name} {Capacity}MW
	 */
	@Override
	public String toString() {
		if (offshore == true) {
			return super.toString() +  " ~~~";
		}else {
			return super.toString();
		}
		
	}
	
	

}
