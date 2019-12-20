package recursion;

import java.util.Arrays;
/**
 * Class Recursion. Demonstrate an understanding of recursive methods.
 * @author landonhowa
 *
 */
public class Recursion {
/**
 * Method that adds the individual digits recursively to output the total.
 * @param n
 * @return
 */
	public static int sumOfDigits(int n) {
		if (n <= 0) return 0;
		return n % 10 + sumOfDigits(n / 10);
	}
/**
 * Recursively checks for the char : followed by the ) and returns the number of times this is true.
 * @param numbers
 * @return
 */
	public static int countSmiles(char[] numbers) {
		if (numbers.length == 0) return 0;
		if(String.valueOf(numbers[0]).equals(":") && String.valueOf(numbers[1]).equals(")")) {
			return 1 + countSmiles(Arrays.copyOfRange(numbers, 1, numbers.length));
		}

		return countSmiles(Arrays.copyOfRange(numbers, 1, numbers.length));
	}
/**
 * Recursively iterates through a string and capitalizes each letter followed by a space.
 * @param str
 * @return
 */
	public static String toUpper(String str) {
		if (str.length() == 0 ) return str;
		char firstChar = Character.toUpperCase(str.charAt(0));
		return firstChar +  " " + toUpper(str.substring(1));
	}
}

