package ioURL;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class DemoURLAccess {

	public static void main(String[] args) {
		String urlString = "https://www.gutenberg.org/files/46768/46768-0.txt";
		Scanner sc = new Scanner(System.in);
		
		try {
			URL url = new URL(urlString);	
			String file = "src/ioURL/textFile.txt";
			int PAGE_LENGTH = 35;
			int count = 0;
			
			 try( InputStream stream = url.openStream();
				      BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
				      BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {

				   String line;
				   while(((line = reader.readLine()) != null)) {

					      
					   if (count != 0 && count % PAGE_LENGTH == 0) {
						   System.out.println("\n- - - Press Enter to continue - - -");
						   String input = sc.nextLine();
						 if (input.isEmpty()) {
							  System.out.println(reader.readLine());
						      writer.write(line + "\n");
						      count++;
						  }
					   }else{
							  System.out.println(reader.readLine());
						      writer.write(line + "\n");
						      count++;  
						  }
				   }
				}
			
		} catch (MalformedURLException e) {
			 System.out.println(
			         "We encountered a problem regarding the following URL:\n" 
			         + urlString 
			         + "\nEither no legal protocol could be found or the string could not be parsed.");
			e.printStackTrace();
		} catch (IOException e) {
			 System.out.println("Attempting to open a stream from the following URL:\n" 
			         + urlString
			         + "\ncaused a problem.");
			   e.printStackTrace();
		}
	}

}