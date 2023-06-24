package core.basesyntax.service.impl;

import core.basesyntax.model.Operation;
import core.basesyntax.service.OperationValidation;

public class OperationValidatorImpl implements OperationValidation {
    @Override
    public Operation validate(String operation) {
        for (Operation enumOperation : Operation.values()) {
            if (enumOperation.getOperationChar().equals(operation)) {
                return enumOperation;
            }
        }
        throw new UnsupportedOperationException("Unknown operation " + operation);
    }
}

