package edu.gatech.seclass;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyWeirdStringTest {

	private MyWeirdStringInterface myweirdstring;

	@Before
	public void setUp() throws Exception {
		myweirdstring = new MyWeirdString();
	}

	@After
	public void tearDown() throws Exception {
		myweirdstring = null;
	}

	@Test
	public void testCountDigits1() {
		myweirdstring.setWeirdString("I'd better put s0me d1gits in this 5tr1n9, right?");
		assertEquals(5, myweirdstring.countDigits());
	}

	/**Count the number in the string, should be 10,especially for number 0
	 */
	@Test
	public void testCountDigits2() {
		myweirdstring.setWeirdString("'1','2','3','4','5','6','7','8','9','0'");
		assertEquals(10, myweirdstring.countDigits());
	}

	/**Count the number in the string, should be 4,to see whether the number on the two ends of the string could be counted.
	 */
	@Test
	public void testCountDigits3() {
		myweirdstring.setWeirdString("2AAA000");
		assertEquals(4, myweirdstring.countDigits());
	}

	/**if the string don't have number, should be 0
	 */
	@Test
	public void testCountDigits4() {
		myweirdstring.setWeirdString("abcdefgh");
		assertEquals(0, myweirdstring.countDigits());
	}

	@Test
	public void testGetEvenCharacters1() {
		myweirdstring.setWeirdString("I'd better put s0me d1gits in this 5tr1n9, right?");
		assertEquals("' etrptsm 1isi hs5rn,rgt", myweirdstring.getEvenCharacters());
	}

	/**test lower case and upper case, string length is even.
	 */
	@Test
	public void testGetEvenCharacters2() {
		myweirdstring.setWeirdString("abCdEFgh");
		assertEquals("bdFh", myweirdstring.getEvenCharacters());
	}

	/**test lower case and upper case, string length is odd.
	 */
	@Test
	public void testGetEvenCharacters3() {
		myweirdstring.setWeirdString("A");
		assertEquals("", myweirdstring.getEvenCharacters());
	}

	/**test of space
	 */
	@Test
	public void testGetEvenCharacters4() {
		myweirdstring.setWeirdString("abCdEFghI ");
		assertEquals("bdFh ", myweirdstring.getEvenCharacters());
	}

	@Test
	public void testGetOddCharacters1() {
		myweirdstring.setWeirdString("I'd better put s0me d1gits in this 5tr1n9, right?");
		assertEquals("Idbte u 0edgt nti t19 ih?", myweirdstring.getOddCharacters());
	}

	/**test lower case and upper case, string length is even.
	 */
	@Test
	public void testGetOddCharacters2() {
		myweirdstring.setWeirdString("abCdEFgh");
		assertEquals("aCEg", myweirdstring.getOddCharacters());
	}

	/**test lower case and upper case, string length is odd.
	 */
	@Test
	public void testGetOddCharacters3() {
		myweirdstring.setWeirdString("abCdEFghI");
		assertEquals("aCEgI", myweirdstring.getOddCharacters());
	}

	/**test of white space
	 */
	@Test
	public void testGetOddCharacters4() {
		myweirdstring.setWeirdString(" abCdEFghI");
		assertEquals(" bdFh", myweirdstring.getOddCharacters());
	}

	@Test
	public void testConvertDigitsToRomanNumeralsInSubstring1() {
		myweirdstring.setWeirdString("I'd better put s0me d1gits in this 5tr1n9, right?");
		myweirdstring.convertDigitsToRomanNumeralsInSubstring(40, 45);
		assertEquals("I'd better put s0me d1gits in this 5tr1nIX, right?", myweirdstring.getWeirdString());
	}

	/**test start and end, and also number 0
	 */
	@Test
	public void testConvertDigitsToRomanNumeralsInSubstring2() {
		myweirdstring.setWeirdString("100001");
		myweirdstring.convertDigitsToRomanNumeralsInSubstring(1,6);
		assertEquals("I0000I", myweirdstring.getWeirdString());
	}

	/**test prefix with white space
	 */
	@Test
	public void testConvertDigitsToRomanNumeralsInSubstring3() {
		myweirdstring.setWeirdString(" 100001");
		myweirdstring.convertDigitsToRomanNumeralsInSubstring(2,7);
		assertEquals(" I0000I", myweirdstring.getWeirdString());
	}

	/**test surfix with white space, and also test conversion from 1 char to two chars
	 */
	@Test
	public void testConvertDigitsToRomanNumeralsInSubstring4() {
		myweirdstring.setWeirdString("900009 1");
		myweirdstring.convertDigitsToRomanNumeralsInSubstring(2,6);
		assertEquals("90000IX 1", myweirdstring.getWeirdString());
	}

	/**test outofBounds exception when end > length of string
	 */
	@Test(expected = MyIndexOutOfBoundsException.class)
	public void testConvertDigitsToRomanNumeralsInSubstring5() {
		myweirdstring.setWeirdString("900009");
		myweirdstring.convertDigitsToRomanNumeralsInSubstring(2,7);
	}

	/**test illegal argument exception when start > end
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testConvertDigitsToRomanNumeralsInSubstring6() {
		myweirdstring.setWeirdString("900009");
		myweirdstring.convertDigitsToRomanNumeralsInSubstring(6,2);

	}
	
	@Test
	public void testMyWeirdStringnull(){
		myweirdstring.setWeirdString(null);
		assertEquals("", myweirdstring.getWeirdString());
	}

}
