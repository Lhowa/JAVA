package keyValue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestClient {
	
	public static <T> void printWithMargin(Collection<T> collection, int indentation){
		String indent = String.join("", Collections.nCopies(indentation, " "));
		collection.forEach(c -> {
			System.out.println(indent + c);
		});
	}

	public static void main(String[] args) {
		System.out.println("Phase 1:");
		System.out.println("--------");
		
		KeyValuePair<String, Integer> p1 = new KeyValuePair<>("SLC", 189899);
		KeyValuePair<String, Integer> p2 = new KeyValuePair<>("NY", 8244910);
		KeyValuePair<String, Integer> p3 = p2;
		KeyValuePair<String, Integer> p4 = new KeyValuePair<>("LA", 3819702);
		KeyValuePair<String, Integer> p5 = new KeyValuePair<>("SF", 812826);
		List<KeyValuePair<String, Integer>> cities = new ArrayList<KeyValuePair<String,Integer>>();
		Collections.addAll(cities, p1,p2,p3,p4,p5);
		
		System.out.println(p1 + "\n" + p2);
		System.out.println("p1.equals(p2): " + p1.equals(p2) + "\n");
		
		System.out.println(p3);
		System.out.println("p2.equals(p3): " + p2.equals(p3) + "\n");
		
		System.out.println("Phase 2:");
		System.out.println("--------");
		System.out.println("Original List:");
		cities.forEach(c -> System.out.println(c));
		System.out.println("\nSorted List:");
		Collections.sort(cities);
		cities.forEach(c -> System.out.println(c));
		System.out.println();
		
		System.out.println("Phase 3:");
		System.out.println("--------");
		System.out.println("Cities with margin 5:");
		printWithMargin(cities, 5);
		
		Set<KeyValuePair<Integer, String>> countryCodes = new HashSet<>();
		KeyValuePair<Integer, String> c1 = new KeyValuePair<>(33 ,"France");
		KeyValuePair<Integer, String> c2 = new KeyValuePair<>(43 ,"Austria");
		KeyValuePair<Integer, String> c3 = new KeyValuePair<>(30 ,"Greece");
		Collections.addAll(countryCodes, c1,c2,c3);
		System.out.println("\nCountry codes with margin 3:");
		printWithMargin(countryCodes, 3);
	}
}
