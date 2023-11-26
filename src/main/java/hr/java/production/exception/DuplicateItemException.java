package hr.java.production.exception;

public class DuplicateItemException extends Exception {
    public DuplicateItemException(String message) {
        super(message);
    }
    public DuplicateItemException(Throwable cause) {
        super(cause);
    }
    public DuplicateItemException(String message, Throwable cause) {
        super(message, cause);
    }
}
