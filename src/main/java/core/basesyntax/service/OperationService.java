package core.basesyntax.service;

import core.basesyntax.model.Operation;

public interface OperationService {
    Operation getOperation(String operationType);
}
