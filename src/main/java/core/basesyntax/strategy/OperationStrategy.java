package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface OperationStrategy {
    OperationService getOperation(FruitTransaction.Operation type);
}
