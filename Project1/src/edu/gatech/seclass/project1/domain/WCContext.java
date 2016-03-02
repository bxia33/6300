package edu.gatech.seclass.project1.domain;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import edu.gatech.seclass.project1.WCConstants;

/**
 * A holder for average sentence length calculation values.  This type
 * accepts raw argument values and will convert and validate the
 * information on creation.
 */
public class WCContext{

	/**
	 * The length of character sequences to consider as words.
	 */
	private int wordLength;
	
	/**
	 * The list of characters to use as sentence delimiters.
	 */
	private List<Character> delimiters = new ArrayList<Character>();
	
	/**
	 * The file to calculate for.
	 */
	private File file;
	
	/**
	 * Create a WC context given the raw value for word length, sentence delimiters, and
	 * file path.  The arguments will be parsed and validated on construction.
	 * 
	 * @param wordLength the length of character sequences to consider as words.
	 * @param delimiters the list of characters to consider as sentence delimiters.
	 * @param file the file to calculate for.
	 * @throws WCContextException thrown for invalid context values.
	 */
	public WCContext(String wordLength, String delimiters, String file) throws WCContextException{
		
		if(file == null){
			throw new WCContextException(WCConstants.MISSING_FILE_PATH_ERROR_MESSAGE);
		}
		
		this.file = new File(file);
		
		if(wordLength == null){
			this.wordLength = WCConstants.DEFAULT_LENGTH;
		}
		else{
			try{
				this.wordLength = Integer.parseInt(wordLength);
			}
			catch(NumberFormatException nfe){
				throw new WCContextException(String.format(WCConstants.INVALID_WORD_LENGTH_ERROR_MESSAGE_TEMPLATE, wordLength));
			}
		}
		
		if(delimiters == null){
			this.delimiters = WCConstants.DEFAULT_DELIMITERS;
		}
		else{
			for(int i = 0; i < delimiters.length(); i++){
				this.delimiters.add(delimiters.charAt(i));
			}
		}
		
		validate();
		
	}

	/**
	 * Validate the context values.
	 * 
	 * @throws WCContextException thrown in response to invalid context values.
	 */
	private void validate() throws WCContextException{
		
		if(wordLength <= 0){
			throw new WCContextException(String.format(WCConstants.INVALID_WORD_LENGTH_ERROR_MESSAGE_TEMPLATE, wordLength));
		}
		
		if(delimiters.isEmpty()){
			throw new WCContextException(WCConstants.DELIMITER_REQUIRED_ERROR_MESSAGE);
		}
		
		if(!file.exists()){
			throw new WCContextException(String.format(WCConstants.INVALID_FILE_PATH_DIRECTORY_ERROR_MESSAGE_TEMPLATE, file));
		}
		
		if(file.isDirectory()){
			throw new WCContextException(String.format(WCConstants.INVALID_FILE_PATH_DOES_NOT_EXIST_ERROR_MESSAGE_TEMPLATE, file));
		}
		
	}

	/**
	 * Get the number of characters in a sequence to consider as a word.
	 * 
	 * @return the word length.
	 */
	public int getWordLength(){
		return wordLength;
	}

	/**
	 * Get the list of characters to consider as sentence delimiters.
	 * 
	 * @return the sentence delimiters.
	 */
	public List<Character> getDelimiters(){
		return delimiters;
	}

	/**
	 * Get the file path to the file to calculate the average sentence length for.
	 * 
	 * @return the file path.
	 */
	public File getFile(){
		return file;
	}
	
}