package core.basesyntax.service.strategy;

import core.basesyntax.model.Operation;

public interface OperationProcessor {
    void addOperationHandler(Operation operation, OperationHandler handler);

    void processOperation(Operation operation);
}
