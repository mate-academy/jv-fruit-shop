package core.basesyntax.validator.quantity;

public class QuantityValidatorImpl implements QuantityValidator {
    @Override
    public boolean isQuantityCorrectForPurchase(long quantity,
                                               long fruitBalance) {
        if (quantity > fruitBalance) {
            throw new UnavailableQuantityException(
                    "This quantity is unavailable at the moment");
        }
        return true;
    }

    @Override
    public void isQuantityLessThanZero(long quantity, int lineNumber) {
        if (quantity < 0) {
            throw new UnavailableQuantityException("Line " + lineNumber
                    + " has unavailable value for quantity");
        }
    }
}
