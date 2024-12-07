package core.basesyntax.service;

import core.basesyntax.FruitTransaction;

public interface OperationStrategy {
    void makeOperation(FruitTransaction.Operation operation, FruitTransaction fruitTransaction, Integer quantity);
}
