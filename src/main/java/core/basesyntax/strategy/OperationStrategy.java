package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface OperationStrategy {
    OperationHandler getHandlerByOperation(FruitTransaction.Operation operation);
}
