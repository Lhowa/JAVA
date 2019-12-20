package labCollection;

import java.util.ArrayList;
import java.util.List;

public class Warmup {

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>();
		for (int i = 2; i < 51; i += 2) {
			numbers.add(i);
		}
		numberArrPrinter(numbers);
		System.out.println("Removing multiples of three...");
		numbers.removeIf(x -> x % 3 == 0);
		numberArrPrinter(numbers);

	}

	private static void numberArrPrinter(List<Integer> numbers) {
		System.out.print("Numbers: " );
		numbers.forEach(el -> System.out.print(el + " "));
		System.out.println();
	}

}
