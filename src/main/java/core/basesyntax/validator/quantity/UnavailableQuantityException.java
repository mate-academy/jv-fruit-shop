package core.basesyntax.validator.quantity;

public class UnavailableQuantityException extends RuntimeException {
    public UnavailableQuantityException(String message) {
        super(message);
    }
}
