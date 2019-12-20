package textManipulation;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * Class for LabTextManipulation
 * take in user input and display after updating the string format
 * @author landonhowa
 *
 */
public class LabTextManipulation {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList <String> parks = new ArrayList <String>();
		String enteredPark;
		StringBuilder sb = new StringBuilder();
		boolean stop = true;
		while (stop == true) {
		System.out.println("Please enter your favorite National Park or Done to stop: ");
		enteredPark = input.nextLine();
		if(!"Done".equalsIgnoreCase(enteredPark)) {
			parks.add(new String(enteredPark));
				sb.append(enteredPark + " | ");
		}else {

			stop = false;
			}
		}
		sb.deleteCharAt(sb.length() -2);

		
		String nationalParks = sb.toString();

		System.out.print("Favorite national Parks: ");
		
		updateSpelling(nationalParks);


	}
	/**
	 * Used to first split the string at every white space, capitalize the first letter, lower case remaining letters, and rejoin to form one string.
	 * @param text return text
	 * @return
	 */
	private static String updateSpelling(String text) {
		String[] words = text.split(" ");
		for (String word : words) {
		 String firstLetter = word.substring(0,1).toUpperCase();
		 String restLetters = word.substring(1).toLowerCase();
		 word = firstLetter + restLetters + " ";
		 String rejoinedSentence = String.join(" ", word);
		 System.out.print(rejoinedSentence);
		}
		return text;
		
	}
}
