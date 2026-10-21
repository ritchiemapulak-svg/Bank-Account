package bank;

public class BankAccount {

    double balance;
    boolean isFrozen;

    public BankAccount() {
        balance = 0;
        isFrozen = false;
    }

    public void deposit(double amount) {
        if (isFrozen) {
            System.out.println("Account is FROZEN. Unable to transact.");
        } else if (amount <= 0) {
            System.out.printf("Amount deposited: %.2f%n", amount);
            System.out.println("Invalid amount. Must be greater than 0");
        } else {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (isFrozen) {
            System.out.println("Account is FROZEN. Unable to transact.");
        } else if (amount <= 0) {
            System.out.printf("Amount withdrawn: %.2f%n", amount);
            System.out.println("Invalid amount. Must be greater than 0");
        } else if (amount > balance) {
            System.out.println("Insufficient balance");
            System.out.printf("Current balance: %.2f%n", balance);
        } else {
            balance -= amount;
        }
    }

    public void getBalance() {
        if (isFrozen) {
            System.out.println("Account is FROZEN.");
        } else {
            System.out.printf("Current balance: %.2f%n", balance);
        }
    }

    public void freezeAccount() {
        isFrozen = true;
    }

    public void unfreezeAccount() {
        isFrozen = false;
    }

    public void isFrozen() {
        System.out.println("Account is frozen: " + isFrozen);
    }

    public static void main(String[] args) {
        // Test 1
        System.out.println("Test 1");
        BankAccount acc1 = new SavingsAccount("Test 0");
        SavingsAccount name = (SavingsAccount) acc1;
        name.getOwnerName();
        // Test 2
        System.out.println("Test 2");
        acc1.deposit(1000.125);
        acc1.getBalance();
        // Test 3
        System.out.println("Test 3");
        acc1.deposit(0);
        // Test 4
        System.out.println("Test 4");
        acc1.deposit(-500);
        acc1.getBalance();
        // Test 5
        System.out.println("Test 5");
        acc1.withdraw(500);
        acc1.getBalance();
        // Test 6
        System.out.println("Test 6");
        acc1.withdraw(1500);
        acc1.getBalance();
        // Test 7
        System.out.println("Test 7");
        acc1.withdraw(-100);
        // Test 8
        System.out.println("Test 8");
        acc1.freezeAccount();
        acc1.deposit(11500);
        // Test 9
        System.out.println("Test 9");
        acc1.withdraw(500);
        // Test 10
        System.out.println("Test 10");
        acc1.unfreezeAccount();
        acc1.withdraw(100);
        acc1.getBalance();

    }

}
