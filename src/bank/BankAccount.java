package bank;

import java.util.ArrayList;
import java.util.List;
/** 
 * Represents a bank account with deposit, withdrawal, and freeze controls. 
 */
public abstract class BankAccount {
    
    private final List<Transaction> transactionHistory;
    private double balance;
    private boolean isFrozen;

    public abstract String getOwnerName();

    public BankAccount() {
        this.transactionHistory = new ArrayList<>();
        balance = 0;
        isFrozen = false;
    }

    /**
     * Deposits a specified amount into the bank account.
     * 
     * @param amount The amount to deposit. Must be greater than 0.
     */
    public void deposit(final double amount) {
        if (isFrozen) {
            System.out.println("Account is FROZEN. Unable to transact.");
            return;
        }
        if (amount <= 0) {
            System.out.println("Amount deposited: " + amount);
            System.out.println("Invalid amount. Must be greater than 0");
            return;
        }
        balance += amount;
        transactionHistory.add(new Transaction("Deposit", amount));
        System.out.printf("Amount deposited: %.2f%n", amount);
    }

    /**
     * Withdraws a specified amount from the bank account.
     * 
     * @param amount The amount to withdraw. Must be greater than 0 and less than or
     *               equal to the current balance.
     */
    public void withdraw(final double amount) {
        if (isFrozen) {
            System.out.println("Account is FROZEN. Unable to transact.");
            return;
        }
        if (amount <= 0) {
            System.out.println("Amount withdrawn: " + amount);
            System.out.println("Invalid amount. Must be greater than 0");
            return;
        }
        if (amount > balance) {
            System.out.println("Amount withdrawn: " + amount);
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            transactionHistory.add(new Transaction("Withdraw", amount));
            System.out.printf("Amount withdrawn: %.2f%n", amount);
        }
        balance -= amount;
        System.out.printf("Amount withdrawn: %.2f%n", amount);
    }
    
    /**
     * Returns the current balance of the bank account.
     * 
     * @return The current balance.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Freezes the bank account, preventing any transactions.
     */
    public void freezeAccount() {
        isFrozen = true;
    }

    /**
     * Unfreezes the bank account, allowing transactions to resume.
     */
    public void unfreezeAccount() {
        isFrozen = false;
    }

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }
}
