package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ValidateOperation;

public class ValidateOperationImpl implements ValidateOperation {
    @Override
    public void validate(Fruit fruit, int amount) {
        if (amount < 0) {
            throw new RuntimeException("Incorrect data");
        }
    }
}
