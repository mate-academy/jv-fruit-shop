package core.basesyntax.service;

import core.basesyntax.model.Operation;

public interface OperationsStrategy {
    OperationHandler getHandler(Operation operation);
}
