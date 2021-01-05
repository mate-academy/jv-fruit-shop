package core.basesyntax.exception;

public class NoSuchFileInPathException extends RuntimeException {
    public NoSuchFileInPathException() {
    }

    public NoSuchFileInPathException(String message) {
        super(message);
    }
}
