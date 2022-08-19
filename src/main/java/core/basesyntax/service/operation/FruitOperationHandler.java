package core.basesyntax.service.operation;

import core.basesyntax.model.FruitTransaction;

public interface FruitOperationHandler {
    void handle(FruitTransaction fruitTransaction);
}
