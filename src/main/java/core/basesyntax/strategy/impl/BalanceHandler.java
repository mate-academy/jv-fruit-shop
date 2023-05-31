package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.FruitTransactionHandler;

public class BalanceHandler implements FruitTransactionHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        if (fruitTransaction.getQuantity() < 0) {
            throw new RuntimeException("Balance-transaction quantity cannot be less than zero");
        }
        Storage.storageMap.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
