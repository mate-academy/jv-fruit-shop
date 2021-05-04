package core.basesyntax.exceptions;

public class WrongOperationException extends RuntimeException {
    public WrongOperationException(String message) {
        super(message);
    }
}
