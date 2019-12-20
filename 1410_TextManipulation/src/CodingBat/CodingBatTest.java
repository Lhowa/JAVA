package CodingBat;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CodingBatTest {

	@Test
	public void WordEnds_TestBeforeAfterXY_c13i() {
	   assertEquals("c13i", CodingBat.wordEnds("abcXY123XYijk", "XY"));

	  }
	@Test
	public void WordEnds_TestBeforeAfterXY_13() {
		assertEquals("13", CodingBat.wordEnds("XY123XY", "XY"));	
	  }
	@Test
	public void WordEnds_TestBeforeAfterXY_11BeforeAfter() {
		assertEquals("11", CodingBat.wordEnds("XY1XY", "XY"));	
	  }
	@Test
	public void WordEnds_TestBeforeAfterXY_XY() {
		assertEquals("XY", CodingBat.wordEnds("XYXY", "XY"));
	  }
	@Test
	public void WordEnds_TestBeforeAfterXY_ReturnNoResultXYOnly() {
		assertEquals("", CodingBat.wordEnds("XY", "XY"));
	  }
	@Test
	public void WordEnds_TestBeforeAfterXY_ReturnNoResultXYNotIncluded() {
		assertEquals("", CodingBat.wordEnds("Hi", "XY"));	
	  }
	@Test
	public void WordEnds_TestBeforeAfterXY_ReturnNoResultNoInput() {
		assertEquals("", CodingBat.wordEnds("", "XY"));	
	  }
	@Test
	public void WordEnds_TestBeforeAfterXY_cxziij() {
		assertEquals("cxziij", CodingBat.wordEnds("abc1xyz1i1j", "1"));	
	  }
	@Test
	public void WordEnds_TestBeforeAfterXY_cxz() {
		assertEquals("cxz", CodingBat.wordEnds("abc1xyz1", "1"));	
	  }
	@Test
	public void WordEnds_TestBeforeAfterXY_cxz11() {
		assertEquals("cxz11", CodingBat.wordEnds("abc1xyz11", "1"));
	  }
	@Test
	public void WordEnds_TestBeforeAfterXY_11() {
		assertEquals("11", CodingBat.wordEnds("abc1xyz1abc", "abc"));	
	  }
	@Test
	public void WordEnds_TestBeforeAfterXY_acac() {
		assertEquals("acac", CodingBat.wordEnds("abc1xyz1abc", "b"));
	  }
	@Test
	public void WordEnds_TestBeforeAfterXY_1111() {
		assertEquals("1111", CodingBat.wordEnds("abc1abc1abc", "abc"));	
	  }

}

