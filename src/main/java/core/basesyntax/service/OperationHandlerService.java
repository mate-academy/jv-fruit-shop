package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

public interface OperationHandlerService {
    void handle(FruitTransaction fruitTransaction);
}
