package nuisance;
/**
 * Class Mosquito, extends class Insect and
 * implemnts the Nuisance interface.
 * Includes the constructor and Mosquito methods
 * @author landonhowa
 *
 */
public class Mosquito extends Insect implements Nuisance{

	/**
	 * Species of insect to be included
	 * @param species
	 */
	public Mosquito(String species) {
		super(species);
	}
	
	/**
	 * Method buzz, returns the following String:
	 * {Species} buzzing around
	 * @return
	 */
	public String buzz() {
		return getSpecies() + " buzzing around";
	}
	
	/**
	 * Method annoy, Overrides and returns the following String:
	 * buzz buzz buzz
	 * @return
	 */
	@Override
	public String annoy() {
		return "buzz buzz buzz";
	}

}
