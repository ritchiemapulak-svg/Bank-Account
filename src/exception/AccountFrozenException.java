package exception;

/**
 * Exception thrown when an action or transaction
 * is attempted on a frozen account.
 */
public class AccountFrozenException extends Exception{
    
    private String message;

    public AccountFrozenException(String message){
        this.message= message;
    }
    
    public String getMessage(){
        return message;
    }
}
