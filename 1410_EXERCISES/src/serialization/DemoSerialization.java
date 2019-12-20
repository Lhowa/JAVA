package serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

/**
 * Demonstrates how to serialize both primitive and reference types
 * and how to recover the serialized information by deserializing it.
 * @author landonhowa
 *
 */
public class DemoSerialization {

	public static void main(String[] args) {
		String file = "src/serialization/BinaryFiles/Words.ser";		
		String[] words = {"one","two","three","four","five","six"};
		System.out.println("Words: " + Arrays.deepToString(words));
		
//		serializeWords(file, words);
		
		//Modifying the array words
		for(int i = 0; i < words.length; i++) {
			if (i % 2 == 1)
				words[i] = null;
		}System.out.println("Modified words: " + Arrays.deepToString(words));
		
		words = deserializeWords(file);
		System.out.println("Deserialized words: " + Arrays.deepToString(words));
		
		System.out.println("Done...");
	}

	private static String[] deserializeWords(String file) {
		String[] stringArray = null;
		try(ObjectInputStream deserializer =
				new ObjectInputStream(new FileInputStream(file))){
			int size = deserializer.readInt();
			stringArray = new String[size];
			for(int i = 0; i < size; i++) {
				stringArray[i] = (String) deserializer.readObject();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("A problem occured when deserializing...");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("A problem occured casting the deserialized object to a String....");
			e.printStackTrace();
		}
		return stringArray;
	}

	@SuppressWarnings("unused")
	private static void serializeWords(String file, String[] words) {
		try(ObjectOutputStream serializer =
				new ObjectOutputStream(new FileOutputStream(file))){
			serializer.writeInt(words.length);
			for(int i = 0; i < words.length; i++) {
				serializer.writeObject(words[i]);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("A problem occured when serializing...");
			e.printStackTrace();
		}
	}

}
