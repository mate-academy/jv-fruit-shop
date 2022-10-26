package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    void doOperation(FruitTransaction fruitTransaction);
}
