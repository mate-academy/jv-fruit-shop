package core.basesyntax.validator.quantity;

public interface QuantityValidator {
    boolean isQuantityCorrectForPurchase(long quantity,
                                        long fruitBalace);

    void isQuantityLessThanZero(long quantity, int lineNumber);
}
