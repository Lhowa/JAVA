package docComments;
/**
 * TripPlanner class, contains constructor and method to calculate fuel consumption.
 * @author landonhowa
 *
 */
public class TripPlanner {
	private String departure;
	private String arrival;
	private int distance;
	private Car car;
	/**
	 * Constructor of class TripPlanner
	 * @param departure
	 * @param arrival
	 * @param distance
	 * @param car
	 */
	public TripPlanner(String departure, String arrival, int distance, Car car) {
		this.departure = departure;
		this.arrival = arrival;
		this.distance = distance;
		this.car = car;
	}
	/**
	 * Calculates the amount of fuel required to drive from departure to destination.
	 * @return
	 */
	public static double fuelConsumption(double totalDistance, int mpg) {
		double fuelNeeded = totalDistance / mpg;
		fuelNeeded = Math.round(fuelNeeded * 10)/10.0;
		return fuelNeeded;
		
	}
	/* (non-JavaDoc)
	 * @see java.lanf.Object#toString()
	 */
	@Override
	public String toString() {
		return "TripPlanner [departure=" + departure + ", arrival=" + arrival + ", distance=" + distance + ", car="
				+ car.getModel() + "]";
	}

}
