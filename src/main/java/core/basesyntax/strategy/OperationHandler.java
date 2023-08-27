package core.basesyntax.strategy;

import core.basesyntax.transaction.FruitTransaction;

public interface OperationHandler {
    void handle(FruitTransaction fruitTransaction);
}
