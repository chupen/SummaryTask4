package ua.nure.teteruk.exception;

public class DBException extends RuntimeException {
    public DBException(String msg) {
        super(msg);
    }

    public DBException(Throwable cause){
        super(cause);
    }

    public DBException(String msg, Throwable cause){
        super(msg, cause);
    }
}
