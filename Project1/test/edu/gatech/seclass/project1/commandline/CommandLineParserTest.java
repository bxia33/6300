package edu.gatech.seclass.project1.commandline;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class CommandLineParserTest{

	/**
	 * The parser instance to use in testing.
	 */
	private CommandLineParser parser;
	
	/**
	 * Setup the parser to use in testing.
	 */
	@Before
	public void setup(){
		parser = new CommandLineParser();
	}

	/**
	 * Validate that attempting to add an option (to the overloaded addOption(String,boolean) method) with a null
	 * option string raises an invalid option exception.
	 * @throws InvalidOptionException
	 */
	@Test(expected=InvalidOptionException.class)
	public void testAddOption_StringBoolean_nullOption() throws InvalidOptionException{
		parser.addOption(null, true);
	}
	
	/**
	 * Validate that attempting to add an option (to the overloaded addOption(String,boolean) method) with an empty
	 * option string raises an invalid option exception.
	 * @throws InvalidOptionException
	 */
	@Test(expected=InvalidOptionException.class)
	public void testAddOption_StringBoolean_emptyOption() throws InvalidOptionException{
		parser.addOption("", true);
	}	
	
	/**
	 * Validate adding an optional option (to the overloaded addOption(String,boolean) method) adds
	 * a single option of the appropriate type.
	 * @throws InvalidOptionException
	 */
	@Test
	public void testAddOption_StringBoolean_Optional() throws InvalidOptionException{
		parser.addOption("a", false);
		assertEquals(1, parser.getOptions().size());
		assertEquals("a", parser.getOptions().iterator().next().getOption());
		assertFalse(parser.getOptions().iterator().next().isArgumentRequired());
	}
	
	/**
	 * Validate adding a required option (to the overloaded addOption(String,boolean) method) adds
	 * a single option of the appropriate type.
	 * @throws InvalidOptionException
	 */
	@Test
	public void testAddOption_StringBoolean_Required() throws InvalidOptionException{
		parser.addOption("a", true);
		assertEquals(1, parser.getOptions().size());
		assertEquals("a", parser.getOptions().iterator().next().getOption());
		assertTrue(parser.getOptions().iterator().next().isArgumentRequired());
	}
	
	/**
	 * Validate that attempting to add an option (to the overloaded addOption(String,String) method) with a null
	 * option string raises an invalid option exception.
	 * @throws InvalidOptionException
	 */
	@Test(expected=InvalidOptionException.class)
	public void testAddOption_StringString_nullOption() throws InvalidOptionException{
		parser.addOption(null, "foo");
	}
	
	/**
	 * Validate that attempting to add an option (to the overloaded addOption(String,String) method) with an empty
	 * option string raises an invalid option exception.
	 * @throws InvalidOptionException
	 */
	@Test(expected=InvalidOptionException.class)
	public void testAddOption_StringString_emptyOption() throws InvalidOptionException{
		parser.addOption("", "foo");
	}	
	
	/**
	 * Validate adding an optional option (to the overloaded addOption(String,String) method) adds
	 * a single option of the appropriate type.
	 * @throws InvalidOptionException
	 */
	@Test
	public void testAddOption_StringString() throws InvalidOptionException{
		parser.addOption("a", "foo");
		assertEquals(1, parser.getOptions().size());
		assertEquals("a", parser.getOptions().iterator().next().getOption());
		assertTrue(parser.getOptions().iterator().next().isArgumentRequired());
		assertEquals("foo", parser.getOptions().iterator().next().getMissingArgumentError());
	}
	
	/**
	 * Validate that parsing the command line with a configured required option generates an exception
	 * when called with the configured option but no argument.
	 * @throws InvalidOptionException
	 * @throws CommandLineParsingException
	 */
	@Test(expected=CommandLineParsingException.class)
	public void testParseCommandLine_missingRequiredArgument() throws InvalidOptionException, CommandLineParsingException{
		parser.addOption("a", true);
		parser.parseCommandLine(new String[]{ "-a" });
	}
	
	/**
	 * Validate that parsing a null command line generates no options.
	 * @throws InvalidOptionException
	 * @throws CommandLineParsingException
	 */
	@Test
	public void testParseCommandLine_nullArguments() throws InvalidOptionException, CommandLineParsingException{
		parser.parseCommandLine(null);
		assertTrue(parser.getOptions().isEmpty());
		assertTrue(parser.getUnmatchedArguments().isEmpty());
	}	
	
	/**
	 * Validate that parsing an argument list with one configured optional option containing that option
	 * generates the correct parsed parameter.
	 * @throws InvalidOptionException
	 * @throws CommandLineParsingException
	 */
	@Test
	public void testParseCommandLine_opptionalOptionFound() throws InvalidOptionException, CommandLineParsingException{
		parser.addOption("a", false);
		parser.parseCommandLine(new String[]{ "-a" });
		assertEquals(1, parser.getOptions().size());
		assertTrue(parser.hasOption("a"));
		assertNull(parser.getArgument("a"));
		assertTrue(parser.getUnmatchedArguments().isEmpty());
	}	
	
	/**
	 * Validate that parsing an argument list with one configured optional option not containing that option
	 * generates the correct unmatched options.
	 * @throws InvalidOptionException
	 * @throws CommandLineParsingException
	 */
	@Test
	public void testParseCommandLine_opptionalOptionNotFound() throws InvalidOptionException, CommandLineParsingException{
		parser.addOption("a", false);
		parser.parseCommandLine(new String[]{ "-b" });
		assertEquals(1, parser.getOptions().size());
		assertFalse(parser.hasOption("a"));
		assertNull(parser.getArgument("a"));
		assertEquals(1, parser.getUnmatchedArguments().size());
		assertEquals("-b", parser.getUnmatchedArguments().get(0));
	}		
	
	/**
	 * Validate that parsing an argument list with one configured required option containing that option
	 * generates the correct parsed parameter.
	 * @throws InvalidOptionException
	 * @throws CommandLineParsingException
	 */
	@Test
	public void testParseCommandLine_requiredOptionFound() throws InvalidOptionException, CommandLineParsingException{
		parser.addOption("a", true);
		parser.parseCommandLine(new String[]{ "-a", "foo" });
		assertEquals(1, parser.getOptions().size());
		assertTrue(parser.hasOption("a"));
		assertEquals("foo", parser.getArgument("a"));
		assertTrue(parser.getUnmatchedArguments().isEmpty());
	}	
	
	/**
	 * Validate that parsing an argument list with one configured required option not containing that option
	 * generates the correct unmatched options.
	 * @throws InvalidOptionException
	 * @throws CommandLineParsingException
	 */
	@Test
	public void testParseCommandLine_requiredOptionNotFound() throws InvalidOptionException, CommandLineParsingException{
		parser.addOption("a", true);
		parser.parseCommandLine(new String[]{ "-b", "foo"});
		assertEquals(1, parser.getOptions().size());
		assertFalse(parser.hasOption("a"));
		assertNull(parser.getArgument("a"));
		assertEquals(2, parser.getUnmatchedArguments().size());
		assertEquals("-b", parser.getUnmatchedArguments().get(0));
		assertEquals("foo", parser.getUnmatchedArguments().get(1));
	}
	
	/**
	 * Test a sample call matching a WC application call with all options and the file
	 * path last parses correctly.
	 * @throws InvalidOptionException 
	 * @throws CommandLineParsingException 
	 */
	@Test
	public void testParseCommandLine_WCAllOptionsFilePathLast() throws InvalidOptionException, CommandLineParsingException{
		parser.addOption("d", true);
		parser.addOption("l", true);
		parser.parseCommandLine(new String[]{ "-l", "5", "-d", ".!?", "~/essay.txt"});
		assertEquals(2, parser.getOptions().size());
		assertTrue(parser.hasOption("l"));
		assertEquals("5", parser.getArgument("l"));
		assertTrue(parser.hasOption("d"));
		assertEquals(".!?", parser.getArgument("d"));		
		assertEquals(1, parser.getUnmatchedArguments().size());
		assertEquals("~/essay.txt", parser.getUnmatchedArguments().get(0));
	}
	
	/**
	 * Test a sample call matching a WC application call with all options and the file
	 * path first parses correctly.
	 * @throws InvalidOptionException 
	 * @throws CommandLineParsingException 
	 */
	@Test
	public void testParseCommandLine_WCAllOptionsFilePathFirst() throws InvalidOptionException, CommandLineParsingException{
		parser.addOption("d", true);
		parser.addOption("l", true);
		parser.parseCommandLine(new String[]{ "~/essay.txt", "-l", "5", "-d", ".!?"});
		assertEquals(2, parser.getOptions().size());
		assertTrue(parser.hasOption("l"));
		assertEquals("5", parser.getArgument("l"));
		assertTrue(parser.hasOption("d"));
		assertEquals(".!?", parser.getArgument("d"));		
		assertEquals(1, parser.getUnmatchedArguments().size());
		assertEquals("~/essay.txt", parser.getUnmatchedArguments().get(0));
	}	
	
}