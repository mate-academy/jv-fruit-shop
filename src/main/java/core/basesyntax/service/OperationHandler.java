package core.basesyntax.service;

import core.basesyntax.serviceimpl.FruitTransaction;

public interface OperationHandler {
    void handler(FruitTransaction fruitTransaction);
}
