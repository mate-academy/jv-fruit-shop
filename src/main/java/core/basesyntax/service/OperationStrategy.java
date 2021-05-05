package core.basesyntax.service;

import core.basesyntax.model.OperationType;
import core.basesyntax.service.handler.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(OperationType operationType);
}
