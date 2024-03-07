package core.basesyntax.service.activity;

import core.basesyntax.model.FruitTransaction;

public interface TransactionHandler {
    void handleTransaction(FruitTransaction fruitTransaction);
}
