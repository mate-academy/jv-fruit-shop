package core.basesyntax.strategy;

import core.basesyntax.model.Operation;

public interface OperationStrategy {
    OperationHandler findOperationHandler(Operation operation);
}
