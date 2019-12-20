package wrapperClass;
import java.util.*;

/**
 * Class DemoWrapperClass. This class consists of 
 * four methods demonstrating the use of wrapper 
 * classes.
 * @author landonhowa
 *
 */
public class DemoWrapperClass {
	
	/**
	 * This method returns the minimum and maximum values 
	 * for byte, short, integer, long, float, and double.
	 * @return min and max for all number types.
	 */
	public static String minMax() {
		String byteMinMax ="Byte	: [" + Byte.MIN_VALUE + " , " + Byte.MAX_VALUE + "]\n";
		String shortMinMax ="Short	: [" + Short.MIN_VALUE + " , " + Short.MAX_VALUE + "]\n";
		String integerMinMax ="Integer	: [" + Integer.MIN_VALUE + " , " + Integer.MAX_VALUE + "]\n";
		String longMinMax ="Long	: [" + Long.MIN_VALUE + " , " + Long.MAX_VALUE + "]\n";
		String floatMinMax ="Float	: [" + Float.MIN_VALUE + " , " + Float.MAX_VALUE + "]\n";
		String doubleMinMax ="Double	: [" + Double.MIN_VALUE + " , " + Double.MAX_VALUE + "]\n";
		return byteMinMax + shortMinMax + integerMinMax + longMinMax + floatMinMax + doubleMinMax;
	}
	
	/**
	 * This function generates 2 random numbers (2 and 4 digits).
	 * Then converts the numbers to respective bases (10, 16, 8, 2).
	 * @return the conversions of bases for the selected number.
	 */
	public static String convert() {
		Random randomNumber = new Random();
		int twoDigitNum = randomNumber.nextInt(90) + 10;
		int fourDigitNum = randomNumber.nextInt(9000) + 1000;
		int[] numbersToConvert = new int[] {9,twoDigitNum,255,fourDigitNum,12345};
		int[] bases = new int[] {10,16,8,2};
		ArrayList<String> numbersToConvertString = new ArrayList<String>();
		
				for (int i : numbersToConvert) {
					String tempString = Integer.toString(i);
					numbersToConvertString.add(tempString);
				}
		Integer.toString(numbersToConvert[0]);
		StringBuilder str = new StringBuilder(); 
		String line1 = "Base 10	Base 16	Base 8	Base 2\n";
		String line2 = "-------	-------	-------	-------\n";
		str.append(line1);
		str.append(line2);
		String allBases = null;
		int count = 0;
		for (int newCount = 1; newCount < 5; newCount++) {
		for (int n : bases) {
				allBases = Integer.toString(Integer.parseInt(numbersToConvertString.get(count), 10), n) + "	";
				str.append(allBases);
			}
		str.append("\n");
		count++;
		}
		String finalString = "" + str;
		return finalString;
	}
	
	/**
	 * Created for the charProperties method to 
	 * generate a random letter between a-z || A-Z.
	 * @return random letter a-z || A-Z.
	 */
	public static char getRandomLetter() {
		int rnd = (int) (Math.random() * 52);
	    char base = (rnd < 26) ? 'A' : 'a';
	    return (char) (base + rnd % 26);
	}
	
	/**
	 * Uses the getRandomLetter method to generate a random letter.
	 * Then appropriates the letter, number, or whitespace.
	 * @return Random letter, char, number, and space with appropriation.
	 */
	public static String charProperties() {

		char rand1 = getRandomLetter();
		char rand2 = getRandomLetter();
		char rand3 = getRandomLetter();
		
		char[] charArr = new char[] {'8',' ','#',rand1,rand2,rand3};
		 StringBuilder stringBuilder = new StringBuilder();
	        for (int i = 0; i < charArr.length; i++) {
	        	char tempRand = charArr[i];
	        	stringBuilder.append(charArr[i]);
	        	if (Character.isUpperCase(tempRand)) {
	        		stringBuilder.append(" uppercase letter");
	        	}else if (Character.isLowerCase(tempRand)){
	        		stringBuilder.append(" lowercase letter");
	        	}else if (Character.isDigit(tempRand)){
	        		stringBuilder.append(" number");
	        	}else if (Character.isSpaceChar(tempRand)){
	        		stringBuilder.append(" white space");
	        	}
	            stringBuilder.append("\n");
	        }
	        return stringBuilder.toString();
	}
	
	/**
	 * Used to generate a random 2 digit number, then converts to a string.
	 * @return random 2 digit number converted to a string.
	 */
	public static String randomTwoDigits() {
		Random randomNumber = new Random();
		Integer twoDigitNum = randomNumber.nextInt(90) + 10;
		String twoDigitNumString = twoDigitNum.toString();
		return twoDigitNumString;
	}
	
	/**
	 * Uses randomTwoDigits method to generate 10 random number strings.
	 * Then will add to an ArrayList and sum up the arrays.
	 * @return
	 */
	public static String parse() {
		String[] floatingPointNumbers = new String[] {"1.1","2.2","3.3","4.4","5.5","6.6","7.7","8.8","9.9"};
		ArrayList<String> newFloatingPointNumbers = new ArrayList<String>();
		ArrayList<String> wholeNumbers = new ArrayList<String>();
		
		int wholeNumberSum = 0;
		double floatingPointNumbersSum = 0;
		String sum = " .. sum = ";
		
		for (String r : floatingPointNumbers) {
			newFloatingPointNumbers.add(r);
		}
		for (int i = 0; i < 10; i++) {
			String randInt = randomTwoDigits();
			wholeNumbers.add(randInt);
		}
		
		for (String s : wholeNumbers) {
			wholeNumberSum += Integer.parseInt(s);
		}
		
		for (String t : floatingPointNumbers) {
			floatingPointNumbersSum += Double.parseDouble(t);
		}

		String tempString = newFloatingPointNumbers.toString() + sum + floatingPointNumbersSum + "\n" + wholeNumbers.toString() 
		+ sum + wholeNumberSum;
		return tempString;
	}	
}
