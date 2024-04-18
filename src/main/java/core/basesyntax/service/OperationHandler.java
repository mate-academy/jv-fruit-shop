package core.basesyntax.service;

import core.basesyntax.FruitTransaction;

public interface OperationHandler {
    void processTransaction(FruitTransaction fruitTransaction);
}
