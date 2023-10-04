package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface OperationHandlerStrategy {
    OperationHandler getOperationStrategy(FruitTransaction.Operation operation);
}
