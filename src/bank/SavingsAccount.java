package bank;

/**
 * A bank account that stores savings and identifies its owner.
 */
public class SavingsAccount extends BankAccount {
   
    private final String ownerName;

    public SavingsAccount(final String ownerName) {
        super();
        this.ownerName = ownerName;
    }
    
    public String getOwnerName() {
        return ownerName;
    }
}
