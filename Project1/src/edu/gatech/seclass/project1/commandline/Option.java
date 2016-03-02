package edu.gatech.seclass.project1.commandline;

import edu.gatech.seclass.project1.WCConstants;

/**
 * A simple POJO that represents a command line option. An option may
 * represent a simple flag or the marker for a required argument 
 * (determined by whether the hasArgument flag is true.) The configured
 * option value should be the raw value of the flag, it should NOT
 * include the leading dash.  Only short command line options are 
 * supported (an option starting with a dash e.g. -d, -l, etc.) An
 * option is used to both describe an option and capture the data
 * for an option depending on context. 
 */
public class Option{

	/**
	 * The string to be used to locate a flag or value argument.
	 */
	private String option;
	
	/**
	 * Whether the option requires an argument or not.
	 */
	private boolean argumentRequired;
	
	/**
	 * The value of the argument.
	 */
	private String argument;
	
	/**
	 * The error message to report if a required argument is not present.
	 */
	private String missingArgumentError;
	
	/**
	 * Create an option given the value of the option (flag) and whether
	 * the option requires an argument or not.
	 * 
	 * @param option the value of the option.
	 * @param argumentRequired whether the option requires an argument.
	 */
	public Option(String option, boolean argumentRequired){
		this.option = option;
		this.argumentRequired = argumentRequired;
		if(argumentRequired){
			this.missingArgumentError = String.format(WCConstants.DEFAULT_MISSING_ARGUMENT_ERROR_TEMPLATE, option);
		}
	}
	
	/**
	 * Create an option given the value of the option (flag) and the
	 * error to display if a required argument is not found
	 * 
	 * @param option the value of the option.
	 * @param missingArgumentError the error to display if a required argument is missing.
	 */
	public Option(String option, String missingArgumentError){
		this.option = option;
		this.argumentRequired = true;
		this.missingArgumentError = missingArgumentError;
	}	
	
	/**
	 * Get the value of the parsed argument for the option.
	 * 
	 * @return the value of the argument or null.
	 */
	public String getArgument(){
		return argument;
	}
	
	/**
	 * Set the value of the parsed argument for the option. Intentionally
	 * package private as only types in this package (namely the command
	 * line parser) should ever set an option value.)
	 * 
	 * @param argument the value of the option argument.
	 */
	void setArgument(String argument){
		this.argument = argument;
	}
	
	/**
	 * Get the value of the option (flag.)
	 * 
	 * @return the option value.
	 */
	public String getOption(){
		return option;
	}
	
	/**
	 * Get whether the option requires an argument or not.
	 * 
	 * @return whether the option requires an argument or not.
	 */
	public boolean isArgumentRequired(){
		return argumentRequired;
	}

	/**
	 * Get the error to display if a required error message is missing.
	 * 
	 * @return the missing required argument error message.
	 */
	public String getMissingArgumentError(){
		return missingArgumentError;
	}
	
}