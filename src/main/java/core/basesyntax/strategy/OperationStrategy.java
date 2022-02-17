package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface OperationStrategy {
    OperationProcess get(FruitTransaction.Operation fruitOperation);
}
