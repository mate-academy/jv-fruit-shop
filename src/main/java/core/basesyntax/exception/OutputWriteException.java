package core.basesyntax.exception;

public class OutputWriteException extends RuntimeException {
    public OutputWriteException(String message, Throwable cause) {
        super(message, cause);
    }

    public OutputWriteException(String message) {
        super(message);
    }
}
