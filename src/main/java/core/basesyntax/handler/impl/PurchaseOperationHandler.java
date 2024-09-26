package core.basesyntax.handler.impl;

import core.basesyntax.handler.OperationHandler;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.Storage;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        int currentQuantity = Storage.getFruitQuantity(transaction.getFruit());
        if (currentQuantity < transaction.getQuantity()) {
            throw new RuntimeException("Not enough stock for " + transaction.getFruit());
        }
        Storage.addFruit(transaction.getFruit(), -transaction.getQuantity());
    }
}
