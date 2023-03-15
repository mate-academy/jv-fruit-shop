package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    int DEFAULT_VALUE = 0;

    void doActivity(FruitTransaction fruitTransaction);
}
