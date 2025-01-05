package core.basesyntax.strategy;

import core.basesyntax.Operation;
import core.basesyntax.operationhandlers.OperationHandler;

public interface OperationStrategy {
    OperationHandler getOperationHandler(Operation operation);
}
