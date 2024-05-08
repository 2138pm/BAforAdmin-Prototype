package ku.cs.services.exceptions;

public class AuthenticationFailedException extends IllegalArgumentException{
    public AuthenticationFailedException(){
        super("Authentication Failed");
    }

    public AuthenticationFailedException(String message){
        super(message);
    }

}
