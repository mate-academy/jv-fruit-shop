package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    void process(FruitTransaction fruitTransaction);
}
