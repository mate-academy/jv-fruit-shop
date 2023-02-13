package core.basesyntax.strategy;

import core.basesyntax.model.Operation;

public interface OperationHandlerStrategy {
    OperationHandler get(Operation operation);
}
