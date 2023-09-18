package core.basesyntax.strategy;

import core.basesyntax.model.Operation;
import core.basesyntax.strategy.handler.OperationHandler;

public interface OperationStrategy {
    OperationHandler getHandler(Operation operation);
}
