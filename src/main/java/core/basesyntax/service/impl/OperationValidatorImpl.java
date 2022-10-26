package core.basesyntax.service.impl;

import core.basesyntax.model.Operation;
import core.basesyntax.service.OperationValidator;

public class OperationValidatorImpl implements OperationValidator {

    @Override
    public boolean isValidOperation(String incomingOperation) {
        for (Operation operation : Operation.values()) {
            if (operation.getOperation().equals(incomingOperation)) {
                return true;
            }
        }
        return false;
    }
}
