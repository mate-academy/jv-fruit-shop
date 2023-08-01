package core.basesyntax.service.impl;

import core.basesyntax.model.Operation;
import core.basesyntax.service.OperationService;

public class OperationServiceImpl implements OperationService {
    @Override
    public Operation getOperation(String typeFromFile) {
        switch (typeFromFile) {
            case "b":
                return Operation.BALANCE;
            case "s":
                return Operation.SUPPLY;
            case "p":
                return Operation.PURCHASE;
            case "r":
                return Operation.RETURN;
            default:
                throw new IllegalArgumentException("Invalid operation type: " + typeFromFile);
        }
    }
}
