package core.basesyntax.exception;

public class CantReadFromFileException extends RuntimeException {
    public CantReadFromFileException(String message) {
        super(message);
    }
}
