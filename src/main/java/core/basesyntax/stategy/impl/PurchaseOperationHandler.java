package core.basesyntax.stategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.stategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        int oldQuantity = Storage.FRUITS.get(fruitTransaction.getFruit());
        if (oldQuantity < fruitTransaction.getQuantity()) {
            throw new RuntimeException("Not enough fruit in the store!");
        }
        Storage.FRUITS.put(
                fruitTransaction.getFruit(), oldQuantity - fruitTransaction.getQuantity());
    }
}
