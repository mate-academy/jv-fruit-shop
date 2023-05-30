package core.basesyntax.strategy;

import core.basesyntax.transaction.FruitTransaction;

public interface OperationHandler {
    void doCalculation(FruitTransaction fruitTransaction);
}
