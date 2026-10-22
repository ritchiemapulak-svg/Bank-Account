package bank;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private final String type;
    private final double amount;
    private final LocalDateTime timestamp;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }
    
    public String toString() {
        return "Transaction [type=" + type + ", amount=" + amount
                + ", time_stamp=" + timestamp.format(formatter) + "]";
    }
}
