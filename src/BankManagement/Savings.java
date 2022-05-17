package BankManagement;
/**
 * This is the savings class
* it will update balance of savings account
* @author Xiaohang Ji
* @since 2022-04-2
*/
public class Savings extends Account implements Policies{
        
	//method to calculate the balance with savings account
		/**
		 * This is the method to calculate the balance with savings account
		 */
	        public void updateBalance(){
	        	 double monthlyInterest = interest/12;
	             balance += balance * monthlyInterest/100;
	        }
}
