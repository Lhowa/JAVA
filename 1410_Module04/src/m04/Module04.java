package m04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Class m04Test contains no main and
 * two methods.
 * @author landonhowa
 *
 */
public class Module04 {
	
	
	/**
	 * method1
	 * This method takes a list of doubles and does the following:
	 * Divides all doubles by 10,
	 * Removes all numbers less than 1,
	 * Removes all duplicate numbers,
	 * Sorts the elements in descending order.
	 * @param List of doubles
	 */
	public static void method1(List<Double> numbers) {
		List <Double> dividedNumbers = new ArrayList<>();
		Set<Double> numberSet = new HashSet<>();
		numbers.forEach(n -> {n = n / 10 ;
		dividedNumbers.add(n);});
		
		for (Double n : dividedNumbers) {
			if (n < 1) {
				dividedNumbers.remove(n);
			}
		}

		numberSet.addAll(dividedNumbers);
		dividedNumbers.removeAll(dividedNumbers);
		dividedNumbers.addAll(numberSet);
		Collections.sort(dividedNumbers);
		Collections.reverse(dividedNumbers);
		System.out.println(dividedNumbers);
	}
	
	/**
	 * method2
	 * This method shifts the elements in the list to the left 3 times,
	 * Then creates a list of strings with the number representation in base 2,
	 * Then removes all elements greater than 10 char's.
	 * @param list of integers
	 * @return list of Strings less than 10 char's long of the original list but in base 2.
	 */
	public static List<String> method2(List<Integer> list){
		List <String> binaryStrings = new ArrayList<>();
		List <String> finalStrings = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			Collections.rotate(list, -1);
		}
		String converted = null;
		for (int n : list) {
			converted = Integer.toString(n, 2);
			binaryStrings.add(converted);
		}
		for (String s : binaryStrings) {
			if (s.length() < 11) {
				finalStrings.add(s);
			}

		}
		System.out.println(finalStrings);
		return finalStrings;
	}
	
//	public static void main(String[] args) {
//		List <Double> testNumbers = new ArrayList<>();
//		testNumbers.add((double) 12);
//		testNumbers.add((double) 22);
//		method1(testNumbers);
//		System.out.println();
//		
//		List <Integer> testInts = new ArrayList<>();
//		testInts.add(1);
//		testInts.add(2);
//		testInts.add(3);
//		method2(testInts);
//
//	}

}
