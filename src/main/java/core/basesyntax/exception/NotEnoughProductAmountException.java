package core.basesyntax.exception;

public class NotEnoughProductAmountException extends RuntimeException {
    public NotEnoughProductAmountException(String message) {
        super(message);
    }
}
