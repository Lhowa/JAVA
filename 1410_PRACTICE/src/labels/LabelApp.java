package labels;

public class LabelApp {

	public static void main(String[] args) {
		Address address1 = new Address("137  James St", "Kent", State.WA, 98032);
		System.out.println("address1: " + address1.getStreet());
		System.out.println();
		
		AdressLabel addressLabel = new AdressLabel("Dan", "Smith", address1);
		System.out.println("addressLabel: " + addressLabel);
		System.out.println();
		
		addressLabel.printLabel();
	}

}
