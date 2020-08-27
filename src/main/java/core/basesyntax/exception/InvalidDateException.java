package core.basesyntax.exception;

public class InvalidDateException extends RuntimeException {
    public InvalidDateException(String message, Throwable e) {
        super(message, e);
    }
}
