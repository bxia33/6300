package edu.gatech.seclass.project1;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

import edu.gatech.seclass.project1.commandline.CommandLineParser;
import edu.gatech.seclass.project1.domain.WCContext;

/**
 * The main WC application entry point.  The WC application is used to calculate
 * the average sentence length for an input file.  The application accepts command
 * line arguments to specify the list of characters to consider as the delimiter for
 * sentences, the number of consecutive characters to consider as a word, and the
 * path to the file to calculate the average sentence length for.
 */
public class WC{

	/**
	 * The entry point to the WC application.
	 * 
	 * @param args the command line arguments.
	 */
	public static void main(String[] args){

		try{
			
			CommandLineParser parser = new CommandLineParser();
			parser.addOption(WCConstants.LENGTH_OPTION, WCConstants.LENGTH_REQUIRED_ARGUMENT_ERROR_MESSAGE);
			parser.addOption(WCConstants.DELIMITER_OPTION, WCConstants.DELIMITER_REQUIRED_ARGUMENT_ERROR_MESSAGE);
			
			parser.parseCommandLine(args);
			
			List<String> additionalArgs = parser.getUnmatchedArguments();
			if((additionalArgs == null) || (additionalArgs.isEmpty())){
				throw new WCException(WCConstants.MISSING_FILE_PATH_ERROR_MESSAGE);
			}
			
			if(additionalArgs.size() > 1){
				throw new WCException(String.format(WCConstants.UNRECOGNIZED_COMMAND_LINE_ARGUMENTS_ERROR_MESSAGE_TEMPLATE, Arrays.toString(additionalArgs.toArray())));
			}
			
			WCContext context = new WCContext(parser.getArgument(WCConstants.LENGTH_OPTION), 
					parser.getArgument(WCConstants.DELIMITER_OPTION), additionalArgs.get(0));
			
			Core calculator = new Core();
			
			DecimalFormat format = new DecimalFormat(WCConstants.DECIMAL_FORMAT);
			System.out.println(format.format(calculator.calculateAverageSentenceLength(context)));
			
		}
		catch(WCException wce){
			System.err.println(WCConstants.ERROR_MESSAGE_PREFIX + wce.getMessage());
		}
		catch(Exception e){
			System.err.println(WCConstants.ERROR_MESSAGE_PREFIX + e.getMessage());
			System.err.println(WCConstants.UNEXPECTED_ERROR_ERROR_MESSAGE);
			e.printStackTrace();
		}
		
	}

}