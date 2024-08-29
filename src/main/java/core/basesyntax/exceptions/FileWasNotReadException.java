package core.basesyntax.exceptions;

public class FileWasNotReadException extends RuntimeException {
    public FileWasNotReadException(String message) {
        super(message);
    }
}
