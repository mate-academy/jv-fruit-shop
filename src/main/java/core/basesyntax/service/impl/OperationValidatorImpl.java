package core.basesyntax.service.impl;

import core.basesyntax.exception.UnknownOperationException;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationValidator;

public class OperationValidatorImpl implements OperationValidator {
    @Override
    public String validate(String operation) {
        for (FruitTransaction.FruitOperation fruitOperation : FruitTransaction
                .FruitOperation.values()) {
            if (fruitOperation.getFirstLetter().equals(operation)) {
                return operation;
            }
        }
        throw new UnknownOperationException("Unknown operation " + operation);
    }
}
