package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void operate(FruitTransaction transaction, Storage storage) {
        if (storage.getQuantityByFruit(transaction.getFruit()) >= transaction.getQuantity()) {
            storage.subtract(transaction.getFruit(), transaction.getQuantity());
        } else {
            throw new RuntimeException("Stock insufficient for this purchase operation");
        }

    }
}
