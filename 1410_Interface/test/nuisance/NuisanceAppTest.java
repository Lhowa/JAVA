package nuisance;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NuisanceAppTest {

	Friend friend1 = new Friend("Juan", 27, Hobby.MUSIC);
	Friend friend2 = new Friend("Kate", 27, Hobby.SPORTS);
	Friend friend3 = new Friend("Alex", 21, Hobby.MUSIC);
	Friend newFriend = new Friend("Kate", 27, Hobby.SPORTS);
	Telemarketer telemarketer1 = new Telemarketer("Fritz", 25);
	
	@Test
	void newFriendConstructor_generateAgeWith0_ThrowIllegal() {
		assertThrows(IllegalArgumentException.class, () -> {Friend friendTest = new Friend("Trevor", 0, Hobby.MUSIC);});
	}
	
	@Test
	void newFriendConstructor_generateAgeWith151_ThrowIllegal() {
		assertThrows(IllegalArgumentException.class, () -> {Friend friendTest = new Friend("Trevor", 151, Hobby.MUSIC);});
	}

	@Test
	void compareFriends_compare1And3_false() {
		assertEquals(false, friend1.equals(friend3));
	}
	

	@Test
	void telemarketerGiveSalesPitch_giveSalesPitch_StringToGiveSalesPitch() {
		assertEquals("Fritz pressures others to buy stuff", telemarketer1.giveSalesPitch());
	}
	@Test
	void newTelemarketerConstructor_generateAgeWith151_ThrowIllegal() {
		assertThrows(IllegalArgumentException.class, () -> {Telemarketer telemarketerTest = new Telemarketer("Trevor", 151);});
	}
	@Test
	void newTelemarketerConstructor_generateAgeWith0_ThrowIllegal() {
		assertThrows(IllegalArgumentException.class, () -> {Telemarketer telemarketerTest = new Telemarketer("Trevor", 0);});
	}
	
	@Test
	void friendChill_chill_ChillString() {
		assertEquals("Juan is chilling", friend1.chill());
	}
}
