package bank;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a transaction made on a bank account, 
 * including its type, amount, and timestamp.
 */
public class Transaction {

    private static final DateTimeFormatter FORMATTER = 
    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private final String type;
    private final double amount;
    private final LocalDateTime timestamp;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }
    
    /**
     * Returns a string representation of the transaction, 
     * including its type, amount, and timestamp.
     * 
     * @return A string representation of the transaction.
     */
    @Override
    public String toString() {
        return "\n  Transaction [type=" + type + ", amount=" + amount
            + ", time_stamp=" + timestamp.format(FORMATTER) + "]";
    }

    public double getAmount(){
        return this.amount;
    }
}
