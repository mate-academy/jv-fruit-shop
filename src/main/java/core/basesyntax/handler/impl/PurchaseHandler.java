package core.basesyntax.handler.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.handler.OperationHandler;
import core.basesyntax.model.FruitTransaction;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        int current = Storage.getFruitQuantity(transaction.getFruit());
        int updated = current - transaction.getQuantity();
        if (updated < 0) {
            throw new RuntimeException("Not enough stock for: " + transaction.getFruit());
        }
        Storage.updateFruit(transaction.getFruit(), updated);
    }
}
