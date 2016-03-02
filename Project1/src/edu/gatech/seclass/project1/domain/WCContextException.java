package edu.gatech.seclass.project1.domain;

import edu.gatech.seclass.project1.WCException;

/**
 * An exception thrown in response to invalid context values.
 */
public class WCContextException extends WCException{

	/**
	 * The generated serial version id.
	 */
	private static final long serialVersionUID = 2788225813950718714L;

	/**
	 * 
	 */
	public WCContextException(){;}

	/**
	 * @param message
	 */
	public WCContextException(String message){
		super(message);
	}

	/**
	 * @param cause
	 */
	public WCContextException(Throwable cause){
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public WCContextException(String message, Throwable cause){
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public WCContextException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace){
		super(message, cause, enableSuppression, writableStackTrace);
	}

}