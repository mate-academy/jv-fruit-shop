package core.basesyntax.service.strategy;

import core.basesyntax.service.handler.OperationHandler;
import core.basesyntax.model.FruitTransaction;

public interface OperationStrategy {
    OperationHandler getOperationHandlers(FruitTransaction.Operation operation);
}
