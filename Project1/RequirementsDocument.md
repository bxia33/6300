# **Requirements Document -- Team 32**

##1 User Requirements

###1.1 Software Interfaces

- The application will run on any platform supporting Java 1.8.  
- No external systems will be used. 
- No external or third party libraries will be used.

###1.2 User Interfaces

1. The application will provide a CLI (command line interface)
2. The application will output the average sentence length as a positive double value rounded off to 2 decimals (xx.xx) on standard output.
3. The application will output any errors as human readable text on standard error.
4. The application will accept the following command line options:
  1. -l a positive integer greater than 0 indicating the number of characters to consider as a qualified word length (defaults to 4 if not specified, so that all words whose character length of at least four is considered)
  2. -d a list of characters to be used as sentence delimiters (defaults to .!?;: if not specified.)
5. The application will need user to specify a raw text file before it can start (file path and file name).

###1.3 User Characteristics

- User shall be students on English class with a range of tech background, from no tech experience to pretty proficient, from no programming skills to self-sufficient in programming.

##2 System Requirements

These subsections contain all the software requirements at a level of detail sufficient to enable designers/developers to design/develop a system that satisfies those requirements, and testers to test that the system satisfies those requirements.
 
###2.1 Functional Requirements

1. The application shall provide a command line interface invoked via a java command.
2. The application shall accept a single file on standard input and treat the file as plain ASCII text, no matter what the original extension of the file may be. 
  1. Content and language of the file doesn’t matter.
  2. Shall output error message, if the program can't access the file. 
3. The application should scan the input file and consider a sentence until it reaches a delimiter, even if a sentence entered in multiple lines.
  1. All parts of the file should be scanned for words and sentences, includes the title of the file (if any).
4. The application should consider all characters (no matter what they are, even if they are bullets) to be the candidates of a qualifying word.
5. The application must consider Carriage return equivalent to white space.
  1. Space, Tab, New line, Sentence Delimiters are considered to be the end of the word.
6.  The application shall output the average sentence length of the input file on standard output (i.e. console)
  1. Average sentence length shall be calculated as the sum of qualified words / number of qualified sentences rounded down to two decimal places (e.g. 12.3421 is rounded to 12.34; 12.3456 is rounded to 12.35).
  2. A "qualified sentence" is a sentence that contains at least one non-zero length word. (e.g. When set ".!" as sentence delimiters, then "Mr." is a sentence. But " !" which is a zero-length sentence, should not be considered as a qualified sentence).
  3. If the entire file contains no qualified words, then the program should return 0.
  4. If there is no sentence delimiter found in the file, then treat the whole file as one sentence.
7.  The application shall accept the command line option -l to set the minimum number of characters (inclusive) for a word to be considered as a qualified word.
  1. As default, a qualified word should contain at least four characters.
  2. Command line option format: -l num 
    1. The num should be a positive integer. It indicates the minimum number of (inclusive) characters the user wants to specify a qualified word. (e.g. if num is 5, then a qualified word should contain at least five or more characters)
    2. The application shall output an error message when the num is not a positive integer. (e.g. num <=0 or num is not a integer).
    3. The application shall output an error message when the parameter "num" is not specified after the command line option -l.
    4. The num always overwrites the existing or the default minimum number of characters for a qualified word. 
  3. A "word" means any number of characters that ended by white space (Space, Tab, New line, and carriage return), regardless the correctness of the word. (e.g."1234", "app2e", “1Mr”, "0").
  4. Sentence delimiters should not be considered as part of a word.
  5. A "qualified word" means any "word" that at least contains the minimum number of characters. The minimum number of characters can be either the default number (four) or specified by command line option -l.
8.  The application shall accept the command line option -d indicating the characters to use as sentence delimiters.
  1. The application shall default to the characters .!?;: if the -d command line option is not specified.
  2. The application shall output an error message, if the option -d isn't followed by sentence delimiter(s).
  3. For example: -d a1$β
    1.  In this case, the characters ‘a’, ‘1’, ‘$’, ‘β’ are considered as delimiters.  The -d command line option always overwrites the existing and/or default sentence delimiters.
    2.  No validation is required on the delimiter entry.
    3.  The application should consider “ and " as two qualifying delimiter entry, and not string specifier.  (i.e. “a1$β" transforms to ‘”’, ‘a’, ‘1’, ‘$’, ‘β’, '"').
    4.  The application shall accept any valid characters that the user's shell can accept.  For example, a tab character can be accepted in a bash shell by using the escape sequence \t and the space character can be specified by enclosing the argument in single quotes.  The specification of shell behavior is outside the scope of this document.
9. The options –d & -l may be specified in any order.
10. Error handling: The format of the error message shall be: "ERROR: Meaningful message according to the nature of the issue". The application should handle the below error scenarios with the corresponding error message. Please note that the below error messages are indicative.
    1. The error message for specifying the delimiter flag without specifying a list of sentence delimiters.  
	    ERROR: The -d command line option requires a list of delimiter character(s)
    2. The error message for specifying the length flag without specifying a value for the word length.  
	    ERROR: The -l command line options requires a minimum length of characters to be considered as words
    3. The error message displayed if no option is specified.  
	    ERROR: A command line option must be specified.  Null and the empty string are not valid option strings
    4. The error message displayed if the required file path argument is not specified. 
	    ERROR: The path to the file to calculate average sentence length for must be specified
    5. The error message displayed for unrecognized command line arguments.  
        ERROR: Unrecognized command line argument(s).  Only -d, -l, and file path are allowed
    6. The error message for an invalid word length argument.  
	    ERROR: The value specified for word length '%s' is invalid. It must be a positive whole number
    7. The error message displayed to indicate an empty list of delimiters is not allowed. 
	    ERROR: Invalid delimiters. An empty set of delimiters is not allowed
	8. The error message for a file path pointing to a directory.  
        ERROR: The file path is invalid.  It points to a directory
    9. The error message for a file path pointing to a file that does not exist.  
        ERROR: The file does not exist
   10. The error message displayed to indicate the following lines after an unexpected error are the stack trace for what occurred. 
	    ERROR: Please contact support providing the following information
   11. IO error message.
        ERROR: An error occurred while reading the file
   12. The error message indicating an error occurred closing the input file.
	    ERROR: An error occurred while closing the file

###2.2 Non-Functional Requirements

1. Should not PC environment (i.e. Hardware, OS etc.) dependent.
2. Should provide better user experience (easy to use, with meaningful error/warning messages and clear help instruction on how to use) interface to end user.
3. Should have the average performance of processing 5000 characters per second
4. Name of the program should be: WC
5. Should provide a user manual to detail out what the program does and hot to use the program.
