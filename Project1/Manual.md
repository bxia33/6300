# **Word Count -- Team 32**

Dear Students, Intended users:

Have you ever wondered about improving your writing style?
Are you the one used to writing lengthy sentences that not esay to read by others?

May be you have one less thing to worry about.  Yes! Here we have our word count tool that can quickly analyze and tell you 
the average number of words you have per sentence.  Isn't that useful?

Research says, the optimum sentence length is roughly between 15 to 20 words.

Now, let's directly jump on to our software and see the usage instructions:

##Please note:
This manual is intended to show you how to use Word Counter tool, it is assumed that:  
 1. You have successfully installed the software. 
 2. You have the knowledge and know how to do command line operation. The command prompt (i.e. $) may vary depending on the operating system on which the program runs.
 3. You know the location of the file to be examed. File location(s) specified in this manual are for demonstration purpose only.  
 4. The file to be examed is a .txt file, and the content of the file is plain ASCII text. 

##1. What this tool does:

 Tells you the qualified average number of words per sentence, else gives you a meaningful message

##2. What this tool does not do:

1. Spelling Checking
2. Language discrepancy
3. Grammar correction

##3. Command line options

Having said that the tool will be able to calculate the average, we will need to specify the minimum character for a word to be considered and the sentence delimiters. The default values are provided as below and using these command line options, you will be able to override the default ones.

We have two command line options: -d & -l

1. -d : Used to specify sentence delimiters.  The moment it's encountered, the application will consider it a sentence.  
	a. It may be specified as a string within double quotes ""; and each individual character inside the quote will act 		   as delimiters.   
	b. You may not want to decorate delimiters with ", if you do not have space or tab.     
	c. There are 5 default delimiters:  '!', '?', '.', ':', ';'    
2. -l : Used to specify minimum character length that qualify a word.  The value is inclusive.
	For example:     
	You are great : Word count is 1 (great is the only word that qualifies).  
	You-are great : Word count is 2 (- is a not a word separator.  So, You-are is considered 1 word).     

	Please note: space, tab, carriage return / line feed & sentence delimiters are considered end of the word.

##4. Steps to execution
 Example 1 :  
 
 Specify the location of the text file to be examined without delimiter & minimum word length specifications   
1. In this case, the application will consider the default delimiters & default minimum length.      
2. Hit Enter to see the result
3. Screenshots from Linux & Windows Operation system is provided for better clarity

#####Linux:
![Alt text](https://github.gatech.edu/github-enterprise-assets/0000/7170/0000/0900/d509ead2-d1e1-11e5-86a1-b482b5519c24.png)

#####Windows:
![Alt text](https://github.gatech.edu/github-enterprise-assets/0000/7170/0000/0898/b4bb555e-d1e1-11e5-9da1-9247907c6ccb.png)

 Example 2: 
 
 Specify the location of the text file to be examined with minimum length specification only   
1. In this case, the application will consider the default delimiters   	
2. Hit Enter to see the result

#####Linux:
![Alt text](https://github.gatech.edu/github-enterprise-assets/0000/7170/0000/0902/d53af3d4-d1e1-11e5-97e2-5fe196b9dda5.png)

#####Windows:
![Alt text](https://github.gatech.edu/github-enterprise-assets/0000/7170/0000/0899/b4bc8118-d1e1-11e5-8112-384e0f5025e5.png)

 Example 3: 
 
 Specifying the location of the text file to be examined with delimiter specification only     
1. In this case, the application will consider the default minimum length specification    
2. Hit enter to see the result

#####Linux:
![Alt text](https://github.gatech.edu/github-enterprise-assets/0000/7170/0000/0901/d5323ea6-d1e1-11e5-90ad-17ac7b6204da.png)

#####Windows:
![Alt text](https://github.gatech.edu/github-enterprise-assets/0000/7170/0000/0896/b4b03304-d1e1-11e5-8227-ea8d13ce0238.png)

 Example 4: 
 
 You can as well specify all three values together (i.e. file name, delimiter, minimum word length in any order)   
1. In this case, the existing OR default delimiter & minimum word length specifications will be overwritten   
2. Hit enter to see the result

#####Linux:
![Alt text](https://github.gatech.edu/github-enterprise-assets/0000/7170/0000/0903/d55da47e-d1e1-11e5-8f85-6c63795596f9.png)

#####Windows:
![Alt text](https://github.gatech.edu/github-enterprise-assets/0000/7170/0000/0897/b4b68e3e-d1e1-11e5-8bb1-f3593e2ff2c4.png)

##5. Examming the command line entries: 

 The command line entries shall follow below format: 
  java -cp <path to the bin directory> edu.gatech.seclass.project1.WC <arguments to WC>

 For example:  java edu.gatech.seclass.project1.WC "/Users/User 1/Desktop/portal.txt" -d .!? -l 5   
 This is an example of a fully qualified input. 

###5.1. Input file specification

In double quotes, specify the full path of the file to be examined.  If your path does not include space, then you may not 
decorate with double quote.  Otherwise, it's mandatory.

In the above example: it is: "/Users/User 1/Desktop/portal.txt"
If you do not have a space in between 'User' and '1' then you may as well enter,
$ java edu.gatech.seclass.project1.WC /Users/User1/Desktop/portal.txt -d .!? -l 5

##6. Error messages

User friendly error messages will be shown according to the nature of the issue.  Some of the common error scenarios are detailed below.  This is just indicative & not finite.  

1. The error message for specifying the delimiter flag without specifying a list of sentence delimiters
	
	ERROR: The -d command line option requires a list of delimiter character(s)

2. The error message for specifying the length flag without specifying a value for the word length
	
	ERROR: The -l command line options requires a minimum length of characters to be considered as words

3. The error message displayed if no option is specified
	
	ERROR: A command line option must be specified.  Null and the empty string are not valid option strings

4. The error message displayed if the required file path argument is not specified.

	ERROR: The path to the file to calculate average sentence length for must be specified

5. The error message displayed for unrecognized command line arguments

	ERROR: Unrecognized command line argument(s).  Only -d, -l, and file path are allowed

6. The error message for an invalid word length argument
	
	ERROR: The value specified for word length is invalid.  It must be a positive whole number

7. The error message displayed to indicate an empty list of delimiters is not allowed
	
	ERROR: Invalid delimiters. An empty set of delimiters is not allowed

8. The error message for a file path pointing to a directory
	
	ERROR: The file path is invalid.  It points to a directory

9. The error message for a file path pointing to a file that does not exist.
	
	ERROR: The file does not exist

10. The error message displayed to indicate the following lines after an unexpected error are the stack trace for what occurred
	
	ERROR: Please contact support providing the following information

11. IO error message.
	
	ERROR: An error occurred while reading the file

12. The error message indicating an error occurred closing the input file.
	
	ERROR: An error occurred while closing the file
