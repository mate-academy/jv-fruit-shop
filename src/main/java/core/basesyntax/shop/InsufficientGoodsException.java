package core.basesyntax.shop;

public class InsufficientGoodsException extends Exception {
    public InsufficientGoodsException(String errorMessage) {
        super(errorMessage);
    }
}
