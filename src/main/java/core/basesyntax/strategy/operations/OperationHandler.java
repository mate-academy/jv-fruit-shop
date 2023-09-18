package core.basesyntax.strategy.operations;

import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    void processOperation(FruitTransaction fruitTransaction);
}
