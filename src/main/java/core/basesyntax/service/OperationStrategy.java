package core.basesyntax.service;

import core.basesyntax.model.OperationType;
import core.basesyntax.service.operations.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(OperationType operation);
}
