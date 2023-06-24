package core.basesyntax.services;

import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    void operate(FruitTransaction fruitTransaction);
}
