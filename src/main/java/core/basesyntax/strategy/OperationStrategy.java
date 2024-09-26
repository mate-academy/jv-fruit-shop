package core.basesyntax.strategy;

import core.basesyntax.handler.OperationHandler;
import core.basesyntax.model.Operation;

public interface OperationStrategy {
    OperationHandler getHandler(Operation operation);
}
