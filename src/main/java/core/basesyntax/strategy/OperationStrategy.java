package core.basesyntax.strategy;

import core.basesyntax.handlers.OperationHandler;
import core.basesyntax.model.operations.Operation;

public interface OperationStrategy {
    OperationHandler getHandler(Operation operation);
}
