package BankManagement;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;
import java.io.FileWriter;  // Import this class to handle errors
import java.io.IOException;

/**
 * This is the bank class
* it will get the array list of the bank account and account the fees
* @author Xiaohang Ji
* @since 2022-04-2
*/
public class Bank {
	
	//declaring variables
	  /**
	  * bank name and ArrayList with name of accounts that use the objects of Account
	  */
        String name= "";
        ArrayList<Account>accounts;
        int count = 0; 
        int countSize =0;
       
     //parameterized constructor
        /**This constructor will get the name and number of students
		 * @param  name of bank 
		 * @param  size of account
		 */
           public Bank(String name, int size) {
        	   this.name= name;
        	   this.countSize = size;
        	   this.accounts= new ArrayList<Account>(size);
           }
      //read and display the data 
         public void readFile() throws FileNotFoundException {  
           File myObj = new File("AccountsSource.txt");
           Scanner myReader = new Scanner(myObj);
           final String c ="C";
           final String s ="S";
          
           do {
        	   String a = myReader.next();
               int num = myReader.nextInt();
               String fn = myReader.next();
               String ln = myReader.next();
               String em = myReader.next();
               long ph = myReader.nextLong();
               double ba = myReader.nextDouble();
               
             switch(a) {
             case c :
            	   Chequing chequing = new Chequing();
                   chequing.readFromFile(num, fn, ln, em, ph, ba);
                   accounts.add(chequing);                   
                   break;
             case s :
            	  Savings savings = new Savings();
 			    	savings.readFromFile(num, fn, ln, em, ph, ba);
 			    	accounts.add(savings);
 			    	break;
              }
           }while(myReader.hasNextLine());
           System.out.println(" ");
           System.out.println("***accounts read from file***");
           System.out.println(" ");
           myReader.close();
		  } 
		  //
         public static  void menu() {
        	 System.out.println("1. Read Account");
    	     System.out.println("2. Run monthly process");
    	     System.out.println("3. Print all Accounts");
    	     System.out.println("4. Read data from file");
    	     System.out.println("5. Write data to file");
    	     System.out.println("6. Exit");
    	     System.out.printf("Enter your option: ");
         }
         
       //write the data 
         public void writeFile() throws FileNotFoundException {
        	 if (accounts.size() == 0) {
      		   System.out.println("**** Invalid menu selection, please try again. ****");
                
      	   }else 
        	 try {
       	      FileWriter myWriter = new FileWriter("AccountsOutput.txt");       	      
       	      for (int index = 0; index < accounts.size(); index++) {
        	    	  myWriter.write(accounts.get(index).toString());
        	    	  //myWriter.write(System.getProperty("line.separator"));
             }
       	      myWriter.close();
       	      System.out.println("****all accounts written to file****");
       	    } catch (IOException e) {
       	      System.out.println("An error occurred.");
       	      e.printStackTrace();
       	    }
         }
           
     //method that Creates a menu and asks the user to enter various details about the account * holders
        /**
       	 * Creates a menu and asks the user to enter various details about the account
       	 * holders
       	 * 
       	 * @param  in   is  accepted the Scanner for Main Class
       	 */
           public void readAccount(Scanner in) {
        	   int type = 0;

           //if ( count >= countSize){        		   
      			 //System.out.println("account holders are full");
      		 //} else {
              do{
       
        	   System.out.println("1 - Checking");
   			   System.out.println("2 - Savings");
   			   System.out.print("Enter the type of account you want to create:");
   			   type = in.nextInt();
   			   
   			   switch(type) {
   			    case 1:
   			    	Chequing chequing = new Chequing();
                    chequing.readInfor(in);
                    accounts.add(chequing);
                    //count +=1;
                    break;
   			    case 2:
   			    	Savings savings = new Savings();
   			    	savings.readInfor(in);
   			    	accounts.add(savings);
   			    	//count +=1;
   			    	break;
   			   default:
					System.out.println("Invalid account type... Please re-enter");
   			   }
   			   
          }while(type !=1 && type !=2); 
      		 }
         //}
     
         // method to runMonthlyProcess
           /**
       	 * Executes monthly bank charges or fee deduction depending upon the type of
       	 * account
       	 */
           public void runMonthlyProcess() {
 
        	   if (accounts.size() == 0) {
        		   System.out.println("No accounts to process");
        	   }else {
         			for (int i = 0; i < accounts.size(); i++) {
         				accounts.get(i).updateBalance();

         			}
         		
         	}
          } 
           
           
           
       //method to print stars
       /**
        * Print stars
        */
       public static void printStars() {
               for (int index = 0; index < 100; index++) {
                       System.out.print("*");
               }
               System.out.println();
       }
     //method to print title
       /**
        * Print title
        */
       public void printTitle() {
               System.out.printf("%-15s | %20s | %20s | %20s | %10s\n", "Acc Number", "Name", "Email", "Phone Number",
                               "Balance");

       }
     //method to print Account Details
       /**
        * Print Account Details
        */
       public void printAccountDetails() {
    	   
    	   if (accounts.size() == 0) {
    		   System.out.println("No accounts to print");
              
    	   }else {
    		   printStars();
        	   System.out.printf("%40s%s BANK", " ", name.toUpperCase());
        	   System.out.println();
        	   printStars();
        	   printTitle();
        	   printStars();
    		   for (int index = 0; index < accounts.size(); index++) {
                   accounts.get(index).printInfo();
           }
                  			
           }
       }

}
