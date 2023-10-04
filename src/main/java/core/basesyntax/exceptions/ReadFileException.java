package core.basesyntax.exceptions;

public class ReadFileException extends RuntimeException {
    public ReadFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReadFileException(String message) {
        super(message);
    }
}
