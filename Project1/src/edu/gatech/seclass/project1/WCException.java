package edu.gatech.seclass.project1;

/**
 * An exception thrown in response to WC errors.
 */
public class WCException extends Exception{

	/**
	 * The generated serial version id.
	 */
	private static final long serialVersionUID = -2161650513468839378L;

	/**
	 * 
	 */
	public WCException(){;}

	/**
	 * @param message
	 */
	public WCException(String message){
		super(message);
	}

	/**
	 * @param cause
	 */
	public WCException(Throwable cause){
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public WCException(String message, Throwable cause){
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public WCException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}