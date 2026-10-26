package bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Manages bank accounts, allowing for adding and retrieving accounts.
 */
public class BankAccountManager implements Bank{

    private static final int MAX_ACCOUNTS = 100;
    private final Map<Integer, BankAccount> accounts;
    private int id;

    public BankAccountManager(){
        this.accounts = new HashMap<>();
        this.id=0;
    }

    public List<Transaction> filteTransactionsAtOrAbove(double amount, List<Transaction> txList){
        if(txList == null) return new ArrayList<>();

        return txList.stream().filter(tx -> tx.getAmount() >= amount).collect(Collectors.toList());
    }

    public List<Transaction> sortTransactionsByAmount(List<Transaction> txList) {
        if (txList == null) return new ArrayList<>();

        List<Transaction> sortedList = new ArrayList<>(txList);
        sortedList.sort((tx1, tx2) -> Double.compare(tx1.getAmount(), tx2.getAmount()));
        return sortedList;
    }

    /**
     * Adds a new bank account to the bank.
     * 
     * @param account The bank account to add.
     */
    public void addAccount(final BankAccount account){
        if(accounts.size() >= MAX_ACCOUNTS){
            System.out.println("Account Limit Reached. Cannot add more.");
            return;
        }
        accounts.put(id, account);
        System.out.println("Account added successfully with ID: " + id);
        id++;
    }
    
    /**
     * Retrieves a bank account by its ID.
     * 
     * @param id The ID of the bank account to retrieve.
     * @return The bank account with the specified ID, or null if not found.
     */
    public BankAccount getAccount(final int id){
        return accounts.get(id);
    }

    /**
     * Lists all bank accounts managed by the bank account manager.
     */
    public void listAccounts() {
        for(Map.Entry<Integer, BankAccount> entry: accounts.entrySet()){
            BankAccount acc = entry.getValue();
            String accountName = "NULL";
            if (acc instanceof SavingsAccount) {
                accountName = ((SavingsAccount) acc).getOwnerName();
            }
            System.out.printf("Account ID: %d, Account Name: %s, Balance: %.2f%n",
           entry.getKey(), accountName, acc.getBalance()); 
        }
    }
}
