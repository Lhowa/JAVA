package phones;
/**
 * Class DeskPhone, type of class Phone
 * @author landonhowa
 *
 */
public class DeskPhone extends Phone{
	public boolean connected;
	//private Voltage voltage;   **Please see note below.**
	
	protected DeskPhone(String model, Dimension demension, Voltage voltage) {
		super(model, demension);
		unPlug(); //Phone originally comes unplugged.
	}
	
	public String connectionInfo;
	
	/**
	 * Provides power to the phone.
	 */
	public void plugIn() {
		connected = true;
		connectionInfo = " connected";
	}
	
	/**
	 * Default, phone is unplugged
	 */
	public void unPlug() {
		connected = false;
		connectionInfo = " not connected";
	}
	
	/**
	 * @return Returns whether is plugged or unplugged.
	 */
	public boolean isConnected(){
		return connected;
	}
	
	
	/**
	 * returns a string of class Phone + the connection info
	 */
	@Override
	public String toString() {
		return super.toString() + connectionInfo;// **removed "+ {voltage} +" for it is not used in the sample output**
	}

}
