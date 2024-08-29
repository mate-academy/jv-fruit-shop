package core.basesyntax.exceptions;

public class FileWasNotWrittenException extends RuntimeException {
    public FileWasNotWrittenException(String message) {
        super(message);
    }
}
