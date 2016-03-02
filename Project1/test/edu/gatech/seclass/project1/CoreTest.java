package edu.gatech.seclass.project1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;

import org.junit.Before;
import org.junit.Test;

import edu.gatech.seclass.project1.domain.WCContext;

public class CoreTest{

	/**
	 * The core object to use in testing.
	 */
	private Core core;

	/**
	 * Setup for unit tests.
	 */
	@Before
	public void setup(){
		core = new Core();
	}

	/**
	 * Test average sentence length calculation for a sample lipsum (dummy text usually used for printing/typesetting) 
	 * to simulate natural text using the default settings.
	 * @throws UnsupportedEncodingException
	 * @throws WCException
	 */
	@Test
	public void testCalculateAverageSentenceLength_sampleLipsumDefaultArguments() throws UnsupportedEncodingException, WCException{
		URL resource = getClass().getClassLoader().getResource("lipsum.txt");
		assertNotNull(resource);
		File file = new File(URLDecoder.decode( resource.getFile(), "UTF-8"));
		WCContext context = new WCContext(null, null, file.getAbsolutePath());
		assertEquals(6.29, core.calculateAverageSentenceLength(context), 0.001);
	}

	/**
	 * Test average sentence length calculation for a sample lipsum (dummy text usually used for printing/typesetting) 
	 * to simulate natural text using the default delimiter and a length of 6.
	 * @throws UnsupportedEncodingException
	 * @throws WCException
	 */
	@Test
	public void testCalculateAverageSentenceLength_sampleLipsumDefaultDelimiterLength6() throws UnsupportedEncodingException, WCException{
		URL resource = getClass().getClassLoader().getResource("lipsum.txt");
		assertNotNull(resource);
		File file = new File(URLDecoder.decode( resource.getFile(), "UTF-8"));
		WCContext context = new WCContext("6", null, file.getAbsolutePath());
		assertEquals(3.86, core.calculateAverageSentenceLength(context), 0.001);
	}	

	/**
	 * Test average sentence length calculation for a sample lipsum (dummy text usually used for printing/typesetting) 
	 * to simulate natural text using the default length and ,. as the delimiters.
	 * @throws UnsupportedEncodingException
	 * @throws WCException
	 */
	@Test
	public void testCalculateAverageSentenceLength_sampleLipsumDefaultLengthDelimiterCommaAndPeriod() throws UnsupportedEncodingException, WCException{
		URL resource = getClass().getClassLoader().getResource("lipsum.txt");
		assertNotNull(resource);
		File file = new File(URLDecoder.decode( resource.getFile(), "UTF-8"));
		WCContext context = new WCContext(null, ",.", file.getAbsolutePath());
		assertEquals(3.38, core.calculateAverageSentenceLength(context), 0.001);
	}	

	/**
	 * Test average sentence length calculation for a sample lipsum (dummy text usually used for printing/typesetting) 
	 * to simulate natural text using the length 6 and ,. as the delimiters.
	 * @throws UnsupportedEncodingException
	 * @throws WCException
	 */
	@Test
	public void testCalculateAverageSentenceLength_sampleLipsumLength6DelimiterCommaAndPeriod() throws UnsupportedEncodingException, WCException{
		URL resource = getClass().getClassLoader().getResource("lipsum.txt");
		assertNotNull(resource);
		File file = new File(URLDecoder.decode( resource.getFile(), "UTF-8"));
		WCContext context = new WCContext("6", ",.", file.getAbsolutePath());
		assertEquals(2.45, core.calculateAverageSentenceLength(context), 0.001);
	}		

	/**
	 * Test average sentence length calculation for an empty file.
	 * @throws UnsupportedEncodingException
	 * @throws WCException
	 */
	@Test
	public void testCalculateAverageSentenceLength_emptyFile() throws UnsupportedEncodingException, WCException{
		URL resource = getClass().getClassLoader().getResource("emptyFile.txt");
		assertNotNull(resource);
		File file = new File(URLDecoder.decode( resource.getFile(), "UTF-8"));
		WCContext context = new WCContext(null, null, file.getAbsolutePath());
		assertEquals(0.0, core.calculateAverageSentenceLength(context), 0.001);
	}

