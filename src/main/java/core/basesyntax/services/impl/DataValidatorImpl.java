package core.basesyntax.services.impl;

import core.basesyntax.exception.IncorrectQuantityException;
import core.basesyntax.exception.InsufficientQuantityException;
import core.basesyntax.services.interfaces.DataValidator;

public class DataValidatorImpl implements DataValidator {
    @Override
    public void checkIfQuantityPositive(int fruitQuantity) {
        if (fruitQuantity < 0) {
            throw new IncorrectQuantityException("Quantity must be positive");
        }
    }

    public void checkIfQuantitySufficiently(int balance, int fruitQuantity) {
        if (balance - fruitQuantity < 0) {
            throw new InsufficientQuantityException("Insufficient quantity of fruit");
        }
    }
}
