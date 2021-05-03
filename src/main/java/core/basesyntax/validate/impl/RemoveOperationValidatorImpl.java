package core.basesyntax.validate.impl;

import core.basesyntax.validate.RemoveOperationValidator;

public class RemoveOperationValidatorImpl implements RemoveOperationValidator {

    @Override
    public boolean removeOperationValidate(Integer currentQuantity, Integer removeValue) {
        if (currentQuantity < removeValue) {
            throw new RuntimeException("Incorrect remove value");
        }
        return true;
    }
}
