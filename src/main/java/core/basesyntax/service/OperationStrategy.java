package core.basesyntax.service;

import core.basesyntax.model.Operation;
import core.basesyntax.operations.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(Operation.Type type);
}
