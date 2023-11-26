package hr.java.production.exception;

public class DuplicateCategoryException extends RuntimeException {
    public DuplicateCategoryException(String message) {
        super(message);
    }

    public DuplicateCategoryException(Throwable cause) {
        super(cause);
    }

    public DuplicateCategoryException(String message, Throwable cause) {
        super(message, cause);
    }
}
