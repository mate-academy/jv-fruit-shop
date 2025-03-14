package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        int availableQuantity = Storage.storage.get(transaction.getFruit());

        if (availableQuantity < transaction.getQuantity()) {
            throw new IllegalArgumentException("Not enough "
                    + transaction.getFruit() + " in stock for purchase. Available: "
                    + availableQuantity + ", Required: " + transaction.getQuantity());
        }

        Storage.remove(transaction.getFruit(), transaction.getQuantity());
    }
}
