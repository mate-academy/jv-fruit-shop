package core.basesyntax.validator.quantity;

public interface QuantityValidator {
    boolean isQuantityCorrectForPurcase(long quantity,
                                        long fruitBalace, int lineNumber);

    void isQuantityLessThanZero(long quantity, int lineNumber);
}
