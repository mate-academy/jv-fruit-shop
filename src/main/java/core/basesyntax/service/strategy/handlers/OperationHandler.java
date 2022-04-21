package core.basesyntax.service.strategy.handlers;

import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    void doOperation(FruitTransaction fruitTransaction);
}
