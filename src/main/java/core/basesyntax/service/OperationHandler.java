package core.basesyntax.service;

import core.basesyntax.models.FruitTransaction;

public interface OperationHandler {
    void operate(FruitTransaction fruitTransaction);
}
