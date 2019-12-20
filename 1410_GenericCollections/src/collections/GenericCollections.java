package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Class Generic Collections. This class does not
 * contain a main method. Rather 3 methods that help 
 * with your understanfing of collections.
 * @author landonhowa
 *
 */
public class GenericCollections {
	/**
	 * This method bypasses all special chars. Numbers
	 * and letters are given a designation. Letters are 
	 * further designated by uppercase and lowercase.
	 * @param list of Chars
	 * @return reversed list with a designation.
	 */
	public static List<String> lettersAndNumbers(List<Character> list){
		List<String> returnedList = new ArrayList<>();
		
		if(list.isEmpty()) {
			return returnedList;
		} else if (list.size() > 0) {
		
		
		for (Character li : list) {
			if(Character.isLetterOrDigit(li)) {
				String stringLi = li.toString();
				if(Character.isUpperCase(li)) {
					returnedList.add("U" + "(" + stringLi.toLowerCase() + ")");
				}else if (Character.isLowerCase(li)) {
					returnedList.add("L" + "(" + stringLi + ")");
				}else {
					returnedList.add("N" + "(" + stringLi + ")");
				}
				
			}
		}
		
		Collections.reverse(returnedList);
		return returnedList;
		}else {
			return null;
		}
	}
	
	/**
	 * This method takes in a list of numbers.
	 * Removes the multiples of 3. Then adds the
	 * first 5 multiples of 4, 5, 6. then removes the 
	 * duplicates.
	 * @param list of Integers
	 * @return the number of un-repeating Integers.
	 */
	public static int modify(List<Integer> list){
		int returnValue = 0;
		if (list == null) {
			 throw new NullPointerException("List cannot be null...");
		}
		for (Integer i : list) {
			if(i % 3 == 0) {
				list.remove(i);
			}
		}
		for (int i = 4; i < 7; i++) {
			for (int j = 1; j < 6; j++) {
				list.add(i * j);
			}
		}
		Collections.sort(list); 
		Set<Integer> numberSet = new HashSet<>();
		numberSet.addAll(list);
		returnValue = numberSet.size();
		return returnValue;
	}
	
	/**
	 * This method removes the the selected position
	 * throughout the list.
	 * @param list of objects
	 * @param n position you would like to remove
	 */
	public static void removeEveryNthElement(List<?> list, int n) {
		int count = 1;
		if (list == null) {
			 throw new NullPointerException("List cannot be null...");
		}
		if (n <= 0) {
			throw new IllegalArgumentException("n needs to be a positive number...");
		}
		for(int i = 0; i < list.size(); i++) {
			if(count % n == 0) {
				list.remove(i);
				count = 1;
			}
			count++;
		}
	}
	
}