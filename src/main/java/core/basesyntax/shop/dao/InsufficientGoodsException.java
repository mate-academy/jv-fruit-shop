package core.basesyntax.shop.dao;

public class InsufficientGoodsException extends Exception {
    public InsufficientGoodsException(String errorMessage) {
        super(errorMessage);
    }
}
