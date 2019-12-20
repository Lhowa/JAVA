package phones;
/**
 * Class PushButtonPhone, type of class DeskPhone
 * @author landonhowa
 *
 */
public class PushButtonPhone extends DeskPhone{
	/**
	 * @param model of the phone.
	 * @param demension of the phone.
	 * @param voltage of the phone.
	 */
	public PushButtonPhone(String model, Dimension demension, Voltage voltage) {
		super(model, demension, voltage);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Returns a string "Pushing buttons to call {Number}"
	 */
	@Override
	public String call(long number) {
		return "Pushing buttons to call " + number;
	}
}
