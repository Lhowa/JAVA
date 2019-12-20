package nuisance;
import java.util.List;
/**
 * Class Butterfly, extends from the class Insect,
 * includes constructor and toString for the class.
 * @author landonhowa
 *
 */
public class Butterfly extends Insect{
	private List <String> colors; 
	
	/**
	 * Butterfly Constructor, must include the Species,
	 * and a list of colors.
	 * @param species
	 * @param colors
	 */
	public Butterfly(String species, List<String> colors) {
		super(species);
		this.colors = colors;
	}

	/**
	 * @return the colors picked
	 */
	public List<String> getColors() {
		return colors;
	}

	/**
	 * toString for Class Butterfly, Prints the following options:
	 * no colors: {species}[]
	 * multiple colors: {species}[{list of colors},]
	 */
	@Override
	public String toString() {
		if (colors == null) {
			return getSpecies() + "[]";
		}else {
			return getSpecies() + "[" + (colors + ",") +"]";
		}
	}
	
	
}
