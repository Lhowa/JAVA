package abstractClass;


public abstract class Printer {
	private int serialNumber;
	private String model;
	private static int count;
	
	/**
	 * @param model
	 */
	protected Printer(String model) {
		count++;
		this.model = model;
		serialNumber = count + 12345;
	}


	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}
	/**
	 * Returns a message of the amount of toner/ink in the printers.
	 */
	public abstract void print();

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + ": " + model + " #" + serialNumber;
	}
}
