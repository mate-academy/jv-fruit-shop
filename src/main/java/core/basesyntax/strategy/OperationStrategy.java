package core.basesyntax.strategy;

import core.basesyntax.model.Operation;
import core.basesyntax.service.operation.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(Operation type);
}
