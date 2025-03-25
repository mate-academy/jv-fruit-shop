package core.basesyntax.service;

import core.basesyntax.model.Operation;
import core.basesyntax.service.operation.OperationHandler;

public interface OperationStrategy {
    OperationHandler getHandler(Operation operation);
}
