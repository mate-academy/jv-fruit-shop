package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

public interface OperationService {
    int processOperation(FruitTransaction fruitTransaction);
}
