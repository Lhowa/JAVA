package labels;

/**
 * US Address that is not a PO box.
 * 
 * @author landonhowa
 *
 */
public class Address {
	private String street;
	private String city;
	private State state;
	private int zip;
	
	/**
	 * Constructor initializes the fields
	 * @param street Street Address
	 * @param city
	 * @param state	US State
	 * @param zip 5 Digit zip code
	 */
	public Address(String street, String city, State state, int zip) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	/**
	 * Returns street address
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * returns the city
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * returns the abbreviation of the state
	 * @return the state
	 */
	public State getState() {
		return state;
	}

	/**
	 * returns the zip code
	 * @return the zip
	 */
	public int getZip() {
		return zip;
	}

}
