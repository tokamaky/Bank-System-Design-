package BankManagement;


     /**
      * This is the chequingclass
     * it will update balance of chequing account
     * @author Xiaohang Ji
     * @since 2022-04-2
     */
public class Chequing extends Account implements Policies{
	
	
      //method to calculate the balance with chequFee account
	   /**
	     * This is the method to calculate the balance with chequFee account
	     * 
	     */
           public void updateBalance(){
        	      balance -= chequFee;
             }
	
}
