package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface OperationHandlerStrategy {
    OperationHandler getOperationHandler(FruitTransaction.Operation type);
}
