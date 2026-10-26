package bank;

import java.util.ArrayList;
import java.util.List;

import exception.AccountFrozenException;
import exception.InsufficientFundsException;
import exception.InvalidAmountException;

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

    /**
     * Deposits a specified amount into the bank account.
     * 
     * @param amount The amount to deposit. Must be greater than 0.
     */
    public void deposit(final double amount) throws InvalidAmountException, AccountFrozenException {
        if (isFrozen) {
            throw new AccountFrozenException("Account is FROZEN. Unable to transact.");
        }
        if (amount <= 0) {
            throw new InvalidAmountException("Invalid Amount");
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
    public void withdraw(final double amount) throws AccountFrozenException, InsufficientFundsException, InvalidAmountException{
        if (isFrozen) {
            throw new AccountFrozenException("Account is FROZEN. Unable to transact.");
        }
        if (amount <= 0) {
            throw new InvalidAmountException("Invalid amount. Must be greater than 0");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient balance.");
        }
        balance -= amount;
        transactionHistory.add(new Transaction("Withdraw", amount));
        System.out.printf("Amount withdrawn: %.2f%n", amount);

    }

     public void printBalance(final BankAccount account) {
        System.out.printf("Current balance: %.2f%n", account.getBalance());
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

    /**
     * Returns the transaction history of the bank account.
     * 
     * @return A list of transactions.
     */
    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }
}
