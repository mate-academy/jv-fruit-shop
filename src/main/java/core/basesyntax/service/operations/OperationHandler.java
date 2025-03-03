package core.basesyntax.service.operations;

import core.basesyntax.service.FruitTransaction;

public interface OperationHandler {
    void processTransaction(FruitTransaction fruitTransaction);
}
