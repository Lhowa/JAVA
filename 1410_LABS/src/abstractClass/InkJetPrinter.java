package abstractClass;

/**
 * class InkJetPrinter, subclass of class Printer
 * @author landonhowa
 *
 */
public class InkJetPrinter extends Printer {
	private int remainingCartridge;

	public InkJetPrinter(int sNumber, String model) {
		super(model);
		remainingCartridge = 100;
	}

	/**
	 * 
	 * @return the remaining Cartridge.
	 */
	public int getRemainingCartridge() {
		return remainingCartridge;
	}
	
	/**
	 * Returns a string containing the remaining cartridge level, reduces the cartridge level by 10.
	 */
	public void print() {
		if (getRemainingCartridge() > 0) {
			remainingCartridge -= 10;
			System.out.println( getModel() + " is printing. Remaining cartridge: " + getRemainingCartridge() + "%");
		} else if (getRemainingCartridge() == 0) {
			System.out.println("The cartridge is empty.");
		}
	}
}
