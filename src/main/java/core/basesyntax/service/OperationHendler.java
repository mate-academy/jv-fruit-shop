package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

public interface OperationHendler {
    int getOperation(FruitTransaction fruitTransaction);
}
