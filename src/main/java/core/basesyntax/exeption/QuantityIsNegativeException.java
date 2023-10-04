package core.basesyntax.exeption;

public class QuantityIsNegativeException extends RuntimeException {
    public QuantityIsNegativeException(String message) {
        super(message);
    }
}
