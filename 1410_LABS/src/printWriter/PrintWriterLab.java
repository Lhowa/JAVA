package printWriter;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * This program takes outputs the times tables 1-10 
 * to a file.
 * 
 * @author landonhowa
 *
 */
public class PrintWriterLab {

	public static void main(String[] args) {
		String fileTimeTables = "src/printWriter/TextFiles/TimeTables.txt";
		
		timesTables(fileTimeTables);
	}
	
	/**
	 * Outputs the times tables.
	 */
	private static void timesTables(String fileTimeTables) {
		try(PrintWriter writer = new PrintWriter(fileTimeTables)){
			int num1 = 1;
			int num2 = 1;
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 10; j++) {
					writer.printf("%2d * %1d = " + num1 * num2, num1,num2);
					num2++;
					writer.printf("%4d * %1d = " + num1 * num2 + "%n", num1,num2);
					num1++;
					num2--;
				}
				num1 = 1;
				num2 += 2;
				writer.println();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