	/**
	 * Test average sentence length calculation for a file containing only a single word using default
	 * arguments.
	 * @throws UnsupportedEncodingException
	 * @throws WCException
	 */
	@Test
	public void testCalculateAverageSentenceLength_singleWordDefaultArguments() throws UnsupportedEncodingException, WCException{
		URL resource = getClass().getClassLoader().getResource("singleWord.txt");
		assertNotNull(resource);
		File file = new File(URLDecoder.decode( resource.getFile(), "UTF-8"));
		WCContext context = new WCContext(null, null, file.getAbsolutePath());
		assertEquals(1.0, core.calculateAverageSentenceLength(context), 0.001);
	}

	/**
	 * Test average sentence length calculation for a file containing only a single word that ends
	 * with a trailing space character using default arguments.
	 * @throws UnsupportedEncodingException
	 * @throws WCException
	 */
	@Test
	public void testCalculateAverageSentenceLength_singleWordTrailingSpaceDefaultArguments() throws UnsupportedEncodingException, WCException{
		URL resource = getClass().getClassLoader().getResource("singleWordTrailingSpace.txt");
		assertNotNull(resource);
		File file = new File(URLDecoder.decode( resource.getFile(), "UTF-8"));
		WCContext context = new WCContext(null, null, file.getAbsolutePath());
		assertEquals(1.0, core.calculateAverageSentenceLength(context), 0.001);
	}

	/**
	 * Test that a file with all sentences that contain no words greater than or equals
	 * to the word limit returns a zero average.
	 * @throws WCException
	 * @throws UnsupportedEncodingException
	 */
	@Test
	public void testZeroWordSen2() throws WCException, UnsupportedEncodingException{
		URL resource = getClass().getClassLoader().getResource("singleCharacters.txt");
		assertNotNull(resource);
		File file = new File(URLDecoder.decode( resource.getFile(), "UTF-8"));
		WCContext newFile = new WCContext("4", ".?!", file.getAbsolutePath());
		assertEquals(0,core.calculateAverageSentenceLength(newFile), 0);
	}

	/**
	 * Test delimiter value less then default.
	 * @throws WCException
	 * @throws UnsupportedEncodingException
	 */
	@Test
	public void testZeroWordSen3() throws WCException, UnsupportedEncodingException{
		URL resource = getClass().getClassLoader().getResource("Test3.txt");
		assertNotNull(resource);
		File file = new File(URLDecoder.decode( resource.getFile(), "UTF-8"));
		WCContext newFile = new WCContext("3", ".?!", file.getAbsolutePath());
		assertEquals(2.5,core.calculateAverageSentenceLength(newFile), 0.01);		
	}

	/**
	 * Test delimiter value bigger then default.
	 * @throws WCException
	 * @throws UnsupportedEncodingException
	 */
	@Test
	public void testZeroWordSen4()throws WCException, UnsupportedEncodingException{
		URL resource = getClass().getClassLoader().getResource("Test4.txt");
		assertNotNull(resource);
		File file = new File(URLDecoder.decode( resource.getFile(), "UTF-8"));
		WCContext newFile = new WCContext("5", ".?!", file.getAbsolutePath());
		assertEquals(1.33,core.calculateAverageSentenceLength(newFile), 0.01);	
	}

	/**
	 * Test one or multiple delimiter and the double decimal.
	 * @throws WCException
	 * @throws UnsupportedEncodingException
	 */
	@Test
	public void testDelimiter1() throws WCException, UnsupportedEncodingException{
		URL resource = getClass().getClassLoader().getResource("Test5.txt");
		assertNotNull(resource);
		File file = new File(URLDecoder.decode( resource.getFile(), "UTF-8"));
		WCContext newFile = new WCContext("4", "!", file.getAbsolutePath());
		assertEquals(1.67,core.calculateAverageSentenceLength(newFile), 0.01);	
	}

