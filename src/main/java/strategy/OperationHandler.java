package strategy;

import core.basesyntax.FruitTransaction;

public interface OperationHandler {
    void handler(FruitTransaction fruitTransaction);
}
