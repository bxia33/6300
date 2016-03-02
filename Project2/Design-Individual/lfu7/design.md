# **Design Note -- TCCart**

## Assumptions and main design decisions

1. Assume: The Credit card scanner will also has the function to connect the credit card service provider.      
   Decision: Through "Manager" class (using the printCustomerCard() method) to use the "rediCardScanner" class, to achieve the system payment processing.     
2. Assume: The function that to send email is contained in a email class.    
   Decision: To let "Email" class contained in external library to have the function of sending email.    
3. Assume: All the necessary external libraries are all contained in one package.  
   Decision: To put all the external libraries into one package call "ExternalLibraries".   
4. Decision: For cleaner UML diagram, decided to let the "Manager" class to access the "ExternalLibraries" package only. So put methods to send email confirmation to customer for transaction receipt, VIP status confirmation and credit gained confirmation (sendEmailtoCofirmVIPstatus(); sendEmailforReceivingCredit(); sendEmailReceipt()) in the "Manager" class.    
5. Decision: To let the "Purchase" class to check the credit availability (checkCreditAvailability()) and VIP discount availability (checkVIPdiscountAvailability()) for each purchase, and to use checkVIPdiscountAvailability() method to calculate total item price before applying any discount and credit, the total discount applied and the total credit applied, and the final total purchase price.     
6. Decision: To let the "Credit" class to update credit information after each purchase transaction. The "available" attribute is used to present if there is credit available. The "TotalCreditAmount" attribute is used to track the available credit amount. 
7. Decision: To let the "VIPdicount" class to update the current VIP status, and track year-to-date spending (calculateYearToDateSpend()) after each purchase transaction. The "VIPstatus" attribute is use to present concurrent VIP discount availability. The "NextYearVIPstatus" attribute is used to present the coming year VIP discount availability, and it is depends on the value of the "YearToDateSpendAmount" attribute.  
8. Decision: To use getCustomerTransactionHistory() method in "Manager" class to let the manager to check transaction history of a customer. 
9. Decision: To use readCustomerCard() method in "Manager" class to let the manager to read the customer card information. 
