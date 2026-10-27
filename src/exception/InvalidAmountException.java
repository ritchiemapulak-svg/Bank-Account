package exception;

/**
 * Exception thrown when an invalid monetary
 * or numeric amount is provided.
 */
public class InvalidAmountException extends Exception{

    private String message;

    public InvalidAmountException(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
