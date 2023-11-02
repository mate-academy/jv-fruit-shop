package core.basesyntax.service.validator;

import core.basesyntax.exception.NegativeQuantityException;

public class FruitQuantityValidatorImpl implements Validator {
    public static final String NEGATIVE_NUMBER_EXCEPTION_MESSAGE =
            "Quantity number can't be negative: ";

    @Override
    public void validate(Integer quantity) {
        if (quantity >= 0) {
            return;
        }
        throw new NegativeQuantityException(NEGATIVE_NUMBER_EXCEPTION_MESSAGE + quantity);
    }
}
