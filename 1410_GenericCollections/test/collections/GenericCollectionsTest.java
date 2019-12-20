package collections;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;




class GenericCollectionsTest {
	List<Character> charTestList = new ArrayList<>();
	List<String> baseChar1 = new ArrayList<>();
	
	int testNum = 0;
	List<Integer> intTestList = new ArrayList<>();
	List<String> intTestListBase = new ArrayList<>();
	


	

	@Test
	void testLettersAndNumbers_testWithOneChar_lowerC() {
		baseChar1.add("L(c)");
		charTestList.add('c');
		Assert.assertEquals(baseChar1, GenericCollections.lettersAndNumbers(charTestList));
	}
	@Test
	void testLettersAndNumbers_testWithtwoChars_upperAndLowerC() {
		baseChar1.add("U(c)");
		baseChar1.add("L(c)");
		charTestList.add('c');
		charTestList.add('C');
		Assert.assertEquals(baseChar1, GenericCollections.lettersAndNumbers(charTestList));
	}
	@Test
	void testLettersAndNumbers_testWithNum_soloNum() {
		baseChar1.add("N(9)");
		charTestList.add('9');
		Assert.assertEquals(baseChar1, GenericCollections.lettersAndNumbers(charTestList));
	}
	@Test
	void testLettersAndNumbers_testEmpty_brackets() {
		Assert.assertEquals(baseChar1, GenericCollections.lettersAndNumbers(charTestList));
	}
	@Test
	void testLettersAndNumbers_null_null() {
		charTestList.add(null);
		assertThrows(NullPointerException.class, () -> {GenericCollections.lettersAndNumbers(charTestList);});
	}
	@Test
	void testLettersAndNumbers_testWithSpecialChar_skipSpecialChar() {
		baseChar1.add("N(9)");
		charTestList.add('9');
		charTestList.add('*');
		Assert.assertEquals(baseChar1, GenericCollections.lettersAndNumbers(charTestList));
	}
	@Test
	void testLettersAndNumbers_testWithTwoSpecialChar_skipSpecialChars() {
		baseChar1.add("N(9)");
		charTestList.add('9');
		charTestList.add('*');
		charTestList.add('#');
		Assert.assertEquals(baseChar1, GenericCollections.lettersAndNumbers(charTestList));
	}
	@Test
	void testLettersAndNumbers_testWithTwoSpecialCharAndNum_skipSpecialChars() {
		baseChar1.add("N(9)");
		baseChar1.add("N(9)");
		charTestList.add('9');
		charTestList.add('*');
		charTestList.add('#');
		charTestList.add('9');
		Assert.assertEquals(baseChar1, GenericCollections.lettersAndNumbers(charTestList));
	}
	

	@Test
	void testModify_addOneNum_14() {
		intTestList.add(1);
		testNum = 14;
		Assert.assertEquals(testNum, GenericCollections.modify(intTestList));
	}
	@Test
	void testModify_addTwoNum_15() {
		intTestList.add(1);
		intTestList.add(2);
		testNum = 15;
		Assert.assertEquals(testNum, GenericCollections.modify(intTestList));
	}
	@Test
	void testModify_addNone_13() {
		testNum = 13;
		Assert.assertEquals(testNum, GenericCollections.modify(intTestList));
	}
	@Test
	void testModify_null_null() {
		assertThrows(NullPointerException.class, () -> {GenericCollections.modify(null);});
	}
	@Test
	void testModify_addLarge_14() {
		intTestList.add(28);
		testNum = 14;
		Assert.assertEquals(testNum, GenericCollections.modify(intTestList));
	}
	@Test
	void testModify_addNegative_14() {
		intTestList.add(-8);
		testNum = 14;
		Assert.assertEquals(testNum, GenericCollections.modify(intTestList));
	}
	@Test
	void testModify_addNegativeAndPositive_15() {
		intTestList.add(-8);
		intTestList.add(8);
		testNum = 14;
		Assert.assertEquals(testNum, GenericCollections.modify(intTestList));
	}
	@Test
	void testModify_addDuplicateNum_13() {
		intTestList.add(5);
		testNum = 13;
		Assert.assertEquals(testNum, GenericCollections.modify(intTestList));
	}

	
//	@Test
//	void testRemoveEveryNthElement() {
//		intTestList.add(1);
//		intTestList.add(2);
//		intTestList.add(3);
//		intTestListBase.add("1, 3");
//		Assert.assertEquals(intTestListBase, GenericCollections.removeEveryNthElement(intTestList, 2));
//	}

}
