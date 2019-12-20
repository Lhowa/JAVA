package unitTesting;
import java.math.BigDecimal;
/**
 * Treasure chest that is defined by the amount of gold stored in it.
 * In this class we assume that each coin is a $20 liberty gold coin.
 * This assumption combined with the knowledge of the gold price and
 * the amount of gold in each coin allows us to calculate the dollar 
 * value of the treasure chest.
 * 
 * 
 * @author landonhowa
 *
 */
public class TreasureChest {
/**
 * Number of gold coins
 */
private int gold;
/**
 * amount of gold per coin in ounces
 */
private static final BigDecimal GOLD_PER_COIN = new BigDecimal(0.9675);
/**
 * Price of an ounce of gold
 */
private static BigDecimal goldPrice =  new BigDecimal(1426.90);

/**
 * Initializes a newly created TreasureChest with the specified number of gold coins
 * <p>
 * @param gold
 * @throws IllegalArgumentException if <code>goldCoins</code> is negative.
 */
public TreasureChest (int goldCoins) {
	if(goldCoins < 0) {
	throw new IllegalArgumentException("The number of goldcoins in the treasure chest can't be negative.");
	
	}
	this.gold = goldCoins;
}
/**
 * @return the amount of gold in this treasure chest.
 */
public int getGold() {
	return gold;
}

/**
 * adds the specified number of coins to this treasure chest
 * <p>
 * @param numberOfCoins to be added
 * @throws IllegalArgumentException if the <code>numberOfCoins</code> is negative
 */
public void addGold(int numberOfCoins) {
	if (numberOfCoins < 0) {
		throw new IllegalArgumentException ("The number of coins in the treasure chest can't be negative.");
		
	}
	gold += numberOfCoins;
}
/**
 * Removes the specified number of coins to this treasure chest
 * <p>
 * @param numberOfCoins to be removed
 * @throws IllegalArgumentException if the <code>numberOfCoins</code> is negative
 * or if the <code>numberOfCoins</code> exceeds the number of gold in this treasure chest.
 */
public int  removeGold(int numberOfCoins) {
	if (numberOfCoins < 0 || numberOfCoins > this.gold) {
		throw new IllegalArgumentException ("The number of coins to be removed can't be greater than"
				+ "the amount of coins in the chest, or can't be negative");
		
	}
	this.gold -= numberOfCoins;
	return this.gold;
}

/**
 * @return the goldPrice
 */
public static BigDecimal getGoldPrice() {
	return goldPrice; 
}
/**
 * <p>
 * @param goldPrice the goldPrice to set
 * @throws IllegalArgumentException if the <code>goldPrice</code> is negative
 */
public static void setGoldPrice(BigDecimal goldPrice) {
	if(goldPrice.compareTo(BigDecimal.ZERO) < 0)
		throw new IllegalArgumentException("The gold price cant be negative");
	
	TreasureChest.goldPrice = goldPrice;
}
/**
 * 
 * @return
 */
public BigDecimal valueInDollars() {
	return new BigDecimal(gold).multiply(GOLD_PER_COIN).multiply(goldPrice);
}

/**
 * returns a string in this format:
 * [ {gold} coins ]
 */
@Override
public String toString() {
	return "[ " + gold + " coins ]";
}


}
