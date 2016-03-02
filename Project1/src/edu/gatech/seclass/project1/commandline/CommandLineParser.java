package edu.gatech.seclass.project1.commandline;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.gatech.seclass.project1.WCConstants;

/**
 * A simple implementation of a command line parser.  This implementation was inspired by the Apache CLI 
 * API (https://commons.apache.org/proper/commons-cli)  However, no code from that library was directly or 
 * indirectly used.  Command line parsing occurs in two phases.  First, a command line parser is created
 * and configured with the options that should be recognized via the addOption method.  Once all of the
 * required options are configured, the options are parsed by passing the command line arguments to the
 * parseCommandLine method.  Once parsing has completed, the hasOptions, getArgument, and 
 * getUnmatchedArguments can be called in order to retrieve the information parsed from the arguments. 
 */
public class CommandLineParser{
	
	/**
	 * The map of option values to the option types to be supported.
	 */
	private Map<String,Option> options = new HashMap<String,Option>();
	
	/**
	 * The map of option values to the parsed option instances.
	 */
	private Map<String,Option> parsedOptions = new HashMap<String,Option>();
	
	/**
	 * The list of unrecognized arguments (unrecognized options or non-option arguments.)
	 */
	private List<String> unmatchedArguments = new ArrayList<String>();
	
	/**
	 * Parse the given arguments.  This should only be called AFTER the desired
	 * options have been set.  If not, no error is reported, but all arguments will
	 * be treated as unmatched arguments.
	 * 
	 * @param arguments the raw command line options.
	 * @throws CommandLineParsingException thrown if an option requiring an argument is missing the required argument.
	 */
	public void parseCommandLine(String[] arguments) throws CommandLineParsingException{
		
		if(arguments == null){
			return;
		}
		
		for(int i = 0; i < arguments.length; i++){
			
			String current = arguments[i].trim();
			
			if(current.startsWith("-")){
				Option option = options.get(current.substring(1, current.length()));
				if(option != null){
					if(option.isArgumentRequired()){
						if((i+1) >= arguments.length){
							throw new CommandLineParsingException(option.getMissingArgumentError());
						}
						option.setArgument(arguments[i+1]);
						parsedOptions.put(option.getOption(), option);
						i++;
					}
					else{
						parsedOptions.put(option.getOption(), option);
					}
					continue;
				}
			}
			
			unmatchedArguments.add(current);
			
		}
		
	}
	
	/**
	 * Add an option to the options to be recognized for parsing.
	 * 
	 * @param option the value of the option (flag) to recognize.
	 * @param argumentRequired whether the option requires an argument.
	 * @throws InvalidOptionException thrown if the option value is null or empty.
	 */
	public void addOption(String option, boolean argumentRequired) throws InvalidOptionException{
		if((option == null) || (option.isEmpty())){
			throw new InvalidOptionException(WCConstants.INVALID_OPTION_CHARACTER_ERROR_MESSAGE);
		}
		options.put(option, new Option(option, argumentRequired));
	}
	
	/**
	 * Add an option to the options to be recognized for parsing.  This option
	 * implicitly specifies that an argument is required.
	 * 
	 * @param option the value of the option (flag) to recognize.
	 * @param missingArgumentError the error message to display if the required argument is missing.
	 * @throws InvalidOptionException thrown if the option value is null or empty.
	 */
	public void addOption(String option, String missingArgumentError) throws InvalidOptionException{
		if((option == null) || (option.isEmpty())){
			throw new InvalidOptionException(WCConstants.INVALID_OPTION_CHARACTER_ERROR_MESSAGE);
		}
		options.put(option, new Option(option, missingArgumentError));
	}	
	
	/**
	 * Get the unordered list of option to recognize.
	 * 
	 * @return the collection of unordered options to recognize.
	 */
	public Collection<Option> getOptions(){
		return Collections.unmodifiableCollection(options.values());
	}
	
	/**
	 * Check whether the given option was found during parsing. Should only 
	 * be called AFTER parseCommandLine. If not, no error will be raised, but 
	 * the result is guaranteed to return false.
	 * 
	 * @param option the value of the option (flag) to check.
	 * @return whether the option is present.
	 */
	public boolean hasOption(String option){
		return parsedOptions.containsKey(option);
	}
	
	/**
	 * Get the value of the argument for the given argument. Should only be called 
	 * AFTER parseCommandLine. If not, no error will be raised, but the result is 
	 * guaranteed to return null.  If the option does not require an argument
	 * then null will be returned.
	 * 
	 * @param option the value of the option (flag) to get the argument for.
	 * @return the value of the argument or null.
	 */
	public String getArgument(String option){
		Option parsedOption = parsedOptions.get(option);
		if(parsedOption == null){
			return null;
		}
		return parsedOption.getArgument();
	}
	
	/**
	 * Get the value of the arguments that are not recognized. This may be because the
	 * option was not defined to be recognized or is an argument that is not an 
	 * option. Should only be called AFTER parseCommandLine. If not, no error will be 
	 * raised, but the result is guaranteed to return an empty list.
	 * 
	 * @return the the list of unmatched arguments.
	 */
	public List<String> getUnmatchedArguments(){
		return unmatchedArguments;
	}
	
}