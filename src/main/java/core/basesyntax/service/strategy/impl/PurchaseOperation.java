package core.basesyntax.service.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.db.StorageImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.strategy.OperationHandler;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void operation(FruitTransaction fruitTransaction) {
        Storage storage = new StorageImpl();
        int newBalance = storage.getFruitBalance(fruitTransaction.getFruit())
                - fruitTransaction.getQuantity();
        if (newBalance < 0) {
            throw new RuntimeException(fruitTransaction.getFruit()
                    + " balance after operation can't be less than 0, but your : "
                    + newBalance);
        }
        storage.setFruitBalance(fruitTransaction.getFruit(), newBalance);
    }
}