	/**
	 * Test irregular delimiter, only "a" and white space are word delimiter.
	 * @throws WCException
	 * @throws UnsupportedEncodingException
	 */
	@Test
	public void testDelimiter2() throws WCException, UnsupportedEncodingException{
		URL resource = getClass().getClassLoader().getResource("Test6.txt");
		assertNotNull(resource);
		File file = new File(URLDecoder.decode( resource.getFile(), "UTF-8"));
		WCContext newFile = new WCContext("4", "a", file.getAbsolutePath());
		assertEquals(2.00,core.calculateAverageSentenceLength(newFile), 0.01);	
	}

	/**
	 * Regular test for double decimal.
	 * @throws WCException
	 * @throws UnsupportedEncodingException
	 */
	@Test
	public void testDelimiter3() throws WCException, UnsupportedEncodingException{
		URL resource = getClass().getClassLoader().getResource("Test7.txt");
		assertNotNull(resource);
		File file = new File(URLDecoder.decode( resource.getFile(), "UTF-8"));
		WCContext newFile = new WCContext("4", ".", file.getAbsolutePath());
		assertEquals(2.00,core.calculateAverageSentenceLength(newFile), 0.01);	
	}

	/**
	 * Test change line calculation.
	 * @throws WCException
	 * @throws UnsupportedEncodingException
	 */
	@Test
	public void testDelimiter4() throws WCException, UnsupportedEncodingException{
		URL resource = getClass().getClassLoader().getResource("Test8.txt");
		assertNotNull(resource);
		File file = new File(URLDecoder.decode( resource.getFile(), "UTF-8"));
		WCContext newFile = new WCContext("4", ".?!", file.getAbsolutePath());
		assertEquals(1.20,core.calculateAverageSentenceLength(newFile), 0.01);	
	}


	/**
	 * Test no delimiter.
	 * @throws WCException
	 * @throws UnsupportedEncodingException
	 */
	@Test
	public void testOneSen() throws WCException, UnsupportedEncodingException{
		URL resource = getClass().getClassLoader().getResource("Test9.txt");
		assertNotNull(resource);
		File file = new File(URLDecoder.decode( resource.getFile(), "UTF-8"));
		WCContext newFile = new WCContext("4", ".?!", file.getAbsolutePath());
		assertEquals(4.00,core.calculateAverageSentenceLength(newFile), 0.01);	
	}

	/**
	 * Test no delimiter at the end.
	 * @throws WCException
	 * @throws UnsupportedEncodingException
	 */
	@Test
	public void testMissingDelimiter() throws WCException, UnsupportedEncodingException{
		URL resource = getClass().getClassLoader().getResource("Test10.txt");
		assertNotNull(resource);
		File file = new File(URLDecoder.decode( resource.getFile(), "UTF-8"));
		WCContext newFile = new WCContext("4", ".?!", file.getAbsolutePath());
		assertEquals(1.00,core.calculateAverageSentenceLength(newFile), 0.01);	
	}

	/**
	 * Test no word length bigger than set value.
	 * @throws WCException
	 * @throws UnsupportedEncodingException
	 */
	@Test
	public void testZeroAverage() throws WCException, UnsupportedEncodingException{
		URL resource = getClass().getClassLoader().getResource("Test11.txt");
		assertNotNull(resource);
		File file = new File(URLDecoder.decode( resource.getFile(), "UTF-8"));
		WCContext newFile = new WCContext("4", ".?!", file.getAbsolutePath());
		assertEquals(0.00,core.calculateAverageSentenceLength(newFile), 0.01);	
	}

	/**
	 * Test calculation speed is greater than or equal to 5000 characters per second
	 * (times the calculation of the average sentence length on a lipsum file that
	 * contains 10000 characters.)
	 * @throws WCException
	 * @throws UnsupportedEncodingException
	 */
	@Test
	public void testSpeed4() throws WCException, UnsupportedEncodingException{
		URL resource = getClass().getClassLoader().getResource("lipsum2.txt");
		assertNotNull(resource);
		File file = new File(URLDecoder.decode( resource.getFile(), "UTF-8"));
		WCContext newFile = new WCContext("4", ".?!", file.getAbsolutePath());
		long start = System.nanoTime();
		core.calculateAverageSentenceLength(newFile);
		long end = System.nanoTime();
		assertEquals(end-start<2000000000.0,true);	
	}

}