package core.basesyntax.exception;

public class FileNotExistException extends RuntimeException {
    public FileNotExistException(String message) {
        super(message);
    }
}
