package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.operation.OperationHandler;

public interface OperationHandlerStrategy {
    OperationHandler getOperation(FruitTransaction.Operation operation);
}
