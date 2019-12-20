package labels;

/**
 * Represents an address label that includes the first and last name and address.
 * @author landonhowa
 *
 */
public class AdressLabel {
	private String firstName;
	private String lastName;
	private Address address;
	/**
	 * Constructor of class AddressLabel
	 * @param firstName
	 * @param lastName
	 * @param address
	 */
	public AdressLabel(String firstName, String lastName, Address address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
	}
	/* (non-Javadoc)
	 * @see java.lanf.Object#toString()
	 */
	@Override
	public String toString() {
		return "AdressLabel [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + "]";
	}
	/**
	 * Prints a label in the following format:</br>
	 * firstName LastName</br>
	 * address</br>
	 * city, state zip</br>
	 */
public void printLabel() {
	System.out.printf("%s %s%n", firstName,lastName);
	System.out.println(address.getStreet());
	System.out.printf("%s, %s %d%n", address.getCity(), address.getState(), address.getZip());
	
}
	
}
