package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

public interface FruitTransactionStrategy {
    void typeOperation(FruitTransaction fruitTransaction);
}
