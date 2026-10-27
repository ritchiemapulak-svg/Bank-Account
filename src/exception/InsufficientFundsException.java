package exception;

/**
 * Exception thrown when an operation cannot be completed due 
 * to insufficient account funds.
 */
public class InsufficientFundsException extends Exception{
    
    private String message;

    public InsufficientFundsException(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
