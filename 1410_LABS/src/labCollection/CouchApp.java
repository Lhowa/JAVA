package labCollection;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Class CouchApp. This is the test app,
 * it works in conjunction with Classes
 * Material, and Couch. List's are printed
 * out based on the filters contained.
 * @author landonhowa
 *
 */
public class CouchApp {

	public static void main(String[] args) {
		List<Color> colors = new ArrayList<>();
		Collections.addAll(colors, Color.BLACK, Color.BLUE, Color.DARK_GRAY,
				Color.DARK_GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.RED, Color.WHITE);
		
		List<Couch> couches = new ArrayList<>();
		
		/**
		 * Generates the initial list.
		 */
		for (int i = 0; i < colors.size(); i++) {
			Couch fabricCouch = new Couch(colors.get(i), Material.FABRIC);
			Couch vinylCouch = new Couch(colors.get(i), Material.VINYL);	
			Couch leatherCouch = new Couch(colors.get(i), Material.LEATHER);
			couches.add(fabricCouch);
			couches.add(vinylCouch);
			couches.add(leatherCouch);
		}
		couches.forEach(c -> System.out.println(c));
		
		List<Couch> favorites = new ArrayList<>();
		Couch fabricRedCouch = new Couch(colors.get(6), Material.FABRIC);
		Couch vinylBlackCouch = new Couch(colors.get(0), Material.LEATHER);	
		Couch leatherWhiteCouch = new Couch(colors.get(7), Material.VINYL);
		favorites.add(fabricRedCouch);
		favorites.add(vinylBlackCouch);
		favorites.add(leatherWhiteCouch);
		
		int couchListSize = couches.size();
		System.out.println("Number of elements in list couches: " + couchListSize);
		
		compareToFavorites(couches, favorites);
		
		System.out.println();
		System.out.println("Removing all vinyl couches . . .\n");
		couches.removeIf(c -> c.getMaterial() == Material.VINYL);
		couches.forEach(c -> System.out.println(c));
		couchListSize = couches.size();
		System.out.println("Number of elements in list couches: " + couchListSize);
		
		compareToFavorites(couches, favorites);
		
		System.out.println("Adding all the favorites to the list couches . . .\n");
		couches.addAll(favorites);
		couches.forEach(c -> System.out.println(c));
		couchListSize = couches.size();
		System.out.println("Number of elements in list couches: " + couchListSize);
		
		compareToFavorites(couches, favorites);
		System.out.println();
		
		System.out.println("Adding all the couches to a set . . .\n");
		
		Set<Couch> couchSet = new HashSet<>();
		couchSet.addAll(couches);
		couchSet.forEach(c -> System.out.println(c));
		int setSize = couchSet.size();
		System.out.println("Number of elements in set: " + setSize);
		if(couchSet.containsAll(favorites)) {
			System.out.println("All favorites are in the list.\n");
		}else {
			System.out.println("Not all favorites are in the list.\n");
		}
	}

	/**
	 * compares the current list of favorites to the
	 * list in couches.
	 * @param couches list
	 * @param favorites list
	 */
	private static void compareToFavorites(List<Couch> couches, List<Couch> favorites) {
		if(couches.containsAll(favorites)) {
			System.out.println("All favorites are in the list.");
		}else {
			System.out.println("Not all favorites are in the list.");
		}
	}
}
