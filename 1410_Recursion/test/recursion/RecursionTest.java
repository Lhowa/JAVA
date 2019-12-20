package recursion;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;



/**
 * JUnit class to test recursive methods in class Recursion.
 * @author landonhowa
 */
class RecursionTest {


	@Test
	public void sumofDigits_2Digits_9() {
	   assertEquals(9, Recursion.sumOfDigits(81));
	  }
	@Test
	public void sumofDigits_3Digits_11() {
	   assertEquals(11, Recursion.sumOfDigits(812));
	  }
	@Test
	public void sumofDigits_negativeNumber_0() {
	   assertEquals(0, Recursion.sumOfDigits(-1));
	  }
	@Test
	public void sumofDigits_is0_0() {
	   assertEquals(0, Recursion.sumOfDigits(0));
	  }
	@Test
	public void sumofDigits_includes0_4() {
	   assertEquals(4, Recursion.sumOfDigits(301));
	  }
	@Test
	public void sumofDigits_multipleNegative_0() {
	   assertEquals(0, Recursion.sumOfDigits(-103));
	  }
	@Test
	public void sumofDigits_5ones_5() {
	   assertEquals(5, Recursion.sumOfDigits(11111));
	  }
	@Test
	public void sumofDigits_alternating0s_3() {
	   assertEquals(3, Recursion.sumOfDigits(10101));
	  }
	
	char[] oneAtBegining = {':',')'};
	char[] oneAtEnd = {'j',':',')'};
	char[] oneAtMiddle = {'j',':',')','k'};
	char[] noSmiles = {'j','p',')','k'};
	char[] emptyArray = {};
	char[] multipleCongruent = {'j',':',')',':',')',':',')','o'};
	char[] multipleScattered = {'j',':',')','x',':',')',':',')','o'};
	char[] oneReverse = {':','(',':',')'};
	@Test
	public void countSmiles_oneAtBegining_1() {
	   assertEquals(1, Recursion.countSmiles(oneAtBegining));
	  }
	@Test
	public void countSmiles_oneAtEnd_1() {
	   assertEquals(1, Recursion.countSmiles(oneAtEnd));
	  }
	@Test
	public void countSmiles_oneAtMiddle_1() {
	   assertEquals(1, Recursion.countSmiles(oneAtMiddle));
	  }
	@Test
	public void countSmiles_noSmiles_0() {
	   assertEquals(0, Recursion.countSmiles(noSmiles));
	  }
	@Test
	public void countSmiles_emptyArray_0() {
	   assertEquals(0, Recursion.countSmiles(emptyArray));
	  }
	@Test
	public void countSmiles_multipleCongruent_3() {
	   assertEquals(3, Recursion.countSmiles(multipleCongruent));
	  }
	@Test
	public void countSmiles_multipleScattered_3() {
	   assertEquals(3, Recursion.countSmiles(multipleScattered));
	  }
	@Test
	public void countSmiles_oneReverse_1() {
	   assertEquals(1, Recursion.countSmiles(oneReverse));
	  }
	
	@Test
	void toUpper_singleLetter_Bspace() {
		assertEquals("B ", Recursion.toUpper("b"));
	}
	@Test
	void toUpper_noLetters_() {
		assertEquals("", Recursion.toUpper(""));
	}
	@Test
	void toUpper_twoWords_BsIsGspaceCsAsT() {
		assertEquals("B I G   C A T ", Recursion.toUpper("big cat"));
	}
	@Test
	void toUpper_3Letters_TspaceHspaceE() {
		assertEquals("T H E ", Recursion.toUpper("the"));
	}
	@Test
	void toUpper_captialLetters_TspaceHspaceE() {
		assertEquals("T H E ", Recursion.toUpper("THE"));
	}
	@Test
	void toUpper_manyLetters_manyLettersWithSpaces() {
		assertEquals("T H E C A T W E N T ", Recursion.toUpper("thecatwent"));
	}
	@Test
	void toUpper_lowerCap_TspaceT() {
		assertEquals("T T ", Recursion.toUpper("tT"));
	}
	@Test
	void toUpper_letterNumber_Tspace8() {
		assertEquals("T 8 ", Recursion.toUpper("t8"));//Possible use of ascii to determine letters only, for future.
	}
}