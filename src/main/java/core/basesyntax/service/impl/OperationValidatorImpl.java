package core.basesyntax.service.impl;

import core.basesyntax.exception.UnknownOperationException;
import core.basesyntax.model.FruitOperation;
import core.basesyntax.service.OperationValidator;

public class OperationValidatorImpl implements OperationValidator {
    @Override
    public String validate(String operation) {
        for (FruitOperation fruitOperation : FruitOperation.values()) {
            if (fruitOperation.getOperation().equals(operation)) {
                return operation;
            }
        }
        throw new UnknownOperationException("Unknown operation " + operation);
    }
}
