package core.basesyntax.service.impl;

import core.basesyntax.model.Operation;
import core.basesyntax.service.OperationService;

public class OperationHandlerImpl implements OperationService {
    @Override
    public Operation getOperation(String operationType) {
        switch (operationType) {
            case "b":
                return Operation.BALANCE;
            case "s":
                return Operation.SUPPLY;
            case "p":
                return Operation.PURCHASE;
            case "r":
                return Operation.RETURN;
            default:
                throw new IllegalArgumentException("Invalid operation type: " + operationType);
        }
    }
}
