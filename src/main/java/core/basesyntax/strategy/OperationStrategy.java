package core.basesyntax.strategy;

import core.basesyntax.operations.Operation;

public interface OperationStrategy {
    OperationHandler get(Operation operation);
}
