package core.basesyntax.exception;

public class GoodsLessQuantityException extends RuntimeException {
    public GoodsLessQuantityException(String message) {
        super(message);
    }
}
