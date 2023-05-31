package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    void calculateData(FruitTransaction fruitTransaction);
}
