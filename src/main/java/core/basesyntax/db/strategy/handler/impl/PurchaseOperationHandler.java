package core.basesyntax.db.strategy.handler.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.db.model.FruitTransaction;
import core.basesyntax.db.strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        int previousQuantity = Storage.getAll().get(transaction.getFruit());
        if (previousQuantity < transaction.getQuantity()) {
            throw new RuntimeException("Not enough product");
        }
        Storage.getAll().put(transaction.getFruit(),
                previousQuantity - transaction.getQuantity());
    }
}
