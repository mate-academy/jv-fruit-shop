package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;

public interface TransactionHandler {
    void handleTransaction(FruitTransaction fruitTransaction, FruitService fruitService);
}
