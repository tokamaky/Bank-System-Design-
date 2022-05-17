package BankManagement;
import java.io.FileNotFoundException;
import java.util.Scanner;
/*
 * Student Name: Xiaohang Ji
 * Lab Professor: Professor Abul Qasim
 * Due Date: 2022-02-27
 * Description: lab 04
 * 
 */
/**
  * This is the main class of the program 
 * it will display the menu
 * @author Xiaohang Ji
 * @since 2022-04-2
 */
public class BankTests {
      
	
	/**
	 * main method
	 * @param 	args The command line arguments.
	 * @throws OutOfNumberException 
	 */
	  
	public static void main(String[] args) throws OutOfNumberException {
		
		Scanner in = new Scanner(System.in);
		
		
		//declaring variables
		String bankName;  
        int num;          
        
        System.out.printf("Enter the name of the bank : ");
        bankName = in.nextLine();
        
        
        System.out.printf("How many account holders do you have : ");
        num = in.nextInt();
      //Read the number of accounts until the value is 0 or negative
        //exception
        while(num <= 0) {
            System.out.println("It can not be 0 or negative. Enter again :");   
            num = in.nextInt();
        }
        
      //object for college class   
    	/**
    	 * Create object for college class  
    	 */
         Bank b1 = new Bank(bankName, num);
        
         
               
            int option = 0;
    	  do {
    		
    		 Bank.menu();
    		 try{               	
                 option = in.nextInt();                
             } catch (Exception e) {
             	System.out.println("Menu option cannot be a letter");       
             	in.next();
                 continue;
             }  if(option<0 || option>6)
             {
            	 throw new OutOfNumberException("outside of the menu options range");
             }            		
        
           switch(option) {
			case 1:	
				
        	    b1.readAccount(in);       
        	    
        	    break;
			case 2:
				b1.runMonthlyProcess();
				break;
			case 3:
				b1.printAccountDetails();
				break;
			case 4:
			try {
				b1.readFile();
			} catch (FileNotFoundException e) {				
				e.printStackTrace();
			}
			break;
			
			case 5:
			try {
				b1.writeFile();
			} catch (FileNotFoundException e) {
				System.out.println("**** Invalid menu selection, please try again. ****");				
				e.printStackTrace();
			}
				break;
				
			case 6:
				System.out.println("Goodbye...Have a nice day");
				System.out.println("Program developed by Xiaohang Ji");
				break;

           }
    	}while(option !=6);

    	 in.close();
	}
}

