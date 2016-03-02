package edu.gatech.seclass.project1.commandline;

import edu.gatech.seclass.project1.WCException;

/**
 * An exception thrown in response to invalid options.
 */
public class InvalidOptionException extends WCException{

	/**
	 * The generated serial version id.
	 */
	private static final long serialVersionUID = 430521001102210440L;

	/**
	 * 
	 */
	public InvalidOptionException(){;}

	/**
	 * @param message
	 */
	public InvalidOptionException(String message){
		super(message);
	}

	/**
	 * @param cause
	 */
	public InvalidOptionException(Throwable cause){
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public InvalidOptionException(String message, Throwable cause){
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public InvalidOptionException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace){
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
