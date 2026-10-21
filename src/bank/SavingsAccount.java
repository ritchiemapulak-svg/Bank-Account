package bank;

public class SavingsAccount extends BankAccount {
   
    public String ownerName;

    public SavingsAccount(String ownerName) {
        super();
        this.ownerName = ownerName;
    }

    public void getOwnerName() {
        System.out.println("Owner Name: " + ownerName);
    }



}
