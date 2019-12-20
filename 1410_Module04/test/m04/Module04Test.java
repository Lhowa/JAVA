package m04;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;


//All able to test with a main, testCases fail with same tests.
class Module04Test {

	@Test
	void testMethod1_2doubles() {
		List <Double> testNumbers = new ArrayList<>();
		List <Double> testNumbersAnswer = new ArrayList<>();
		testNumbers.add((double) 12);
		testNumbers.add((double) 22);
		testNumbersAnswer.add(2.2);
		testNumbersAnswer.add(1.2);
		assertEquals(testNumbersAnswer, testNumbers);
	}
	@Test
	void testMethod_negativeDoubles() {
		List <Double> testNumbers = new ArrayList<>();
		List <Double> testNumbersAnswer = new ArrayList<>();
		testNumbers.add((double) 12);
		testNumbers.add((double) -22);
		testNumbersAnswer.add(1.2);
		assertEquals(testNumbersAnswer, testNumbers);
	}
	@Test
	void testMethod1_sameDouble() {
		List <Double> testNumbers = new ArrayList<>();
		List <Double> testNumbersAnswer = new ArrayList<>();
		testNumbers.add((double) 12);
		testNumbers.add((double) 12);
		testNumbersAnswer.add(1.2);
		assertEquals(testNumbersAnswer, testNumbers);
	}

	@Test
	void testMethod2_3nums() {
		List <Integer> testInts = new ArrayList<>();
		List <String> testString = new ArrayList<>();
		testInts.add(1);
		testInts.add(2);
		testInts.add(3);
		testString.add("1");
		testString.add("10");
		testString.add("11");
		assertEquals(testString, testInts);
	}
	@Test
	void testMethod2_greaterThan10Chars() {
		List <Integer> testInts = new ArrayList<>();
		List <String> testString = new ArrayList<>();
		testInts.add(1);
		testInts.add(2);
		testInts.add(3);
		testInts.add(11110);
		testString.add("1");
		testString.add("10");
		testString.add("11");
		assertEquals(testString, testInts);
	}
	@Test
	void testMethod2_add2GreaterThan10() {

		List <Integer> testInts = new ArrayList<>();
		List <String> testString = new ArrayList<>();
		testInts.add(1);
		testInts.add(2);
		testInts.add(3);
		testInts.add(11110);
		testInts.add(1111012);
		testString.add("1");
		testString.add("10");
		testString.add("11");
		assertEquals(testString, testInts);
	}
	

}
