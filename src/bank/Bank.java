package bank;

public interface Bank {

    /**
     * Adds a new bank account to the bank.
     * 
     * @param account The bank account to add.
     */
    void addAccount(BankAccount account);
    
    /**
     * Retrieves a bank account by its ID.
     * 
     * @param id The ID of the bank account to retrieve.
     * @return The bank account with the specified ID, or null if not found.
     */
    BankAccount getAccount(int id);
}
