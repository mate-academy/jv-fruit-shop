package core.basesyntax.service.strategy;

import core.basesyntax.model.FruitTransaction;

public interface FruitTransactionHandler {
    void handler(FruitTransaction fruitTransaction);
}
