package bank;

public class BankAccount {

    private double balance;
    private boolean isFrozen;

    public BankAccount() {
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

    private static void printBalance(final BankAccount account) {
        System.out.printf("Current balance: %.2f%n", account.getBalance());
    }

    public static void main(final String[] args) {
        BankAccount acc1 = new SavingsAccount("Test0");

        System.out.println("Test 1");
        System.out.println("Account Owner: " + ((SavingsAccount) acc1).getOwnerName() + ".");

        System.out.println("\nTest 2");
        acc1.deposit(1000.125);
        printBalance(acc1);

        System.out.println("\nTest 3");
        acc1.deposit(0);

        System.out.println("\nTest 4");
        acc1.deposit(-500);

        System.out.println("\nTest 5");
        acc1.withdraw(500);
        printBalance(acc1);

        System.out.println("\nTest 6");
        acc1.withdraw(1500);
        printBalance(acc1);

        System.out.println("\nTest 7");
        acc1.withdraw(-100);

        System.out.println("\nTest 8");
        acc1.freezeAccount();
        acc1.deposit(11500);

        System.out.println("\nTest 9");
        acc1.withdraw(500);

        System.out.println("\nTest 10");
        acc1.unfreezeAccount();
        acc1.withdraw(100);
        printBalance(acc1);

    }

}
