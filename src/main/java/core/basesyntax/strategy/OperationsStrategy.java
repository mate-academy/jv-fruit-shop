package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface OperationsStrategy {
    OperationHandler get(FruitTransaction.Operation operation);
}
