package m05;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Module05 test, read and write to a file.
 * Once read, the info is stored line by line into an ArrayList.
 * The lines are then altered, then written to the new file.
 * @author landonhowa
 *
 */
public class Module05 {

	public static void main(String[] args){
		List<String> lines = new ArrayList<String>();
		//Read from the file, then add each line to the arrayList.
		try {
			for (String line : Files.readAllLines(Paths.get("src/m05/Resources/Quote.txt"))) {
				lines.add(line);
			}
		} catch (IOException e) {
			System.out.println("File not found...");
		}
		
		//Print the Quote
		for (String line : lines) {
			System.out.println(line);	
		}
		
		System.out.println();
		
		modifyText(lines);
		
		//Print the Quote
		for (String line : lines) {
			System.out.println(line);	
		}
		
		String file = "src/m05/Resources/Quote2.txt";
		
		//Writes the quote to a new file with a new line appended.
		try {
			PrintWriter writer = new PrintWriter(file);
			for (int i = 0; i < lines.size(); i++) {
				writer.println(lines.get(i));
				writer.println();
			}writer.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found...");
		}
	}

	/**
	 * Even lines become capitalized, odds lowercase. Adds the line number.
	 * @param lines from the quote.
	 */
	private static void modifyText(List<String> lines) {
		for (int i = 0; i < lines.size(); i++) {
			int j = i+1;
			if(i % 2 == 0) {
				if(i + 1 < 10){
					lines.set(i,"0"+ j + " " + lines.get(i).toUpperCase());
				}else {
					lines.set(i, j + " " + lines.get(i).toUpperCase());
				}
			}else {
				if(i + 1 < 10){
					lines.set(i,"0"+ j + " " + lines.get(i).toLowerCase());
				}else {
					lines.set(i, j + " " + lines.get(i).toLowerCase());
				}
			}
		}
	}

}

