package m01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * JUnit Tests for Module01
 * @author landonhowa
 *
 */
class Module01Test {

	@Test
	void Transform_cs_CSIS() {
		assertEquals("<CSIS-world>", Module01.transform("cs world"));
	}
	@Test
	void Transform_csis_CSIS() {
		assertEquals("<CSIS-world>", Module01.transform("csis world"));
	}
	void Transform_cis_CSIS() {
		assertEquals("<CSIS-world>", Module01.transform("cis world"));
	}
	void Transform_cS_CSIS() {
		assertEquals("<CSIS-world>", Module01.transform("cS world"));
	}
	@Test
	void Transform_csIs_CSIS() {
		assertEquals("<CSIS-world>", Module01.transform("csIs world"));
	}
	void Transform_Cis_CSIS() {
		assertEquals("<CSIS-world>", Module01.transform("Cis world"));
	}
	void Transform_underscoreIgnore_CSIS() {
		assertEquals("<CSIS_world>", Module01.transform("Cis_world"));
	}
	void Transform_addHyphen_Css1430() {
		assertEquals("<Css-1430>", Module01.transform("Css 1430"));
	}
	void Transform_noChange_mom() {
		assertEquals("<mom>", Module01.transform("mom"));
	}
	void Transform_manyHyphen_saltHyphenLakeHyphenCity() {
		assertEquals("<salt-lake-city>", Module01.transform("salt lake city"));
	}
	void Transform_passNothing_emptyArrows() {
		assertEquals("< >", Module01.transform(""));
	}

}
