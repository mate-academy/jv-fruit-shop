package core.basesyntax.exception;

public class FileWritingException extends RuntimeException {
    public FileWritingException(String message, Throwable e) {
        super(message, e);
    }
}
