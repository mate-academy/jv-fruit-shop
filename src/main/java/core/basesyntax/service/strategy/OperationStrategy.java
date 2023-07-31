package core.basesyntax.service.strategy;

import core.basesyntax.model.Operation;
import core.basesyntax.service.strategy.handler.OperationHandler;

public interface OperationStrategy {
    OperationHandler getOperationHandler(Operation operation);
}
