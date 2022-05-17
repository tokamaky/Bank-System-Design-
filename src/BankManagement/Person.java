package BankManagement;
import java.util.Scanner;
//package 
/**
 * This is the person class it will get the information of person.
* 
* @author Xiaohang Ji
* @since 2022-04-2
*/
class Person {
	//declaring variables
		 /**
		  * personal attributes
		  */
		String firstName;
		String lastName;
		String emailId;
		long phoneNumber;
		

		 
		//defining readInfo() method	 
			/**
			 * This is the readInfo method
			 * @param in accept the Scanner for Main Class
			 */
		 public  void readInfo(Scanner in) {
			 System.out.printf("Enter first name:");
			 this.firstName=in.next();
			 System.out.printf("Enter last name:");
			 this.lastName=in.next();
			 System.out.printf("Enter email Id:");
			 this.emailId=in.next();
			 System.out.printf("Enter phone number:");
			 this.phoneNumber=in.nextLong();
		}
}
