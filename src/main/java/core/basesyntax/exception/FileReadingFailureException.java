package core.basesyntax.exception;

public class FileReadingFailureException extends RuntimeException {
    public FileReadingFailureException(String message, Throwable cause) {
        super(message, cause);
    }
}
