package m02;
/**
 * Class Module02, this class is used as the test class.
 * Create/display new PowerPlants.
 * @author landonhowa
 *
 */
public class Module02 {

	public static void main(String[] args) {
		PowerPlant powerPlant = new PowerPlant(100);
		WindFarm onshoreWindFarm = new WindFarm(6800, false);
		WindFarm offshoreWindFarm = new WindFarm(400, true);
		HydroPowerPlant hydroWithDam = new HydroPowerPlant(22500, true);
		HydroPowerPlant hydroWithOutDam = new HydroPowerPlant(15, false);
		
		PowerPlant[] powerPlants = {powerPlant, onshoreWindFarm, offshoreWindFarm, hydroWithDam, hydroWithOutDam};
		
		for (PowerPlant p : powerPlants) {
			System.out.println(p);
			System.out.println(p.generateElectricity());
			System.out.println();
		}

	}

}
