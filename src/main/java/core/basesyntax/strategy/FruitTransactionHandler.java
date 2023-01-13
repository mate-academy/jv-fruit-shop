package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface FruitTransactionHandler {
    void handleTransaction(FruitTransaction fruitTransaction);
}
