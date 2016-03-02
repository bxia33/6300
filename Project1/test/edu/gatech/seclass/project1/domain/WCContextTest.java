package edu.gatech.seclass.project1.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class WCContextTest{

	/**
	 * Validate that creating a context with a null file raises an exception.
	 * @throws WCContextException
	 */
	@Test(expected=WCContextException.class)
	public void testWCContextInit_NullFile() throws WCContextException{
		new WCContext("7", ".!?", null);
	}

	/**
	 * Validate that creating a context with a word length that is not a number raises an exception.
	 * @throws WCContextException
	 */
	@Test(expected=WCContextException.class)
	public void testWCContextInit_InvalidWordLengthAlpha() throws WCContextException{
		new WCContext("a", ".!?", "~/essay.txt");
	}
	
	/**
	 * Validate that creating a context with a word length of zero raises an exception.
	 * @throws WCContextException
	 */
	@Test(expected=WCContextException.class)
	public void testWCContextInit_invalidWordLengthZero() throws WCContextException{
		new WCContext("0", ".!?", "~/essay.txt");
	}

	/**
	 * Validate that creating a context with a negative word length raises an exception.
	 * @throws WCContextException
	 */
	@Test(expected=WCContextException.class)
	public void testWCContextInit_invalidWordLengthNegative() throws WCContextException{
		new WCContext("-1", ".!?", "~/essay.txt");
	}
	
	/**
	 * Validate that creating a context with an empty delimiter list raises an exception.
	 * @throws WCContextException
	 */
	@Test(expected=WCContextException.class)
	public void testWCContextInit_invalidDelimitersEmpty() throws WCContextException{
		new WCContext("1", "", "~/essay.txt");
	}
	
	/**
	 * Validate that creating a context with a non-existent file raises an exception.
	 * @throws WCContextException
	 */
	@Test(expected=WCContextException.class)
	public void testWCContextInit_invalidFileDoesNotExist() throws WCContextException{
		
		//Create a file path that is guaranteed to not exist.Øß
		File current = new File(System.getProperty("user.dir"));
		int i = 1;
		while((new File(current, "WCContextTest" + i)).exists()){
			i++;
		}
		
		new WCContext(null, null, (new File(current, "WCContextTest" + i)).getAbsolutePath());
	}	
	
	/**
	 * Validate that creating a context with a directory raises an exception
	 * @throws WCContextException
	 */
	@Test(expected=WCContextException.class)
	public void testWCContextInit_invalidFileDirectory() throws WCContextException{
		new WCContext(null, null, System.getProperty("user.dir"));
	}

	/**
	 * Validate creating a context with a valid file.
	 * @throws IOException
	 * @throws WCContextException
	 */
	@Test
	public void testWCContextInit_validFile() throws IOException, WCContextException{
		File tempFile = File.createTempFile("WCContextTest", null);
		tempFile.deleteOnExit();
		WCContext context = new WCContext(null, null, tempFile.getAbsolutePath());
		assertEquals(tempFile, context.getFile());
	}
	
	/**
	 * Validate creating a context with the default word length.
	 * @throws IOException
	 * @throws WCContextException
	 */
	@Test
	public void testWCContextInit_defaultWordLength() throws IOException, WCContextException{
		File tempFile = File.createTempFile("WCContextTest", null);
		tempFile.deleteOnExit();
		WCContext context = new WCContext(null, null, tempFile.getAbsolutePath());
		assertEquals(4, context.getWordLength());
	}
	
	/**
	 * Validate creating a context with an explicit word length.
	 * @throws IOException
	 * @throws WCContextException
	 */
	@Test
	public void testWCContextInit_explicitWordLength() throws IOException, WCContextException{
		File tempFile = File.createTempFile("WCContextTest", null);
		tempFile.deleteOnExit();
		WCContext context = new WCContext("7", null, tempFile.getAbsolutePath());
		assertEquals(7, context.getWordLength());
	}

	/**
	 * Validate creating a context with the default delimiters.
	 * @throws IOException
	 * @throws WCContextException
	 */
	@Test
	public void testWCContextInit_defaultDelimiters() throws IOException, WCContextException{
		File tempFile = File.createTempFile("WCContextTest", null);
		tempFile.deleteOnExit();
		WCContext context = new WCContext(null, null, tempFile.getAbsolutePath());
		assertEquals(5, context.getDelimiters().size());
		assertTrue(context.getDelimiters().contains('.'));
		assertTrue(context.getDelimiters().contains('!'));
		assertTrue(context.getDelimiters().contains('?'));
		assertTrue(context.getDelimiters().contains(':'));
		assertTrue(context.getDelimiters().contains(';'));
	}
	
	/**
	 * Validate creating a context with an explicit delimiter list.
	 * @throws IOException
	 * @throws WCContextException
	 */
	@Test
	public void testWCContextInit_explicitDelmiters() throws IOException, WCContextException{
		File tempFile = File.createTempFile("WCContextTest", null);
		tempFile.deleteOnExit();
		WCContext context = new WCContext(null, ".!?a", tempFile.getAbsolutePath());
		assertEquals(4, context.getDelimiters().size());
		assertTrue(context.getDelimiters().contains('.'));
		assertTrue(context.getDelimiters().contains('!'));
		assertTrue(context.getDelimiters().contains('?'));
		assertTrue(context.getDelimiters().contains('a'));
	}
	
}