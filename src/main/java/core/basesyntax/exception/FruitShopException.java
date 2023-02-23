package core.basesyntax.exception;

public class FruitShopException extends RuntimeException {
    public FruitShopException(String message) {
        super(message);
    }

    public FruitShopException(String message, Throwable cause) {
        super(message, cause);
    }
}
