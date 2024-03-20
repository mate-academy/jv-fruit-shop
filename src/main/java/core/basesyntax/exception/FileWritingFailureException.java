package core.basesyntax.exception;

public class FileWritingFailureException extends RuntimeException {
    public FileWritingFailureException(String message, Throwable cause) {
        super(message, cause);
    }
}
