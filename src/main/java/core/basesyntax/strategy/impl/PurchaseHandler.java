package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        int previousQuantity = Storage.getStorageMap().get(transaction.getFruit());
        if (previousQuantity < transaction.getQuantity()) {
            throw new RuntimeException("The amount of fruits "
                    + transaction.getFruit() + " less to sell");
        }
        Storage.getStorageMap().put(transaction.getFruit(),
                previousQuantity - transaction.getQuantity());
    }
}
