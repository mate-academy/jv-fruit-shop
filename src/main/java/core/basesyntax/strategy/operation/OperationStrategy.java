package core.basesyntax.strategy.operation;

import core.basesyntax.model.Operation;

public interface OperationStrategy {
    String UNKNOWN_OPERATION = "Unknown operation";

    OperationHandler get(Operation operation);
}
