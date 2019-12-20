package docComments;
/**
 * Contains Main for running app, also contains all print statements.
 * @author landonhowa
 *
 */
public class TravelApp {

	public static void main(String[] args) {
		Car m4 = new Car("BMW", "M4", 25);
		Car civic = new Car("Honda", "Civic", 42);
		TripPlanner California = new TripPlanner("SF", "LA", 382, m4);
		TripPlanner Florida = new TripPlanner("Tampa", "Miami", 280, civic);

		System.out.printf("Cars:%n%s %s 25 mph%n", m4.getMake(), m4.getModel());
		System.out.printf("%s %s 42 mph%n%n", civic.getMake(), civic.getModel());
		System.out.println("California Trip:\n" + California);
		System.out.println("fuel consumption " + TripPlanner.fuelConsumption(382 ,m4.getMpg()) + " gallons");
		System.out.println("\nFlorida Trip:\n" + Florida);
		System.out.println("fuel consumption " + TripPlanner.fuelConsumption(280,civic.getMpg()) + " gallons");

	}

}
