package core.basesyntax.strategy;

import core.basesyntax.transaction.Operation;

public interface OperationHandlerStrategy {
    OperationHandler getOperationService(Operation operation);
}
