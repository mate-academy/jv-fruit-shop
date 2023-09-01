package core.basesyntax.service;

import core.basesyntax.serviceimpl.FruitTransaction;

public interface OperationService {
    void handle(FruitTransaction fruitTransaction);
}
