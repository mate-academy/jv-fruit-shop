package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

public interface OperationStrategy {
    OperationStrategyImpl get (FruitTransaction.Operation fruitTransaction);
}
