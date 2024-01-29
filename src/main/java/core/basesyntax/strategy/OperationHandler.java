package core.basesyntax.strategy;

import core.basesyntax.fruittransaction.FruitTransaction;

public interface OperationHandler {
    void handle(FruitTransaction fruitTransaction);
}
