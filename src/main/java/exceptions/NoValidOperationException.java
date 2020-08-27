package exceptions;

public class NoValidOperationException extends RuntimeException {
    public NoValidOperationException(String message) {
        super(message);
    }
}
