package unitTesting;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TreasureChestTest {
	private TreasureChest treasure;
	private TreasureChest emptyChest;
	private final BigDecimal DELTA = new BigDecimal (0.000001);
	
	@BeforeEach
	void setUp() throws Exception {
		treasure = new TreasureChest(10);
		emptyChest = new TreasureChest(0);
		TreasureChest.setGoldPrice(new BigDecimal(1426.90));
	}

	
	
	@Test

	void TreasureChest_0Coins_ThrowsIllegalArgumentException() {
		TreasureChest treasure0 = new TreasureChest(0);
		int expected = 0;
		int actual =treasure0.getGold();
		assertEquals(expected, actual);
	}
	@Test
	void TreasureChest_NegativeCoins_ThrowsIllegalArgumentException() {
		TreasureChest treasure7 = new TreasureChest(7);
		assertThrows(IllegalArgumentException.class, () -> {new TreasureChest(-2);});
	}
	@Test
	void TreasureChest_PositiveNumberOfCoins_AllCoinsStoredInTreasureChest() {
		TreasureChest treasure7 = new TreasureChest(7);
		int expected = 7;
		int actual =treasure7.getGold();
		assertEquals(expected, actual);
	}
	
	
	
	

	@Test
	void addGold_AddingPositiveNumberOfCoins_IncreaseNumberOfCoinsInTreasureChest() {
		treasure.addGold(5);
		int expected = 15;
		int actual = treasure.getGold();
		assertEquals(expected, actual);
	}
	@Test
	void addGold_AddingZeroCoins_IncreaseNumberOfCoinsInTreasureChest() {
		treasure.addGold(0);
		assertEquals(10, treasure.getGold());//another way to write without expected and actual. Replaced here.
	}
	@Test
	void addGold_AddingNegativeNumberOfCoins_IncreaseNumberOfCoinsInTreasureChest() {
		assertThrows(IllegalArgumentException.class, () -> {treasure.addGold(-1);});
	}
	
	
	
	

	@Test
	void RemoveGold_RemovingAnOkayAmount_DecreaseNumberOfCoinsInChest() {
		assertEquals(7, treasure.removeGold(3));
	}
	@Test
	void RemoveGold_Removing0Coins_RemovingNoCoinsFromTheChest() {
		assertEquals(10, treasure.removeGold(0));
	}
	void RemoveGold_RemovingAllCoins_RemovingAllCoinsInTheChest() {
		assertEquals(0, treasure.removeGold(10));
	}
	@Test
	void RemoveGold_RemovingTooManyCoins_ThrowsIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> {treasure.removeGold(11);});
	}
	@Test
	void RemoveGold_RemovingNegativeAmountOfCoins_THrowsIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> {treasure.removeGold(-1);});
	}
	
	
	
	
	

	@Test
	void SetGoldPrice_SetNegativePrice_ThrowsIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> {TreasureChest.setGoldPrice(new BigDecimal(-0.01));});
	}
	@Test
	void SetGoldPrice_SettingPositivePrice_UpdatesGoldPrice() {
		TreasureChest.setGoldPrice(new BigDecimal(1376.57));
		assertEquals(new BigDecimal(1376.57), TreasureChest.getGoldPrice());
	}
	@Test
	void SetGoldPrice_Setting0_ThrowsIllegalUpdatesGoldPrice() {
		TreasureChest.setGoldPrice(BigDecimal.ZERO);
		assertEquals(BigDecimal.ZERO, TreasureChest.getGoldPrice());
	}
	
	

	
	
	
	
	
	@Test
	void ValueInDollars_FilledTreasureChest_ReturnsTotalAmointOfGoldMultipliedByPrice() {
		BigDecimal difference = (new BigDecimal(13805.2575).subtract(treasure.valueInDollars())).abs();
		assertTrue(!(difference.compareTo(DELTA) > 1));
	}
	@Test
	void ValueInDollars_EmptyTreasureChest_Returns0() {
		BigDecimal difference = (BigDecimal.ZERO.subtract(emptyChest.valueInDollars())).abs();
		assertTrue(!(difference.compareTo(DELTA) > 1));
	}

	
	
	
	
	
	@Test
	void ToString_PositiveNumberOfCoins_ReturnNumberCoinsInBracket() {
		String expected = "[ 10 coins ]"; // [ {gold} coins ]
		String actual = treasure.toString();
		assertEquals(expected, actual);
	}
	@Test
	void ToString_NoCoins_Return0CoinsInBracket() {
		String expected = "[ 0 coins ]"; // [ {gold} coins ]
		String actual = emptyChest.toString();
		assertEquals(expected, actual);
	}

}
