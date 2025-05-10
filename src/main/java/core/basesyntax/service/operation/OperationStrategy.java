package core.basesyntax.service.operation;

import core.basesyntax.model.Operation;

public interface OperationStrategy {
    OperationHandler get(Operation operation);
}
