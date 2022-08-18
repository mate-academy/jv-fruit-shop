package core.basesyntax.service.operationsservice;

import core.basesyntax.model.FruitTransaction;

public interface FruitOperationHandler {
    void handle(FruitTransaction fruitTransaction);
}
