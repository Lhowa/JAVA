package labInterface;
/**
 * Interface Flyable, to be used for classes:
 * Bird, Hangglider, and Plane.
 * @author landonhowa
 *
 */
public interface Flyable {
	/**
	 * Calls the interface method launch.
	 */
	public abstract void launch();
	
	/**
	 * Calls the interface method land.
	 */
	public abstract void land();

}
