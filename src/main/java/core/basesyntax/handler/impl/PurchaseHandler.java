package core.basesyntax.handler.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.handler.OperationHandler;
import core.basesyntax.model.FruitTransaction;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void handleOperation(FruitTransaction fruitTransaction) {
        int beforePurchasing = Storage.STORAGE.get(fruitTransaction.getFruit());
        if (beforePurchasing < fruitTransaction.getQuantity()) {
            throw new RuntimeException("We`re apologizing, only: "
                    + beforePurchasing + " items of:" + fruitTransaction.getFruit()
                    + ", left in the storage.");
        }
        int afterPurchasing = beforePurchasing - fruitTransaction.getQuantity();
        Storage.STORAGE.put(fruitTransaction.getFruit(), afterPurchasing);
    }
}
