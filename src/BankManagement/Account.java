package BankManagement;
import java.util.Scanner;
/**
 * This is the account class it will get the information of account and print it 
* 
* @author Xiaohang Ji
* @since 2022-04-2
*/
abstract class Account {

	   //attributes
	/**
	  * Account attributes
	  * include account Holder and balance
	  * 
	  */
	   long accountNumber;
	   Person accountHolder;
	   double balance;
	   
	   
	   //Constructor
	   /**
        * constructor
        * 
        * @param accountNumber   account number 
        * @param accHolder       account holder
        * @param balance         the balance of account
        */
       public Account(long accountNumber, Person accHolder, double balance) {
               this.accountNumber = accountNumber;
               this.accountHolder = accHolder;
               this.balance = balance;
       }
       /**
        * constructor
        * 
        */
       public Account() {
    	   accountHolder = new Person();
       }
	   
	   //readInfo method 
	   /**
	    * This is the method to get information of personal and account attributes
	    * @param in is accepted the Scanner for Main Class
	    */
	   public void readInfor(Scanner in) {		   
		   System.out.printf("Enter Account Number :");
		   this.accountNumber=in.nextLong();
		   accountHolder.readInfo(in);
		   System.out.printf("Enter Balance :");
		   this.balance = in.nextDouble();
		   while(balance<0) {
			   System.out.printf("It can not negative. Enter again :");   
                balance = in.nextDouble();}
	   }
	   
	 //readFromFile method 
	   /**
	    * This is the method to get information of personal and account attributes from file
	    * @param accountNumberFromFile  account number 
	    * @param firstNameFromFile      first name 
	    * @param lastNameFromFile       last name
	    * @param emailStringFromFile    email id
	    * @param phoneNumberFromFile    phone number
	    * @param balanceFromFile        balance
	    */
	   public void readFromFile(long accountNumberFromFile, String firstNameFromFile,
			   String lastNameFromFile, String emailStringFromFile, long phoneNumberFromFile, double balanceFromFile ) {
		   this.accountNumber = accountNumberFromFile;
		   accountHolder.firstName = firstNameFromFile;
		   accountHolder.lastName = lastNameFromFile;
		   accountHolder.emailId = emailStringFromFile;
		   accountHolder.phoneNumber = phoneNumberFromFile;
		   this.balance = balanceFromFile;
	   }
	   
	  
	   //override the toString()
	   /**
	    * This is the method to override the toString
	    */
	   public String toString() {
      	 return this.accountNumber+"  "+ accountHolder.firstName+" "+accountHolder.lastName+"  "+
				   accountHolder.emailId+"  "+accountHolder.phoneNumber+"  "+this.balance + "\r\n";//this is important
       }
	   //abstract method to update balance
	   /**
	    * this is the abstract method to update the balance
	    */
	   abstract public void updateBalance();
	   
	   //To display the details 
	   /**
	    * This is the method to display the information details
	    */
	   public void printInfo() {
		   System.out.printf("%15s | %20s | %20s | %20s | %10.2f\n", this.accountNumber, accountHolder.firstName+" "+accountHolder.lastName,
				   accountHolder.emailId,accountHolder.phoneNumber,this.balance );

		   
	   }
	  
}
