package bank;

import java.util.ArrayList;
import java.util.List;

import exception.AccountFrozenException;
import exception.InsufficientFundsException;
import exception.InvalidAmountException;

/**
 * Represents a bank account with deposit, withdrawal,
 * and freeze controls.
 */
public class BankAccount {

    private static final String INVALID_AMOUNT_MSG =
     "Invalid amount. Must be greater than 0";
    private static final String FROZEN_MSG =
     "Account is FROZEN. Unable to transact.";

    private final List<Transaction> transactionHistory;
    private double balance;
    private boolean isFrozen;

    public BankAccount() {
        this.transactionHistory = new ArrayList<>();
        this.balance = 0;
        this.isFrozen = false;
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
     * Returns whether the account is frozen.
     *
     * @return true if the account is frozen, false otherwise.
     */
    public boolean isFrozen() {
        return isFrozen;
    }

    /**
     * Returns the transaction history of the bank account.
     * 
     * @return A list of transactions.
     */
    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    /**
     * Deposits a specified amount into the bank account.
     * 
     * @param amount The amount to deposit. Must be greater than 0.
     */
    public void deposit(final double amount) {
        try {
            if (isFrozen()) {
                throw new AccountFrozenException(FROZEN_MSG);
            }
            if (amount <= 0) {
                throw new InvalidAmountException(INVALID_AMOUNT_MSG);
            }
            balance += amount;
            transactionHistory.add(new Transaction("Deposit", amount));
            System.out.printf("Amount deposited: %.2f%n", amount);
        } catch (InvalidAmountException | AccountFrozenException e) {
            System.out.printf("Amount Deposited: %.2f%n", amount);
            System.out.println(e.getMessage());
        }
    }

    /**
     * Withdraws a specified amount from the bank account.
     * 
     * @param amount The amount to withdraw.
     *               Must be greater than 0 and less than or equal to the
     *               current balance.
     */
    public void withdraw(final double amount) {
        try {
            if (isFrozen()) {
                throw new AccountFrozenException(FROZEN_MSG);
            }
            if (amount <= 0) {
                throw new InvalidAmountException(INVALID_AMOUNT_MSG);
            }
            if (amount > balance) {
                throw new InsufficientFundsException("Insufficient balance.");
            }
            balance -= amount;
            transactionHistory.add(
                    new Transaction("Withdraw", amount));
            System.out.printf("Amount withdrawn: %.2f%n", amount);
        } catch (InvalidAmountException | InsufficientFundsException
             | AccountFrozenException e) {
            System.out.printf("Amount Withdrawn: %.2f%n", amount);
            System.out.println(e.getMessage());
        }
    }

    /**
     * Prints the current balance of the given account.
     *
     * @param account The account whose balance is printed.
     */
    public void printBalance(final BankAccount account) {
        System.out.printf("Current balance: %.2f%n",
                account.getBalance());
    }
}
