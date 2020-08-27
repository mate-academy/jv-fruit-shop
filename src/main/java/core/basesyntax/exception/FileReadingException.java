package core.basesyntax.exception;

public class FileReadingException extends RuntimeException {
    public FileReadingException(String message, Throwable e) {
        super(message, e);
    }
}
