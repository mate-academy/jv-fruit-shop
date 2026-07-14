package core.basesyntax.activities;

import core.basesyntax.transactions.FruitTransaction;

public interface OperationHandler {
    void operationHandler(FruitTransaction fruitTransaction);
}
