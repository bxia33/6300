package edu.gatech.seclass.project1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Iterator;

import edu.gatech.seclass.project1.domain.WCContext;

/**
 * The core calculator of the WC application.  The only publicly available API
 * method is calculateAverageSentenceLength which takes in a WCContext and
 * calculates the average sentence length based on the context options.
 */
public class Core{
	
	/**
	 * A simple runtime exception extension that allows the wrapping of 
	 * a checked exception with a runtime exception.
	 * 
	 * @author <a href="mailto:matthew.welsh@gatech.edu">Matthew Welsh</a>
	 */
	private static final class RuntimeIOException extends RuntimeException{

		/**
		 * The generated serial version id.
		 */
		private static final long serialVersionUID = 7324936739965314065L;
		
		/**
		 * Create an IO runtime exception given a checked exception.
		 * 
		 * @param cause the original cause of the exception.
		 */
		public RuntimeIOException(Throwable cause){
			super(cause);
		}
		
	}
	
	/**
	 * A utility method for calculateAverageSentenceLength that creates an iterator
	 * the incrementally returns the individual lines of the given reader.
	 * 
	 * @param input the reader to read lines from.
	 * @return the iterator for the given input.
	 */
	private Iterator<String> getFileStream(final BufferedReader input){
		
		return new Iterator<String>(){

			private String buffer;
			boolean complete = false;
			
			@Override
			public boolean hasNext(){
				if(complete){
					return false;
				}
				if(buffer == null){
					try{
						buffer = input.readLine();
					} 
					catch(IOException ioe){
						throw new RuntimeIOException(ioe);
					}
					if(buffer == null){
						complete = true;
						return false;
					}
				}
				return true;
			}

			@Override
			public String next(){
				String toReturn = buffer;
				buffer = null;
				return toReturn;
			}
			
		};
		
	}
	
	/**
	 * Calculate average sentence length.  Calculate the average sentence length for the
	 * file in the given context based on the constraints given in the context.  The 
	 * returned value is the average sentence length rounded to the nearest two decimal
	 * places.
	 * 
	 * @param context the context for the calculation.
	 * @return the rounded calculated sentence length.
	 * @throws WCException
	 */
	public double calculateAverageSentenceLength(WCContext context) throws WCException{
		
		double wordCount = 0;
		double sentenceCount = 0;
		
		BufferedReader br = null;
		try{
			
			int currentWordCount = 0;
			StringBuilder buffer = new StringBuilder();
			br = new BufferedReader(new FileReader(context.getFile()));
			Iterator<String> it = getFileStream(br);
			while(it.hasNext()){
				String line = it.next() + "\n";
				for(int i = 0; i < line.length(); i++){
					char current = line.charAt(i);
					if(context.getDelimiters().contains(current)){
						if(buffer.length() >= context.getWordLength()){
							currentWordCount++;
						}
						buffer.delete(0, buffer.length());
						if(currentWordCount > 0){
							wordCount += currentWordCount;
							sentenceCount++;
						}
						currentWordCount = 0;
					}
					else if(Character.isWhitespace(current)){
						if(buffer.length() >= context.getWordLength()){
							currentWordCount++;
						}
						buffer.delete(0, buffer.length());
					}
					else{
						buffer.append(current);
					}
				}
			}
			
			if(buffer.length() >= context.getWordLength()){
				currentWordCount++;
			}			
			
			if(currentWordCount > 0){
				wordCount += currentWordCount;
				sentenceCount++;
			}
			
		} 
		catch(FileNotFoundException fnfe){
			throw new WCException(String.format(WCConstants.INVALID_FILE_PATH_DOES_NOT_EXIST_ERROR_MESSAGE_TEMPLATE, 
					context.getFile().getAbsolutePath()), fnfe);
		}
		catch(RuntimeIOException rioe){
			throw new WCException(String.format(WCConstants.IO_ERROR_ERROR_MESSAGE_TEMPLATE, context.getFile().getAbsolutePath()), rioe);
		}
		finally{
			if(br != null){
				try{
					br.close();
				} 
				catch(IOException ioe){
					throw new WCException(String.format(WCConstants.CLOSE_FILE_ERROR_MESSAGE_TEMPLATE, 
							context.getFile().getAbsolutePath()), ioe);
				}
			}
		}
		
		if(sentenceCount > 0){
			return new BigDecimal(wordCount/sentenceCount).setScale(2, RoundingMode.HALF_UP).doubleValue();
		}
		else{
			return 0;
		}
		
	}
	
}