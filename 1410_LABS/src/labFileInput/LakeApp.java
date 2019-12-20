package labFileInput;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Reads in data records from the csv file and prints the lakes.
 * 
 * @author Landon Howa
 *
 */
public class LakeApp {
	public static void main(String[] args) {
		List <Lake> lakes = new ArrayList<Lake>();
		try(Scanner reader = new Scanner(LakeApp.class.getResourceAsStream("Lakes.csv"))) {
			
			
			 while (reader.hasNextLine()) {
				 String name = reader.next();
				 int depth = reader.nextInt();
				 boolean hasMarina = reader.nextBoolean();
				 reader.nextLine();
				 
				System.out.println(new Lake(name, depth, hasMarina));
				getLake(reader.nextLine());


				
			 }
		}
	}

	private static Lake getLake(String line) {
		  // TODO Auto-generated method stub
		  return null;
		}

}