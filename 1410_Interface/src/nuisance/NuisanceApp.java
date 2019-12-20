package nuisance;
/**
 * Class NuisanceApp, class is used to create
 * various Persons and Insects. The app will also print 
 * them out and test the methods provided in the individual
 * classes.
 * @author landonhowa
 *
 */
public class NuisanceApp {

	public static void main(String[] args) {
		Friend friend1 = new Friend("Juan", 27, Hobby.MUSIC);
		Friend friend2 = new Friend("Kate", 27, Hobby.SPORTS);
		Friend friend3 = new Friend("Alex", 21, Hobby.MUSIC);
		Friend newFriend = new Friend("Kate", 27, Hobby.SPORTS);
		
		Friend[] friends = {friend1, friend2, friend3};
		
		System.out.println("3 Friends.");
		
		int count = 1;
		
		for (Friend f : friends) {
			System.out.println("friend" + count + ": " + f);
			count++;
		}

		
		System.out.println();
		

		
		System.out.println("friend1 equals friend2: " + friend1.equals(friend2));
		System.out.println("friend1 equals friend3: " + friend1.equals(friend3));
		System.out.println("friend2 equals new friend: " + friend2.equals(newFriend));
		
		System.out.println();
		
		Telemarketer telemarketer1 = new Telemarketer("Fritz", 25);
		
		System.out.println("telemarketer: " + telemarketer1);
		
		System.out.println();

		System.out.println("3 Insects:");
		
		Mosquito mosquito = new Mosquito("Aedes Vexans");
		PeskyMosquito peskyMosquito = new PeskyMosquito("Anopheles Walkeri");
		Butterfly butterfly = new Butterfly("Swallowtail", null);
		
		Insect[] insects = {mosquito, peskyMosquito, butterfly};
		
		for (Insect i : insects) {
			System.out.println(i);
		}
		
		System.out.println();
		
		System.out.println("3 Nuisances:");
		
		Nuisance[] nuisances = {telemarketer1, mosquito, peskyMosquito};
		
		for (Nuisance n : nuisances) {
			if(n instanceof Mosquito) {
				System.out.println(((Mosquito) n).buzz());
			}
			if(n instanceof PeskyMosquito) {
				System.out.println(((PeskyMosquito) n).bite());
			}
			if(n instanceof Nuisance) {
				System.out.println(((Nuisance) n).annoy());
			}
			System.out.println();
		}
	}

}
