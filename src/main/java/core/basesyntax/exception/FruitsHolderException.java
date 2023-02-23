package core.basesyntax.exception;

public class FruitsHolderException extends RuntimeException {
    public FruitsHolderException(String message) {
        super(message);
    }

    public FruitsHolderException(String message, Throwable cause) {
        super(message, cause);
    }
}
