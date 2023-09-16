package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        int initialQuantity = Storage.STORAGE.get(fruitTransaction.getFruit());
        if (initialQuantity < fruitTransaction.getQuantity()) {
            throw new RuntimeException("Unfortunately, we don't have this amount " + initialQuantity);
        }
        Storage.STORAGE.put(fruitTransaction.getFruit(), initialQuantity - fruitTransaction.getQuantity());
    }
}
