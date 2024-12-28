package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

public interface OperationStrategy {
    void makeOperation(FruitTransaction.Operation operation,
                       FruitTransaction fruitTransaction,
                       Integer quantity);
}
