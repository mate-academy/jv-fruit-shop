package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    boolean applyOperation(FruitTransaction fruitTransaction);
}
