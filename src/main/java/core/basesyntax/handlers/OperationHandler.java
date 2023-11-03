package core.basesyntax.handlers;

import core.basesyntax.transaction.FruitTransaction;

public interface OperationHandler {
    void handleOperation(FruitTransaction fruitTransaction);
}
