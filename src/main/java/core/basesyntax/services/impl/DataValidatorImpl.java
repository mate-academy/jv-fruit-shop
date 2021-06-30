package core.basesyntax.services.impl;

import core.basesyntax.exception.IncorrectQuantityException;
import core.basesyntax.exception.InsufficientQuantityException;
import core.basesyntax.services.interfaces.DataValidator;

public class DataValidatorImpl implements DataValidator {
    private static final String INCORRECT_QUANTITY_EXCEPTION_MESSAGE = "Quantity must be positive";
    private static final String INSUFFICIENT_QUANTITY_EXCEPTION_MESSAGE = "Insufficient"
            + " quantity of fruit";

    @Override
    public void checkIfQuantityPositive(int fruitQuantity) {
        if (fruitQuantity < 0) {
            throw new IncorrectQuantityException(INCORRECT_QUANTITY_EXCEPTION_MESSAGE);
        }
    }

    public void checkIfQuantitySufficiently(int balance, int fruitQuantity) {
        if (balance - fruitQuantity < 0) {
            throw new InsufficientQuantityException(INSUFFICIENT_QUANTITY_EXCEPTION_MESSAGE);
        }
    }
}
