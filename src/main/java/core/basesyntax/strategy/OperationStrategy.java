package core.basesyntax.strategy;

import core.basesyntax.Operation;
import core.basesyntax.operationHandler.OperationHandler;

public interface OperationStrategy {
    OperationHandler getHandler(Operation operation);
}
