package core.basesyntax.validator.quantity;

public class QuantityValidatorImpl implements QuantityValidator {
    @Override
    public boolean isQuantityCorrectForPurcase(long quantity,
                                               long fruitBalace, int lineNumber) {
        try {
            if (quantity > fruitBalace) {
                throw new UnavailableQuantity();
            }
            return true;
        } catch (UnavailableQuantity e) {
            throw new RuntimeException(
                    "Line " + lineNumber
                            + " has unavailable value for quantity", e);
        }
    }

    @Override
    public void isQuantityLessThanZero(long quantity, int lineNumber) {
        try {
            if (quantity < 0) {
                throw new UnavailableQuantity();
            }
        } catch (UnavailableQuantity e) {
            throw new RuntimeException(
                    "Line " + lineNumber
                            + " has unavailable value for quantity", e);
        }
    }
}
