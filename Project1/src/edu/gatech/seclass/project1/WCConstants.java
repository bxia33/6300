package edu.gatech.seclass.project1;

import java.util.Arrays;
import java.util.List;

/**
 * A collection of constants for the WC application.
 */
public abstract class WCConstants{

	/**
	 * The command line option for specifying the list of sentence delimiters.
	 */
	public static final String DELIMITER_OPTION = "d";
	
	/**
	 * The default sentence delimiters.
	 */
	public static final List<Character> DEFAULT_DELIMITERS = Arrays.asList('.', '!', '?', ';', ':');
	
	/**
	 * The error message for specifying the delimiter flag without specifying a list of sentence delimiters.
	 */
	public static final String DELIMITER_REQUIRED_ARGUMENT_ERROR_MESSAGE = "The -" + DELIMITER_OPTION + " command line option requires a list of delimiter character.s";
	
	/**
	 * The command line option for specifying the length of a word. 
	 */
	public static final String LENGTH_OPTION = "l";
	
	/**
	 * The default value for the length of a word.
	 */
	public static final int DEFAULT_LENGTH = 4;
	
	/**
	 * The error message for specifying the length flag without specifying a value for the word length.
	 */
	public static final String LENGTH_REQUIRED_ARGUMENT_ERROR_MESSAGE = "The -" + LENGTH_OPTION + " command line options requires a length of characters to be considered as words.";
	
	/**
	 * The template to use for creating an error message for an option with a required argument that does not have an argument specified.
	 */
	public static final String DEFAULT_MISSING_ARGUMENT_ERROR_TEMPLATE = "The command line option '%s' requires an argument.";
	
	/**
	 * The error message displayed by the command line parser if an invalid option string is specified for addOption.
	 */
	public static final String INVALID_OPTION_CHARACTER_ERROR_MESSAGE = "A command line option must be specified.  Null and the empty string are not valid option strings.";
	
	/**
	 * The error message displayed if the required file path argument is not specified.
	 */
	public static final String MISSING_FILE_PATH_ERROR_MESSAGE = "The path to the file to calculate average sentence length for must be specified.";
	
	/**
	 * The error message displayed for unrecognized command line arguments.
	 */
	public static final String UNRECOGNIZED_COMMAND_LINE_ARGUMENTS_ERROR_MESSAGE_TEMPLATE = "Unrecognized command line arguments '%s'.  Only the -" 
			+ DELIMITER_OPTION + ", -" + LENGTH_OPTION + ", and file path are allowed.";
	
	/**
	 * The template to use for creating the error message for an invalid word length argument.
	 */
	public static final String INVALID_WORD_LENGTH_ERROR_MESSAGE_TEMPLATE = "The value specified for word length '%s' is invalid.  It must be a positive whole number.";
	
	/**
	 * The error message displayed to indicate an empty list of delimiters is not allowed.
	 */
	public static final String DELIMITER_REQUIRED_ERROR_MESSAGE = "Invalid delimiters. An empty set of delimiters is not allowed.";
	
	/**
	 * The template to use in constructing the error message for a file path pointing to a directory.
	 */
	public static final String INVALID_FILE_PATH_DIRECTORY_ERROR_MESSAGE_TEMPLATE = "The file path '%s' is invalid.  It points to a directory.";
	
	/**
	 * The template to use in constructing the error message for a file path pointing to a file that does not exist.
	 */
	public static final String INVALID_FILE_PATH_DOES_NOT_EXIST_ERROR_MESSAGE_TEMPLATE = "The file path '%s' is invalid.  It does not exist.";
	
	/**
	 * The error message displayed to indicate the following lines after an unexpected error are the stack trace for what occurred.
	 */
	public static final String UNEXPECTED_ERROR_ERROR_MESSAGE = "Please contact support providing the following information:";
	
	/**
	 * The default prefix to add to all error messages.
	 */
	public static final String ERROR_MESSAGE_PREFIX = "ERROR: ";
	
	/**
	 * The default decimal format string to format the final average value.
	 */
	public static final String DECIMAL_FORMAT = "0.00";
	
	/**
	 * The template to use in constructing the IO error message.
	 */
	public static final String IO_ERROR_ERROR_MESSAGE_TEMPLATE = "An error occured reading the file '%s'.";
	
	/**
	 * The template to use in constructing the error message indicating an error occurred closing the input file.
	 */
	public static final String CLOSE_FILE_ERROR_MESSAGE_TEMPLATE = "An error occurred closing the file '%s'.";
	
}