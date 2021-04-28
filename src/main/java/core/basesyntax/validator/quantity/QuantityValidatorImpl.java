package core.basesyntax.validator.quantity;

public class QuantityValidatorImpl implements QuantityValidator {
    @Override
    public boolean isQuantityCorrectForPurchase(long quantity,
                                               long fruitBalance, int lineNumber) {
        if (quantity > fruitBalance) {
            throw new UnavailableQuantityException("Line " + lineNumber
                    + " has unavailable value for quantity");
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
