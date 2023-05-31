package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.FruitTransactionHandler;

public class BalanceHandler implements FruitTransactionHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        Storage.storageMap.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
