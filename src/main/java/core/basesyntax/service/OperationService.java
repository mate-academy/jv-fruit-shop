package core.basesyntax.service;

import core.basesyntax.model.Operation;

public interface OperationService {
    Operation getOperationType(String operationTypeSymbol);
}
