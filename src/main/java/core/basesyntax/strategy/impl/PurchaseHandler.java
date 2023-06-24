package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseHandler implements OperationHandler {
    public static final int EMPTY_VALUE = 0;

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        int currentBalance = Storage.storage.getOrDefault(fruitTransaction.getFruit(), EMPTY_VALUE);
        int updatedBalance = currentBalance - fruitTransaction.getQuantity();
        if (updatedBalance < EMPTY_VALUE) {
            throw new RuntimeException("Not enough quantity available in storage");
        }
        Storage.storage.put(fruitTransaction.getFruit(), updatedBalance);
    }
}
