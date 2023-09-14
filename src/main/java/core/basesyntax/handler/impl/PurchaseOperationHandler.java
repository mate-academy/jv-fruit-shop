package core.basesyntax.handler.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.handler.ShopOperationHandler;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandler implements ShopOperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        Integer oldQuantityValue = Storage.fruitStorage.get(fruitTransaction.getFruit());
        if (oldQuantityValue == null || oldQuantityValue < fruitTransaction.getQuantity()) {
            throw new IllegalArgumentException("Available quantity of "
                    + fruitTransaction.getFruit()
                    + " is less than required for purchase operation");
        }
        Storage.fruitStorage.put(fruitTransaction.getFruit(),
                oldQuantityValue - fruitTransaction.getQuantity());
    }
}
