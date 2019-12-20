package abstractClass;

/**
 * Class PrinterApp, test class of package.
 * Creates new printers of each type and runs tell 
 * toner/cartridge is empty
 * @author landonhowa
 *
 */
public class PrinterApp {

	public static void main(String[] args) {
		InkJetPrinter inkPrinter = new InkJetPrinter(1, "Cannon Pixma");
		LaserPrinter lzrPrinter = new LaserPrinter(2, "HP Laser Jet Pro");
		System.out.println(inkPrinter);
		System.out.println("Remaining Cartridge: " + inkPrinter.getRemainingCartridge() + "%");
		
		System.out.println();

		System.out.println(lzrPrinter);
		System.out.println("Remaining Toner: " + lzrPrinter.getRemainingToner() + "%");

		System.out.println();
		System.out.println("List of Printers");
		Printer printers[] = { inkPrinter, lzrPrinter };
		for (Printer p : printers) {
			System.out.println(p);
			p.print();
			p.print();
			p.print();
			p.print();
			p.print();
			p.print();
			p.print();
			p.print();
			p.print();
			p.print();
			p.print();
			System.out.println();
		}
	}

}
