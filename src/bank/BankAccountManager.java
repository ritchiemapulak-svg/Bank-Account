package bank;

import java.util.HashMap;
import java.util.Map;

public class BankAccountManager implements Bank{

    private static final int MAX_ACCOUNTS = 100;
    private final Map<Integer, BankAccount> accounts;
    private int id;

    public BankAccountManager(){
        accounts = new HashMap<>();
        id=0;
    }

    public void addAccount(final BankAccount account){
        if(accounts.size() >= MAX_ACCOUNTS){
            System.out.println("Account Limit Reached. Cannot add more.");
            return;
        }
        accounts.put(id, account);
        System.out.println("Account added successfully with ID: " + id);
        id++;
    }
    public BankAccount getAccount(final int id){
        return accounts.get(id);
    }
    public void listAccounts() {
        for(Map.Entry<Integer, BankAccount> entry: accounts.entrySet()){
            BankAccount acc = entry.getValue();
            System.out.println("Account id: %d, Account name: %s, Account balance: %.2f", entry.getKey(), acc.getOwnerName(), acc.getBalance());   
        }
    }
}
