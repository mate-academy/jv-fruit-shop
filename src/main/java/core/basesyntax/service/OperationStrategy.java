package core.basesyntax.service;

import core.basesyntax.service.operations.Operation;

public interface OperationStrategy {
    Operation getOperation(String operationSymbol);
}
