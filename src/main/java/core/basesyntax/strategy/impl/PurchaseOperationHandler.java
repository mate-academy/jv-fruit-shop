package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        String fruitName = fruitTransaction.getFruit();
        int transactionQuantity = fruitTransaction.getQuantity();
        int initialQuantity = Storage.STORAGE.get(fruitName);
        if (initialQuantity < transactionQuantity) {
            throw new RuntimeException("Unfortunately, we don't have this amount "
                    + fruitName);
        }
        Storage.STORAGE.put(
                fruitTransaction.getFruit(), initialQuantity - transactionQuantity);
    }
}
