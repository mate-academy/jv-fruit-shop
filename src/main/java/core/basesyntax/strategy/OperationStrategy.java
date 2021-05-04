package core.basesyntax.strategy;

import core.basesyntax.handler.OperationHandler;
import core.basesyntax.model.OperationType;

public interface OperationStrategy {
    OperationHandler getHandler(OperationType operationType);
}
