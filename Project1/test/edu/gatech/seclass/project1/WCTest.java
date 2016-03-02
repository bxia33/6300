package edu.gatech.seclass.project1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import edu.gatech.seclass.project1.WC;

/**
 * WC integration tests.
 */
public class WCTest{

	/**
	 * The captured out stream for testing.
	 */
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	/**
	 * The captured err stream for testing.
	 */
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	/**
	 * Setup the captured streams for testing.
	 */
	@Before
	public void setUpStreams(){
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}

	/**
	 * Clean up test streams.
	 */
	@After
	public void cleanUpStreams(){
		System.setOut(null);
		System.setErr(null);
	}

	/**
	 * Test WC.java main to see whether printout is expected.
	 * @throws UnsupportedEncodingException 
	 */
	@Test	
	public void testWCmain1() throws UnsupportedEncodingException{
		URL resource = getClass().getClassLoader().getResource("emptyFile.txt");
		assertNotNull(resource);
		File file = new File(URLDecoder.decode( resource.getFile(), "UTF-8"));
		String[] argument = { file.getAbsolutePath(),"-d", ".?!","-l","4"};
		WC.main(argument);
		String s = outContent.toString();
		double expected = 0.0;
		assertEquals(expected,Double.parseDouble(s),0.0);	
	}

	/**
	 * Test WC.java main to see whether printout is expected with 2 decimal.
	 * @throws UnsupportedEncodingException 
	 */
	@Test
	public void testWCmain2() throws UnsupportedEncodingException{
		URL resource = getClass().getClassLoader().getResource("Test4.txt");
		assertNotNull(resource);
		File file = new File(URLDecoder.decode( resource.getFile(), "UTF-8"));
		String[] argument = {file.getAbsolutePath(),"-d", ".?!","-l","4"};
		WC.main(argument);
		String s = outContent.toString();
		double expected = 1.33;
		assertEquals(expected,Double.parseDouble(s),0.0);	
	}

	/**
	 * Test WC.java main to see whether printout is expected with half round up.
	 * @throws UnsupportedEncodingException 
	 */
	@Test
	public void testWCmain3() throws UnsupportedEncodingException{
		URL resource = getClass().getClassLoader().getResource("Test5.txt");
		assertNotNull(resource);
		File file = new File(URLDecoder.decode( resource.getFile(), "UTF-8"));
		String[] argument = {file.getAbsolutePath(),"-d", "!","-l","4"};
		WC.main(argument);
		String s = outContent.toString();
		double expected = 1.67;
		assertEquals(expected,Double.parseDouble(s),0.0);		
	}

	/**
	 * Test WC.java main to see whether printout is expected with 1 decimal.
	 * @throws UnsupportedEncodingException 
	 */
	@Test
	public void testWCmain4() throws UnsupportedEncodingException{
		URL resource = getClass().getClassLoader().getResource("Test6.txt");
		assertNotNull(resource);
		File file = new File(URLDecoder.decode( resource.getFile(), "UTF-8"));
		String[] argument = {file.getAbsolutePath(),"-d", "?","-l","4"};
		WC.main(argument);
		String s = outContent.toString();
		double expected = 3.0;
		assertEquals(expected,Double.parseDouble(s),0.0);	
	}

	/**
	 * Test default parameters.
	 * @throws UnsupportedEncodingException 
	 */
	@Test
	public void testWCmain5() throws UnsupportedEncodingException{
		URL resource = getClass().getClassLoader().getResource("Test7.txt");
		assertNotNull(resource);
		File file = new File(URLDecoder.decode( resource.getFile(), "UTF-8"));
		String[] argument = {file.getAbsolutePath()};
		WC.main(argument);
		String s = outContent.toString();
		double expected = 1.20;
		assertEquals(expected,Double.parseDouble(s),0.0);	
	}

}