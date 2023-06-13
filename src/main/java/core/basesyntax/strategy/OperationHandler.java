package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    int executeOperation(FruitTransaction fruitTransaction);
}

