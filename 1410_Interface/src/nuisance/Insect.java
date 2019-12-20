package nuisance;
/**
 * Class Insect, includes the constructor,
 * getter and toString for the class.
 * @author landonhowa
 *
 */
public class Insect {
	private String species;

	/**
	 * Species of insect to be included
	 * @param species
	 */
	public Insect(String species) {
		this.species = species;
	}

	/**
	 * @return the species
	 */
	public String getSpecies() {
		return species;
	}
	
	/**
	 * returns a String in the following format:
	 * {Class name} {Species}
	 */
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " " + species;
	}
}
