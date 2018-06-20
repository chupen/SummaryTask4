package ua.nure.teteruk.exception;

public class ApplicationException extends RuntimeException {

    public ApplicationException(String msg){
        super(msg);
    }

    public ApplicationException(Throwable cause){
        super(cause);
    }

    public ApplicationException(String msg, Throwable cause){
        super(msg, cause);
    }
}
