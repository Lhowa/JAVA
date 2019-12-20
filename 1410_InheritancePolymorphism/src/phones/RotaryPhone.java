package phones;
/**
 * Class RotaryPhone, type of class DeskPhone
 * @author landonhowa
 *
 */
public class RotaryPhone extends DeskPhone{

	/**
	 * @param model
	 * @param demension
	 * @param voltage
	 */
	public RotaryPhone(String model, Dimension demension, Voltage voltage) {
		super(model, demension, voltage);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * returns a string "Rotating to call {number}"
	 */
	@Override
	public String call(long number) {
		return "Rotating to call " + number;
	}
	
}
