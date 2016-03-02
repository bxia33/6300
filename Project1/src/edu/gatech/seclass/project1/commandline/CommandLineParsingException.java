package edu.gatech.seclass.project1.commandline;

import edu.gatech.seclass.project1.WCException;

/**
 * An exception thrown in response to command line parsing problems.
 */
public class CommandLineParsingException extends WCException{

	/**
	 * The generated serial version id.
	 */
	private static final long serialVersionUID = 484839089332680422L;

	/**
	 * 
	 */
	public CommandLineParsingException(){;}

	/**
	 * @param message
	 */
	public CommandLineParsingException(String message){
		super(message);
	}

	/**
	 * @param cause
	 */
	public CommandLineParsingException(Throwable cause){
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public CommandLineParsingException(String message, Throwable cause){
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public CommandLineParsingException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}