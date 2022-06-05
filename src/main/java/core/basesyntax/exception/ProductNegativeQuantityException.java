package core.basesyntax.exception;

public class ProductNegativeQuantityException extends RuntimeException {
    public ProductNegativeQuantityException(String message) {
        super(message);
    }
}
