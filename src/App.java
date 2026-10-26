import bank.BankAccount;
import bank.BankAccountManager;
import bank.SavingsAccount;
import exception.InsufficientFundsException;
import exception.InvalidAmountException;

/**
 * Runs the bank account exercise demonstrations.
 */
public class App {

    public static void main(final String[] args) {
        BankAccount acc1 = new SavingsAccount("Test0");

        System.out.println("Test 1");
        System.out.println("Account Owner: " + ((SavingsAccount) acc1).getOwnerName() + ".");

        System.out.println("\nTest 2");
        try {
            acc1.deposit(1000.125);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // printBalance(acc1);

        System.out.println("\nTest 3");
        try{
           acc1.deposit(0); 
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        

        System.out.println("\nTest 4");
        try{
            acc1.deposit(-500);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println("\nTest 5");
        try{
            acc1.withdraw(500);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        // printBalance(acc1);

        System.out.println("\nTest 6");
        acc1.withdraw(1500);
        // printBalance(acc1);

        System.out.println("\nTest 7");
        acc1.withdraw(-100);

        System.out.println("\nTest 8");
        acc1.freezeAccount();
        acc1.deposit(11500);

        System.out.println("\nTest 9");
        acc1.withdraw(500);

        System.out.println("\nTest 10");
        acc1.unfreezeAccount();
        acc1.withdraw(100);
        // printBalance(acc1);

        System.out.println("\nTest 11");
        System.out.println("Transaction history: " + acc1.getTransactionHistory());

        System.out.println("\nTest 12");
        BankAccountManager accM1 = new BankAccountManager();

        System.out.println("\nTest 13");
        accM1.addAccount(acc1);

        System.out.println("\nTest 14");
        accM1.addAccount(new SavingsAccount("Ritchie"));

        System.out.println("\nTest 15");
        accM1.listAccounts();
    }
}
