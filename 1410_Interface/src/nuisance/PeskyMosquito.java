package nuisance;

/**
 * class PeskyMosquito, extends from the Mosquito class,
 * includes constructor and class specific method
 * @author landonhowa
 *
 */
public class PeskyMosquito extends Mosquito{
	
	/**
	 * Constructor for PeskMosquito
	 * requires the Species.
	 * @param species
	 */
	public PeskyMosquito(String species) {
		super(species);
	}
	
	/**
	 * method that returns the following string:
	 * sucking blood
	 * @return
	 */
	public String bite() {
		return "sucking blood";
	}
}
