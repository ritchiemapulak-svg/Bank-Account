package bank;

import java.util.ArrayList;
import java.util.List;
/** 
 * Represents a bank account with deposit, withdrawal, and freeze controls. 
 */
public class BankAccount {
    
    private final List<Transaction> transactionHistory;
    private double balance;
    private boolean isFrozen;

    public BankAccount() {
        this.transactionHistory = new ArrayList<>();
        balance = 0;
        isFrozen = false;
    }

    public void deposit(final double amount) {
        if (isFrozen) {
            System.out.println("Account is FROZEN. Unable to transact.");
        } else if (amount <= 0) {
            System.out.println("Amount deposited: " + amount);
            System.out.println("Invalid amount. Must be greater than 0");
        } else {
            balance += amount;
            transactionHistory.add(new Transaction("Deposit", amount));
            System.out.printf("Amount deposited: %.2f%n", amount);
        }
    }

    public void withdraw(final double amount) {
        if (isFrozen) {
            System.out.println("Account is FROZEN. Unable to transact.");
        } else if (amount <= 0) {
            System.out.println("Amount withdrawn: " + amount);
            System.out.println("Invalid amount. Must be greater than 0");
        } else if (amount > balance) {
            System.out.println("Amount withdrawn: " + amount);
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            transactionHistory.add(new Transaction("Withdraw", amount));
            System.out.printf("Amount withdrawn: %.2f%n", amount);
        }
    }

    public double getBalance() {
        return balance;
    }

    public void freezeAccount() {
        isFrozen = true;
    }

    public void unfreezeAccount() {
        isFrozen = false;
    }

    public boolean isFrozen() {
        return isFrozen;
    }

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }
}
