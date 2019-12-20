package fileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

/**
 * Demonstrates how to use a file writer,
 * and reader.
 * 
 * @author landonhowa
 *
 */
public class DemoPrintWriter {
	private static Random rand = new Random();

	public static void main(String[] args) {
		String fileRandomNumbers = "src/fileIO/TextFiles/RandomNumbers.txt";
		String fileDecimalOctalHex = "src/fileIO/TextFiles/DecimalOctalHex.txt";
		
		//writeNumbersToFile(fileRandomNUmbers);
		
		//writeNumbersInDecimalOctalAndHex(fileRandomNUmbers, fileDecimalOctalHex);

		
		System.out.println("Done...");
	}
	
	/**
	 * Reads from the file fileRandomNumbers then creates a new file
	 * fileDecimalOctalHex and writes to the file in the new number format.
	 * @param fileRandomNumbers
	 * @param fileDecimalOctalHex
	 */
	@SuppressWarnings("unused")
	private static void writeNumbersInDecimalOctalAndHex(String fileRandomNumbers, String fileDecimalOctalHex) {
		try(Scanner reader = new Scanner(new File(fileRandomNumbers));
				PrintWriter writer = new PrintWriter(fileDecimalOctalHex)){
			while(reader.hasNextInt()) {
				int n = reader.nextInt();
				writer.printf("%d %03o %02X%n", n, n, n);//Prints the decimal, octal with a leading 0 and
				//a width of 3 followed by the hexadecimal number with a leading 0 and a width of 2.
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Writes 5 random numbers to a file passed as an arg.
	 * each number is written on a new line.
	 * If the file does not exist it will be created.
	 * If the file does exist the numbers will replace the original content
	 * 
	 * @param file relative path
	 */
	@SuppressWarnings("unused")
	private static void writeNumbersToFile(String fileRandomNumbers) {
		try(PrintWriter writer = new PrintWriter(fileRandomNumbers)){
			for(int i = 0; i < 5; i++) {
				writer.println(rand.nextInt(90) + 10);
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
