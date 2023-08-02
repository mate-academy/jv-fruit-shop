package core.basesyntax.service.impl;

import core.basesyntax.exceptions.OperationNotFoundException;
import core.basesyntax.model.Operation;
import core.basesyntax.service.OperationService;

public class OperationServiceImpl implements OperationService {
    @Override
    public Operation getOperationType(String operationTypeSymbol) {
        for (Operation operation : Operation.values()) {
            if (operation.getCode().equals(operationTypeSymbol)) {
                return operation;
            }
        }
        throw new OperationNotFoundException("Invalid operation type: " + operationTypeSymbol);
    }
}

