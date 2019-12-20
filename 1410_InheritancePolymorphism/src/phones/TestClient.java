package phones;
/**
 * Class TestClient from here all phone classes are tested/created including Dimensions
 * and adding a voltage.
 * @author landonhowa
 *
 */
public class TestClient {

	public static void main(String[] args) {
		Dimension rDimension = new Dimension(143, 208, 119);
		RotaryPhone rPhone = new RotaryPhone("Model 500", rDimension, Voltage.V110);
		
		Dimension pbDimension = new Dimension(178, 228, 127);
		PushButtonPhone pbPhone = new PushButtonPhone("Cortelco 2500", pbDimension, Voltage.DUAL);
		
		Dimension sp1Dimension = new Dimension(145.6, 68.2, 7.9);
		SmartPhone sp1 = new SmartPhone("Pixel3", sp1Dimension, 128);
		
		Dimension sp2Dimension = new Dimension(138.4, 67.3, 7.3);
		SmartPhone sp2 = new SmartPhone("iPhone8", sp2Dimension, 64);

		System.out.println("Various Phones:");
		System.out.println(rPhone.toString());
		System.out.println(pbPhone.toString());
		System.out.println(sp1.toString());
		System.out.println(sp2.toString());
		System.out.println();
		
		rPhone.plugIn();
		pbPhone.plugIn();
		pbPhone.unPlug();
		
		Phone[] phones = {rPhone, pbPhone, sp1, sp2};
		System.out.println("Array Elements");
		
		for (Phone p : phones) {
			System.out.println(p.toString());
			System.out.println(p.call(8019574111l));//"l" is included to treat as a long, otherwise out of bounds exception, treated as int.
			if(p instanceof SmartPhone) {
				System.out.println(((SmartPhone) p).browse());
				System.out.println(((SmartPhone) p).takePicture());
			}
			System.out.println();
			
			
		}
	}

}
