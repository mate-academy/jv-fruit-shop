package core.basesyntax.exceptions;

public class WriteFileException extends RuntimeException {
    public WriteFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public WriteFileException(String message) {
        super(message);
    }
}
