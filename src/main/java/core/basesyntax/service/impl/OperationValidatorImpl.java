package core.basesyntax.service.impl;

import core.basesyntax.model.Operation;
import core.basesyntax.service.OperationValidator;

public class OperationValidatorImpl implements OperationValidator {
    @Override
    public String validate(String operation) {
        for (Operation enumOperation : Operation.values()) {
            if (enumOperation.chooseOperation().equals(operation)) {
                return operation;
            }
        }
        throw new UnsupportedOperationException("Unknown operation " + operation);
    }
}
