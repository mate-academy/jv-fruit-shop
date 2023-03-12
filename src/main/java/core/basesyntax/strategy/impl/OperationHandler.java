package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    void doCalculation(FruitTransaction fruitTransaction);
}
