package core.basesyntax.validator.quantity;

public interface QuantityValidator {
    boolean isQuantityCorrectForPurchase(long quantity,
                                        long fruitBalace, int lineNumber);

    void isQuantityLessThanZero(long quantity, int lineNumber);
}
