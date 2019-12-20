package abstractClass;

/**
 * class LaserPrinter, subclass of class Printer
 * @author landonhowa
 *
 */
public class LaserPrinter extends Printer {
	private int remainingToner;

	public LaserPrinter(int sNumber, String model) {
		super(model);
		remainingToner = 100;
	}

	/**
	 * 
	 * @return the remaining Toner.
	 */
	public int getRemainingToner() {
		return remainingToner;
	}
	
	/**
	 * Returns a string containing the remaining toner level, reduces the toner level by 10.
	 */
	public void print() {
		if (getRemainingToner() > 0) {
			remainingToner -= 10;
			System.out.println( getModel() + " is printing. Remaining cartridge: " + getRemainingToner() + "%");
		} else if (getRemainingToner() == 0) {
			System.out.println("The toner is empty.");
		}
	}
}
