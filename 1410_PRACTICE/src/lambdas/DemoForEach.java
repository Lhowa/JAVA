package lambdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Demonstrates how to use lambda expressions with forEach
 * loops. The demonstrations have been refactored into methods.
 * @author landonhowa
 *
 */
public class DemoForEach {
	
	public static void main(String[] args) {
		
//		demoForEachWithListOfStrings();

//		demoForEachWithListAndSet();
	}

	@SuppressWarnings("unused")
	private static void demoForEachWithListAndSet() {
		List<Integer> numberList = new ArrayList<>();
		
		//Creates 15 random 1 digit numbers
		for(int i = 0; i < 15; i++) {
			int randomNumber = (int) Math.floor(Math.random() * 10);
			numberList.add(randomNumber);
		}
		
		System.out.print("Number List: ");
		numberList.forEach(n -> System.out.print(n + " "));
		System.out.println();
		
		List<Integer> numberList2 = new ArrayList<>();
		numberList.forEach(n -> numberList2.add(10 * n));
		System.out.println("Number List 2: " + numberList2);
		
		//Sets
		Set<Integer> numberSet = new HashSet<>();
		numberSet.addAll(numberList2);
		System.out.println("Number Set: " + numberSet);//Sets will not add duplicates
		numberSet.forEach(n -> System.out.print(n + " "));//Same as above using lambda
		System.out.println();
	}

	@SuppressWarnings("unused")
	private static void demoForEachWithListOfStrings() {
		List<String> instruments = new ArrayList<>();
		Collections.addAll(instruments, "Bongo", "Bugle", "Cello", "Chime", "Flute", "Piano", "Taiko", "Viola");
		System.out.println("Instruments" + instruments);
		
		System.out.print("Instruments: ");
		for (String el : instruments) {
			System.out.print("[" + el + "] ");
		}
		System.out.println();//The same is done below...
		System.out.print("Instruments: ");
		instruments.forEach(el -> System.out.print("[" + el + "] "));
		System.out.println();
		
		System.out.print("Instruments: ");
		instruments.forEach(el -> System.out.print("[" + el.toLowerCase() + "] "));
		System.out.println();
		
		System.out.print("Instruments: ");
		instruments.forEach(el -> System.out.print(el + "|" + el + " "));
		System.out.println();
	}
}
