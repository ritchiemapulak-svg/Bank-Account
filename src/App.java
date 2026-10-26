import bank.BankAccount;
import bank.BankAccountManager;
import bank.SavingsAccount;

/**
 * Runs the bank account exercise demonstrations.
 */
public class App {

    public static void main(final String[] args) {
        System.out.println("============================================");
        System.out.println("EXERCISE 1: Bank Account with OOP Concepts");
        System.out.println("============================================");

        BankAccount acc1 = new SavingsAccount("Test0");

        System.out.println("\nTest 1");
        System.out.println("Account Owner: "
                + ((SavingsAccount) acc1).getOwnerName() + ".");

        System.out.println("\nTest 2");
        try {
            acc1.deposit(1000.125);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        acc1.printBalance(acc1);

        System.out.println("\nTest 3");
        try {
            acc1.deposit(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nTest 4");
        try {
            acc1.deposit(-500);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nTest 5");
        try {
            acc1.withdraw(500);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        acc1.printBalance(acc1);

        System.out.println("\nTest 6");
        try {
            acc1.withdraw(1500);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            acc1.printBalance(acc1);
        }

        System.out.println("\nTest 7");
        try {
            acc1.withdraw(-100);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nTest 8");
        acc1.freezeAccount();
        try {
            acc1.deposit(11500);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nTest 9");
        try {
            acc1.withdraw(500);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nTest 10");
        acc1.unfreezeAccount();
        try {
            acc1.withdraw(100);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        acc1.printBalance(acc1);

        // Exercise 2 test cases
        System.out.println("\n============================================");
        System.out.println("EXERCISE 2: Collections and Package");
        System.out.println("============================================");

        System.out.println("\nTest 1");
        System.out.println("Transaction history: "
                + acc1.getTransactionHistory());

        System.out.println("\nTest 2");
        BankAccountManager accM1 = new BankAccountManager();
        System.out.println("Bank Account Manager created.");

        System.out.println("\nTest 3");
        accM1.addAccount(acc1);

        System.out.println("\nTest 4");
        accM1.addAccount(new SavingsAccount("Ritchie"));

        System.out.println("\nTest 5");
        accM1.listAccounts();

        // ---- Exercise 3 test cases ----
        System.out.println("\n============================================");
        System.out.println("EXERCISE 3: Exceptions and Lambda Expressions");
        System.out.println("============================================");

        System.out.println("\n[Setup] Create account Test3 and add it");
        BankAccountManager manager = new BankAccountManager();
        BankAccount acc2 = new SavingsAccount("Test3");
        manager.addAccount(acc2);

        System.out.println("\n[Setup] Deposit 1000.125, then withdraw 500");
        try {
            acc2.deposit(1000.125);
            acc2.withdraw(500);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nTest Case 1");
        try {
            System.out.printf("Amount deposited: %.2f%n", -500.0);
            acc2.deposit(-500);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nTest Case 2");
        acc2.freezeAccount();
        try {
            acc2.deposit(11500);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        acc2.unfreezeAccount();

        System.out.println("\nTest Case 3");
        try {
            System.out.printf("Amount withdrawn: %.2f%n", -100.0);
            acc2.withdraw(-100);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nTest Case 4");
        try {
            System.out.printf("Amount withdrawn: %.2f%n", 1500.0);
            acc2.withdraw(1500);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            acc2.printBalance(acc2);
        }

        System.out.println("\nTest Case 5");
        acc2.freezeAccount();
        try {
            acc2.withdraw(500);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        acc2.unfreezeAccount();

        System.out.println("\n[Setup] Withdraw 100 (needed for sort test)");
        try {
            acc2.withdraw(100);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nTest Case 6");
        System.out.println("Filtering transactions at or above 200...");
        System.out.println(manager.filterTransactionsAtOrAbove(
                200, acc2.getTransactionHistory()));

        System.out.println("\nTest Case 7");
        System.out.println("Sorting transactions by amount...");
        System.out.println(manager.sortTransactionsByAmount(
                acc2.getTransactionHistory()));
    }
}
